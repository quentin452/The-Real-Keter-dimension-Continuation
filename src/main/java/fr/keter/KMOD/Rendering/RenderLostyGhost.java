package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityLostyGhost;
import fr.keter.KMOD.Models.ModelLostyGhost;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLostyGhost extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Losty Ghost/Losty Ghost.png");

   public RenderLostyGhost() {
      super(new ModelLostyGhost(), 0.1F);
   }

   protected ResourceLocation getEntityTexture(EntityLostyGhost p_110775_1_) {
      return ghastTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityLostyGhost)p_110775_1_);
   }
}
