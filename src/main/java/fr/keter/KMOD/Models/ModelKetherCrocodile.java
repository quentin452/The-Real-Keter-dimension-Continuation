package fr.keter.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKetherCrocodile extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;
   ModelRenderer Shape10;
   ModelRenderer Shape11;

   public ModelKetherCrocodile() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Shape1 = new ModelRenderer(this, 2, 12);
      this.Shape1.addBox(-2.0F, 1.0F, -3.0F, 5, 5, 5);
      this.Shape1.setRotationPoint(0.0F, 15.0F, -2.0F);
      this.Shape1.setTextureSize(64, 32);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 32, 0);
      this.Shape2.addBox(-2.0F, 5.0F, -6.0F, 5, 1, 5);
      this.Shape2.setRotationPoint(0.0F, 15.4F, -2.0F);
      this.Shape2.setTextureSize(64, 32);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 29, 0);
      this.Shape3.addBox(-2.0F, 0.0F, -6.0F, 5, 1, 5);
      this.Shape3.setRotationPoint(0.0F, 19.0F, -2.0F);
      this.Shape3.setTextureSize(64, 32);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 28, 0);
      this.Shape4.addBox(-4.0F, 0.0F, 0.0F, 9, 7, 10);
      this.Shape4.setRotationPoint(0.0F, 14.0F, 0.0F);
      this.Shape4.setTextureSize(64, 32);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 34, 0);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Shape5.setRotationPoint(-4.0F, 20.0F, 0.0F);
      this.Shape5.setTextureSize(64, 32);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 31, 0);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Shape6.setRotationPoint(3.0F, 20.0F, 0.0F);
      this.Shape6.setTextureSize(64, 32);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 29, 0);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Shape7.setRotationPoint(3.0F, 20.0F, 8.0F);
      this.Shape7.setTextureSize(64, 32);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 33, 0);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Shape8.setRotationPoint(-4.0F, 20.0F, 8.0F);
      this.Shape8.setTextureSize(64, 32);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 31, 0);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 2, 6);
      this.Shape9.setRotationPoint(-1.0F, 15.0F, 9.0F);
      this.Shape9.setTextureSize(64, 32);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 31, 0);
      this.Shape10.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 2);
      this.Shape10.setRotationPoint(0.0F, 14.73333F, 8.0F);
      this.Shape10.setTextureSize(64, 32);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 1.747395F, 1.189716F, 0.8551081F);
      this.Shape11 = new ModelRenderer(this, 33, 0);
      this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 0, 2);
      this.Shape11.setRotationPoint(0.0F, 14.0F, 3.0F);
      this.Shape11.setTextureSize(64, 32);
      this.Shape11.mirror = true;
      this.setRotation(this.Shape11, 1.747395F, 1.189716F, 0.8551081F);
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
      this.Shape9.render(f5);
      this.Shape10.render(f5);
      this.Shape11.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      this.Shape5.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Shape7.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Shape6.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Shape8.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
