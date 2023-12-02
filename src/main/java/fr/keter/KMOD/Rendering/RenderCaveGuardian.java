package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityCaveGuardian;
import fr.keter.KMOD.Models.ModelCaveGuardian;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCaveGuardian extends RenderLiving {
   private static final ResourceLocation ghastTextures = new ResourceLocation("real kether:textures/entities/Cave Guardian/Cave Guardian.png");

   public RenderCaveGuardian() {
      super(new ModelCaveGuardian(), 2.0F);
   }

   protected ResourceLocation getEntityTexture(EntityCaveGuardian p_110775_1_) {
      return ghastTextures;
   }

   protected void preRenderCallback(EntityCaveGuardian p_77041_1_, float p_77041_2_) {
      BossStatus.setBossStatus(p_77041_1_, false);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.preRenderCallback((EntityCaveGuardian)p_77041_1_, p_77041_2_);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityCaveGuardian)p_110775_1_);
   }
}
