package com.KMOD.Rendering;

import com.KMOD.Entities.EntityKetherBoar;
import com.KMOD.Models.ModelKetherBoar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderKetherBoar extends RenderLiving {
   private static final ResourceLocation cowTextures = new ResourceLocation("real kether", "textures/entities/Kether Boar/Kether Boar.png");
   private static final ResourceLocation cowTextures1 = new ResourceLocation("real kether", "textures/entities/Kether Flying Boar/Kether Flying Boar.png");
   private static final ModelBase Model1 = new ModelKetherBoar();

   public RenderKetherBoar() {
      super(Model1, 0.7F);
   }

   public void func_177_a(EntityKetherBoar entityMasso, double d, double d1, double d2, float f, float f1) {
      super.doRender(entityMasso, d, d1, d2, f, f1);
   }

   public void doRenderLiving(EntityLivingBase entityliving, double d, double d1, double d2, float f, float f1) {
      this.func_177_a((EntityKetherBoar)entityliving, d, d1, d2, f, f1);
   }

   public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
      this.func_177_a((EntityKetherBoar)entity, d, d1, d2, f, f1);
   }

   protected ResourceLocation getEntityTexture(EntityKetherBoar e) {
      return e.isSaddled() ? cowTextures1 : cowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityKetherBoar)p_110775_1_);
   }
}
