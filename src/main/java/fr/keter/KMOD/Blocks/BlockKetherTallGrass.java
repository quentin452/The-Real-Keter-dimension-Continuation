package fr.keter.KMOD.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class BlockKetherTallGrass extends BlockKetherBushBase implements IGrowable, IShearable {
   private static final String[] field_149871_a = new String[]{"Kether Tall Grass"};
   @SideOnly(Side.CLIENT)
   private IIcon[] field_149870_b;

   public BlockKetherTallGrass() {
      super(Material.vine);
      float f = 0.4F;
      this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      if (p_149691_2_ >= this.field_149870_b.length) {
         p_149691_2_ = 0;
      }

      return this.field_149870_b[p_149691_2_];
   }

   @SideOnly(Side.CLIENT)
   public int getBlockColor() {
      double d0 = 0.5D;
      double d1 = 1.0D;
      return ColorizerGrass.getGrassColor(d0, d1);
   }

   public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      return super.canBlockStay(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
   }

   @SideOnly(Side.CLIENT)
   public int getRenderColor(int p_149741_1_) {
      return p_149741_1_ == 0 ? 16777215 : ColorizerGrass.getGrassColor(0.5D, 1.0D);
   }

   @SideOnly(Side.CLIENT)
   public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      int l = p_149720_1_.getBlockMetadata(p_149720_2_, p_149720_3_, p_149720_4_);
      return l == 0 ? 16777215 : p_149720_1_.getBiomeGenForCoords(p_149720_2_, p_149720_4_).getBiomeGrassColor(p_149720_2_, p_149720_3_, p_149720_4_);
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
      return 1 + p_149679_2_.nextInt(p_149679_1_ * 2 + 1);
   }

   public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
   }

   public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.field_149870_b = new IIcon[field_149871_a.length];

      for(int i = 0; i < this.field_149870_b.length; ++i) {
         this.field_149870_b[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
      }

   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      int l = p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_);
      return l != 0;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      int l = p_149853_1_.getBlockMetadata(p_149853_3_, p_149853_4_, p_149853_5_);
      boolean b0 = true;
      if (l == 2) {
         b0 = true;
      }

   }

   public ArrayList getDrops(World world, int x, int y, int z, int meta, int fortune) {
      ArrayList ret = new ArrayList();
      if (world.rand.nextInt(8) != 0) {
         return ret;
      } else {
         ItemStack seed = ForgeHooks.getGrassSeed(world);
         if (seed != null) {
            ret.add(seed);
         }

         return ret;
      }
   }

   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
      return true;
   }

   public ArrayList onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
      ArrayList ret = new ArrayList();
      ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
      return ret;
   }
}
