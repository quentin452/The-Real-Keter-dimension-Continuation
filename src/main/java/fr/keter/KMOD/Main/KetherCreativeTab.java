package fr.keter.KMOD.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class KetherCreativeTab extends CreativeTabs {
   public KetherCreativeTab(int id, String name) {
      super(id, name);
   }

   public Item getTabIconItem() {
      return KMOD_Main.LonsdaleiteGem;
   }
}
