package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityKetherCrocodile;
import fr.keter.KMOD.Models.ModelKetherCrocodile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderKetherCrocodile extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Kether Crocodile/Kether Crocodile.png");

   public RenderKetherCrocodile() {
      super(new ModelKetherCrocodile(), 0.5F);
   }

   protected ResourceLocation getEntityTexture(EntityKetherCrocodile p_110775_1_) {
      return ghastTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityKetherCrocodile)p_110775_1_);
   }
}
