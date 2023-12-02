package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityStoneDevourer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderStoneDevourer extends RenderLiving {
   private static final ResourceLocation cowTextures = new ResourceLocation("real kether:textures/entities/Stone Devourer/Stone Devourer.png");

   public RenderStoneDevourer(ModelBase p_i1253_1_, float p_i1253_2_) {
      super(p_i1253_1_, p_i1253_2_);
   }

   protected ResourceLocation getEntityTexture(EntityStoneDevourer p_110775_1_) {
      return cowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityStoneDevourer)p_110775_1_);
   }
}
