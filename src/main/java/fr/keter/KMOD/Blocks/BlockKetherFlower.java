package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockKetherFlower extends BlockKetherBushBase {
   @SideOnly(Side.CLIENT)
   private IIcon[] field_149861_N;
   private int field_149862_O;

   public BlockKetherFlower() {
      super(Material.plants);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return this.blockIcon;
   }

   public int damageDropped(int p_149692_1_) {
      return p_149692_1_;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      Random random = new Random();
      if (this == KMOD_Main.KetherYellowFlower && random.nextInt(4) == 1) {
         return KMOD_Main.YellowFlowerEssence;
      } else if (this == KMOD_Main.KetherBlueFlower && random.nextInt(4) == 1) {
         return KMOD_Main.BlueFlowerEssence;
      } else {
         return this == KMOD_Main.KetherRedFlower && random.nextInt(4) == 1 ? KMOD_Main.RedFlowerEssence : Item.getItemFromBlock(this);
      }
   }
}
