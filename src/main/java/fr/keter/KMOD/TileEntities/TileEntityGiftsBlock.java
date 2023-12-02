package fr.keter.KMOD.TileEntities;

import fr.keter.KMOD.Main.KMOD_Main;
import fr.keter.KMOD.Recipes.RecipesGiftsBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGiftsBlock extends TileEntity implements ISidedInventory {
   private static final int[] slotsTop = new int[]{0};
   private static final int[] slotsBottom = new int[]{2, 1};
   private static final int[] slotsSides = new int[]{1};
   private ItemStack[] furnaceItemStacks = new ItemStack[3];
   public int furnaceCookTime;
   private String field_145958_o;
   int SatisfactionNew;
   int c = 0;
   int c1 = 0;

   public void addSatisfaction(int i) {
      KMOD_Main var10000 = KMOD_Main.instance;
      KMOD_Main.Satisfaction = this.SatisfactionNew + i;
   }

   public void setSatisfaction(int i) {
      KMOD_Main var10000 = KMOD_Main.instance;
      KMOD_Main.Satisfaction = i;
   }

   public void substractSatisfaction(int i) {
      KMOD_Main var10000 = KMOD_Main.instance;
      KMOD_Main.Satisfaction = this.SatisfactionNew - i;
   }

   public int getSatisfaction(int i) {
      KMOD_Main var10000 = KMOD_Main.instance;
      return KMOD_Main.Satisfaction;
   }

   public int getSizeInventory() {
      return this.furnaceItemStacks.length;
   }

   public ItemStack getStackInSlot(int par1) {
      return this.furnaceItemStacks[par1];
   }

   public ItemStack decrStackSize(int par1, int par2) {
      if (this.furnaceItemStacks[par1] != null) {
         ItemStack itemstack;
         if (this.furnaceItemStacks[par1].stackSize <= par2) {
            itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
         } else {
            itemstack = this.furnaceItemStacks[par1].splitStack(par2);
            if (this.furnaceItemStacks[par1].stackSize == 0) {
               this.furnaceItemStacks[par1] = null;
            }

            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int par1) {
      if (this.furnaceItemStacks[par1] != null) {
         ItemStack itemstack = this.furnaceItemStacks[par1];
         this.furnaceItemStacks[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
      this.furnaceItemStacks[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
         par2ItemStack.stackSize = this.getInventoryStackLimit();
      }

   }

   public String getInventoryName() {
      return this.hasCustomInventoryName() ? this.field_145958_o : "Gifts Block";
   }

   public boolean hasCustomInventoryName() {
      return this.field_145958_o != null && this.field_145958_o.length() > 0;
   }

   public void func_145951_a(String p_145951_1_) {
      this.field_145958_o = p_145951_1_;
   }

   public void readFromNBT(NBTTagCompound p_145839_1_) {
      super.readFromNBT(p_145839_1_);
      NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
      this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

      for(int i = 0; i < nbttaglist.tagCount(); ++i) {
         NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
         byte b0 = nbttagcompound1.getByte("Slot");
         if (b0 >= 0 && b0 < this.furnaceItemStacks.length) {
            this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
         }
      }

      this.furnaceCookTime = p_145839_1_.getShort("CookTime");
      if (p_145839_1_.hasKey("CustomName", 8)) {
         this.field_145958_o = p_145839_1_.getString("CustomName");
      }

      KMOD_Main var10000 = KMOD_Main.instance;
      KMOD_Main.Satisfaction = p_145839_1_.getShort("Satisfaction");
   }

   public void writeToNBT(NBTTagCompound p_145841_1_) {
      super.writeToNBT(p_145841_1_);
      p_145841_1_.setShort("CookTime", (short)this.furnaceCookTime);
      NBTTagList nbttaglist = new NBTTagList();

      for(int i = 0; i < this.furnaceItemStacks.length; ++i) {
         if (this.furnaceItemStacks[i] != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i);
            this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
         }
      }

      p_145841_1_.setTag("Items", nbttaglist);
      if (this.hasCustomInventoryName()) {
         p_145841_1_.setString("CustomName", this.field_145958_o);
      }

      KMOD_Main var10002 = KMOD_Main.instance;
      p_145841_1_.setShort("Satisfaction", (short)KMOD_Main.Satisfaction);
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   @SideOnly(Side.CLIENT)
   public int getCookProgressScaled(int p_145953_1_) {
      return this.furnaceCookTime * p_145953_1_ / 450;
   }

   @SideOnly(Side.CLIENT)
   public int getSatisfactionProgressScaled(int p_145953_1_) {
      return this.SatisfactionNew * p_145953_1_ / 9999;
   }

   public void updateEntity() {
      KMOD_Main var10001 = KMOD_Main.instance;
      this.SatisfactionNew = KMOD_Main.Satisfaction;
      boolean flag1 = false;
      if (!this.worldObj.isRemote) {
         if (this.SatisfactionNew >= 3500) {
            ++this.c1;
            if (this.c1 >= 8000) {
               this.c1 = 0;
               this.substractSatisfaction(1);
            }
         }

         if (this.canSmelt()) {
            ++this.c;
            if (this.c >= 1000) {
               this.c = 0;
               this.substractSatisfaction(1);
            }

            ++this.furnaceCookTime;
            if (this.furnaceCookTime == 450) {
               this.furnaceCookTime = 0;
               this.smeltItem();
               flag1 = true;
            }
         } else {
            this.furnaceCookTime = 0;
         }
      }

      if (flag1) {
         this.markDirty();
      }

   }

   private boolean canSmelt() {
      if (this.furnaceItemStacks[0] != null) {
         if (this.SatisfactionNew >= 0 && this.SatisfactionNew <= 9999) {
            return true;
         } else if (this.SatisfactionNew >= 9999 && this.furnaceItemStacks[0].getItem() != KMOD_Main.DarkEnergy) {
            return false;
         } else {
            return this.SatisfactionNew >= 0;
         }
      } else {
         return false;
      }
   }

   public void smeltItem() {
      new NBTTagCompound();
      if (this.canSmelt()) {
         int k = RecipesGiftsBlock.smelting().getSmeltingResult(this.furnaceItemStacks[0].getItem());
         this.addSatisfaction(k);
         --this.furnaceItemStacks[0].stackSize;
         if (this.furnaceItemStacks[0].stackSize <= 0) {
            this.furnaceItemStacks[0] = null;
         }
      }

   }

   public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
      return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
   }

   public void openInventory() {
   }

   public void closeInventory() {
   }

   public int[] getAccessibleSlotsFromSide(int par1) {
      return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
   }

   public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
      return this.isItemValidForSlot(par1, par2ItemStack);
   }

   public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
      return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
   }

   public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
      return false;
   }
}
