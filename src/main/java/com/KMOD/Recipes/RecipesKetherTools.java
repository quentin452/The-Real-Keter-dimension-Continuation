package com.KMOD.Recipes;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesKetherTools {
   private String[][] recipePatterns = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] recipeItems;

   public RecipesKetherTools() {
      this.recipeItems = new Object[][]{{KMOD_Main.RubyGem, KMOD_Main.TopazGem, KMOD_Main.SapphireGem, KMOD_Main.LonsdaleiteGem, KMOD_Main.AdamantiumIngot, KMOD_Main.ShadowGem, KMOD_Main.SaintGem}, {KMOD_Main.RubyPickaxe, KMOD_Main.TopazPickaxe, KMOD_Main.SapphirePickaxe, KMOD_Main.LonsdaleitePickaxe, KMOD_Main.AdamantiumPickaxe, KMOD_Main.ShadowPickaxe, KMOD_Main.SaintPickaxe}, {KMOD_Main.RubyShovel, KMOD_Main.TopazShovel, KMOD_Main.SapphireShovel, KMOD_Main.LonsdaleiteShovel, KMOD_Main.AdamantiumShovel, KMOD_Main.ShadowShovel, KMOD_Main.SaintShovel}, {KMOD_Main.RubyAxe, KMOD_Main.TopazAxe, KMOD_Main.SapphireAxe, KMOD_Main.LonsdaleiteAxe, KMOD_Main.AdamantiumAxe, KMOD_Main.ShadowAxe, KMOD_Main.SaintAxe}, {KMOD_Main.RubyHoe, KMOD_Main.TopazHoe, KMOD_Main.SapphireHoe, KMOD_Main.LonsdaleiteHoe, KMOD_Main.AdamantiumHoe, KMOD_Main.ShadowHoe, KMOD_Main.SaintHoe}};
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
