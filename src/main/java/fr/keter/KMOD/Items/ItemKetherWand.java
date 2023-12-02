package fr.keter.KMOD.Items;

import fr.keter.KMOD.Entities.EntityBlueEssence;
import fr.keter.KMOD.Entities.EntityKeherEnergy;
import fr.keter.KMOD.Entities.EntityRedEssence;
import fr.keter.KMOD.Entities.EntityYellowEssence;
import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemKetherWand extends ItemKether {
   public ItemKetherWand(String Name) {
      super(Name);
      this.maxStackSize = 1;
      this.setMaxDamage(384);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer e) {
      if (this == KMOD_Main.KetherBlueWand) {
         if (e.inventory.hasItem(KMOD_Main.BlueFlowerEssence)) {
            EntityBlueEssence ebe = new EntityBlueEssence(w, e);
            if (!w.isRemote) {
               w.spawnEntityInWorld(ebe);
            }

            e.inventory.consumeInventoryItem(KMOD_Main.BlueFlowerEssence);
         } else if (w.isRemote) {
            e.addChatMessage(new ChatComponentText("You need Blue Flower Essence!"));
         }
      }

      if (this == KMOD_Main.KetherRedWand) {
         if (e.inventory.hasItem(KMOD_Main.RedFlowerEssence)) {
            EntityRedEssence ebe = new EntityRedEssence(w, e);
            if (!w.isRemote) {
               w.spawnEntityInWorld(ebe);
            }

            e.inventory.consumeInventoryItem(KMOD_Main.RedFlowerEssence);
         } else if (w.isRemote) {
            e.addChatMessage(new ChatComponentText("You need Red Flower Essence!"));
         }
      }

      if (this == KMOD_Main.KetherYellowWand) {
         if (e.inventory.hasItem(KMOD_Main.YellowFlowerEssence)) {
            EntityYellowEssence ebe = new EntityYellowEssence(w, e);
            if (!w.isRemote) {
               w.spawnEntityInWorld(ebe);
            }

            e.inventory.consumeInventoryItem(KMOD_Main.YellowFlowerEssence);
         } else if (w.isRemote) {
            e.addChatMessage(new ChatComponentText("You need Yellow Flower Essence!"));
         }
      }

      if (this == KMOD_Main.KetherWand) {
         if (e.inventory.hasItem(KMOD_Main.KetherEnergy)) {
            EntityKeherEnergy ebe = new EntityKeherEnergy(w, e);
            if (!w.isRemote) {
               w.spawnEntityInWorld(ebe);
            }

            e.inventory.consumeInventoryItem(KMOD_Main.KetherEnergy);
         } else if (w.isRemote) {
            e.addChatMessage(new ChatComponentText("You need Kether Energy!"));
         }
      }

      return i;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      if (this == KMOD_Main.KetherYellowWand) {
         par3List.add("§eOhhh Yes!");
      }

      if (this == KMOD_Main.KetherBlueWand) {
         par3List.add("§9Ohhh Yes!");
      }

      if (this == KMOD_Main.KetherRedWand) {
         par3List.add("§cOhhh Yes!");
      }

      if (this == KMOD_Main.KetherWand) {
         par3List.add("§bThe Best Wand!");
      }

   }

   public int getMaxItemUseDuration(ItemStack p_77626_1_) {
      return 72000;
   }

   public int getItemEnchantability() {
      return 0;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
