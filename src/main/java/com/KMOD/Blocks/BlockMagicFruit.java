package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockMagicFruit extends BlockCrops {
   @SideOnly(Side.CLIENT)
   private IIcon[] field_149868_a;

   protected boolean canPlaceBlockOn(Block p_149854_1_) {
      return p_149854_1_ == KMOD_Main.KetherCloud;
   }

   public int getRenderType() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      if (p_149691_2_ < 7) {
         if (p_149691_2_ == 6) {
            p_149691_2_ = 5;
         }

         return this.field_149868_a[p_149691_2_ >> 1];
      } else {
         return this.field_149868_a[3];
      }
   }

   protected Item func_149866_i() {
      return KMOD_Main.MagicFruit;
   }

   protected Item func_149865_P() {
      return KMOD_Main.MagicFruit;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.field_149868_a = new IIcon[4];

      for(int i = 0; i < this.field_149868_a.length; ++i) {
         this.field_149868_a[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_stage_" + i);
      }

   }
}
