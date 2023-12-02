package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKetherButterfly extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;

   public ModelKetherButterfly() {
      this.textureWidth = 64;
      this.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
      this.Shape1.setRotationPoint(0.0F, 12.0F, -3.0F);
      this.Shape1.setTextureSize(64, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, -0.1487144F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 40, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2);
      this.Shape2.setRotationPoint(1.0F, 12.0F, -2.0F);
      this.Shape2.setTextureSize(64, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 40, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2);
      this.Shape3.setRotationPoint(0.0F, 13.0F, -2.0F);
      this.Shape3.setTextureSize(64, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 3.141593F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      this.Shape2.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
      this.Shape3.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
   }
}
