package fr.keter.KMOD.Recipes;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesRevertedKetherGemBlocks {
   private String[][] recipePatterns = new String[][]{{"X"}};
   private Object[][] recipeItems;

   public RecipesRevertedKetherGemBlocks() {
      this.recipeItems = new Object[][]{{Item.getItemFromBlock(KMOD_Main.RubyBlock), Item.getItemFromBlock(KMOD_Main.TopazBlock), Item.getItemFromBlock(KMOD_Main.SapphireBlock), Item.getItemFromBlock(KMOD_Main.LonsdaleiteBlock), Item.getItemFromBlock(KMOD_Main.MalachiteBlock), Item.getItemFromBlock(KMOD_Main.AdamantiumBlock), Item.getItemFromBlock(KMOD_Main.ShadowBlock), Item.getItemFromBlock(KMOD_Main.SaintBlock)}, {KMOD_Main.RubyGem, KMOD_Main.TopazGem, KMOD_Main.SapphireGem, KMOD_Main.LonsdaleiteGem, KMOD_Main.Malachite, KMOD_Main.AdamantiumIngot, KMOD_Main.ShadowGem, KMOD_Main.SaintGem}};
   }

   public void addRecipes() {
      for(int i = 0; i < this.recipeItems[0].length; ++i) {
         Object object = this.recipeItems[0][i];

         for(int j = 0; j < this.recipeItems.length - 1; ++j) {
            Item block = (Item)this.recipeItems[j + 1][i];
            GameRegistry.addRecipe(new ItemStack(block, 9), new Object[]{this.recipePatterns[j], 'X', object});
         }
      }

   }
}
