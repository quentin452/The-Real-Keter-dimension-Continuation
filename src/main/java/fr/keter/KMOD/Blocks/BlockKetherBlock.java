package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockKetherBlock extends BlockStone {
   public boolean breakble = true;
   Random r = new Random();

   public BlockKetherBlock(String Name) {
      this.setTickRandomly(true);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.setBlockName(Name);
      this.setHardness(1.5F);
      this.setResistance(10.0F);
      this.setStepSound(soundTypePiston);
   }

   public void setbreakble() {
      this.breakble = true;
   }

   public void setunbreakable() {
      this.breakble = false;
   }

   public void setBlockWithUnbreakable(World w, int i, int j, int k, BlockKetherBlock bkb) {
      w.setBlock(i, j, k, bkb);
      bkb.setunbreakable();
   }

   public void updateTick(World w, int i, int j, int k, Random random) {
      if (this.breakble) {
         this.setHardness(1.5F);
      }

      if (!this.breakble) {
         this.setHardness(-1.0F);
      }

   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      if (this == KMOD_Main.KetherStone) {
         if (KMOD_Main.instance.getSEtap() == 1) {
            return this.r.nextInt(5) == 1 ? Item.getItemFromBlock(this) : Items.stick;
         } else if (KMOD_Main.instance.getSEtap() == 2) {
            return this.r.nextInt(3) == 1 ? Item.getItemFromBlock(this) : Items.stick;
         } else if (KMOD_Main.instance.getSEtap() == 3) {
            return this.r.nextInt(2) == 1 ? Item.getItemFromBlock(this) : Items.stick;
         } else if (KMOD_Main.instance.getSEtap() == 4) {
            return Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 5) {
            return Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 6) {
            return this.r.nextInt(30) == 1 ? KMOD_Main.TopazGem : Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 7) {
            return this.r.nextInt(27) == 1 ? KMOD_Main.RubyGem : Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 8) {
            return this.r.nextInt(25) == 1 ? KMOD_Main.SapphireGem : Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 9) {
            return this.r.nextInt(25) == 3 ? KMOD_Main.LonsdaleiteGem : Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.getSEtap() == 10) {
            return this.r.nextInt(20) == 3 ? KMOD_Main.LonsdaleiteGem : Item.getItemFromBlock(this);
         } else if (KMOD_Main.instance.isSBest()) {
            return this.r.nextInt(15) == 3 ? KMOD_Main.LonsdaleiteGem : Item.getItemFromBlock(this);
         } else {
            return KMOD_Main.instance.isSHostile() ? Items.stick : Item.getItemFromBlock(this);
         }
      } else {
         return Item.getItemFromBlock(this);
      }
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
