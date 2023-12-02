package com.KMOD.Recipes;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesKetherWeapons {
   private String[][] recipePatterns = new String[][]{{"X", "X", "#"}};
   private Object[][] recipeItems;

   public RecipesKetherWeapons() {
      this.recipeItems = new Object[][]{{KMOD_Main.RubyGem, KMOD_Main.TopazGem, KMOD_Main.SapphireGem, KMOD_Main.LonsdaleiteGem, KMOD_Main.AdamantiumIngot, KMOD_Main.ShadowGem, KMOD_Main.SaintGem}, {KMOD_Main.RubySword, KMOD_Main.TopazSword, KMOD_Main.SapphireSword, KMOD_Main.LonsdaleiteSword, KMOD_Main.AdamantiumSword, KMOD_Main.ShadowSword, KMOD_Main.SaintSword}};
   }

   public void addRecipes() {
      for(int i = 0; i < this.recipeItems[0].length; ++i) {
         Object object = this.recipeItems[0][i];

         for(int j = 0; j < this.recipeItems.length - 1; ++j) {
            Item item = (Item)this.recipeItems[j + 1][i];
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{this.recipePatterns[j], '#', Items.stick, 'X', object});
         }
      }

   }
}
