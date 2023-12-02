package fr.keter.KMOD.Models;

import fr.keter.KMOD.Entities.EntityDemonEye;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDemonEye extends ModelBase {
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

   public ModelDemonEye() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 50, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
      this.Shape1.setRotationPoint(-3.0F, 0.0F, -3.0F);
      this.Shape1.setTextureSize(128, 128);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1);
      this.Shape2.setRotationPoint(-2.0F, 1.0F, 2.0F);
      this.Shape2.setTextureSize(128, 128);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
      this.Shape3.setRotationPoint(2.0F, 1.0F, -2.0F);
      this.Shape3.setTextureSize(128, 128);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
      this.Shape4.setRotationPoint(-4.0F, 1.0F, -2.0F);
      this.Shape4.setTextureSize(128, 128);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 0);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.Shape5.setRotationPoint(-1.0F, 2.0F, 3.0F);
      this.Shape5.setTextureSize(128, 128);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
      this.Shape6.setRotationPoint(-2.0F, -1.0F, -2.0F);
      this.Shape6.setTextureSize(128, 128);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 0, 0);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
      this.Shape7.setRotationPoint(-2.0F, 5.0F, -2.0F);
      this.Shape7.setTextureSize(128, 128);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 50, 50);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
      this.Shape8.setRotationPoint(5.0F, 0.0F, -3.0F);
      this.Shape8.setTextureSize(128, 128);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 50, 50);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
      this.Shape9.setRotationPoint(-10.0F, 0.0F, -2.0F);
      this.Shape9.setTextureSize(128, 128);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
      this.Shape10 = new ModelRenderer(this, 50, 50);
      this.Shape10.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
      this.Shape10.setRotationPoint(-3.0F, 0.0F, 5.0F);
      this.Shape10.setTextureSize(128, 128);
      this.Shape10.mirror = true;
      this.setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
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
      this.renderDefenceBalls((EntityDemonEye)entity, f, f1, f2, f3, f4, f5);
   }

   public void renderDefenceBalls(EntityDemonEye e, float f, float f1, float f2, float f3, float f4, float f5) {
      if (EntityDemonEye.DefenceBalls == 3) {
         this.Shape8.render(f5);
         this.Shape9.render(f5);
         this.Shape10.render(f5);
      }

      if (EntityDemonEye.DefenceBalls == 2) {
         this.Shape9.render(f5);
         this.Shape10.render(f5);
      }

      if (EntityDemonEye.DefenceBalls == 1) {
         this.Shape10.render(f5);
      }

      if (EntityDemonEye.DefenceBalls == 0) {
      }

   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      float f6 = f2 * 3.1415927F * -0.1F;

      int i;
      for(i = 0; i < 4; ++i) {
         this.Shape8.rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
         this.Shape8.rotationPointX = MathHelper.cos(f6) * 9.0F;
         this.Shape8.rotationPointZ = MathHelper.sin(f6) * 9.0F;
         ++f6;
      }

      for(i = 0; i < 4; ++i) {
         this.Shape9.rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
         this.Shape9.rotationPointX = MathHelper.cos(f6) * 9.0F;
         this.Shape9.rotationPointZ = MathHelper.sin(f6) * 9.0F;
         ++f6;
      }

      for(i = 0; i < 4; ++i) {
         this.Shape10.rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + f2) * 0.25F);
         this.Shape10.rotationPointX = MathHelper.cos(f6) * 9.0F;
         this.Shape10.rotationPointZ = MathHelper.sin(f6) * 9.0F;
         ++f6;
      }

   }
}
