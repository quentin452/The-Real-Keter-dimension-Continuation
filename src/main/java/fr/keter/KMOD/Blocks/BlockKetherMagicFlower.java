package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import fr.keter.KMOD.Particles.KetherParticleSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockKetherMagicFlower extends BlockKetherBushBase {
   @SideOnly(Side.CLIENT)
   private IIcon[] field_149861_N;
   private int field_149862_O;

   public BlockKetherMagicFlower(String Name) {
      super(Material.plants);
      this.setBlockName(Name);
      this.setTickRandomly(true);
   }

   public int getRenderType() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if (p_149734_5_.nextInt(60) == 1) {
         KetherParticleSpawner kps = new KetherParticleSpawner();
         KetherParticleSpawner.spawnParticle("test1", (double)p_149734_2_, (double)p_149734_3_, (double)p_149734_4_, 0.0D, 0.1D, 0.0D);
      }

   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
      if (p_149674_5_.nextInt(5000) == 5 && p_149674_1_.isAirBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_)) {
         p_149674_1_.setBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 7 && p_149674_1_.isAirBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_ - 1)) {
         p_149674_1_.setBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_ - 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 2 && p_149674_1_.isAirBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_ - 1)) {
         p_149674_1_.setBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_ - 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 10 && p_149674_1_.isAirBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_ + 1)) {
         p_149674_1_.setBlock(p_149674_2_ + 1, p_149674_3_, p_149674_4_ + 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 15 && p_149674_1_.isAirBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_ - 1)) {
         p_149674_1_.setBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_ + 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 16 && p_149674_1_.isAirBlock(p_149674_2_, p_149674_3_, p_149674_4_ - 1)) {
         p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_ - 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 17 && p_149674_1_.isAirBlock(p_149674_2_, p_149674_3_, p_149674_4_ + 1)) {
         p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_ + 1, KMOD_Main.KetherMagicFlower);
      }

      if (p_149674_5_.nextInt(5000) == 18 && p_149674_1_.isAirBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_)) {
         p_149674_1_.setBlock(p_149674_2_ - 1, p_149674_3_, p_149674_4_, KMOD_Main.KetherMagicFlower);
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return this.blockIcon;
   }

   public int damageDropped(int p_149692_1_) {
      return p_149692_1_;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(this);
   }
}
