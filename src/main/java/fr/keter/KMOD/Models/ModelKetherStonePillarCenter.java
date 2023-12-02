package fr.keter.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKetherStonePillarCenter extends ModelBase {
   ModelRenderer Shape2;

   public ModelKetherStonePillarCenter() {
      this.textureWidth = 128;
      this.textureHeight = 32;
      this.Shape2 = new ModelRenderer(this, 50, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 10, 16, 10);
      this.Shape2.setRotationPoint(-5.0F, 8.0F, -5.0F);
      this.Shape2.setTextureSize(128, 32);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Shape2.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
   }
}
