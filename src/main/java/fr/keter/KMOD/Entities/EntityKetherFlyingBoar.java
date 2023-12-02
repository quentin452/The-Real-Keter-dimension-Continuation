package fr.keter.KMOD.Entities;

import fr.keter.KMOD.Main.KMOD_Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityKetherFlyingBoar extends EntityAnimal {
   private final EntityAIControlledByPlayer aiControlledByPlayer;
   private static boolean saddled;

   public EntityKetherFlyingBoar(World p_i1689_1_) {
      super(p_i1689_1_);
      this.setSize(1.0F, 1.0F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
      this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
      this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
      this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(7, new EntityAILookIdle(this));
      saddled = true;
   }

   public EntityAIControlledByPlayer getAIControlledByPlayer() {
      return this.aiControlledByPlayer;
   }

   public boolean isAIEnabled() {
      return true;
   }

   public void onUpdate() {
      super.onUpdate();
      this.newUpdate();
   }

   public void newUpdate() {
      if (this.motionY < 0.0D) {
         this.motionY = -1.0E-23D;
      }

      if (this.motionY < 0.0D) {
         this.motionY *= -1.0E-4D;
      }

      this.fallDistance = 0.0F;
      if (!this.worldObj.isRemote && this.riddenByEntity != null && this.riddenByEntity != null) {
         if (Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed()) {
            this.moveEntityWithHeading(0.2F, 0.0F);
         }

         if (Minecraft.getMinecraft().gameSettings.keyBindBack.getIsKeyPressed()) {
            this.moveEntityWithHeading(-0.2F, 0.0F);
         }

         if (Minecraft.getMinecraft().gameSettings.keyBindLeft.getIsKeyPressed()) {
            this.moveEntityWithHeading(0.0F, 0.2F);
         }

         if (Minecraft.getMinecraft().gameSettings.keyBindRight.getIsKeyPressed()) {
            this.moveEntityWithHeading(0.0F, -0.2F);
         }

         if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
            this.motionY = 0.25D;
         }
      }

      super.onUpdate();
   }

   public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
      if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
         this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
         this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
         this.setRotation(this.rotationYaw, this.rotationPitch);
         this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
         p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
         p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;
         if (p_70612_2_ <= 0.0F) {
            p_70612_2_ *= 0.25F;
         }

         this.stepHeight = 1.0F;
         this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
         if (!this.worldObj.isRemote) {
            if (!this.onGround) {
               this.setAIMoveSpeed(0.25F);
            } else {
               this.setAIMoveSpeed(0.02F);
            }

            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
         }

         this.prevLimbSwingAmount = this.limbSwingAmount;
         double d1 = this.posX - this.prevPosX;
         double d0 = this.posZ - this.prevPosZ;
         float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;
         if (f4 > 1.0F) {
            f4 = 1.0F;
         }

         this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
         this.limbSwing += this.limbSwingAmount;
      } else {
         this.stepHeight = 0.5F;
         this.jumpMovementFactor = 0.02F;
         super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
      }

   }

   public boolean canBeSteered() {
      return this.riddenByEntity != null;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
   }

   protected void updateAITasks() {
      super.updateAITasks();
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, (byte)0);
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
   }

   protected String getLivingSound() {
      return "real kether:boar.boar";
   }

   protected String getHurtSound() {
      return "mob.pig.say";
   }

   protected String getDeathSound() {
      return "mob.pig.death";
   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      this.playSound("mob.pig.step", 0.15F, 1.0F);
   }

   public boolean isSaddled() {
      return saddled;
   }

   public boolean interact(EntityPlayer ep) {
      if (this.isSaddled() && !this.worldObj.isRemote) {
         ep.mountEntity(this);
      }

      return true;
   }

   protected Item getDropItem() {
      return this.isBurning() ? KMOD_Main.Venison : KMOD_Main.Venison;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
      int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

      for(int k = 0; k < j; ++k) {
         if (this.isBurning()) {
            this.dropItem(KMOD_Main.Venison, 2);
         } else {
            this.dropItem(KMOD_Main.Venison, 2);
         }
      }

   }

   public void onStruckByLightning(EntityLightningBolt p_70077_1_) {
   }

   protected void fall(float p_70069_1_) {
      super.fall(p_70069_1_);
      if (p_70069_1_ > 5.0F && this.riddenByEntity instanceof EntityPlayer) {
      }

   }

   public EntityKetherBoar createChild(EntityAgeable p_90011_1_) {
      return new EntityKetherBoar(this.worldObj);
   }

   public boolean isBreedingItem(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.getItem() == Items.apple;
   }
}
