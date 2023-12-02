package fr.keter.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLame extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape11;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;
   ModelRenderer Shape10;
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer leg1;
   ModelRenderer leg2;
   ModelRenderer leg3;
   ModelRenderer leg4;

   public ModelLame() {
      this.textureWidth = 256;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3);
      this.Shape1.setRotationPoint(-2.0F, -8.0F, -18.0F);
      this.Shape1.setTextureSize(256, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 5, 1);
      this.Shape2.setRotationPoint(-3.0F, -9.0F, -15.0F);
      this.Shape2.setTextureSize(256, 128);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 50, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape3.setRotationPoint(2.0F, -11.0F, -15.0F);
      this.Shape3.setTextureSize(256, 128);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape11 = new ModelRenderer(this, 50, 0);
      this.Shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape11.setRotationPoint(-3.0F, -11.0F, -15.0F);
      this.Shape11.setTextureSize(256, 128);
      this.setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
      this.Shape4.setRotationPoint(-3.0F, -14.0F, -12.0F);
      this.Shape4.setTextureSize(256, 128);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 0);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
      this.Shape5.setRotationPoint(2.0F, -14.0F, -12.0F);
      this.Shape5.setTextureSize(256, 128);
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 4, 4, 1);
      this.Shape6.setRotationPoint(-2.0F, 4.0F, 10.0F);
      this.Shape6.setTextureSize(256, 128);
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 100, 0);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 6, 1, 5);
      this.Shape7.setRotationPoint(-3.0F, 9.0F, -13.0F);
      this.Shape7.setTextureSize(256, 128);
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 100, 0);
      this.Shape8.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 4);
      this.Shape8.setRotationPoint(0.0F, 10.0F, -12.0F);
      this.Shape8.setTextureSize(256, 128);
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 0, 0);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
      this.Shape9.setRotationPoint(-1.0F, 4.2F, 10.2F);
      this.Shape9.setTextureSize(256, 128);
      this.setRotation(this.Shape9, -0.5205006F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 0, 0);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
      this.Shape10.setRotationPoint(-1.0F, 5.2F, 11.95F);
      this.Shape10.setTextureSize(256, 128);
      this.setRotation(this.Shape10, -1.301251F, 0.0F, 0.0F);
      this.head = new ModelRenderer(this, 100, 0);
      this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 21, 6);
      this.head.setRotationPoint(0.0F, -8.0F, -8.0F);
      this.head.setTextureSize(256, 128);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 100, 0);
      this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10);
      this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
      this.body.setTextureSize(256, 128);
      this.setRotation(this.body, 1.570796F, 0.0F, 0.0F);
      this.leg1 = new ModelRenderer(this, 0, 100);
      this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
      this.leg1.setTextureSize(256, 128);
      this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
      this.leg2 = new ModelRenderer(this, 0, 100);
      this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
      this.leg2.setTextureSize(256, 128);
      this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
      this.leg3 = new ModelRenderer(this, 0, 100);
      this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
      this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
      this.leg3.setTextureSize(256, 128);
      this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
      this.leg4 = new ModelRenderer(this, 0, 100);
      this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
      this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
      this.leg4.setTextureSize(256, 128);
      this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape11.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      this.Shape6.render(f5);
      this.Shape7.render(f5);
      this.Shape8.render(f5);
      this.Shape9.render(f5);
      this.Shape10.render(f5);
      this.head.render(f5);
      this.body.render(f5);
      this.leg1.render(f5);
      this.leg2.render(f5);
      this.leg3.render(f5);
      this.leg4.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
   }
}
