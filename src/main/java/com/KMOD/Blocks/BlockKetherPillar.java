package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import com.KMOD.TileEntities.TileEntityKetherStonePillarBase;
import com.KMOD.TileEntities.TileEntityKetherStonePillarCenter;
import com.KMOD.TileEntities.TileEntityKetherStonePillarTop;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarBase;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarCenter;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarTop;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockKetherPillar extends BlockContainer {
   public BlockKetherPillar() {
      super(Material.rock);
      this.setTickRandomly(true);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
      if (this == KMOD_Main.KetherStonePillarBase) {
         return new TileEntityKetherStonePillarBase();
      } else if (this == KMOD_Main.KetherStonePillarCenter) {
         return new TileEntityKetherStonePillarCenter();
      } else if (this == KMOD_Main.KetherStonePillarTop) {
         return new TileEntityKetherStonePillarTop();
      } else if (this == KMOD_Main.KetherYellowStoneBrickPillarBase) {
         return new TileEntityKetherYellowStoneBrickPillarBase();
      } else if (this == KMOD_Main.KetherYellowStoneBrickPillarCenter) {
         return new TileEntityKetherYellowStoneBrickPillarCenter();
      } else {
         return this == KMOD_Main.KetherYellowStoneBrickPillarTop ? new TileEntityKetherYellowStoneBrickPillarTop() : null;
      }
   }

   public int getRenderType() {
      return -1;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(this);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
