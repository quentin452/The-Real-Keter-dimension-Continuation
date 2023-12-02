package fr.keter.KMOD.Items;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemGravityWand extends ItemKether {
   private int gravity;
   private boolean upgraded;

   public ItemGravityWand(String Name) {
      super(Name);
      this.maxStackSize = 1;
      this.setMaxDamage(384);
      this.setUnlocalizedName(Name);
      this.setCreativeTab(KMOD_Main.KetherTab);
      this.gravity = 0;
      this.upgraded = false;
   }

   public void setUpgraded(boolean b) {
      this.upgraded = b;
   }

   public boolean getUpgraded() {
      return this.upgraded;
   }

   public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer e) {
      Random random = new Random();
      if (!w.isRemote) {
         ++this.gravity;
         if (this.gravity == 2) {
            this.gravity = 0;
         }
      }

      if (random.nextInt(1000) == 567 && e instanceof EntityPlayer) {
         e.inventory.consumeInventoryItem(this);
         if (w.isRemote) {
            e.addChatMessage(new ChatComponentText("OOps... Something Went Wrong"));
         }
      }

      return i;
   }

   public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase e1, EntityLivingBase e2) {
      if (this.upgraded) {
         ++e1.motionY;
      }

      return false;
   }

   public void onUpdate(ItemStack i, World w, Entity e, int icc, boolean b) {
      new Random();
      if (this.gravity == 1) {
         e.motionY = 0.2D;
      }

      e.fallDistance = 0.0F;
   }

   public int getMaxItemUseDuration(ItemStack p_77626_1_) {
      return 72000;
   }

   public void addInformation(ItemStack par1ItemStack, EntityPlayer e, List par3List, boolean par4) {
      if (this == KMOD_Main.GravityWand && this.upgraded) {
         par3List.add("Enchanted!");
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
      this.itemIcon = par1IconRegister.registerIcon("Real Kether:" + this.getUnlocalizedName().substring(5));
   }
}
