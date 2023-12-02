package com.KMOD.Entities;

import MCACommonLibrary.IMCAnimatedEntity;
import MCACommonLibrary.animation.AnimationHandler;
import animations.New.AnimationHandlerNew;
import com.KMOD.Main.KMOD_Main;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySimple extends EntityAnimal implements IMCAnimatedEntity {
   private final EntityAIControlledByPlayer aiControlledByPlayer;
   private static boolean saddled;
   protected AnimationHandler animHandler = new AnimationHandlerNew(this);
   private boolean walking = false;
   private boolean isWalkingAnimationActive = false;

   public EntitySimple(World p_i1689_1_) {
      super(p_i1689_1_);
      this.setSize(1.0F, 0.5F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
      this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
      this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.apple, false));
      this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
      this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(8, new EntityAILookIdle(this));
      saddled = false;
   }

   public boolean isWalking() {
      return this.walking;
   }

   public boolean getIsWalkingAnimationActive() {
      return this.isWalkingAnimationActive;
   }

   public void onUpdate() {
      super.onUpdate();
      this.isWalkingAnimationActive = this.getAnimationHandler().isAnimationActive("walkCycle");
      if (!(this.motionX >= 0.2D) && !(this.motionZ >= 0.2D) && !(this.motionX <= 0.2D) && !(this.motionZ <= 0.2D)) {
         this.walking = false;
      } else {
         this.walking = true;
      }

   }

   public boolean isAIEnabled() {
      return true;
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

   public AnimationHandler getAnimationHandler() {
      return this.animHandler;
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
      if (!this.isSaddled() && ep.inventory.hasItem(KMOD_Main.FullCloth) && ep.inventory.hasItem(KMOD_Main.Wings) && !this.worldObj.isRemote) {
         saddled = true;
         ep.inventory.consumeInventoryItem(KMOD_Main.FullCloth);
         ep.inventory.consumeInventoryItem(KMOD_Main.Wings);
         EntityKetherFlyingBoar ekfb = new EntityKetherFlyingBoar(this.worldObj);
         ekfb.setPosition(this.posX, this.posY, this.posZ);
         this.worldObj.spawnEntityInWorld(ekfb);
         this.posX = 9999.0D;
         this.posY = 9999.0D;
         this.posZ = 9999.0D;
         this.despawnEntity();
         this.setDead();
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

   public EntitySimple createChild(EntityAgeable p_90011_1_) {
      return new EntitySimple(this.worldObj);
   }

   public boolean isBreedingItem(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.getItem() == Items.apple;
   }

   public EntityAIControlledByPlayer getAIControlledByPlayer() {
      return this.aiControlledByPlayer;
   }
}
