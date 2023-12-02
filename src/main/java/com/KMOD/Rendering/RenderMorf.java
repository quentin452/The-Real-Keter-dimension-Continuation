package com.KMOD.Rendering;

import com.KMOD.Entities.EntityMorf;
import com.KMOD.Models.ModelMorf;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderMorf extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Morf/Morf.png");

   public RenderMorf() {
      super(new ModelMorf(), 0.0F);
   }

   protected ResourceLocation getEntityTexture(EntityMorf p_110775_1_) {
      return ghastTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityMorf)p_110775_1_);
   }
}
