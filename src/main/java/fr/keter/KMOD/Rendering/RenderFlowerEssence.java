package fr.keter.KMOD.Rendering;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFlowerEssence extends Render {
   private float field_77002_a = 0.3F;
   private Item item;

   public RenderFlowerEssence(Item it) {
      this.item = it;
   }

   public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glPushMatrix();
      this.bindEntityTexture(p_76986_1_);
      GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
      GL11.glEnable(32826);
      float f2 = this.field_77002_a;
      GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
      IIcon iicon = this.item.getIconFromDamage(0);
      Tessellator tessellator = Tessellator.instance;
      float f3 = iicon.getMinU();
      float f4 = iicon.getMaxU();
      float f5 = iicon.getMinV();
      float f6 = iicon.getMaxV();
      float f7 = 1.0F;
      float f8 = 0.5F;
      float f9 = 0.25F;
      GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
      tessellator.startDrawingQuads();
      tessellator.setNormal(0.0F, 1.0F, 0.0F);
      tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
      tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
      tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
      tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
      tessellator.draw();
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return TextureMap.locationItemsTexture;
   }
}
