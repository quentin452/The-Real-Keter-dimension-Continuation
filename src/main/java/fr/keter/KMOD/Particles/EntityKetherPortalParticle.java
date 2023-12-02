package fr.keter.KMOD.Particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityKetherPortalParticle extends EntityFX {
   float reddustParticleScale;
   private double portalPosX;
   private double portalPosY;
   private double portalPosZ;
   int c;

   public EntityKetherPortalParticle(World par1World, double par2, double par4, double par6, float par8, float par9, float par10) {
      this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
      this.portalPosX = this.posX = par2;
      this.portalPosY = this.posY = par4;
      this.portalPosZ = this.posZ = par6;
      this.motionX = (double)par8;
      this.motionY = (double)par9;
      this.motionZ = (double)par10;
   }

   public EntityKetherPortalParticle(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11) {
      super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
      this.c = 0;
      if (par9 == 0.0F) {
         par9 = 1.0F;
      }

      float var12 = (float)Math.random() * 0.4F + 0.6F;
      this.particleScale *= 0.75F;
      this.particleScale *= par8;
      this.particleAlpha = 125.0F;
      this.reddustParticleScale = this.particleScale;
      this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) * 3;
      this.particleMaxAge = (int)((float)this.particleMaxAge * par8) * 3;
      this.noClip = false;
   }

   public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
      Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Real Kether:textures/particles/KetherPortalParticle.png"));
      float var8 = ((float)this.particleAge + par2) / (float)this.particleMaxAge * 32.0F;
      this.particleAlpha = 5.0F;
      if (var8 < 0.0F) {
         var8 = 0.0F;
      }

      if (var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.particleScale = this.reddustParticleScale * var8;
      super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
   }

   public int getBrightnessForRender(float p_70070_1_) {
      int i = super.getBrightnessForRender(p_70070_1_);
      float f1 = (float)this.particleAge / (float)this.particleMaxAge;
      f1 *= f1;
      f1 *= f1;
      int j = i & 255;
      int k = i >> 16 & 255;
      k += (int)(f1 * 15.0F * 16.0F);
      if (k > 240) {
         k = 240;
      }

      return j | k << 16;
   }

   public float getBrightness(float p_70013_1_) {
      float f1 = super.getBrightness(p_70013_1_);
      float f2 = (float)this.particleAge / (float)this.particleMaxAge;
      f2 = f2 * f2 * f2 * f2;
      return f1 * (1.0F - f2) + f2;
   }

   public void onUpdate() {
      ++this.c;
      if (this.c > 0 && this.c <= 3) {
         this.setParticleTextureIndex(0);
      }

      if (this.c > 3 && this.c <= 6) {
         this.setParticleTextureIndex(1);
      }

      if (this.c > 6 && this.c <= 9) {
         this.setParticleTextureIndex(2);
      }

      if (this.c > 9 && this.c <= 12) {
         this.setParticleTextureIndex(3);
      }

      if (this.c > 12 && this.c <= 15) {
         this.setParticleTextureIndex(4);
      }

      if (this.c > 15 && this.c <= 18) {
         this.setParticleTextureIndex(5);
      }

      if (this.c > 18 && this.c <= 21) {
         this.setParticleTextureIndex(6);
      }

      if (this.c > 21 && this.c <= 24) {
         this.setParticleTextureIndex(7);
      }

      if (this.c >= 25) {
         this.c = 0;
      }

      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      float f = (float)this.particleAge / (float)this.particleMaxAge;
      float f1 = f;
      f = -f + f * f * 2.0F;
      f = 1.0F - f;
      this.posX = this.portalPosX + this.motionX * (double)f;
      this.posY = this.portalPosY + this.motionY * (double)f + (double)(1.0F - f1);
      this.posZ = this.portalPosZ + this.motionZ * (double)f;
      if (this.particleAge++ >= this.particleMaxAge) {
         this.setDead();
      }

   }
}
