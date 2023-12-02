package fr.keter.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStoneDevourer extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Leg1;
   ModelRenderer Leg2;
   ModelRenderer Leg3;
   ModelRenderer Leg4;

   public ModelStoneDevourer() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 14);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 11, 11, 13);
      this.Shape1.setRotationPoint(-6.0F, 12.0F, -5.0F);
      this.Shape1.setTextureSize(128, 128);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 11, 5, 2);
      this.Shape2.setRotationPoint(-6.0F, 18.0F, -7.0F);
      this.Shape2.setTextureSize(128, 128);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 100, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape3.setRotationPoint(4.0F, 17.0F, -7.0F);
      this.Shape3.setTextureSize(128, 128);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 100, 0);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape4.setRotationPoint(-6.0F, 17.0F, -7.0F);
      this.Shape4.setTextureSize(128, 128);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 100, 0);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape5.setRotationPoint(-4.0F, 17.0F, -7.0F);
      this.Shape5.setTextureSize(128, 128);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 100, 0);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape6.setRotationPoint(-2.0F, 17.0F, -7.0F);
      this.Shape6.setTextureSize(128, 128);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 100, 0);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape7.setRotationPoint(2.0F, 17.0F, -7.0F);
      this.Shape7.setTextureSize(128, 128);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 100, 0);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape8.setRotationPoint(0.0F, 17.0F, -7.0F);
      this.Shape8.setTextureSize(128, 128);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Leg1 = new ModelRenderer(this, 0, 0);
      this.Leg1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Leg1.setRotationPoint(3.0F, 23.0F, -5.0F);
      this.Leg1.setTextureSize(128, 128);
      this.Leg1.mirror = true;
      this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
      this.Leg2 = new ModelRenderer(this, 0, 0);
      this.Leg2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Leg2.setRotationPoint(3.0F, 23.0F, 6.0F);
      this.Leg2.setTextureSize(128, 128);
      this.Leg2.mirror = true;
      this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
      this.Leg3 = new ModelRenderer(this, 0, 0);
      this.Leg3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Leg3.setRotationPoint(-6.0F, 23.0F, -5.0F);
      this.Leg3.setTextureSize(128, 128);
      this.Leg3.mirror = true;
      this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
      this.Leg4 = new ModelRenderer(this, 0, 0);
      this.Leg4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Leg4.setRotationPoint(-6.0F, 23.0F, 6.0F);
      this.Leg4.setTextureSize(128, 128);
      this.Leg4.mirror = true;
      this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      this.Shape6.render(f5);
      this.Shape7.render(f5);
      this.Shape8.render(f5);
      this.Leg1.render(f5);
      this.Leg2.render(f5);
      this.Leg3.render(f5);
      this.Leg4.render(f5);
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
