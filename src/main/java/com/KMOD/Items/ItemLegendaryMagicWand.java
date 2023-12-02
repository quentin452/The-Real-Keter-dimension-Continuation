package com.KMOD.Items;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemLegendaryMagicWand extends ItemKether {
   private int Uses = 256;
   int MagicType = 0;
   private boolean FireSpell = false;
   private boolean FrozenSpell = false;
   private boolean AirSpell = false;
   private boolean WebSpell = false;
   private Entity attackedEntity;
   int c = 0;

   public ItemLegendaryMagicWand(String Name) {
      super(Name);
      this.maxStackSize = 64;
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer e) {
      if (!w.isRemote) {
         ++this.MagicType;
         if (this.MagicType == 5) {
            this.MagicType = 0;
         }

         if (this.MagicType == 0) {
            this.FireSpell = true;
            e.addChatMessage(new ChatComponentText("Changed To Fire Spell"));
         }

         if (this.MagicType == 1) {
            this.FireSpell = false;
            this.FrozenSpell = true;
            e.addChatMessage(new ChatComponentText("Changed To Froze Spell"));
         }

         if (this.MagicType == 2) {
            this.FireSpell = false;
            this.FrozenSpell = false;
            this.AirSpell = true;
            e.addChatMessage(new ChatComponentText("Changed To Air Spell"));
         }

         if (this.MagicType == 3) {
            this.AirSpell = false;
            this.WebSpell = true;
            e.addChatMessage(new ChatComponentText("Changed To Web Spell"));
         }

         if (this.MagicType == 4) {
            this.WebSpell = false;
            this.FireSpell = false;
            this.FrozenSpell = false;
            this.AirSpell = false;
            e.addChatMessage(new ChatComponentText("Changed To Nothing"));
         }
      }

      return i;
   }

   public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase e1, EntityLivingBase e2) {
      if (this.FireSpell) {
         e1.setFire(5);
      }

      if (this.FrozenSpell) {
         this.attackedEntity = e1;
      }

      if (this.AirSpell) {
         e1.motionY = 1.2D;
      }

      if (this.WebSpell) {
         e1.worldObj.setBlock((int)e1.posX, (int)e1.posY, (int)e1.posZ, Blocks.web);
      }

      --this.Uses;
      return false;
   }

   public void onUpdate(ItemStack i, World w, Entity e, int icc, boolean b) {
      if (this.Uses == 0 && e instanceof EntityPlayer) {
         ((EntityPlayer)e).inventory.consumeInventoryItem(this);
      }

      if (this.attackedEntity != null) {
         ++this.c;
         this.FrozeEntity();
      }

   }

   public void FrozeEntity() {
      if (this.attackedEntity != null) {
         if (this.c <= 300) {
            this.attackedEntity.motionX = 0.0D;
            this.attackedEntity.motionY = 0.0D;
            this.attackedEntity.motionZ = 0.0D;
         } else {
            this.attackedEntity = null;
            this.c = 0;
         }
      }

   }

   public boolean onEntitySwing(EntityLiving e, ItemStack i) {
      return false;
   }

   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer e, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer e, List par3List, boolean par4) {
      if (this == KMOD_Main.LegendaryMagicWand) {
         par3List.add("ďż˝6Magic is here!");
         par3List.add("Uses: " + this.Uses);
      }

   }
}
