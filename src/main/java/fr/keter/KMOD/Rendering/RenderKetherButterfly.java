package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityKetherButterfly;
import fr.keter.KMOD.Models.ModelKetherButterfly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderKetherButterfly extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Kether Butterfly/Kether Butterfly.png");

   public RenderKetherButterfly() {
      super(new ModelKetherButterfly(), 0.1F);
   }

   protected ResourceLocation getEntityTexture(EntityKetherButterfly p_110775_1_) {
      return ghastTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityKetherButterfly)p_110775_1_);
   }
}
