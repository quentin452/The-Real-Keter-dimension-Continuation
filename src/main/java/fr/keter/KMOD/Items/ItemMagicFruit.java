package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemMagicFruit extends ItemFood implements IPlantable {
   private Block field_150908_b;
   private Block soilId;
   Block field_150935_a;

   public ItemMagicFruit(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_, Block p_i45351_4_, String Name) {
      super(p_i45351_1_, p_i45351_2_, false);
      this.field_150935_a = KMOD_Main.MagicFruitBlock;
      this.field_150908_b = p_i45351_3_;
      this.soilId = p_i45351_4_;
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.setAlwaysEdible();
   }

   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if (this != KMOD_Main.MagicFruit) {
         return this.bFull3D;
      } else {
         Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
         if (block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1) {
            p_77648_7_ = 1;
         } else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush) {
            if (p_77648_7_ == 0) {
               --p_77648_5_;
            }

            if (p_77648_7_ == 1) {
               ++p_77648_5_;
            }

            if (p_77648_7_ == 2) {
               --p_77648_6_;
            }

            if (p_77648_7_ == 3) {
               ++p_77648_6_;
            }

            if (p_77648_7_ == 4) {
               --p_77648_4_;
            }

            if (p_77648_7_ == 5) {
               ++p_77648_4_;
            }
         }

         if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
         } else if (p_77648_1_.stackSize == 0) {
            return false;
         } else {
            if (p_77648_3_.canPlaceEntityOnSide(this.field_150935_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_)) {
               int i1 = this.field_150935_a.onBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
               if (p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150935_a, i1, 3)) {
                  if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150935_a) {
                     this.field_150935_a.onBlockPlacedBy(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
                     this.field_150935_a.onPostBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
                  }

                  p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.field_150935_a.stepSound.func_150496_b(), (this.field_150935_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150935_a.stepSound.getPitch() * 0.8F);
                  --p_77648_1_.stackSize;
               }
            }

            return true;
         }
      }
   }

   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
      return EnumPlantType.Crop;
   }

   public Block getPlant(IBlockAccess world, int x, int y, int z) {
      return this.field_150908_b;
   }

   public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
      return 0;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
