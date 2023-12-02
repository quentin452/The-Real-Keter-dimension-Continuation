package fr.keter.KMOD.Entities;

import fr.keter.KMOD.Main.KMOD_Main;
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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityKetherCow extends EntityAnimal {
   public EntityKetherCow(World p_i1683_1_) {
      super(p_i1683_1_);
      this.setSize(0.9F, 1.3F);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
      this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Item.getItemFromBlock(KMOD_Main.KetherMagicFlower), false));
      this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
      this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
      this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(7, new EntityAILookIdle(this));
   }

   public boolean isAIEnabled() {
      return true;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3000000029802322D);
   }

   protected String getLivingSound() {
      return "mob.cow.say";
   }

   protected String getHurtSound() {
      return "mob.cow.hurt";
   }

   protected String getDeathSound() {
      return "mob.cow.hurt";
   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      this.playSound("mob.cow.step", 0.15F, 1.0F);
   }

   protected float getSoundVolume() {
      return 0.4F;
   }

   protected Item getDropItem() {
      return Item.getItemFromBlock(KMOD_Main.KetherMagicFlower);
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
      int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

      int k;
      for(k = 0; k < j; ++k) {
         this.dropItem(Items.leather, 1);
      }

      j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

      for(k = 0; k < j; ++k) {
         if (this.isBurning()) {
            this.dropItem(Items.cooked_beef, 1);
         } else {
            this.dropItem(Items.beef, 1);
         }
      }

   }

   public boolean interact(EntityPlayer p_70085_1_) {
      ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
      if (itemstack != null && itemstack.getItem() == Items.bucket && !p_70085_1_.capabilities.isCreativeMode) {
         if (itemstack.stackSize-- == 1) {
            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, new ItemStack(Items.milk_bucket));
         } else if (!p_70085_1_.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket))) {
            p_70085_1_.dropPlayerItemWithRandomChoice(new ItemStack(Items.milk_bucket, 1, 0), false);
         }

         return true;
      } else {
         return super.interact(p_70085_1_);
      }
   }

   public EntityKetherCow createChild(EntityAgeable p_90011_1_) {
      return new EntityKetherCow(this.worldObj);
   }
}
