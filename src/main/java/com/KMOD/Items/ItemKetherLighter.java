package com.KMOD.Items;

import com.KMOD.Blocks.BlockKetherPortal;
import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemKetherLighter extends Item {
   public ItemKetherLighter() {
      this.maxStackSize = 1;
      this.setMaxDamage(64);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if (p_77648_7_ == 0) {
         --p_77648_5_;
      }

      if (p_77648_7_ == 1) {
         ++p_77648_5_;
      }

      if (p_77648_7_ == 2) {
         --p_77648_6_;
      }

      if (p_77648_7_ == 3) {
         ++p_77648_6_;
      }

      if (p_77648_7_ == 4) {
         --p_77648_4_;
      }

      if (p_77648_7_ == 5) {
         ++p_77648_4_;
      }

      if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         if (p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_)) {
            p_77648_3_.playSoundEffect((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 0.5D, (double)p_77648_6_ + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_ - 1, p_77648_6_) == KMOD_Main.MagicStone) {
               ((BlockKetherPortal)KMOD_Main.KetherPortal).func_150000_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
               p_77648_2_.inventory.consumeInventoryItem(this);
            }
         }

         p_77648_1_.damageItem(1, p_77648_2_);
         return true;
      }
   }

   public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      if ((p_149726_1_.provider.dimensionId > 0 || !((BlockKetherPortal)KMOD_Main.KetherPortal).func_150000_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_)) && !World.doesBlockHaveSolidTopSurface(p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_)) {
         p_149726_1_.setBlockToAir(p_149726_2_, p_149726_3_, p_149726_4_);
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister p_149651_1_) {
      this.itemIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
