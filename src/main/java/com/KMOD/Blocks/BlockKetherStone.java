package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BlockKetherStone extends BlockStone {
   public BlockKetherStone(String Name) {
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.setBlockName(Name);
      this.setHardness(1.5F);
      this.setResistance(10.0F);
      this.setStepSound(soundTypePiston);
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(KMOD_Main.KetherCobblestone);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
