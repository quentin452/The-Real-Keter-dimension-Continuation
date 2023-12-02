package fr.keter.KMOD.Items;

import fr.keter.KMOD.Blocks.BlockKetherBlock;
import fr.keter.KMOD.Entities.EntityCaveGuardian;
import fr.keter.KMOD.Entities.EntityDemonEye;
import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemKether extends Item {
   Block field_150935_a;
   Random random;

   public ItemKether(String Name) {
      this.field_150935_a = KMOD_Main.Hemp;
      this.random = new Random();
      this.maxStackSize = 64;
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIconFromDamage(int p_77617_1_) {
      return this.itemIcon;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer e, List par3List, boolean par4) {
      if (this == KMOD_Main.YellowFlowerEssence) {
         par3List.add("§eClear Yellow Energy");
      }

      if (this == KMOD_Main.BlueFlowerEssence) {
         par3List.add("§9Clear Blue Energy");
      }

      if (this == KMOD_Main.RedFlowerEssence) {
         par3List.add("§cClear Red Energy");
      }

      if (this == KMOD_Main.KetherEnergy) {
         par3List.add("§bThe Cleariest Energy In The World");
      }

      if (this == KMOD_Main.DarkEnergy) {
         par3List.add("§0It Smells Bad");
      }

      if (this == KMOD_Main.DemonEyeSummoner) {
         par3List.add("§5WOOOOOO!");
      }

      if (this == KMOD_Main.KetherKey) {
         par3List.add("§bThat's A Key!");
      }

      if (this == KMOD_Main.Pytajnik) {
         par3List.add("§b???");
      }

      if (this == KMOD_Main.MidasHand) {
         par3List.add("§6WOOOOOOW!!!");
      }

   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
       if (p_77659_3_.capabilities.isCreativeMode && (p_77659_2_.isRemote)) {
           p_77659_3_.addChatMessage(new ChatComponentText("You must be in survival mode to use the item ??? due to a duplication issue."));
           return p_77659_1_;
       }
      else if (this == KMOD_Main.Pytajnik && !p_77659_3_.capabilities.isCreativeMode) {
         int c = random.nextInt(15);
         int c1 = random.nextInt(5);
         int c2 = random.nextInt(10);
         ItemStack i;
         if (random.nextInt(10) == 1) {
            i = new ItemStack(KMOD_Main.Crystals, c);
         } else if (random.nextInt(10) == 1) {
            i = new ItemStack(KMOD_Main.LonsdaleiteGem, c1);
         } else if (random.nextInt(10) == 1) {
            i = new ItemStack(KMOD_Main.RubyGem, c2);
         } else if (random.nextInt(10) == 1) {
            i = new ItemStack(KMOD_Main.TopazGem, c2);
         } else if (random.nextInt(10) == 1) {
            i = new ItemStack(KMOD_Main.SapphireGem, c2);
         } else if (random.nextInt(11) == 1) {
            i = new ItemStack(KMOD_Main.HermesBoots, 1);
         } else if (random.nextInt(12) == 1) {
            i = new ItemStack(KMOD_Main.JumpBoots, 1);
         } else if (random.nextInt(13) == 1) {
            i = new ItemStack(KMOD_Main.LonsdaleiteSword, 1);
         } else if (random.nextInt(12) == 1) {
            i = new ItemStack(KMOD_Main.KetherEnergy, c);
         } else if (random.nextInt(12) == 1) {
            i = new ItemStack(KMOD_Main.DarkEnergy, c1);
         } else if (random.nextInt(17) == 1) {
            i = new ItemStack(KMOD_Main.DemonEyeSummoner, 1);
         } else if (random.nextInt(30) == 1) {
            i = new ItemStack(KMOD_Main.KetherWand, 1);
         } else if (random.nextInt(15) == 1) {
            i = new ItemStack(KMOD_Main.KetherBlueWand, 1);
         } else if (random.nextInt(15) == 1) {
            i = new ItemStack(KMOD_Main.KetherRedWand, 1);
         } else if (random.nextInt(15) == 1) {
            i = new ItemStack(KMOD_Main.KetherYellowWand, 1);
         } else if (random.nextInt(45) == 3) {
            i = new ItemStack(KMOD_Main.LegendaryMagicWand, 1);
         } else if (random.nextInt(100) == 3) {
            i = new ItemStack(KMOD_Main.MidasHand, 1);
         } else {
            i = new ItemStack(KMOD_Main.Joint, c);
         }

         p_77659_3_.inventory.consumeInventoryItem(KMOD_Main.Pytajnik);
         p_77659_3_.inventory.addItemStackToInventory(i);
      }

      if (this == KMOD_Main.DemonEyeSummoner) {
         if (!p_77659_2_.isRemote) {
            EntityDemonEye ede = new EntityDemonEye(p_77659_2_);
            ede.setLocationAndAngles(p_77659_3_.posX, p_77659_3_.posY + 3.0D, p_77659_3_.posZ, p_77659_3_.rotationYaw, 0.0F);
            p_77659_2_.spawnEntityInWorld(ede);
         }

         p_77659_3_.inventory.consumeInventoryItem(KMOD_Main.DemonEyeSummoner);
      }

      if (this == KMOD_Main.KetherStatue && p_77659_3_.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && p_77659_2_.getBlock((int)p_77659_3_.posX, (int)p_77659_3_.posY - 1, (int)p_77659_3_.posZ) == KMOD_Main.KetherYellowStoneBrick) {
         EntityCaveGuardian ecg = new EntityCaveGuardian(p_77659_2_);
         ecg.setLocationAndAngles(p_77659_3_.posX + 1.0D, p_77659_3_.posY, p_77659_3_.posZ + 1.0D, p_77659_3_.rotationYaw, 0.0F);
         p_77659_3_.worldObj.spawnEntityInWorld(ecg);
         p_77659_3_.inventory.consumeInventoryItem(KMOD_Main.KetherStatue);
      }

      return p_77659_1_;
   }

   public void setBlockWithUnbreakable(World w, int i, int j, int k, BlockKetherBlock bkb) {
      w.setBlock(i, j, k, bkb);
      bkb.setunbreakable();
   }

   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if (this == KMOD_Main.MidasHand) {
         if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
         } else {
            UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
            if (MinecraftForge.EVENT_BUS.post(event)) {
               return false;
            } else if (event.getResult() == Result.ALLOW) {
               return true;
            } else {
               p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
               if (p_77648_7_ != 0) {
                  Block block1 = Blocks.gold_block;
                  if (p_77648_3_.isRemote) {
                     return true;
                  } else {
                     p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                     if (this.random.nextInt(500) == 50) {
                        p_77648_2_.addChatMessage(new ChatComponentText("Oops... Something Went Wrong"));
                        p_77648_2_.inventory.consumeInventoryItem(KMOD_Main.MidasHand);
                     }

                     return true;
                  }
               } else {
                  return false;
               }
            }
         }
      } else if (this != KMOD_Main.Weed) {
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
}
