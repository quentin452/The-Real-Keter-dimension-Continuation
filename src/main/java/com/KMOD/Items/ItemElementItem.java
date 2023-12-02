package com.KMOD.Items;

import com.KMOD.Main.KMOD_Main;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemElementItem extends Item {
   private float field_150934_a;
   private float maxDamage;
   Random random = new Random();
   private String ElementType;
   private boolean isSocketOpened = false;
   private String insertedElement = "null";
   private boolean canInsertElement = true;

   public ItemElementItem(String Name, float maxDamage, ItemElementItem.ElementType e, boolean par1, boolean par2) {
      this.canInsertElement = par2;
      this.isSocketOpened = par1;
      this.maxStackSize = 1;
      this.ElementType = e.getElementName();
      this.maxDamage = maxDamage;
      this.setMaxDamage((int)maxDamage);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.field_150934_a = (float)((int)maxDamage);
   }

   public float func_150931_i() {
      return (float)this.random.nextInt((int)this.maxDamage);
   }

   public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      if (par1ItemStack.stackTagCompound == null) {
         par1ItemStack.setTagCompound(new NBTTagCompound());
      }

      par1ItemStack.stackTagCompound.setString("ElementType", this.ElementType);
      par1ItemStack.stackTagCompound.setBoolean("isSocketOpened", this.isSocketOpened);
      par1ItemStack.stackTagCompound.setBoolean("canInsertElement", this.canInsertElement);
      par1ItemStack.stackTagCompound.setString("insertedElement", this.insertedElement);
   }

   public void onUpdate(ItemStack i, World w, Entity e, int icc, boolean b) {
      if (i.stackTagCompound == null) {
         i.setTagCompound(new NBTTagCompound());
      }

      this.ElementType = i.stackTagCompound.getString("ElementType");
      this.isSocketOpened = i.stackTagCompound.getBoolean("isSocketOpened");
      this.canInsertElement = i.stackTagCompound.getBoolean("canInsertElement");
      this.insertedElement = i.stackTagCompound.getString("insertedElement");
      if (this.isSocketOpened && this.insertedElement == "null") {
         this.canInsertElement = true;
      } else {
         this.canInsertElement = false;
      }

   }

   public void openSocket() {
      this.isSocketOpened = true;
   }

   public void closeSocket() {
      this.isSocketOpened = false;
   }

   public void insertElementIfPossible(ItemElementItem.ElementType e) {
      if (this.canInsertElement) {
         this.insertedElement = e.getElementName();
      }

   }

   public void extractElementIfPossible() {
      if (!this.canInsertElement) {
         this.insertedElement = "null";
      }

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
      return -1;
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
      return p_77659_1_;
   }

   public boolean func_150897_b(Block p_150897_1_) {
      return p_150897_1_ == Blocks.web;
   }

   public int getItemEnchantability() {
      return 0;
   }

   public String getToolMaterialName() {
      return "Element";
   }

   public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
      return false;
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
      String ss;
      if (this.isSocketOpened) {
         ss = "true";
      } else {
         ss = "false";
      }

      String s;
      if (this.canInsertElement) {
         s = "true";
      } else {
         s = "false";
      }

      par3List.add("Inserted Element: " + this.insertedElement);
      par3List.add("Can Insert Element: " + s);
      par3List.add("Is Socket Opened: " + ss);
   }

   public static enum ElementType {
      FIRE("Fire"),
      NATURE("Nature"),
      EARTH("Earth"),
      WATER("Water"),
      DARK("Dark"),
      LIGHT("Light");

      private String type;

      private ElementType(String Type) {
         this.type = Type;
      }

      public String getElementName() {
         return this.type;
      }
   }
}
