package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockUnbreakableKetherLog extends BlockLog {
   public static final String[] field_150168_M = new String[]{"Kether"};

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.field_150167_a = new IIcon[field_150168_M.length];
      this.field_150166_b = new IIcon[field_150168_M.length];

      for(int i = 0; i < this.field_150167_a.length; ++i) {
         this.field_150167_a[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
         this.field_150166_b[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_top");
      }

   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return this == KMOD_Main.KetherLonsdaleiteLog ? KMOD_Main.LonsdaleiteGem : Item.getItemFromBlock(this);
   }
}
