package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockKetherOre extends Block {
   Random r = new Random();

   public BlockKetherOre(float i, String Name) {
      super(Material.rock);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.setHardness(i);
      this.setBlockName(Name);
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      if (this == KMOD_Main.SapphireOre) {
         return KMOD_Main.SapphireGem;
      } else if (this == KMOD_Main.RubyOre) {
         return KMOD_Main.RubyGem;
      } else if (this == KMOD_Main.TopazOre) {
         return KMOD_Main.TopazGem;
      } else if (this == KMOD_Main.LonsdaleiteOre) {
         return KMOD_Main.LonsdaleiteGem;
      } else if (this == KMOD_Main.MalachiteOre) {
         return KMOD_Main.Malachite;
      } else if (this == KMOD_Main.AdamantiumOre) {
         return Item.getItemFromBlock(KMOD_Main.AdamantiumOre);
      } else if (this == KMOD_Main.ShadowOre) {
         return KMOD_Main.ShadowGem;
      } else {
         return this == KMOD_Main.SaintOre ? KMOD_Main.SaintGem : Items.diamond;
      }
   }

   public int quantityDropped(Random p_149745_1_) {
      if (this == KMOD_Main.AdamantiumOre) {
         return 1;
      } else if (this == KMOD_Main.ShadowOre) {
         return 1;
      } else if (this == KMOD_Main.SaintOre) {
         return 1;
      } else if (KMOD_Main.instance.getSEtap() == 1) {
         return this.r.nextInt(10) == 5 ? 1 : 0;
      } else if (KMOD_Main.instance.getSEtap() == 2) {
         return this.r.nextInt(8) == 5 ? 1 : 0;
      } else if (KMOD_Main.instance.getSEtap() == 3) {
         return this.r.nextInt(6) == 1 ? 1 : 0;
      } else if (KMOD_Main.instance.getSEtap() == 4) {
         return this.r.nextInt(3) == 1 ? 1 : 0;
      } else if (KMOD_Main.instance.getSEtap() == 5) {
         return 1;
      } else if (KMOD_Main.instance.getSEtap() == 6) {
         return this.r.nextInt(3) == 1 ? 2 : 1;
      } else if (KMOD_Main.instance.getSEtap() == 7) {
         return this.r.nextInt(3) == 1 ? 3 : 2;
      } else if (KMOD_Main.instance.getSEtap() == 8) {
         return this.r.nextInt(3) == 1 ? 4 : 3;
      } else if (KMOD_Main.instance.getSEtap() == 9) {
         return this.r.nextInt(3) == 1 ? 5 : 4;
      } else if (KMOD_Main.instance.getSEtap() == 10) {
         return 6;
      } else if (KMOD_Main.instance.isSBest()) {
         return this.r.nextInt(3) == 1 ? 10 : 8;
      } else {
         return KMOD_Main.instance.isSHostile() ? 0 : 1;
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
