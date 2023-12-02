package com.KMOD.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCaveGuardian extends ModelBase {
   ModelRenderer Symbol;
   ModelRenderer head;
   ModelRenderer DemonRightWing;
   ModelRenderer DemonLeftWing;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;

   public ModelCaveGuardian() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Symbol = new ModelRenderer(this, 60, 0);
      this.Symbol.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 0);
      this.Symbol.setRotationPoint(0.0F, -14.53333F, 0.0F);
      this.Symbol.setTextureSize(128, 128);
      this.Symbol.mirror = true;
      this.setRotation(this.Symbol, 0.0F, 0.0F, 0.0F);
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.head.setTextureSize(128, 128);
      this.head.mirror = true;
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.DemonRightWing = new ModelRenderer(this, 1, 36);
      this.DemonRightWing.addBox(-26.0F, 0.0F, -0.5F, 26, 17, 0);
      this.DemonRightWing.setRotationPoint(-2.0F, 1.0F, 1.0F);
      this.DemonRightWing.setTextureSize(128, 128);
      this.DemonRightWing.mirror = true;
      this.setRotation(this.DemonRightWing, 0.0F, 0.0F, 1.06083F);
      this.DemonLeftWing = new ModelRenderer(this, 72, 37);
      this.DemonLeftWing.addBox(0.0F, 0.0F, -0.5F, 26, 17, 0);
      this.DemonLeftWing.setRotationPoint(2.0F, 1.0F, 2.0F);
      this.DemonLeftWing.setTextureSize(128, 128);
      this.DemonLeftWing.mirror = true;
      this.setRotation(this.DemonLeftWing, 0.0F, 0.0F, -1.047198F);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
      this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body.setTextureSize(128, 128);
      this.body.mirror = true;
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
      this.rightarm.setRotationPoint(-4.0F, 2.0F, 0.0F);
      this.rightarm.setTextureSize(128, 128);
      this.rightarm.mirror = true;
      this.setRotation(this.rightarm, -0.5410521F, 0.0F, -0.4287933F);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
      this.leftarm.setRotationPoint(4.0F, 2.0F, 0.0F);
      this.leftarm.setTextureSize(128, 128);
      this.leftarm.mirror = true;
      this.setRotation(this.leftarm, -0.5410521F, 0.0F, 0.4287933F);
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
      this.rightleg.setTextureSize(128, 128);
      this.rightleg.mirror = true;
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
      this.leftleg.setTextureSize(128, 128);
      this.leftleg.mirror = true;
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      this.Symbol.render(f5);
      this.head.render(f5);
      this.DemonRightWing.render(f5);
      this.DemonLeftWing.render(f5);
      this.body.render(f5);
      this.rightarm.render(f5);
      this.leftarm.render(f5);
      this.rightleg.render(f5);
      this.leftleg.render(f5);
   }

   private void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
   }

   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);

      for(int i = 0; i < 4; ++i) {
         this.DemonRightWing.rotateAngleX = MathHelper.cos((float)(i * 2) + f2) * 0.25F;
         this.DemonLeftWing.rotateAngleX = MathHelper.cos((float)(i * 2) + f2) * 0.25F;
      }

   }
}
