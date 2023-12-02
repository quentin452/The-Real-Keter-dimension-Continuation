package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMovingSands extends Block {
   public BlockMovingSands(String Name) {
      super(Material.ground);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.setBlockName(Name);
      this.setResistance(10.0F);
   }

   public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity e) {
      e.setInWeb();
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(KMOD_Main.MovingSands);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister par1IconRegister) {
      this.blockIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
