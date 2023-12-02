package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemKetherShovel extends ItemTool {
   private static final Set field_150916_c;

   public ItemKetherShovel(ToolMaterial p_i45353_1_, String Name) {
      super(1.0F, p_i45353_1_, field_150916_c);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public boolean func_150897_b(Block p_150897_1_) {
      return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
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
      field_150916_c = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
   }
}
