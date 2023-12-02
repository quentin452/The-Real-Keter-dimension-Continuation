package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockKetherGrass extends Block implements IGrowable {
   private static final Logger logger = LogManager.getLogger();
   @SideOnly(Side.CLIENT)
   private IIcon field_149991_b;
   @SideOnly(Side.CLIENT)
   private IIcon field_149993_M;
   @SideOnly(Side.CLIENT)
   private static IIcon field_149994_N;

   public BlockKetherGrass() {
      super(Material.grass);
      this.setTickRandomly(true);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1 ? this.field_149991_b : (p_149691_1_ == 0 ? KMOD_Main.KetherDirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if (!p_149674_1_.isRemote) {
         if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2) {
            p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, KMOD_Main.KetherDirt);
         } else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
            for(int l = 0; l < 4; ++l) {
               int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
               int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
               int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
               p_149674_1_.getBlock(i1, j1 + 1, k1);
               if (p_149674_1_.getBlock(i1, j1, k1) == KMOD_Main.KetherDirt && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
                  p_149674_1_.setBlock(i1, j1, k1, KMOD_Main.KetherGrass);
               }
            }
         }
      }

   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return KMOD_Main.KetherDirt.getItemDropped(0, p_149650_2_, p_149650_3_);
   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      return true;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
      if (p_149673_5_ == 1) {
         return this.field_149991_b;
      } else if (p_149673_5_ == 0) {
         return KMOD_Main.KetherDirt.getBlockTextureFromSide(p_149673_5_);
      } else {
         Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
         return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_149993_M;
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_side");
      this.field_149991_b = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_top");
      this.field_149993_M = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_side_snowed");
      field_149994_N = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_side_overlay");
   }

   @SideOnly(Side.CLIENT)
   public static IIcon getIconSideOverlay() {
      return field_149994_N;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      label34:
      for(int l = 0; l < 128; ++l) {
         int i1 = p_149853_3_;
         int j1 = p_149853_4_ + 1;
         int k1 = p_149853_5_;

         for(int l1 = 0; l1 < l / 16; ++l1) {
            i1 += p_149853_2_.nextInt(3) - 1;
            j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
            k1 += p_149853_2_.nextInt(3) - 1;
            if (p_149853_1_.getBlock(i1, j1 - 1, k1) != KMOD_Main.KetherGrass || p_149853_1_.getBlock(i1, j1, k1).isNormalCube()) {
               continue label34;
            }
         }

         if (p_149853_1_.getBlock(i1, j1, k1).getMaterial() == Material.air) {
            if (p_149853_2_.nextInt(8) != 0) {
               if (Blocks.tallgrass.canBlockStay(p_149853_1_, i1, j1, k1)) {
                  p_149853_1_.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
               }
            } else {
               p_149853_1_.getBiomeGenForCoords(i1, k1).plantFlower(p_149853_1_, p_149853_2_, i1, j1, k1);
            }
         }
      }

   }
}
