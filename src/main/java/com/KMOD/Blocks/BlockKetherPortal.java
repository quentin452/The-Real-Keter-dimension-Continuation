package com.KMOD.Blocks;

import com.KMOD.DimensionBases.TeleporterKether;
import com.KMOD.Main.KMOD_Main;
import com.KMOD.Particles.KetherParticleSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BlockKetherPortal extends BlockPortal {
   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
      EntityPlayerMP player;
      if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null && par5Entity instanceof EntityPlayerMP) {
         player = (EntityPlayerMP)par5Entity;
         MinecraftServer mServer = MinecraftServer.getServer();
         if (player.timeUntilPortal > 0) {
            player.timeUntilPortal = 10;
         } else if (player.dimension != 8) {
            player.timeUntilPortal = 10;
            player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 8, new TeleporterKether(mServer.worldServerForDimension(8)));
         } else {
            player.timeUntilPortal = 10;
            player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterKether(mServer.worldServerForDimension(1)));
         }
      }

      if (par5Entity instanceof EntityPlayerMP) {
         player = (EntityPlayerMP)par5Entity;
         player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 10));
         player.addPotionEffect(new PotionEffect(Potion.heal.id, 100, 10));
         player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 10));
         player.addPotionEffect(new PotionEffect(Potion.confusion.id, 50, 10));
      }

   }

   public boolean func_150000_e(World par1World, int par2, int par3, int par4) {
      byte b0 = 0;
      byte b1 = 0;
      if (par1World.getBlock(par2 - 1, par3, par4) == KMOD_Main.MagicStone || par1World.getBlock(par2 + 1, par3, par4) == KMOD_Main.MagicStone) {
         b0 = 1;
      }

      if (par1World.getBlock(par2, par3, par4 - 1) == KMOD_Main.MagicStone || par1World.getBlock(par2, par3, par4 + 1) == KMOD_Main.MagicStone) {
         b1 = 1;
      }

      if (b0 == b1) {
         return false;
      } else {
         if (par1World.isAirBlock(par2 - b0, par3, par4 - b1)) {
            par2 -= b0;
            par4 -= b1;
         }

         int l;
         int i1;
         for(l = -1; l <= 2; ++l) {
            for(i1 = -1; i1 <= 3; ++i1) {
               boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
               if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
                  Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                  boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                  if (flag) {
                     if (j1 != KMOD_Main.MagicStone) {
                        return false;
                     }
                  } else if (!isAirBlock) {
                     return false;
                  }
               }
            }
         }

         for(l = 0; l < 2; ++l) {
            for(i1 = 0; i1 < 3; ++i1) {
               par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, KMOD_Main.KetherPortal, 0, 2);
            }
         }

         return true;
      }
   }

   public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
      byte b0 = 0;
      byte b1 = 1;
      if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this) {
         b0 = 1;
         b1 = 0;
      }

      int i1;
      for(i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1) {
      }

      if (par1World.getBlock(par2, i1 - 1, par4) != KMOD_Main.MagicStone) {
         par1World.setBlockToAir(par2, par3, par4);
      } else {
         int j1;
         for(j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1) {
         }

         if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == KMOD_Main.MagicStone) {
            boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
            boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;
            if (flag && flag1) {
               par1World.setBlockToAir(par2, par3, par4);
            } else if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != KMOD_Main.MagicStone || par1World.getBlock(par2 - b0, par3, par4 - b1) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b1) != KMOD_Main.MagicStone || par1World.getBlock(par2 + b0, par3, par4 + b1) != this)) {
               par1World.setBlockToAir(par2, par3, par4);
            }
         } else {
            par1World.setBlockToAir(par2, par3, par4);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if (p_149734_5_.nextInt(100) == 0) {
         p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int l = 0; l < 4; ++l) {
         double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
         double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
         double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
         double d3 = 0.0D;
         double d4 = 0.0D;
         double d5 = 0.0D;
         int i1 = p_149734_5_.nextInt(2) * 2 - 1;
         d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this) {
            d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
         } else {
            d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
            d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
         }

         KetherParticleSpawner kps = new KetherParticleSpawner();
         if (p_149734_5_.nextInt(30) == 5) {
            for(int i = 0; i <= 2; ++i) {
               KetherParticleSpawner.spawnParticle("KetherPortalParticle", d0, d1, d2, d3, d4, d5);
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
