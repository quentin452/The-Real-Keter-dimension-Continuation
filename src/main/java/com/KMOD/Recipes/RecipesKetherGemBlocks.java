package com.KMOD.Recipes;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class RecipesKetherGemBlocks {
   private String[][] recipePatterns = new String[][]{{"XXX", "XXX", "XXX"}};
   private Object[][] recipeItems;

   public RecipesKetherGemBlocks() {
      this.recipeItems = new Object[][]{{KMOD_Main.RubyGem, KMOD_Main.TopazGem, KMOD_Main.SapphireGem, KMOD_Main.LonsdaleiteGem, KMOD_Main.Malachite, KMOD_Main.AdamantiumIngot, KMOD_Main.ShadowGem, KMOD_Main.SaintGem}, {KMOD_Main.RubyBlock, KMOD_Main.TopazBlock, KMOD_Main.SapphireBlock, KMOD_Main.LonsdaleiteBlock, KMOD_Main.MalachiteBlock, KMOD_Main.AdamantiumBlock, KMOD_Main.ShadowBlock, KMOD_Main.SaintBlock}};
   }

   public void addRecipes() {
      for(int i = 0; i < this.recipeItems[0].length; ++i) {
         Object object = this.recipeItems[0][i];

         for(int j = 0; j < this.recipeItems.length - 1; ++j) {
            Block block = (Block)this.recipeItems[j + 1][i];
            GameRegistry.addRecipe(new ItemStack(block), new Object[]{this.recipePatterns[j], 'X', object});
         }
      }

   }
}
