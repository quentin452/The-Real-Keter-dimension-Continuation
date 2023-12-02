package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKetherCloud extends BlockKetherBlock {
   public BlockKetherCloud() {
      super("Kether Cloud");
      this.setLightOpacity(0);
      this.setTickRandomly(true);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
   }

   public int getRenderType() {
      return 0;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      if (KMOD_Main.instance.getSEtap() >= 6) {
         return p_149650_2_.nextInt(5) == 3 ? KMOD_Main.CloudDust : Item.getItemFromBlock(this);
      } else {
         return Item.getItemFromBlock(this);
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
      entity.fallDistance = 0.0F;
      if (entity instanceof EntityPlayer) {
      }

      entity.fallDistance = 0.0F;
   }

   @SideOnly(Side.CLIENT)
   public int getRenderBlockPass() {
      return 1;
   }

   public int getRenderColor(int i) {
      if (i == 1) {
         return 13434879;
      } else {
         return i != 2 ? 16777215 : 16777088;
      }
   }

   public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k) {
      return this.getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
   }

   public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return true;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
      return world.getBlockMetadata(i, j, k) == 1 ? AxisAlignedBB.getBoundingBox((double)i, (double)j, (double)k, (double)i, (double)j, (double)k) : AxisAlignedBB.getBoundingBox((double)i, (double)j, (double)k, (double)(i + 1), (double)j, (double)(k + 1));
   }
}
