package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public abstract class BlockKetherLeavesBase extends BlockLeavesBase implements IShearable {
   int[] field_150128_a;
   @SideOnly(Side.CLIENT)
   protected int field_150127_b;
   protected IIcon[][] field_150129_M = new IIcon[2][];

   public BlockKetherLeavesBase() {
      super(Material.leaves, false);
      this.setTickRandomly(true);
   }

   public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      byte b0 = 1;
      int i1 = b0 + 1;
      if (p_149749_1_.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1)) {
         for(int j1 = -b0; j1 <= b0; ++j1) {
            for(int k1 = -b0; k1 <= b0; ++k1) {
               for(int l1 = -b0; l1 <= b0; ++l1) {
                  Block block = p_149749_1_.getBlock(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                  if (block.isLeaves(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1)) {
                     block.beginLeavesDecay(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                  }
               }
            }
         }
      }

   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if (!p_149674_1_.isRemote) {
         int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);
         if ((l & 8) != 0 && (l & 4) == 0) {
            byte b0 = 4;
            int i1 = b0 + 1;
            byte b1 = 32;
            int j1 = b1 * b1;
            int k1 = b1 / 2;
            if (this.field_150128_a == null) {
               this.field_150128_a = new int[b1 * b1 * b1];
            }

            int l1;
            if (p_149674_1_.checkChunksExist(p_149674_2_ - i1, p_149674_3_ - i1, p_149674_4_ - i1, p_149674_2_ + i1, p_149674_3_ + i1, p_149674_4_ + i1)) {
               l1 = -b0;

               label110:
               while(true) {
                  int i2;
                  int j2;
                  if (l1 > b0) {
                     l1 = 1;

                     while(true) {
                        if (l1 > 4) {
                           break label110;
                        }

                        for(i2 = -b0; i2 <= b0; ++i2) {
                           for(j2 = -b0; j2 <= b0; ++j2) {
                              for(int k2 = -b0; k2 <= b0; ++k2) {
                                 if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1) {
                                    if (this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
                                       this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
                                       this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2) {
                                       this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2) {
                                       this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2) {
                                       this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2) {
                                       this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
                                    }
                                 }
                              }
                           }
                        }

                        ++l1;
                     }
                  }

                  for(i2 = -b0; i2 <= b0; ++i2) {
                     for(j2 = -b0; j2 <= b0; ++j2) {
                        Block block = p_149674_1_.getBlock(p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2);
                        if (!block.canSustainLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2)) {
                           if (block.isLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2)) {
                              this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
                           } else {
                              this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
                           }
                        } else {
                           this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
                        }
                     }
                  }

                  ++l1;
               }
            }

            l1 = this.field_150128_a[k1 * j1 + k1 * b1 + k1];
            if (l1 >= 0) {
               p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l & -9, 4);
            } else {
               this.removeLeaves(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if (p_149734_1_.canLightningStrikeAt(p_149734_2_, p_149734_3_ + 1, p_149734_4_) && !World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && p_149734_5_.nextInt(15) == 1) {
         double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
         double d1 = (double)p_149734_3_ - 0.05D;
         double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
         p_149734_1_.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
      }

   }

   private void removeLeaves(World p_150126_1_, int p_150126_2_, int p_150126_3_, int p_150126_4_) {
      this.dropBlockAsItem(p_150126_1_, p_150126_2_, p_150126_3_, p_150126_4_, p_150126_1_.getBlockMetadata(p_150126_2_, p_150126_3_, p_150126_4_), 0);
      p_150126_1_.setBlockToAir(p_150126_2_, p_150126_3_, p_150126_4_);
   }

   public int quantityDropped(Random p_149745_1_) {
      return p_149745_1_.nextInt(20) == 0 ? 1 : 0;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(KMOD_Main.KetherSapling);
   }

   public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, 1.0F, p_149690_7_);
   }

   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
   }

   protected int func_150123_b(int p_150123_1_) {
      return 20;
   }

   public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
   }

   public int damageDropped(int p_149692_1_) {
      return p_149692_1_ & 3;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public abstract IIcon getIcon(int var1, int var2);

   @SideOnly(Side.CLIENT)
   public void setGraphicsLevel(boolean p_150122_1_) {
      this.field_150121_P = p_150122_1_;
      this.field_150127_b = p_150122_1_ ? 0 : 1;
   }

   protected ItemStack createStackedBlock(int p_149644_1_) {
      return new ItemStack(Item.getItemFromBlock(this), 1, p_149644_1_ & 3);
   }

   public abstract String[] func_150125_e();

   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
      return true;
   }

   public ArrayList onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
      ArrayList ret = new ArrayList();
      ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
      return ret;
   }

   public void beginLeavesDecay(World world, int x, int y, int z) {
      int i2 = world.getBlockMetadata(x, y, z);
      if ((i2 & 8) == 0) {
         world.setBlockMetadataWithNotify(x, y, z, i2 | 8, 4);
      }

      world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
   }

   public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
      return true;
   }

   public ArrayList getDrops(World world, int x, int y, int z, int metadata, int fortune) {
      ArrayList ret = new ArrayList();
      int chance = this.func_150123_b(metadata);
      if (fortune > 0) {
         chance -= 2 << fortune;
         if (chance < 10) {
            chance = 10;
         }
      }

      if (world.rand.nextInt(chance) == 0) {
         ret.add(new ItemStack(this.getItemDropped(metadata, world.rand, fortune), 1, this.damageDropped(metadata)));
      }

      chance = 200;
      if (fortune > 0) {
         chance -= 10 << fortune;
         if (chance < 40) {
            chance = 40;
         }
      }

      this.captureDrops(true);
      this.func_150124_c(world, x, y, z, metadata, chance);
      ret.addAll(this.captureDrops(false));
      return ret;
   }
}
