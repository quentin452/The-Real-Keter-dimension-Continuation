package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockKetherBushBase extends Block implements IPlantable {
   protected BlockKetherBushBase(Material p_i45395_1_) {
      super(p_i45395_1_);
      this.setTickRandomly(true);
      float f = 0.2F;
      this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
   }

   protected BlockKetherBushBase() {
      this(Material.plants);
   }

   public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
   }

   protected boolean canPlaceBlockOn(Block p_149854_1_) {
      return p_149854_1_ == Blocks.grass || p_149854_1_ == Blocks.dirt || p_149854_1_ == Blocks.farmland || p_149854_1_ == KMOD_Main.KetherGrass || p_149854_1_ == KMOD_Main.KetherDirt;
   }

   public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
      this.checkAndDropBlock(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      this.checkAndDropBlock(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
   }

   protected void checkAndDropBlock(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_) {
      if (!this.canBlockStay(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_)) {
         this.dropBlockAsItem(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, p_149855_1_.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
         p_149855_1_.setBlock(p_149855_2_, p_149855_3_, p_149855_4_, getBlockById(0), 0, 2);
      }

   }

   public boolean canBlockStay(World world, int x, int y, int z) {
      return world.getBlock(x, y - 1, z) == KMOD_Main.KetherGrass || world.getBlock(x, y - 1, z) == KMOD_Main.KetherDirt || world.getBlock(x, y - 1, z) == Blocks.grass || world.getBlock(x, y - 1, z) == Blocks.dirt;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public int getRenderType() {
      return 1;
   }

   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
      return EnumPlantType.Plains;
   }

   public Block getPlant(IBlockAccess world, int x, int y, int z) {
      return this;
   }

   public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
      return world.getBlockMetadata(x, y, z);
   }
}
