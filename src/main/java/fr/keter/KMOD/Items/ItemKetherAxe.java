package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemKetherAxe extends ItemTool {
   private static final Set field_150917_c;

   public ItemKetherAxe(ToolMaterial p_i45327_1_, String Name) {
      super(3.0F, p_i45327_1_, field_150917_c);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
      return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public void addInformation(ItemStack it, EntityPlayer e, List par3List, boolean par4) {
      par3List.add("Max Durability: " + this.toolMaterial.getMaxUses());
      par3List.add("Effciency: " + this.toolMaterial.getEfficiencyOnProperMaterial());
      par3List.add("Harvest Level: " + this.toolMaterial.getHarvestLevel());
   }

   static {
      field_150917_c = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
   }
}
