package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BlockKetherGemBlock extends Block {
   public BlockKetherGemBlock(String Name) {
      super(Material.piston);
      this.setHardness(3.0F);
      this.setResistance(5.0F);
      this.setStepSound(soundTypePiston);
      this.setBlockName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(this);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
