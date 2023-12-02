package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockKetherLog extends BlockLog {
   public static final String[] field_150168_M = new String[]{"Kether"};
   Random r = new Random();

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.field_150167_a = new IIcon[field_150168_M.length];
      this.field_150166_b = new IIcon[field_150168_M.length];

      for(int i = 0; i < this.field_150167_a.length; ++i) {
         if (this == KMOD_Main.UnbreakbleKetherLog) {
            this.field_150167_a[i] = p_149651_1_.registerIcon("Real Kether:Kether Log");
            this.field_150166_b[i] = p_149651_1_.registerIcon("Real Kether:Kether Log_top");
         }

         if (this == KMOD_Main.LifeLog) {
            this.field_150167_a[i] = p_149651_1_.registerIcon("Real Kether:Kether Log");
            this.field_150166_b[i] = p_149651_1_.registerIcon("Real Kether:Kether Log_top");
         }

         this.field_150167_a[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
         this.field_150166_b[i] = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_top");
      }

   }

   public void onBlockDestroyedByPlayer(World w, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      if (this == KMOD_Main.LifeLog) {
         w.setBlock(p_149664_2_, p_149664_3_, p_149664_4_, KMOD_Main.LifeLog);
         EntityPlayer ep = w.getClosestPlayer((double)p_149664_2_, (double)p_149664_3_, (double)p_149664_4_, 16.0D);
         float actualhealth = ep.getHealth();
         ep.setHealth(actualhealth - 7.0F);
      }

   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return this == KMOD_Main.KetherLonsdaleiteLog ? KMOD_Main.LonsdaleiteGem : Item.getItemFromBlock(this);
   }

   public int quantityDropped(Random p_149745_1_) {
      if (this == KMOD_Main.KetherLog) {
         if (KMOD_Main.instance.getSEtap() == 1) {
            return 0;
         } else if (KMOD_Main.instance.getSEtap() == 2) {
            return this.r.nextInt(10) == 1 ? 1 : 0;
         } else if (KMOD_Main.instance.getSEtap() == 3) {
            return this.r.nextInt(8) == 1 ? 1 : 0;
         } else if (KMOD_Main.instance.getSEtap() == 4) {
            return this.r.nextInt(4) == 1 ? 1 : 0;
         } else if (KMOD_Main.instance.getSEtap() == 5) {
            return 1;
         } else if (KMOD_Main.instance.getSEtap() == 6) {
            return this.r.nextInt(10) == 1 ? 2 : 1;
         } else if (KMOD_Main.instance.getSEtap() == 7) {
            return this.r.nextInt(4) == 1 ? 3 : 2;
         } else if (KMOD_Main.instance.getSEtap() == 8) {
            return this.r.nextInt(5) == 1 ? 4 : 3;
         } else if (KMOD_Main.instance.getSEtap() == 9) {
            return this.r.nextInt(6) == 1 ? 5 : 4;
         } else if (KMOD_Main.instance.getSEtap() == 10) {
            return this.r.nextInt(7) == 1 ? 6 : 5;
         } else {
            return KMOD_Main.instance.isSBest() ? 7 : 1;
         }
      } else {
         return 1;
      }
   }
}
