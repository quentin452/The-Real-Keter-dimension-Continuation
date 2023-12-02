package com.KMOD.Rendering;

import animations.New.AnimationHandlerNew;
import com.KMOD.Entities.EntitySimple;
import com.KMOD.Models.ModelSimple;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSimple extends RenderLiving {
   private static final ResourceLocation cowTextures = new ResourceLocation("real kether:textures/entities/Drago/texture1.png");
   private static final ModelBase Model1 = new ModelSimple();

   public RenderSimple() {
      super(Model1, 1.0F);
   }

   public void doRender(Entity _entity, double d, double d1, double d2, float f, float f1) {
      EntitySimple entity = (EntitySimple)_entity;
      entity.getAnimationHandler().animationsUpdate();
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      super.doRender(entity, d, d1, d2, f, f1);
      GL11.glEnable(2884);
      GL11.glPopMatrix();
      if (entity.isWalking() && !entity.getIsWalkingAnimationActive()) {
         entity.getAnimationHandler().activateAnimation(AnimationHandlerNew.animChannels, "walkCycle", 1.0F);
      }

   }

   protected void preRenderCallback(EntityLivingBase entityliving, float f) {
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, 3.0F, 0.0F);
   }

   protected ResourceLocation getEntityTexture(EntitySimple e) {
      return cowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntitySimple)p_110775_1_);
   }
}
