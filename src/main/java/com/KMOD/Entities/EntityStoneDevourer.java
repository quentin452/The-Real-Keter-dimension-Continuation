package com.KMOD.Entities;

import com.KMOD.Main.KMOD_Main;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityStoneDevourer extends EntityAnimal {
   int counter = 0;

   public EntityStoneDevourer(World p_i1689_1_) {
      super(p_i1689_1_);
      this.setSize(0.9F, 0.9F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
      this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(3, new EntityAIFollowParent(this, 1.1D));
      this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(6, new EntityAILookIdle(this));
      this.tasks.addTask(7, new EntityAITempt(this, 1.2D, KMOD_Main.DarkEnergy, false));
      this.NewOnUpdate();
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

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
   }

   protected String getLivingSound() {
      return "mob.pig.say";
   }

   protected String getHurtSound() {
      return "mob.pig.say";
   }

   protected String getDeathSound() {
      return "mob.pig.death";
   }

   public void onUpdate() {
      super.onUpdate();
      if (!this.worldObj.isRemote) {
         this.updateLeashedState();
      }

      this.NewOnUpdate();
   }

   public void NewOnUpdate() {
      ++this.counter;
      if (this.counter == 10000) {
         if ((this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == Blocks.stone || this.worldObj.getBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ) == KMOD_Main.KetherStone) && this.worldObj.isAirBlock((int)this.posX, (int)this.posY, (int)this.posZ)) {
            this.worldObj.setBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ, KMOD_Main.Crystals);
         }

         this.counter = 1;
      }

   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      this.playSound("mob.pig.step", 0.15F, 1.0F);
   }

   protected Item getDropItem() {
      return Item.getItemFromBlock(Blocks.stone);
   }

   public EntityStoneDevourer createChild(EntityAgeable p_90011_1_) {
      return new EntityStoneDevourer(this.worldObj);
   }

   public boolean isBreedingItem(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.getItem() == KMOD_Main.DarkEnergy;
   }
}
