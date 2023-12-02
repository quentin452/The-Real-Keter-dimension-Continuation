package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemKetherSword extends Item {
   private float field_150934_a;
   private final ToolMaterial field_150933_b;

   public ItemKetherSword(ToolMaterial p_i45356_1_, String Name) {
      this.field_150933_b = p_i45356_1_;
      this.maxStackSize = 1;
      this.setMaxDamage(p_i45356_1_.getMaxUses());
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.field_150934_a = 4.0F + p_i45356_1_.getDamageVsEntity();
   }

   public float func_150931_i() {
      return this.field_150933_b.getDamageVsEntity();
   }

   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
      if (p_150893_2_ == Blocks.web) {
         return 15.0F;
      } else {
         Material material = p_150893_2_.getMaterial();
         return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
      }
   }

   public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
      p_77644_1_.damageItem(1, p_77644_3_);
      return true;
   }

   public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
      if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D) {
         p_150894_1_.damageItem(2, p_150894_7_);
      }

      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
      return true;
   }

   public EnumAction getItemUseAction(ItemStack p_77661_1_) {
      return EnumAction.block;
   }

   public int getMaxItemUseDuration(ItemStack p_77626_1_) {
      return 72000;
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
      return p_77659_1_;
   }

   public boolean func_150897_b(Block p_150897_1_) {
      return p_150897_1_ == Blocks.web;
   }

   public int getItemEnchantability() {
      return this.field_150933_b.getEnchantability();
   }

   public String getToolMaterialName() {
      return this.field_150933_b.toString();
   }

   public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
      return this.field_150933_b.func_150995_f() == p_82789_2_.getItem() ? true : super.getIsRepairable(p_82789_1_, p_82789_2_);
   }

   public Multimap getItemAttributeModifiers() {
      Multimap multimap = super.getItemAttributeModifiers();
      multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a, 0));
      return multimap;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public void addInformation(ItemStack it, EntityPlayer e, List par3List, boolean par4) {
   }
}
