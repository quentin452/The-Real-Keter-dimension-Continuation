package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemKetherHoe extends Item {
   protected ToolMaterial theToolMaterial;

   public ItemKetherHoe(ToolMaterial p_i45343_1_, String Name) {
      this.theToolMaterial = p_i45343_1_;
      this.maxStackSize = 1;
      this.setMaxDamage(p_i45343_1_.getMaxUses());
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
         if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
         } else if (event.getResult() == Result.ALLOW) {
            p_77648_1_.damageItem(1, p_77648_2_);
            return true;
         } else {
            Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
            if (p_77648_7_ == 0 || !p_77648_3_.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(p_77648_3_, p_77648_4_, p_77648_5_ + 1, p_77648_6_) || block != Blocks.grass && block != Blocks.dirt) {
               return false;
            } else {
               Block block1 = Blocks.farmland;
               p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
               if (p_77648_3_.isRemote) {
                  return true;
               } else {
                  p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                  p_77648_1_.damageItem(1, p_77648_2_);
                  return true;
               }
            }
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
      return true;
   }

   public String getToolMaterialName() {
      return this.theToolMaterial.toString();
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
