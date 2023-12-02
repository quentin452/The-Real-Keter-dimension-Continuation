package com.KMOD.Items;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemEnergyCrystal extends ItemKether {
   public ItemEnergyCrystal(String Name) {
      super(Name);
      this.maxStackSize = 1;
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer e, List par3List, boolean par4) {
      StringBuilder var10001 = (new StringBuilder()).append("§bCumulated Energy: ");
      KMOD_Main var10002 = KMOD_Main.instance;
      par3List.add(var10001.append(KMOD_Main.CumulatedEnergy).toString());
   }

   public void setCumulatedEnergy(int Energy) {
      KMOD_Main var10000 = KMOD_Main.instance;
      KMOD_Main.CumulatedEnergy = Energy;
   }

   public void subtractCumulatedEnergy(int Energy) {
      KMOD_Main var10000 = KMOD_Main.instance;
      var10000 = KMOD_Main.instance;
      KMOD_Main.CumulatedEnergy -= Energy;
   }

   public void addCumulatedEnergy(int Energy) {
      KMOD_Main var10000 = KMOD_Main.instance;
      var10000 = KMOD_Main.instance;
      KMOD_Main.CumulatedEnergy += Energy;
   }

   public int getCumulatedEnergy() {
      KMOD_Main var10000 = KMOD_Main.instance;
      return KMOD_Main.CumulatedEnergy;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
