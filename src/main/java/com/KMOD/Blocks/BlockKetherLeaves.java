package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKetherLeaves extends BlockKetherLeavesBase {
   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
      Random random = new Random();
      int i = random.nextInt(5);
      if ((p_150124_5_ & 3) == 1 && p_150124_1_.rand.nextInt(p_150124_6_) == 0) {
         this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.apple, 1, 0));
      }

      if (this == KMOD_Main.KetherLonsdaleiteLeaves && (p_150124_5_ & 3) == 1 && p_150124_1_.rand.nextInt(p_150124_6_) == 0) {
         this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(KMOD_Main.LonsdaleiteGem, 1, 0));
      }

   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
   }

   public int damageDropped(int p_149692_1_) {
      return super.damageDropped(p_149692_1_) + 4;
   }

   public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) & 3;
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return this.blockIcon;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      if (this == KMOD_Main.UnbreakbleKetherLeaves) {
         this.blockIcon = p_149651_1_.registerIcon("Real Kether:Kether Leaves");
      }

      if (this == KMOD_Main.KetherBlueLeaves) {
         this.blockIcon = p_149651_1_.registerIcon("Real Kether:Kether Blue Leaves");
      }

      if (this == KMOD_Main.KetherGoldenLeaves) {
         this.blockIcon = p_149651_1_.registerIcon("Real Kether:Kether Golden Leaves");
      }

      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
      iblockaccess.getBlock(i, j, k);
      return true;
   }

   public String[] func_150125_e() {
      return null;
   }
}
