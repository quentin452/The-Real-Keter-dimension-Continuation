package com.KMOD.Blocks;

import com.KMOD.WorldGens.KetherGenNormalTrees;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockKetherSapling extends BlockKetherBushBase implements IGrowable {
   public BlockKetherSapling() {
      float f = 0.4F;
      this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if (!p_149674_1_.isRemote) {
         super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
         if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0) {
            this.func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return this.blockIcon;
   }

   public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
      int l = p_149879_1_.getBlockMetadata(p_149879_2_, p_149879_3_, p_149879_4_);
      if ((l & 8) == 0) {
         p_149879_1_.setBlockMetadataWithNotify(p_149879_2_, p_149879_3_, p_149879_4_, l | 8, 4);
      } else {
         this.func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
      }

   }

   public void func_149878_d(World p_149878_1_, int p_149878_2_, int p_149878_3_, int p_149878_4_, Random p_149878_5_) {
      if (TerrainGen.saplingGrowTree(p_149878_1_, p_149878_5_, p_149878_2_, p_149878_3_, p_149878_4_)) {
         int l = p_149878_1_.getBlockMetadata(p_149878_2_, p_149878_3_, p_149878_4_) & 7;
         Object object = new KetherGenNormalTrees(true);
         int i1 = 0;
         int j1 = 0;
         boolean flag = false;
         switch(l) {
         case 0:
         default:
            break;
         case 1:
            label80:
            for(i1 = 0; i1 >= -1; --i1) {
               for(j1 = 0; j1 >= -1; --j1) {
                  if (this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, 1) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, 1) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, 1) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, 1)) {
                     object = new KetherGenNormalTrees(true);
                     flag = true;
                     break label80;
                  }
               }
            }

            if (!flag) {
               j1 = 0;
               i1 = 0;
               object = new KetherGenNormalTrees(true);
            }
            break;
         case 2:
            object = new KetherGenNormalTrees(true);
            break;
         case 3:
            label97:
            for(i1 = 0; i1 >= -1; --i1) {
               for(j1 = 0; j1 >= -1; --j1) {
                  if (this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, 3) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, 3) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, 3) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, 3)) {
                     object = new KetherGenNormalTrees(true);
                     flag = true;
                     break label97;
                  }
               }
            }

            if (!flag) {
               j1 = 0;
               i1 = 0;
               object = new KetherGenNormalTrees(true);
            }
            break;
         case 4:
            object = new KetherGenNormalTrees(true);
            break;
         case 5:
            label114:
            for(i1 = 0; i1 >= -1; --i1) {
               for(j1 = 0; j1 >= -1; --j1) {
                  if (this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, 5) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, 5) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, 5) && this.func_149880_a(p_149878_1_, p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, 5)) {
                     object = new KetherGenNormalTrees(true);
                     flag = true;
                     break label114;
                  }
               }
            }

            if (!flag) {
               return;
            }
         }

         Block block = Blocks.air;
         if (flag) {
            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
         } else {
            p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, block, 0, 4);
         }

         if (!((WorldGenerator)object).generate(p_149878_1_, p_149878_5_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1)) {
            if (flag) {
               p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
               p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
               p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
               p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
            } else {
               p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, this, l, 4);
            }
         }

      }
   }

   public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_) {
      return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
   }

   public int damageDropped(int p_149692_1_) {
      return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      return true;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return (double)p_149852_1_.rand.nextFloat() < 0.45D;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
   }
}
