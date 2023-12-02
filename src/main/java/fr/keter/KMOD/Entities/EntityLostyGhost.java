package fr.keter.KMOD.Entities;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityLostyGhost extends EntityMob {
   protected static final IAttribute field_110186_bp = (new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
   private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private static final AttributeModifier babySpeedBoostModifier;
   private final EntityAIBreakDoor field_146075_bs = new EntityAIBreakDoor(this);
   private boolean field_146076_bu = false;
   private float field_146074_bv = -1.0F;
   private float field_146073_bw;
   Random r = new Random();

   public EntityLostyGhost(World p_i1745_1_) {
      super(p_i1745_1_);
      this.getNavigator().setBreakDoors(false);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
      this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
      this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
      this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
      this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(8, new EntityAILookIdle(this));
      this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
      this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
      this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
      this.setSize(1.0F, 1.0F);
      this.experienceValue = 50;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(80.0D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.1D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3300000041723251D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
      this.getAttributeMap().registerAttribute(field_110186_bp).setBaseValue(this.rand.nextDouble() * ForgeModContainer.zombieSummonBaseChance);
   }

   protected void entityInit() {
      super.entityInit();
      this.getDataWatcher().addObject(12, (byte)0);
      this.getDataWatcher().addObject(13, (byte)0);
      this.getDataWatcher().addObject(14, (byte)0);
   }

   public int getTotalArmorValue() {
      int i = super.getTotalArmorValue() + 2;
      if (i > 20) {
         i = 20;
      }

      return i;
   }

   protected boolean isAIEnabled() {
      return true;
   }

   public boolean func_146072_bX() {
      return this.field_146076_bu;
   }

   public void func_146070_a(boolean p_146070_1_) {
      if (this.field_146076_bu != p_146070_1_) {
         this.field_146076_bu = p_146070_1_;
         if (p_146070_1_) {
            this.tasks.addTask(1, this.field_146075_bs);
         } else {
            this.tasks.removeTask(this.field_146075_bs);
         }
      }

   }

   public boolean isChild() {
      return this.getDataWatcher().getWatchableObjectByte(12) == 1;
   }

   protected int getExperiencePoints(EntityPlayer p_70693_1_) {
      if (this.isChild()) {
         this.experienceValue = (int)((float)this.experienceValue * 2.5F);
      }

      return super.getExperiencePoints(p_70693_1_);
   }

   public void setChild(boolean p_82227_1_) {
      this.getDataWatcher().updateObject(12, (byte)(p_82227_1_ ? 1 : 0));
      if (this.worldObj != null && !this.worldObj.isRemote) {
         IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
         iattributeinstance.removeModifier(babySpeedBoostModifier);
         if (p_82227_1_) {
            iattributeinstance.applyModifier(babySpeedBoostModifier);
         }
      }

      this.func_146071_k(p_82227_1_);
   }

   public void onLivingUpdate() {
      if (KMOD_Main.instance.getSEtap() == 1) {
         if (this.r.nextInt(10) == 5) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 15;
         }
      } else if (KMOD_Main.instance.getSEtap() == 2) {
         if (this.r.nextInt(8) == 5) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 15;
         }
      } else if (KMOD_Main.instance.getSEtap() == 3) {
         if (this.r.nextInt(6) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 15;
         }
      } else if (KMOD_Main.instance.getSEtap() == 4) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 30;
         }
      } else if (KMOD_Main.instance.getSEtap() == 5) {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
         this.experienceValue = 40;
      } else if (KMOD_Main.instance.getSEtap() == 6) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 30;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 40;
         }
      } else if (KMOD_Main.instance.getSEtap() == 7) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 55;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 40;
         }
      } else if (KMOD_Main.instance.getSEtap() == 8) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 60;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 45;
         }
      } else if (KMOD_Main.instance.getSEtap() == 9) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 70;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 60;
         }
      } else if (KMOD_Main.instance.getSEtap() == 10) {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
         this.experienceValue = 70;
      } else if (KMOD_Main.instance.isSBest()) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.5D);
            this.experienceValue = 90;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 80;
         }
      } else if (KMOD_Main.instance.isSHostile()) {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
         this.experienceValue = 1;
      } else {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
         this.experienceValue = 50;
      }

      if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
         float f = this.getBrightness(1.0F);
         if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            boolean flag = true;
            ItemStack itemstack = this.getEquipmentInSlot(4);
            if (itemstack != null) {
               if (itemstack.isItemStackDamageable()) {
                  itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));
                  if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage()) {
                     this.renderBrokenItemStack(itemstack);
                     this.setCurrentItemOrArmor(4, (ItemStack)null);
                  }
               }

               flag = false;
            }

            if (flag) {
               this.setFire(8);
            }
         }
      }

      super.onLivingUpdate();
   }

   public void onUpdate() {
      super.onUpdate();
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
      boolean flag = super.attackEntityAsMob(p_70652_1_);
      if (flag) {
         int i = this.worldObj.difficultySetting.getDifficultyId();
         if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)i * 0.3F) {
            p_70652_1_.setFire(2 * i);
         }
      }

      return flag;
   }

   protected Item getDropItem() {
      return KMOD_Main.APieceOfCloth;
   }

   public EnumCreatureAttribute getCreatureAttribute() {
      return EnumCreatureAttribute.UNDEAD;
   }

   protected void dropRareDrop(int p_70600_1_) {
      switch(this.rand.nextInt(3)) {
      case 0:
         this.dropItem(KMOD_Main.APieceOfCloth, 3);
         break;
      case 1:
         this.dropItem(KMOD_Main.RubySword, 1);
         break;
      case 2:
         this.dropItem(KMOD_Main.TopazGem, 1);
      }

   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
      if (this.isChild()) {
         p_70014_1_.setBoolean("IsBaby", true);
      }

      p_70014_1_.setBoolean("CanBreakDoors", this.func_146072_bX());
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
      if (p_70037_1_.getBoolean("IsBaby")) {
         this.setChild(true);
      }

      this.func_146070_a(p_70037_1_.getBoolean("CanBreakDoors"));
   }

   @SideOnly(Side.CLIENT)
   public void handleHealthUpdate(byte p_70103_1_) {
      if (p_70103_1_ == 16) {
         this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
      } else {
         super.handleHealthUpdate(p_70103_1_);
      }

   }

   protected int getConversionTimeBoost() {
      int i = 1;
      if (this.rand.nextFloat() < 0.01F) {
         int j = 0;

         for(int k = (int)this.posX - 4; k < (int)this.posX + 4 && j < 14; ++k) {
            for(int l = (int)this.posY - 4; l < (int)this.posY + 4 && j < 14; ++l) {
               for(int i1 = (int)this.posZ - 4; i1 < (int)this.posZ + 4 && j < 14; ++i1) {
                  Block block = this.worldObj.getBlock(k, l, i1);
                  if (block == Blocks.iron_bars || block == Blocks.bed) {
                     if (this.rand.nextFloat() < 0.3F) {
                        ++i;
                     }

                     ++j;
                  }
               }
            }
         }
      }

      return i;
   }

   public void func_146071_k(boolean p_146071_1_) {
      this.func_146069_a(p_146071_1_ ? 0.5F : 1.0F);
   }

   protected final void setSize(float p_70105_1_, float p_70105_2_) {
      boolean flag = this.field_146074_bv > 0.0F && this.field_146073_bw > 0.0F;
      this.field_146074_bv = p_70105_1_;
      this.field_146073_bw = p_70105_2_;
      if (!flag) {
         this.func_146069_a(1.0F);
      }

   }

   protected final void func_146069_a(float p_146069_1_) {
      super.setSize(this.field_146074_bv * p_146069_1_, this.field_146073_bw * p_146069_1_);
   }

   protected String getLivingSound() {
      return "real kether:ghost.ghost";
   }

   protected String getHurtSound() {
      return "real kether:ghost.ghost";
   }

   protected String getDeathSound() {
      return "real kether:ghost.ghost";
   }

   static {
      babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);
   }

   class GroupData implements IEntityLivingData {
      public boolean field_142048_a;
      public boolean field_142046_b;

      private GroupData(boolean p_i2348_2_, boolean p_i2348_3_) {
         this.field_142048_a = false;
         this.field_142046_b = false;
         this.field_142048_a = p_i2348_2_;
         this.field_142046_b = p_i2348_3_;
      }

      GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_) {
         this(p_i2349_2_, p_i2349_3_);
      }
   }
}
