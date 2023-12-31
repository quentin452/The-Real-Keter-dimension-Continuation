package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityKetherGhast;
import fr.keter.KMOD.Models.ModelKetherGhast;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderKetherGhast extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Kether Ghast/Kether Ghast.png");

   public RenderKetherGhast() {
      super(new ModelKetherGhast(), 0.5F);
   }

   protected ResourceLocation getEntityTexture(EntityKetherGhast p_110775_1_) {
      return ghastTextures;
   }

   protected void preRenderCallback(EntityKetherGhast p_77041_1_, float p_77041_2_) {
      float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
      float f2 = (8.0F + f1) / 2.0F;
      float f3 = (8.0F + 1.0F / f1) / 2.0F;
      GL11.glScalef(f3, f2, f3);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.preRenderCallback((EntityKetherGhast)p_77041_1_, p_77041_2_);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityKetherGhast)p_110775_1_);
   }
}
