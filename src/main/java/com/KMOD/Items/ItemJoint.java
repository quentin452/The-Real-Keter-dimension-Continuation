package com.KMOD.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemJoint extends ItemFood {
   public final int itemUseDuration;
   private final int healAmount;
   private final float saturationModifier;
   private final boolean isWolfsFavoriteMeat;
   private boolean alwaysEdible;
   private int potionId;
   private int potionDuration;
   private int potionAmplifier;
   private float potionEffectProbability;

   public ItemJoint(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
      super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
      this.itemUseDuration = 32;
      this.healAmount = p_i45339_1_;
      this.isWolfsFavoriteMeat = p_i45339_3_;
      this.saturationModifier = p_i45339_2_;
      this.setAlwaysEdible();
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public ItemJoint(int p_i45340_1_, boolean p_i45340_2_) {
      this(p_i45340_1_, 0.6F, p_i45340_2_);
   }

   public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      --p_77654_1_.stackSize;
      p_77654_3_.getFoodStats().func_151686_a(this, p_77654_1_);
      p_77654_2_.playSoundAtEntity(p_77654_3_, "random.burp", 0.5F, p_77654_2_.rand.nextFloat() * 0.1F + 0.9F);
      this.onFoodEaten(p_77654_1_, p_77654_2_, p_77654_3_);
      return p_77654_1_;
   }

   protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
      p_77849_3_.addPotionEffect(new PotionEffect(Potion.confusion.id, 500, 50));
      if (!p_77849_2_.isRemote && this.potionId > 0 && p_77849_2_.rand.nextFloat() < this.potionEffectProbability) {
         p_77849_3_.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 200, this.potionAmplifier));
      }

   }

   public int getMaxItemUseDuration(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction getItemUseAction(ItemStack p_77661_1_) {
      return EnumAction.eat;
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World w, EntityPlayer p_77659_3_) {
      if (p_77659_3_.canEat(this.alwaysEdible)) {
         p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
      }

      return p_77659_1_;
   }

   public int func_150905_g(ItemStack p_150905_1_) {
      return this.healAmount;
   }

   public float func_150906_h(ItemStack p_150906_1_) {
      return this.saturationModifier;
   }

   public boolean isWolfsFavoriteMeat() {
      return this.isWolfsFavoriteMeat;
   }

   public ItemJoint setPotionEffect(int p_77844_1_, int p_77844_2_, int p_77844_3_, float p_77844_4_) {
      this.potionId = p_77844_1_;
      this.potionDuration = p_77844_2_;
      this.potionAmplifier = p_77844_3_;
      this.potionEffectProbability = p_77844_4_;
      return this;
   }

   public ItemJoint setAlwaysEdible() {
      this.alwaysEdible = true;
      return this;
   }
}
