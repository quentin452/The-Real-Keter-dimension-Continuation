package com.KMOD.Gui;

import com.KMOD.Container.ContainerGiftsBlock;
import com.KMOD.Main.KMOD_Main;
import com.KMOD.TileEntities.TileEntityGiftsBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiGiftsBlock extends GuiContainer {
   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("Real Kether:textures/gui/container/Gifts Block.png");
   private TileEntityGiftsBlock tileFurnace;

   public GuiGiftsBlock(InventoryPlayer par1InventoryPlayer, TileEntityGiftsBlock par2TileEntityGiftsBlock) {
      super(new ContainerGiftsBlock(par1InventoryPlayer, par2TileEntityGiftsBlock));
      this.tileFurnace = par2TileEntityGiftsBlock;
   }

   protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
      String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
      this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 20, 4210752);
      this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
      FontRenderer var10000 = this.fontRendererObj;
      StringBuilder var10001 = (new StringBuilder()).append("Satisfaction: ");
      KMOD_Main var10002 = KMOD_Main.instance;
      var10000.drawString(I18n.format(var10001.append(KMOD_Main.Satisfaction).toString(), new Object[0]), 8, this.ySize - 115, 4210752);
   }

   protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
      int k = (this.width - this.xSize) / 2;
      int l = (this.height - this.ySize) / 2;
      this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
      int i1 = this.tileFurnace.getCookProgressScaled(122);
      this.drawTexturedModalRect(k + 27, l + 3, 0, 166, i1, 15);
      int i11 = this.tileFurnace.getSatisfactionProgressScaled(169);
      this.drawTexturedModalRect(k + 3, l + 28, 0, 181, i11, 9);
   }
}
