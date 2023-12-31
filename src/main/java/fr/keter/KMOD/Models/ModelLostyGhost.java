package fr.keter.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLostyGhost extends ModelBase {
   ModelRenderer Tail1;
   ModelRenderer Tail3;
   ModelRenderer Tail4;
   ModelRenderer Tail5;
   ModelRenderer Body;
   ModelRenderer Head;
   ModelRenderer Shoulder1;
   ModelRenderer Arm1;
   ModelRenderer Finger1;
   ModelRenderer Finger2;
   ModelRenderer Shoulder2;
   ModelRenderer Arm2;
   ModelRenderer Finger3;
   ModelRenderer Finger4;
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;

   public ModelLostyGhost() {
      this.textureWidth = 1280;
      this.textureHeight = 1024;
      this.Tail1 = new ModelRenderer(this, 11, 230);
      this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
      this.Tail1.setRotationPoint(0.0F, 14.0F, 13.0F);
      this.Tail1.setTextureSize(1280, 1024);
      this.Tail1.mirror = true;
      this.setRotation(this.Tail1, 0.0F, -0.7435722F, 0.0F);
      this.Tail3 = new ModelRenderer(this, 25, 230);
      this.Tail3.addBox(0.0F, -1.0F, -6.0F, 3, 2, 6);
      this.Tail3.setRotationPoint(0.0F, 15.0F, 15.0F);
      this.Tail3.setTextureSize(1280, 1024);
      this.Tail3.mirror = true;
      this.setRotation(this.Tail3, 0.0F, 0.5205006F, 0.0F);
      this.Tail4 = new ModelRenderer(this, 45, 230);
      this.Tail4.addBox(0.0F, 0.0F, -8.0F, 3, 2, 8);
      this.Tail4.setRotationPoint(-2.0F, 14.0F, 10.0F);
      this.Tail4.setTextureSize(1280, 1024);
      this.Tail4.mirror = true;
      this.setRotation(this.Tail4, 0.0F, -0.5948578F, 0.0F);
      this.Tail5 = new ModelRenderer(this, 70, 230);
      this.Tail5.addBox(0.0F, 0.0F, -12.0F, 3, 2, 12);
      this.Tail5.setRotationPoint(2.0F, 14.0F, 6.0F);
      this.Tail5.setTextureSize(1280, 1024);
      this.Tail5.mirror = true;
      this.setRotation(this.Tail5, 0.0F, 0.3717861F, 0.0F);
      this.Body = new ModelRenderer(this, 73, 212);
      this.Body.addBox(-4.0F, -11.0F, -4.0F, 10, 11, 4);
      this.Body.setRotationPoint(-1.0F, 16.0F, -4.0F);
      this.Body.setTextureSize(1280, 1024);
      this.Body.mirror = true;
      this.setRotation(this.Body, 0.4089647F, 0.0F, 0.0F);
      this.Head = new ModelRenderer(this, 65, 186);
      this.Head.addBox(-7.0F, -6.0F, -4.0F, 12, 15, 9);
      this.Head.setRotationPoint(1.0F, 0.0F, -11.0F);
      this.Head.setTextureSize(1280, 1024);
      this.Head.mirror = true;
      this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
      this.Shoulder1 = new ModelRenderer(this, 48, 200);
      this.Shoulder1.addBox(-3.0F, 0.0F, -2.0F, 2, 8, 3);
      this.Shoulder1.setRotationPoint(-4.0F, 7.0F, -11.0F);
      this.Shoulder1.setTextureSize(1280, 1024);
      this.Shoulder1.mirror = true;
      this.setRotation(this.Shoulder1, 0.0F, 0.0F, 0.3346075F);
      this.Arm1 = new ModelRenderer(this, 48, 214);
      this.Arm1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Arm1.setRotationPoint(-9.0F, 13.0F, -13.0F);
      this.Arm1.setTextureSize(1280, 1024);
      this.Arm1.mirror = true;
      this.setRotation(this.Arm1, 0.0F, 0.0F, 0.0F);
      this.Finger1 = new ModelRenderer(this, 40, 220);
      this.Finger1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
      this.Finger1.setRotationPoint(-9.0F, 16.0F, -13.0F);
      this.Finger1.setTextureSize(1280, 1024);
      this.Finger1.mirror = true;
      this.setRotation(this.Finger1, 0.0F, 0.0F, 0.5948578F);
      this.Finger2 = new ModelRenderer(this, 57, 220);
      this.Finger2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
      this.Finger2.setRotationPoint(-8.0F, 16.0F, -13.0F);
      this.Finger2.setTextureSize(1280, 1024);
      this.Finger2.mirror = true;
      this.setRotation(this.Finger2, 0.0F, 0.0F, -0.5948606F);
      this.Shoulder2 = new ModelRenderer(this, 114, 200);
      this.Shoulder2.addBox(0.0F, 0.0F, -2.0F, 2, 8, 3);
      this.Shoulder2.setRotationPoint(4.0F, 7.0F, -11.0F);
      this.Shoulder2.setTextureSize(1280, 1024);
      this.Shoulder2.mirror = true;
      this.setRotation(this.Shoulder2, 0.0F, 0.0F, -0.3346145F);
      this.Arm2 = new ModelRenderer(this, 114, 214);
      this.Arm2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
      this.Arm2.setRotationPoint(6.0F, 13.0F, -13.0F);
      this.Arm2.setTextureSize(1280, 1024);
      this.Arm2.mirror = true;
      this.setRotation(this.Arm2, 0.0F, 0.0F, 0.0F);
      this.Finger3 = new ModelRenderer(this, 124, 220);
      this.Finger3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
      this.Finger3.setRotationPoint(6.0F, 16.0F, -13.0F);
      this.Finger3.setTextureSize(1280, 1024);
      this.Finger3.mirror = true;
      this.setRotation(this.Finger3, 0.0F, 0.0F, 0.5948578F);
      this.Finger4 = new ModelRenderer(this, 107, 220);
      this.Finger4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
      this.Finger4.setRotationPoint(7.0F, 16.0F, -13.0F);
      this.Finger4.setTextureSize(1280, 1024);
      this.Finger4.mirror = true;
      this.setRotation(this.Finger4, 0.0F, 0.0F, -0.5948606F);
      this.Shape1 = new ModelRenderer(this, 65, 180);
      this.Shape1.addBox(0.0F, -3.0F, 0.0F, 2, 3, 2);
      this.Shape1.setRotationPoint(-1.0F, -5.5F, -8.0F);
      this.Shape1.setTextureSize(1280, 1024);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, -0.4089647F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 65, 170);
      this.Shape2.addBox(0.0F, -5.0F, 0.0F, 2, 5, 2);
      this.Shape2.setRotationPoint(-1.0F, -7.5F, -7.0F);
      this.Shape2.setTextureSize(1280, 1024);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, -0.8922867F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 52, 168);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2);
      this.Shape3.setRotationPoint(-1.0F, -10.0F, -4.0F);
      this.Shape3.setTextureSize(1280, 1024);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 34, 175);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
      this.Shape4.setRotationPoint(-1.0F, -1.0F, -4.0F);
      this.Shape4.setTextureSize(1280, 1024);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.4833219F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 27, 165);
      this.Shape5.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5);
      this.Shape5.setRotationPoint(0.0F, -7.0F, 1.0F);
      this.Shape5.setTextureSize(1280, 1024);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 1.449966F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 21, 174);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
      this.Shape6.setRotationPoint(-0.5F, -6.0F, 1.0F);
      this.Shape6.setTextureSize(1280, 1024);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.2602503F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Tail1.render(f5);
      this.Tail3.render(f5);
      this.Tail4.render(f5);
      this.Tail5.render(f5);
      this.Body.render(f5);
      this.Head.render(f5);
      this.Shoulder1.render(f5);
      this.Arm1.render(f5);
      this.Finger1.render(f5);
      this.Finger2.render(f5);
      this.Shoulder2.render(f5);
      this.Arm2.render(f5);
      this.Finger3.render(f5);
      this.Finger4.render(f5);
      this.Shape1.render(f5);
      this.Shape2.render(f5);
      this.Shape3.render(f5);
      this.Shape4.render(f5);
      this.Shape5.render(f5);
      this.Shape6.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
      this.Tail5.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Tail4.rotateAngleZ = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
      this.Tail3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Tail1.rotateAngleZ = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
   }
}
