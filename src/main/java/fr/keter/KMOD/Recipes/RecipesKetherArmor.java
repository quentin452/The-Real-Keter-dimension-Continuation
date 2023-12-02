package fr.keter.KMOD.Recipes;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesKetherArmor {
   private String[][] recipePatterns = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Object[][] recipeItems;

   public RecipesKetherArmor() {
      this.recipeItems = new Object[][]{{KMOD_Main.RubyGem, KMOD_Main.TopazGem, KMOD_Main.SapphireGem, KMOD_Main.LonsdaleiteGem, KMOD_Main.AdamantiumIngot, KMOD_Main.ShadowGem, KMOD_Main.SaintGem}, {KMOD_Main.RubyHelmet, KMOD_Main.TopazHelmet, KMOD_Main.SapphireHelmet, KMOD_Main.LonsdaleiteHelmet, KMOD_Main.AdamantiumHelmet, KMOD_Main.ShadowHelmet, KMOD_Main.SaintHelmet}, {KMOD_Main.RubyChestplate, KMOD_Main.TopazChestplate, KMOD_Main.SapphireChestplate, KMOD_Main.LonsdaleiteChestplate, KMOD_Main.AdamantiumChestplate, KMOD_Main.ShadowChestplate, KMOD_Main.SaintChestplate}, {KMOD_Main.RubyLeggins, KMOD_Main.TopazLeggins, KMOD_Main.SapphireLeggins, KMOD_Main.LonsdaleiteLeggins, KMOD_Main.AdamantiumLeggins, KMOD_Main.ShadowLeggins, KMOD_Main.SaintLeggins}, {KMOD_Main.RubyBoots, KMOD_Main.TopazBoots, KMOD_Main.SapphireBoots, KMOD_Main.LonsdaleiteBoots, KMOD_Main.AdamantiumBoots, KMOD_Main.ShadowBoots, KMOD_Main.SaintBoots}};
   }

   public void addRecipes() {
      for(int i = 0; i < this.recipeItems[0].length; ++i) {
         Object object = this.recipeItems[0][i];

         for(int j = 0; j < this.recipeItems.length - 1; ++j) {
            Item item = (Item)this.recipeItems[j + 1][i];
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{this.recipePatterns[j], 'X', object});
         }
      }

   }
}
