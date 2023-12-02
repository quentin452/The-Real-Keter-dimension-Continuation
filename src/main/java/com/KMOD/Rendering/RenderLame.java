package com.KMOD.Rendering;

import com.KMOD.Entities.EntityLame;
import com.KMOD.Models.ModelLame;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLame extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Lame/Lame.png");

   public RenderLame() {
      super(new ModelLame(), 0.5F);
   }

   protected ResourceLocation getEntityTexture(EntityLame p_110775_1_) {
      return ghastTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityLame)p_110775_1_);
   }
}
