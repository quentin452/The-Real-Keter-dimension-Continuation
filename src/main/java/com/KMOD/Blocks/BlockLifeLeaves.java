package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import com.KMOD.Particles.KetherParticleSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLifeLeaves extends BlockKetherLeavesBase {
   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if (this == KMOD_Main.LifeLeaves && p_149734_1_.getBlock(p_149734_2_, p_149734_3_ - 1, p_149734_4_) == Blocks.air && p_149734_5_.nextInt(40) == 1) {
         KetherParticleSpawner kps = new KetherParticleSpawner();
         KetherParticleSpawner.spawnParticle("KetherLifeLeavesParticle", (double)p_149734_2_, (double)p_149734_3_, (double)p_149734_4_, 0.0D, -0.5D, 0.0D);
      }

   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
      if (this == KMOD_Main.LifeLeaves && p_149674_1_.getBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_) == Blocks.air && p_149674_5_.nextInt(40) == 1) {
         KetherParticleSpawner kps = new KetherParticleSpawner();
         KetherParticleSpawner.spawnParticle("KetherLifeLeavesParticle", (double)p_149674_2_, (double)p_149674_3_, (double)p_149674_4_, 0.0D, -0.5D, 0.0D);
      }

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

   public void onBlockDestroyedByPlayer(World w, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      w.setBlock(p_149664_2_, p_149664_3_, p_149664_4_, this);
      EntityPlayer ep = w.getClosestPlayer((double)p_149664_2_, (double)p_149664_3_, (double)p_149664_4_, 16.0D);
      float actualhealth = ep.getHealth();
      ep.setHealth(actualhealth - 7.0F);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
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
