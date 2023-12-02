package fr.keter.KMOD.Recipes;

import fr.keter.KMOD.Main.KMOD_Main;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesGiftsBlock {
   private static final RecipesGiftsBlock smeltingBase = new RecipesGiftsBlock();
   private Map smeltingList = new HashMap();
   private Map experienceList = new HashMap();

   public static RecipesGiftsBlock smelting() {
      return smeltingBase;
   }

   private RecipesGiftsBlock() {
   }

   public int getSmeltingResult(Item it) {
      if (it == KMOD_Main.RubyGem) {
         return 10;
      } else if (it == KMOD_Main.TopazGem) {
         return 10;
      } else if (it == KMOD_Main.SapphireGem) {
         return 10;
      } else if (it == Items.diamond) {
         return 10;
      } else if (it == KMOD_Main.Pytajnik) {
         return 20;
      } else if (it == KMOD_Main.EnergyCrystal) {
         return 50;
      } else if (it == Items.golden_apple) {
         return 20;
      } else if (it == Item.getItemFromBlock(KMOD_Main.Crystals)) {
         return -40;
      } else if (it == KMOD_Main.KetherEnergy) {
         return 10;
      } else if (it == KMOD_Main.LonsdaleiteGem) {
         return 20;
      } else if (it == KMOD_Main.DarkEnergy) {
         return -20;
      } else if (it == KMOD_Main.JumpBoots) {
         return 100;
      } else if (it == KMOD_Main.HermesBoots) {
         return 100;
      } else if (it == KMOD_Main.KetherWand) {
         return -250;
      } else if (it == KMOD_Main.LegendaryMagicWand) {
         return -250;
      } else if (it == KMOD_Main.GravityWand) {
         return -50;
      } else if (it == KMOD_Main.AdamantiumIngot) {
         return 350;
      } else if (it == KMOD_Main.ShadowGem) {
         return 15;
      } else if (it == KMOD_Main.SaintGem) {
         return 18;
      } else {
         return it == KMOD_Main.MidasHand ? 500 : 1;
      }
   }

   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
      return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
   }

   public Map getSmeltingList() {
      return this.smeltingList;
   }

   public float func_151398_b(ItemStack p_151398_1_) {
      float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
      if (ret != -1.0F) {
         return ret;
      } else {
         Iterator iterator = this.experienceList.entrySet().iterator();

         while(iterator.hasNext()) {
            Entry entry = (Entry)iterator.next();
            if (this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey())) {
               return (Float)entry.getValue();
            }
         }

         return 0.0F;
      }
   }
}
