package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKetherBoar extends ModelBase {
   ModelRenderer Body;
   ModelRenderer Leg1;
   ModelRenderer Leg2;
   ModelRenderer Leg3;
   ModelRenderer Leg4;
   ModelRenderer Tail;
   ModelRenderer Morda;
   ModelRenderer Zab1;
   ModelRenderer Zab2;
   ModelRenderer Zab3;
   ModelRenderer Zab4;
   ModelRenderer Zab5;
   ModelRenderer Zab6;
   ModelRenderer Zab7;
   ModelRenderer Zab8;
   ModelRenderer Grzbiet1;
   ModelRenderer Grzbiet2;
   ModelRenderer Grzbiet3;
   ModelRenderer Grzbiet4;
   ModelRenderer Grzbiet5;

   public ModelKetherBoar() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Body = new ModelRenderer(this, 0, 19);
      this.Body.addBox(0.0F, 0.0F, 0.0F, 14, 14, 19);
      this.Body.setRotationPoint(-7.0F, 7.0F, -8.0F);
      this.Body.setTextureSize(128, 128);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
      this.Leg1 = new ModelRenderer(this, 20, 0);
      this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2);
      this.Leg1.setRotationPoint(-7.0F, 21.0F, -8.0F);
      this.Leg1.setTextureSize(128, 128);
      this.Leg1.mirror = true;
      this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
      this.Leg2 = new ModelRenderer(this, 20, 0);
      this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2);
      this.Leg2.setRotationPoint(5.0F, 21.0F, 9.0F);
      this.Leg2.setTextureSize(128, 128);
      this.Leg2.mirror = true;
      this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
      this.Leg3 = new ModelRenderer(this, 20, 0);
      this.Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2);
      this.Leg3.setRotationPoint(5.0F, 21.0F, -8.0F);
      this.Leg3.setTextureSize(128, 128);
      this.Leg3.mirror = true;
      this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
      this.Leg4 = new ModelRenderer(this, 20, 0);
      this.Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2);
      this.Leg4.setRotationPoint(-7.0F, 21.0F, 9.0F);
      this.Leg4.setTextureSize(128, 128);
      this.Leg4.mirror = true;
      this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
      this.Tail = new ModelRenderer(this, 50, 0);
      this.Tail.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
      this.Tail.setRotationPoint(-1.0F, 10.0F, 11.0F);
      this.Tail.setTextureSize(128, 128);
      this.Tail.mirror = true;
      this.setRotation(this.Tail, -0.5205006F, 0.0F, 0.0F);
      this.Morda = new ModelRenderer(this, 0, 58);
      this.Morda.addBox(0.0F, 0.0F, 0.0F, 14, 8, 1);
      this.Morda.setRotationPoint(-7.0F, 13.0F, -9.0F);
      this.Morda.setTextureSize(128, 128);
      this.Morda.mirror = true;
      this.setRotation(this.Morda, 0.0F, 0.0F, 0.0F);
      this.Zab1 = new ModelRenderer(this, 0, 0);
      this.Zab1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab1.setRotationPoint(6.0F, 12.0F, -9.0F);
      this.Zab1.setTextureSize(128, 128);
      this.Zab1.mirror = true;
      this.setRotation(this.Zab1, 0.0F, 0.0F, 0.0F);
      this.Zab2 = new ModelRenderer(this, 0, 0);
      this.Zab2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab2.setRotationPoint(-7.0F, 12.0F, -9.0F);
      this.Zab2.setTextureSize(128, 128);
      this.Zab2.mirror = true;
      this.setRotation(this.Zab2, 0.0F, 0.0F, 0.0F);
      this.Zab3 = new ModelRenderer(this, 0, 0);
      this.Zab3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab3.setRotationPoint(2.0F, 12.0F, -9.0F);
      this.Zab3.setTextureSize(128, 128);
      this.Zab3.mirror = true;
      this.setRotation(this.Zab3, 0.0F, 0.0F, 0.0F);
      this.Zab4 = new ModelRenderer(this, 0, 0);
      this.Zab4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab4.setRotationPoint(-5.0F, 12.0F, -9.0F);
      this.Zab4.setTextureSize(128, 128);
      this.Zab4.mirror = true;
      this.setRotation(this.Zab4, 0.0F, 0.0F, 0.0F);
      this.Zab5 = new ModelRenderer(this, 0, 0);
      this.Zab5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab5.setRotationPoint(4.0F, 12.0F, -9.0F);
      this.Zab5.setTextureSize(128, 128);
      this.Zab5.mirror = true;
      this.setRotation(this.Zab5, 0.0F, 0.0F, 0.0F);
      this.Zab6 = new ModelRenderer(this, 0, 0);
      this.Zab6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab6.setRotationPoint(-3.0F, 12.0F, -9.0F);
      this.Zab6.setTextureSize(128, 128);
      this.Zab6.mirror = true;
      this.setRotation(this.Zab6, 0.0F, 0.0F, 0.0F);
      this.Zab7 = new ModelRenderer(this, 0, 0);
      this.Zab7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab7.setRotationPoint(0.0F, 12.0F, -9.0F);
      this.Zab7.setTextureSize(128, 128);
      this.Zab7.mirror = true;
      this.setRotation(this.Zab7, 0.0F, 0.0F, 0.0F);
      this.Zab8 = new ModelRenderer(this, 0, 0);
      this.Zab8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Zab8.setRotationPoint(-1.0F, 12.0F, -9.0F);
      this.Zab8.setTextureSize(128, 128);
      this.Zab8.mirror = true;
      this.setRotation(this.Zab8, 0.0F, 0.0F, 0.0F);
      this.Grzbiet1 = new ModelRenderer(this, 74, 0);
      this.Grzbiet1.addBox(0.0F, 0.0F, 0.0F, 0, 5, 2);
      this.Grzbiet1.setRotationPoint(0.0F, 3.0F, -6.0F);
      this.Grzbiet1.setTextureSize(128, 128);
      this.Grzbiet1.mirror = true;
      this.setRotation(this.Grzbiet1, 0.2974289F, 0.0F, 0.0F);
      this.Grzbiet2 = new ModelRenderer(this, 74, 0);
      this.Grzbiet2.addBox(0.0F, 0.0F, 0.0F, 0, 5, 2);
      this.Grzbiet2.setRotationPoint(0.0F, 4.0F, -3.0F);
      this.Grzbiet2.setTextureSize(128, 128);
      this.Grzbiet2.mirror = true;
      this.setRotation(this.Grzbiet2, 0.2974289F, 0.0F, 0.0F);
      this.Grzbiet3 = new ModelRenderer(this, 74, 0);
      this.Grzbiet3.addBox(0.0F, 0.0F, 0.0F, 0, 5, 2);
      this.Grzbiet3.setRotationPoint(0.0F, 5.0F, 0.0F);
      this.Grzbiet3.setTextureSize(128, 128);
      this.Grzbiet3.mirror = true;
      this.setRotation(this.Grzbiet3, 0.2974289F, 0.0F, 0.0F);
      this.Grzbiet4 = new ModelRenderer(this, 74, 0);
      this.Grzbiet4.addBox(0.0F, 0.0F, 0.0F, 0, 5, 2);
      this.Grzbiet4.setRotationPoint(0.0F, 6.0F, 3.0F);
      this.Grzbiet4.setTextureSize(128, 128);
      this.Grzbiet4.mirror = true;
      this.setRotation(this.Grzbiet4, 0.2974289F, 0.0F, 0.0F);
      this.Grzbiet5 = new ModelRenderer(this, 74, 0);
      this.Grzbiet5.addBox(0.0F, 0.0F, 0.0F, 0, 5, 2);
      this.Grzbiet5.setRotationPoint(0.0F, 7.0F, 6.0F);
      this.Grzbiet5.setTextureSize(128, 128);
      this.Grzbiet5.mirror = true;
      this.setRotation(this.Grzbiet5, 0.2974289F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Body.render(f5);
      this.Leg1.render(f5);
      this.Leg2.render(f5);
      this.Leg3.render(f5);
      this.Leg4.render(f5);
      this.Tail.render(f5);
      this.Morda.render(f5);
      this.Zab1.render(f5);
      this.Zab2.render(f5);
      this.Zab3.render(f5);
      this.Zab4.render(f5);
      this.Zab5.render(f5);
      this.Zab6.render(f5);
      this.Zab7.render(f5);
      this.Zab8.render(f5);
      this.Grzbiet1.render(f5);
      this.Grzbiet2.render(f5);
      this.Grzbiet3.render(f5);
      this.Grzbiet4.render(f5);
      this.Grzbiet5.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
