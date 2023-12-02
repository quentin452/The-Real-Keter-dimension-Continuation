package fr.keter.KMOD.Gui;

import fr.keter.KMOD.Container.ContainerEnergyEnchanter;
import fr.keter.KMOD.TileEntities.TileEntityEnergyEnchanter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiEnergyEnchanter extends GuiContainer {
   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("Real Kether:textures/gui/container/Energy Enchanter1.png");
   private TileEntityEnergyEnchanter tileFurnace;

   public GuiEnergyEnchanter(InventoryPlayer p_i1091_1_, TileEntityEnergyEnchanter p_i1091_2_) {
      super(new ContainerEnergyEnchanter(p_i1091_1_, p_i1091_2_));
      this.tileFurnace = p_i1091_2_;
   }

   protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
      String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
      this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
      this.fontRendererObj.drawString(I18n.format("Cost: " + this.tileFurnace.cost, new Object[0]), 58, this.ySize - 96 + 2, 4210752);
   }

   protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
      int k = (this.width - this.xSize) / 2;
      int l = (this.height - this.ySize) / 2;
      this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
      if (this.tileFurnace.isBurning()) {
         int i1 = this.tileFurnace.getBurnTimeRemainingScaled(40);
         this.drawTexturedModalRect(k + 5, l + 21 + 40 - i1, 176, 40 - i1, 22, i1 + 4);
         i1 = this.tileFurnace.getCookProgressScaled(122);
         this.drawTexturedModalRect(k + 25, l + 4, 0, 166, i1, 16);
      }

   }
}
