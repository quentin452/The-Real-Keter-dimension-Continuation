package com.KMOD.Container;

import com.KMOD.Main.KMOD_Main;
import com.KMOD.TileEntities.TileEntityGiftsBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGiftsBlock extends Container {
   private TileEntityGiftsBlock tileFurnace;
   private int lastCookTime;
   int Satisfaction;

   public ContainerGiftsBlock(InventoryPlayer par1InventoryPlayer, TileEntityGiftsBlock par2TileEntityGiftsBlock) {
      KMOD_Main var10001 = KMOD_Main.instance;
      this.Satisfaction = KMOD_Main.Satisfaction;
      this.tileFurnace = par2TileEntityGiftsBlock;
      this.addSlotToContainer(new Slot(par2TileEntityGiftsBlock, 0, 4, 4));

      int i;
      for(i = 0; i < 3; ++i) {
         for(int j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
         }
      }

      for(i = 0; i < 9; ++i) {
         this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
      }

   }

   public void addCraftingToCrafters(ICrafting par1ICrafting) {
      super.addCraftingToCrafters(par1ICrafting);
      par1ICrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
      par1ICrafting.sendProgressBarUpdate(this, 1, this.Satisfaction);
   }

   public void detectAndSendChanges() {
      super.detectAndSendChanges();

      for(int i = 0; i < this.crafters.size(); ++i) {
         ICrafting icrafting = (ICrafting)this.crafters.get(i);
         if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
            icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
         }

         icrafting.sendProgressBarUpdate(this, 1, this.Satisfaction);
      }

      this.lastCookTime = this.tileFurnace.furnaceCookTime;
   }

   @SideOnly(Side.CLIENT)
   public void updateProgressBar(int par1, int par2) {
      if (par1 == 0) {
         this.tileFurnace.furnaceCookTime = par2;
      }

      if (par1 == 1) {
         this.Satisfaction = par2;
      }

   }

   public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
      return this.tileFurnace.isUseableByPlayer(par1EntityPlayer);
   }

   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack itemstack = null;
      Slot slot = (Slot)this.inventorySlots.get(par2);
      if (slot != null && slot.getHasStack()) {
         ItemStack itemstack1 = slot.getStack();
         itemstack = itemstack1.copy();
         if (par2 == 2) {
            if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
               return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
         } else if ((par2 == 1 || par2 == 0) && !this.mergeItemStack(itemstack1, 3, 39, false)) {
            return null;
         }

         if (itemstack1.stackSize == 0) {
            slot.putStack((ItemStack)null);
         } else {
            slot.onSlotChanged();
         }

         if (itemstack1.stackSize == itemstack.stackSize) {
            return null;
         }

         slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
      }

      return itemstack;
   }
}
