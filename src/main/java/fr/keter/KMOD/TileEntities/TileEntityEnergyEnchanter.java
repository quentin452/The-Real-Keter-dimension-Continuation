package fr.keter.KMOD.TileEntities;

import fr.keter.KMOD.Blocks.BlockEnergyEnchanter;
import fr.keter.KMOD.Items.ItemEnergyCrystal;
import fr.keter.KMOD.Items.ItemGravityWand;
import fr.keter.KMOD.Items.ItemKether;
import fr.keter.KMOD.Items.ItemKetherWand;
import fr.keter.KMOD.Items.ItemLegendaryMagicWand;
import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEnergyEnchanter extends TileEntity implements ISidedInventory {
   private static final int[] slotsTop = new int[]{0};
   private static final int[] slotsBottom = new int[]{2, 1};
   private static final int[] slotsSides = new int[]{1};
   public int cost = 0;
   private ItemStack[] furnaceItemStacks = new ItemStack[4];
   public int furnaceBurnTime;
   public int currentItemBurnTime;
   public int furnaceCookTime;
   private String field_145958_o;

   public int getSizeInventory() {
      return this.furnaceItemStacks.length;
   }

   public ItemStack getStackInSlot(int p_70301_1_) {
      return this.furnaceItemStacks[p_70301_1_];
   }

   public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
      if (this.furnaceItemStacks[p_70298_1_] != null) {
         ItemStack itemstack;
         if (this.furnaceItemStacks[p_70298_1_].stackSize <= p_70298_2_) {
            itemstack = this.furnaceItemStacks[p_70298_1_];
            this.furnaceItemStacks[p_70298_1_] = null;
            return itemstack;
         } else {
            itemstack = this.furnaceItemStacks[p_70298_1_].splitStack(p_70298_2_);
            if (this.furnaceItemStacks[p_70298_1_].stackSize == 0) {
               this.furnaceItemStacks[p_70298_1_] = null;
            }

            return itemstack;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
      if (this.furnaceItemStacks[p_70304_1_] != null) {
         ItemStack itemstack = this.furnaceItemStacks[p_70304_1_];
         this.furnaceItemStacks[p_70304_1_] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
      this.furnaceItemStacks[p_70299_1_] = p_70299_2_;
      if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit()) {
         p_70299_2_.stackSize = this.getInventoryStackLimit();
      }

   }

   public String getInventoryName() {
      return this.hasCustomInventoryName() ? this.field_145958_o : "Energy Enchanter";
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

      this.furnaceBurnTime = p_145839_1_.getShort("BurnTime");
      this.furnaceCookTime = p_145839_1_.getShort("CookTime");
      this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
      if (p_145839_1_.hasKey("CustomName", 8)) {
         this.field_145958_o = p_145839_1_.getString("CustomName");
      }

   }

   public void writeToNBT(NBTTagCompound p_145841_1_) {
      super.writeToNBT(p_145841_1_);
      p_145841_1_.setShort("BurnTime", (short)this.furnaceBurnTime);
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

   }

   public int getInventoryStackLimit() {
      return 64;
   }

   @SideOnly(Side.CLIENT)
   public int getCookProgressScaled(int p_145953_1_) {
      return this.furnaceCookTime * p_145953_1_ / 4000;
   }

   @SideOnly(Side.CLIENT)
   public int getBurnTimeRemainingScaled(int p_145955_1_) {
      if (this.currentItemBurnTime == 0) {
         this.currentItemBurnTime = 200;
      }

      return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
   }

   public boolean isBurning() {
      return this.furnaceBurnTime > 0;
   }

   public void updateEntity() {
      ItemGravityWand igw = (ItemGravityWand)KMOD_Main.GravityWand;
      ItemKetherWand ikw = (ItemKetherWand)KMOD_Main.KetherWand;
      if (this.furnaceItemStacks[0] == null) {
         this.cost = 0;
      }

      if (this.furnaceItemStacks[0] != null && this.furnaceItemStacks[0].getItem() == igw) {
         this.cost = 100000000;
      }

      if (this.furnaceItemStacks[0] != null && this.furnaceItemStacks[0].getItem() == ikw) {
         this.cost = 200;
      }

      if (this.furnaceItemStacks[0] != null && this.furnaceItemStacks[0].getItem() == KMOD_Main.LonsdaleiteBoots) {
         this.cost = 100;
      }

      if (this.furnaceItemStacks[0] != null && this.furnaceItemStacks[0].getItem() == KMOD_Main.JumpBoots) {
         this.cost = 50;
      }

      if (this.furnaceItemStacks[0] != null && this.furnaceItemStacks[0].getItem() == KMOD_Main.BlueFruit) {
         this.cost = 30;
      }

      boolean flag = this.furnaceBurnTime > 0;
      boolean flag1 = false;
      if (this.furnaceBurnTime > 0) {
         --this.furnaceBurnTime;
      }

      if (!this.worldObj.isRemote) {
         if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
               this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
               if (this.furnaceBurnTime > 0) {
                  flag1 = true;
                  if (this.furnaceItemStacks[1] != null) {
                     --this.furnaceItemStacks[1].stackSize;
                     if (this.furnaceItemStacks[1].stackSize == 0) {
                        this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
                     }
                  }
               }
            }

            if (this.isBurning() && this.canSmelt()) {
               ++this.furnaceCookTime;
               if (this.furnaceCookTime == 4000) {
                  this.furnaceCookTime = 0;
                  this.smeltItem();
                  flag1 = true;
               }
            } else {
               this.furnaceCookTime = 0;
            }
         }

         if (flag != this.furnaceBurnTime > 0) {
            flag1 = true;
            BlockEnergyEnchanter.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
         }
      }

      if (flag1) {
         this.markDirty();
      }

   }

   private boolean canSmelt() {
      ItemEnergyCrystal iec = KMOD_Main.EnergyCrystal;
      ItemGravityWand igw = (ItemGravityWand)KMOD_Main.GravityWand;
      ItemKetherWand ikw = (ItemKetherWand)KMOD_Main.KetherWand;
      if (this.furnaceItemStacks[0] == null) {
         return false;
      } else if (this.furnaceItemStacks[3] != null && this.furnaceItemStacks[3].getItem() == iec) {
         if (this.furnaceItemStacks[0].getItem() == igw && iec.getCumulatedEnergy() >= 100000000 && this.furnaceItemStacks[2] == null && !igw.getUpgraded()) {
            return true;
         } else if (this.furnaceItemStacks[0].getItem() == ikw && iec.getCumulatedEnergy() >= 200 && this.furnaceItemStacks[2] == null) {
            return true;
         } else if (this.furnaceItemStacks[0].getItem() == KMOD_Main.LonsdaleiteBoots && iec.getCumulatedEnergy() >= 100 && this.furnaceItemStacks[2] == null) {
            return true;
         } else if (this.furnaceItemStacks[0].getItem() == KMOD_Main.JumpBoots && iec.getCumulatedEnergy() >= 50 && this.furnaceItemStacks[2] == null) {
            return true;
         } else {
            return this.furnaceItemStacks[0].getItem() == KMOD_Main.BlueFruit && iec.getCumulatedEnergy() >= 30 && this.furnaceItemStacks[2] == null;
         }
      } else {
         return false;
      }
   }

   public void smeltItem() {
      ItemEnergyCrystal iec = KMOD_Main.EnergyCrystal;
      ItemGravityWand igw = (ItemGravityWand)KMOD_Main.GravityWand;
      ItemKether LG = (ItemKether)KMOD_Main.LonsdaleiteGem;
      ItemKetherWand ikw = (ItemKetherWand)KMOD_Main.KetherWand;
      ItemLegendaryMagicWand ilmg = (ItemLegendaryMagicWand)KMOD_Main.LegendaryMagicWand;
      if (this.canSmelt()) {
         KMOD_Main var10000;
         if (this.furnaceItemStacks[0].getItem() == igw && !igw.getUpgraded() && iec.getCumulatedEnergy() >= 100000000) {
            this.furnaceItemStacks[2] = new ItemStack(igw, 1);
            igw.setUpgraded(true);
            var10000 = KMOD_Main.instance;
            var10000 = KMOD_Main.instance;
            KMOD_Main.CumulatedEnergy -= 100000000;
         }

         if (this.furnaceItemStacks[0].getItem() == ikw && iec.getCumulatedEnergy() >= 200) {
            this.furnaceItemStacks[2] = new ItemStack(ilmg, 1);
            var10000 = KMOD_Main.instance;
            var10000 = KMOD_Main.instance;
            KMOD_Main.CumulatedEnergy -= 200;
         }

         if (this.furnaceItemStacks[0].getItem() == KMOD_Main.LonsdaleiteBoots && iec.getCumulatedEnergy() >= 100) {
            this.furnaceItemStacks[2] = new ItemStack(KMOD_Main.JumpBoots, 1);
            var10000 = KMOD_Main.instance;
            var10000 = KMOD_Main.instance;
            KMOD_Main.CumulatedEnergy -= 100;
         }

         if (this.furnaceItemStacks[0].getItem() == KMOD_Main.JumpBoots && iec.getCumulatedEnergy() >= 50) {
            this.furnaceItemStacks[2] = new ItemStack(KMOD_Main.HermesBoots, 1);
            var10000 = KMOD_Main.instance;
            var10000 = KMOD_Main.instance;
            KMOD_Main.CumulatedEnergy -= 50;
         }

         if (this.furnaceItemStacks[0].getItem() == KMOD_Main.BlueFruit && iec.getCumulatedEnergy() >= 30) {
            this.furnaceItemStacks[2] = new ItemStack(KMOD_Main.MagicFruit, 1);
            var10000 = KMOD_Main.instance;
            var10000 = KMOD_Main.instance;
            KMOD_Main.CumulatedEnergy -= 30;
         }

         --this.furnaceItemStacks[0].stackSize;
         if (this.furnaceItemStacks[0].stackSize <= 0) {
            this.furnaceItemStacks[0] = null;
         }
      }

   }

   public static int getItemBurnTime(ItemStack p_145952_0_) {
      if (p_145952_0_ == null) {
         return 0;
      } else {
         Item item = p_145952_0_.getItem();
         if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
            Block block = Block.getBlockFromItem(item);
            if (block == Blocks.wooden_slab) {
               return 150;
            }

            if (block.getMaterial() == Material.wood) {
               return 300;
            }

            if (block == Blocks.coal_block) {
               return 16000;
            }
         }

         if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) {
            return 200;
         } else if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) {
            return 200;
         } else if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) {
            return 200;
         } else if (item == Items.stick) {
            return 100;
         } else if (item == Items.coal) {
            return 1600;
         } else if (item == Items.lava_bucket) {
            return 20000;
         } else if (item == Item.getItemFromBlock(Blocks.sapling)) {
            return 100;
         } else {
            return item == Items.blaze_rod ? 2400 : GameRegistry.getFuelValue(p_145952_0_);
         }
      }
   }

   public static boolean isItemFuel(ItemStack p_145954_0_) {
      return getItemBurnTime(p_145954_0_) > 0;
   }

   public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
      return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
   }

   public void openInventory() {
   }

   public void closeInventory() {
   }

   public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
      return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
   }

   public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
      return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
   }

   public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
      return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
   }

   public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
      return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
   }
}
