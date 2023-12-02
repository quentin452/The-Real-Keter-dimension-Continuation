package com.KMOD.Blocks;

import com.KMOD.Main.KMOD_Main;
import com.KMOD.Particles.KetherParticleSpawner;
import com.KMOD.TileEntities.TileEntityGiftsBlock;
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

public class BlockGiftsBlock extends BlockContainer {
   private final Random field_149933_a = new Random();
   private static boolean field_149934_M;
   @SideOnly(Side.CLIENT)
   private IIcon field_149935_N;
   @SideOnly(Side.CLIENT)
   private IIcon field_149936_O;

   public BlockGiftsBlock() {
      super(Material.rock);
   }

   public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.getItemFromBlock(KMOD_Main.GiftsBlock);
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
         TileEntityGiftsBlock var10 = (TileEntityGiftsBlock)par1World.getTileEntity(par2, par3, par4);
         if (var10 != null) {
            par5EntityPlayer.openGui(KMOD_Main.instance, 1, par1World, par2, par3, par4);
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
         p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, KMOD_Main.GiftsBlock);
      } else {
         p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, KMOD_Main.GiftsBlock);
      }

      field_149934_M = false;
      p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);
      if (tileentity != null) {
         tileentity.validate();
         p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
      }

   }

   public void onBlockDestroyedByPlayer(World w, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      if (this == KMOD_Main.GiftsBlock) {
         w.setBlock(p_149664_2_, p_149664_3_, p_149664_4_, KMOD_Main.GiftsBlock);
         EntityPlayer ep = w.getClosestPlayer((double)p_149664_2_, (double)p_149664_3_, (double)p_149664_4_, 16.0D);
         float actualhealth = ep.getHealth();
         ep.setHealth(actualhealth - 9.0F);
      }

   }

   public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
      return new TileEntityGiftsBlock();
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
         ((TileEntityGiftsBlock)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
      }

   }

   public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if (!field_149934_M) {
         TileEntityGiftsBlock TileEntityGiftsBlock = (TileEntityGiftsBlock)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
         if (TileEntityGiftsBlock != null) {
            for(int i1 = 0; i1 < TileEntityGiftsBlock.getSizeInventory(); ++i1) {
               ItemStack itemstack = TileEntityGiftsBlock.getStackInSlot(i1);
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
      for(int l = 0; l < 4; ++l) {
         double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
         double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
         double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
         double d3 = 0.0D;
         double d4 = 0.0D;
         double d5 = 0.0D;
         int i1 = p_149734_5_.nextInt(2) * 2 - 1;
         d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
         if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this) {
            d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
         } else {
            d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
            d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
         }

         KetherParticleSpawner kps = new KetherParticleSpawner();
         KetherParticleSpawner.spawnParticle("KetherPortalParticle", d0, d1, d2, d3, d4, d5);
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
      return Item.getItemFromBlock(KMOD_Main.GiftsBlock);
   }
}
