package fr.keter.KMOD.Entities;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMorf extends EntityTameable {
   private float field_70926_e;
   private float field_70924_f;
   private boolean field_70928_h;
   public int courseChangeCooldown;
   public double waypointX;
   public double waypointY;
   public double waypointZ;

   public EntityMorf(World p_i1696_1_) {
      super(p_i1696_1_);
      this.setSize(0.6F, 0.8F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(1, new EntityAISwimming(this));
      this.tasks.addTask(2, this.aiSit);
      this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
      this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
      this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
      this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(8, new EntityAILookIdle(this));
      this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
      this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
      this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
      this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
      this.setTamed(false);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
      if (this.isTamed()) {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
      } else {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
      }

   }

   public boolean isAIEnabled() {
      return true;
   }

   public void setAttackTarget(EntityLivingBase p_70624_1_) {
      super.setAttackTarget(p_70624_1_);
   }

   protected void updateAITick() {
      this.dataWatcher.updateObject(18, this.getHealth());
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(18, new Float(this.getHealth()));
      this.dataWatcher.addObject(19, new Byte((byte)0));
      this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
   }

   protected float getSoundVolume() {
      return 0.4F;
   }

   protected Item getDropItem() {
      return Item.getItemById(-1);
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
      if (!this.worldObj.isRemote && !this.field_70928_h && !this.hasPath() && this.onGround) {
         this.field_70928_h = true;
         this.worldObj.setEntityState(this, (byte)8);
      }

   }

   public void onUpdate() {
      super.onUpdate();
      this.field_70924_f = this.field_70926_e;
   }

   private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
      double d4 = (this.waypointX - this.posX) / p_70790_7_;
      double d5 = (this.waypointY - this.posY) / p_70790_7_;
      double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
      AxisAlignedBB axisalignedbb = this.boundingBox.copy();

      for(int i = 1; (double)i < p_70790_7_; ++i) {
         axisalignedbb.offset(d4, d5, d6);
         if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public int getVerticalFaceSpeed() {
      return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
      if (this.isEntityInvulnerable()) {
         return false;
      } else {
         Entity entity = p_70097_1_.getEntity();
         this.aiSit.setSitting(false);
         if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
            p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
         }

         return super.attackEntityFrom(p_70097_1_, p_70097_2_);
      }
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
      int i = this.isTamed() ? 4 : 2;
      return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
   }

   public void setTamed(boolean p_70903_1_) {
      super.setTamed(p_70903_1_);
      if (p_70903_1_) {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
      } else {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
      }

   }

   public boolean interact(EntityPlayer p_70085_1_) {
      ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
      if (!this.isTamed() && itemstack != null && itemstack.getItem() == KMOD_Main.DarkEnergy) {
         if (!p_70085_1_.capabilities.isCreativeMode) {
            --itemstack.stackSize;
         }

         if (itemstack.stackSize <= 0) {
            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
         }

         if (!this.worldObj.isRemote) {
            if (this.rand.nextInt(3) == 0) {
               this.setTamed(true);
               this.setPathToEntity((PathEntity)null);
               this.setAttackTarget((EntityLivingBase)null);
               this.setHealth(20.0F);
               this.func_152115_b(p_70085_1_.getUniqueID().toString());
               this.playTameEffect(true);
               this.worldObj.setEntityState(this, (byte)7);
            } else {
               this.playTameEffect(false);
               this.worldObj.setEntityState(this, (byte)6);
            }
         }

         return true;
      } else {
         return super.interact(p_70085_1_);
      }
   }

   @SideOnly(Side.CLIENT)
   public void handleHealthUpdate(byte p_70103_1_) {
      if (p_70103_1_ == 8) {
         this.field_70928_h = true;
      } else {
         super.handleHealthUpdate(p_70103_1_);
      }

   }

   public int getMaxSpawnedInChunk() {
      return 8;
   }

   public EntityMorf createChild(EntityAgeable p_90011_1_) {
      EntityMorf entitywolf = new EntityMorf(this.worldObj);
      String s = this.func_152113_b();
      if (s != null && s.trim().length() > 0) {
         entitywolf.func_152115_b(s);
         entitywolf.setTamed(true);
      }

      return entitywolf;
   }

   public void func_70918_i(boolean p_70918_1_) {
      if (p_70918_1_) {
         this.dataWatcher.updateObject(19, (byte)1);
      } else {
         this.dataWatcher.updateObject(19, (byte)0);
      }

   }

   public boolean canMateWith(EntityAnimal p_70878_1_) {
      if (p_70878_1_ == this) {
         return false;
      } else if (!this.isTamed()) {
         return false;
      } else if (!(p_70878_1_ instanceof EntityMorf)) {
         return false;
      } else {
         EntityMorf entitywolf = (EntityMorf)p_70878_1_;
         return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
      }
   }

   public boolean func_70922_bv() {
      return this.dataWatcher.getWatchableObjectByte(19) == 1;
   }

   protected boolean canDespawn() {
      return !this.isTamed() && this.ticksExisted > 2400;
   }

   public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
      if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast)) {
         if (p_142018_1_ instanceof EntityMorf) {
            EntityMorf entitywolf = (EntityMorf)p_142018_1_;
            if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_) {
               return false;
            }
         }

         return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
      } else {
         return false;
      }
   }
}
