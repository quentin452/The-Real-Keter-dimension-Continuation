package fr.keter.KMOD.Blocks;

import fr.keter.KMOD.Main.KMOD_Main;
import fr.keter.KMOD.TileEntities.TileEntityEnergyConverter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnergyConverter extends BlockContainer {
   private final Random field_149933_a = new Random();
   private final boolean field_149932_b;
   private static boolean field_149934_M;
   @SideOnly(Side.CLIENT)
   private IIcon field_149935_N;
   @SideOnly(Side.CLIENT)
   private IIcon field_149936_O;

   public BlockEnergyConverter(boolean p_i45407_1_) {
      super(Material.rock);
      this.field_149932_b = p_i45407_1_;
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(KMOD_Main.EnergyConverter);
   }

   public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
   }

   private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_) {
      if (!p_149930_1_.isRemote) {
         Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
         Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
         Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
         Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
         byte b0 = 3;
         if (block.func_149730_j() && !block1.func_149730_j()) {
            b0 = 3;
         }

         if (block1.func_149730_j() && !block.func_149730_j()) {
            b0 = 2;
         }

         if (block2.func_149730_j() && !block3.func_149730_j()) {
            b0 = 5;
         }

         if (block3.func_149730_j() && !block2.func_149730_j()) {
            b0 = 4;
         }

         p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1 ? this.field_149935_N : (p_149691_1_ == 0 ? this.field_149935_N : (p_149691_1_ != p_149691_2_ ? this.blockIcon : this.field_149936_O));
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister p_149651_1_) {
      this.blockIcon = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_side");
      this.field_149936_O = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_front_active");
      this.field_149935_N = p_149651_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5) + "_top");
   }

   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
      if (par1World.isRemote) {
         return true;
      } else if (!par5EntityPlayer.isSneaking()) {
         TileEntityEnergyConverter var10 = (TileEntityEnergyConverter)par1World.getTileEntity(par2, par3, par4);
         if (var10 != null) {
            par5EntityPlayer.openGui(KMOD_Main.instance, 0, par1World, par2, par3, par4);
         }

         return true;
      } else {
         return false;
      }
   }

   public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
      int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
      TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
      field_149934_M = true;
      if (p_149931_0_) {
         p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, KMOD_Main.EnergyConverterActive);
      } else {
         p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, KMOD_Main.EnergyConverter);
      }

      field_149934_M = false;
      p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);
      if (tileentity != null) {
         tileentity.validate();
         p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
      }

   }

   public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
      return new TileEntityEnergyConverter();
   }

   public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
      if (l == 0) {
         p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
      }

      if (l == 1) {
         p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
      }

      if (l == 2) {
         p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
      }

      if (l == 3) {
         p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
      }

      if (p_149689_6_.hasDisplayName()) {
         ((TileEntityEnergyConverter)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
      }

   }

   public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if (!field_149934_M) {
         TileEntityEnergyConverter TileEntityEnergyConverter = (TileEntityEnergyConverter)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
         if (TileEntityEnergyConverter != null) {
            for(int i1 = 0; i1 < TileEntityEnergyConverter.getSizeInventory(); ++i1) {
               ItemStack itemstack = TileEntityEnergyConverter.getStackInSlot(i1);
               if (itemstack != null) {
                  float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                  float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                  float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

                  while(itemstack.stackSize > 0) {
                     int j1 = this.field_149933_a.nextInt(21) + 10;
                     if (j1 > itemstack.stackSize) {
                        j1 = itemstack.stackSize;
                     }

                     itemstack.stackSize -= j1;
                     EntityItem entityitem = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                     if (itemstack.hasTagCompound()) {
                        entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                     }

                     float f3 = 0.05F;
                     entityitem.motionX = (double)((float)this.field_149933_a.nextGaussian() * f3);
                     entityitem.motionY = (double)((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
                     entityitem.motionZ = (double)((float)this.field_149933_a.nextGaussian() * f3);
                     p_149749_1_.spawnEntityInWorld(entityitem);
                  }
               }
            }

            p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
         }
      }

      super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if (this.field_149932_b) {
         int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
         float f = (float)p_149734_2_ + 0.5F;
         float f1 = (float)p_149734_3_ + 0.0F + p_149734_5_.nextFloat() * 6.0F / 16.0F;
         float f2 = (float)p_149734_4_ + 0.5F;
         float f3 = 0.52F;
         float f4 = p_149734_5_.nextFloat() * 0.6F - 0.3F;
         if (l == 4) {
            p_149734_1_.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
         } else if (l == 5) {
            p_149734_1_.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
         } else if (l == 2) {
            p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
         } else if (l == 3) {
            p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
         }
      }

   }

   public boolean hasComparatorInputOverride() {
      return true;
   }

   public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      return Container.calcRedstoneFromInventory((IInventory)p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
   }

   @SideOnly(Side.CLIENT)
   public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.getItemFromBlock(KMOD_Main.EnergyConverter);
   }
}
