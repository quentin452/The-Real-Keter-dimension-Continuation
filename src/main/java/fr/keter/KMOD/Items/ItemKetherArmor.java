package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemKetherArmor extends ItemArmor {
   public ItemKetherArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_, String Name) {
      super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister p_94581_1_) {
      this.itemIcon = p_94581_1_.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
      if (this == KMOD_Main.LonsdaleiteBoots) {
         player.fallDistance = 0.0F;
      }

      if (this == KMOD_Main.LonsdaleiteChestplate) {
         player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 500, 4));
      }

      if (this == KMOD_Main.LonsdaleiteHelmet) {
         player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 500, 4));
      }

      if (this == KMOD_Main.JumpBoots) {
         player.addPotionEffect(new PotionEffect(Potion.jump.id, 500, 4));
         player.fallDistance = 0.0F;
      }

      if (this == KMOD_Main.HermesBoots) {
         player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 500, 4));
      }

   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      if (this == KMOD_Main.LonsdaleiteBoots) {
         par3List.add("§bPainless Fall?");
      }

      if (this == KMOD_Main.LonsdaleiteChestplate) {
         par3List.add("§bHow is the fire does not burn?");
      }

      if (this == KMOD_Main.LonsdaleiteHelmet) {
         par3List.add("§bDo I have gills?");
      }

      if (this == KMOD_Main.JumpBoots) {
         par3List.add("§fWhat The F..k with ME?!?!?");
      }

      if (this == KMOD_Main.HermesBoots) {
         par3List.add("§fVery fast! And No Pain During Fall!");
      }

   }

   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
      if (!stack.getItem().equals(KMOD_Main.SapphireHelmet) && !stack.getItem().equals(KMOD_Main.SapphireChestplate) && !stack.getItem().equals(KMOD_Main.SapphireBoots)) {
         if (stack.getItem().equals(KMOD_Main.SapphireLeggins)) {
            return "Real Kether:textures/armor/SapphireArmor_layer_2.png";
         } else if (!stack.getItem().equals(KMOD_Main.SapphireHelmet) && !stack.getItem().equals(KMOD_Main.SapphireChestplate) && !stack.getItem().equals(KMOD_Main.SapphireBoots)) {
            if (stack.getItem().equals(KMOD_Main.SapphireLeggins)) {
               return "Real Kether:textures/armor/SapphireArmor_layer_2.png";
            } else if (!stack.getItem().equals(KMOD_Main.RubyHelmet) && !stack.getItem().equals(KMOD_Main.RubyChestplate) && !stack.getItem().equals(KMOD_Main.RubyBoots)) {
               if (stack.getItem().equals(KMOD_Main.RubyLeggins)) {
                  return "Real Kether:textures/armor/RubyArmor_layer_2.png";
               } else if (!stack.getItem().equals(KMOD_Main.TopazHelmet) && !stack.getItem().equals(KMOD_Main.TopazChestplate) && !stack.getItem().equals(KMOD_Main.TopazBoots)) {
                  if (stack.getItem().equals(KMOD_Main.TopazLeggins)) {
                     return "Real Kether:textures/armor/TopazArmor_layer_2.png";
                  } else if (!stack.getItem().equals(KMOD_Main.LonsdaleiteHelmet) && !stack.getItem().equals(KMOD_Main.LonsdaleiteChestplate) && !stack.getItem().equals(KMOD_Main.LonsdaleiteBoots)) {
                     if (stack.getItem().equals(KMOD_Main.LonsdaleiteLeggins)) {
                        return "Real Kether:textures/armor/LonsdaleiteArmor_layer_2.png";
                     } else if (stack.getItem().equals(KMOD_Main.JumpBoots)) {
                        return "Real Kether:textures/armor/SpecialArmor_layer_1.png";
                     } else if (stack.getItem().equals(KMOD_Main.HermesBoots)) {
                        return "Real Kether:textures/armor/SpecialArmor_layer_1.png";
                     } else if (!stack.getItem().equals(KMOD_Main.AdamantiumHelmet) && !stack.getItem().equals(KMOD_Main.AdamantiumChestplate) && !stack.getItem().equals(KMOD_Main.AdamantiumBoots)) {
                        if (stack.getItem().equals(KMOD_Main.AdamantiumLeggins)) {
                           return "Real Kether:textures/armor/AdamantiumArmor_layer_2.png";
                        } else if (!stack.getItem().equals(KMOD_Main.ShadowHelmet) && !stack.getItem().equals(KMOD_Main.ShadowChestplate) && !stack.getItem().equals(KMOD_Main.ShadowBoots)) {
                           if (stack.getItem().equals(KMOD_Main.ShadowLeggins)) {
                              return "Real Kether:textures/armor/ShadowArmor_layer_2.png";
                           } else if (!stack.getItem().equals(KMOD_Main.SaintHelmet) && !stack.getItem().equals(KMOD_Main.SaintChestplate) && !stack.getItem().equals(KMOD_Main.SaintBoots)) {
                              return stack.getItem().equals(KMOD_Main.SaintLeggins) ? "Real Kether:textures/armor/SaintArmor_layer_2.png" : null;
                           } else {
                              return "Real Kether:textures/armor/SaintArmor_layer_1.png";
                           }
                        } else {
                           return "Real Kether:textures/armor/ShadowArmor_layer_1.png";
                        }
                     } else {
                        return "Real Kether:textures/armor/AdamantiumArmor_layer_1.png";
                     }
                  } else {
                     return "Real Kether:textures/armor/LonsdaleiteArmor_layer_1.png";
                  }
               } else {
                  return "Real Kether:textures/armor/TopazArmor_layer_1.png";
               }
            } else {
               return "Real Kether:textures/armor/RubyArmor_layer_1.png";
            }
         } else {
            return "Real Kether:textures/armor/SapphireArmor_layer_1.png";
         }
      } else {
         return "Real Kether:textures/armor/SapphireArmor_layer_1.png";
      }
   }
}
