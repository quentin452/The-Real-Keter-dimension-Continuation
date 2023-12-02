package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockKetherGlowingGrass extends BlockKetherBushBase {
   @SideOnly(Side.CLIENT)
   private IIcon[] field_149861_N;
   private int field_149862_O;

   public BlockKetherGlowingGrass() {
      super(Material.plants);
      this.setHardness(0.0F);
      this.setBlockName("Glowing Kether Grass");
      this.setLightLevel(0.8F);
      this.setStepSound(Block.soundTypeGrass);
      this.setCreativeTab(KMOD_Main.KetherTab);
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
      return Item.getItemFromBlock(this);
   }
}
