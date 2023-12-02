package fr.keter.KMOD.Particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.world.World;

public class KetherParticleSpawner {
   private static Minecraft mc = Minecraft.getMinecraft();
   private static World theWorld;
   private static TextureManager renderEngine;

   public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12) {
      if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
         int var14 = mc.gameSettings.particleSetting;
         if (var14 == 1 && theWorld.rand.nextInt(3) == 0) {
            var14 = 2;
         }

         double var15 = mc.renderViewEntity.posX - par2;
         double var17 = mc.renderViewEntity.posY - par4;
         double var19 = mc.renderViewEntity.posZ - par6;
         EntityFX var21 = null;
         double var22 = 16.0D;
         if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
            return null;
         } else if (var14 > 1) {
            return null;
         } else {
            if (particleName.equals("test1")) {
               var21 = new EntityTestParticle1(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
            } else if (particleName.equals("KetherPortalParticle")) {
               var21 = new EntityKetherPortalParticle(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
            } else if (particleName.equals("KetherLifeLeavesParticle")) {
               var21 = new EntityKetherLifeLeavesParticle(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
            } else if (particleName.equals("KetherNewParticle1")) {
               var21 = new EntityKetherNewParticle1(theWorld, par2, par4, par6, (float)par8, (float)par10, (float)par12);
            }

            mc.effectRenderer.addEffect((EntityFX)var21);
            return (EntityFX)var21;
         }
      } else {
         return null;
      }
   }

   static {
      theWorld = mc.theWorld;
      renderEngine = mc.renderEngine;
   }
}
