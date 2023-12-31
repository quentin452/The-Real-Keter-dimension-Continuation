package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityDemonEye;
import fr.keter.KMOD.Models.ModelDemonEye;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderDemonEye extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Demon Eye/Demon Eye.png");

   public RenderDemonEye() {
      super(new ModelDemonEye(), 5.0F);
   }

   protected ResourceLocation getEntityTexture(EntityDemonEye p_110775_1_) {
      return ghastTextures;
   }

   protected void preRenderCallback(EntityDemonEye p_77041_1_, float p_77041_2_) {
      BossStatus.setBossStatus(p_77041_1_, false);
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
      this.preRenderCallback((EntityDemonEye)p_77041_1_, p_77041_2_);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityDemonEye)p_110775_1_);
   }
}
