package fr.keter.KMOD.Rendering;

import fr.keter.KMOD.Entities.EntityKetherSlime;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderKetherSlime extends RenderLiving {
   private static final ResourceLocation KetherSlimeTextures = new ResourceLocation("real kether:textures/entities/Kether Slime/Kether Slime.png");
   private static final ResourceLocation KetherRubySlimeTextures = new ResourceLocation("real kether:textures/entities/Kether Slime/Ruby Kether Slime.png");
   private static final ResourceLocation KetherTopazSlimeTextures = new ResourceLocation("real kether:textures/entities/Kether Slime/Topaz Kether Slime.png");
   private static final ResourceLocation KetherSapphireSlimeTextures = new ResourceLocation("real kether:textures/entities/Kether Slime/Sapphire Kether Slime.png");
   private ModelBase scaleAmount;

   public RenderKetherSlime(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_) {
      super(p_i1267_1_, p_i1267_3_);
      this.scaleAmount = p_i1267_2_;
   }

   protected int shouldRenderPass(EntityKetherSlime p_77032_1_, int p_77032_2_, float p_77032_3_) {
      if (p_77032_1_.isInvisible()) {
         return 0;
      } else if (p_77032_2_ == 0) {
         this.setRenderPassModel(this.scaleAmount);
         GL11.glEnable(2977);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         return 1;
      } else {
         if (p_77032_2_ == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         return -1;
      }
   }

   protected void preRenderCallback(EntityKetherSlime p_77041_1_, float p_77041_2_) {
      float f1 = (float)p_77041_1_.getSlimeSize();
      float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
      float f3 = 1.0F / (f2 + 1.0F);
      GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
   }

   protected ResourceLocation getEntityTexture(EntityKetherSlime e) {
      if (e.SlimeType == "Normal") {
         return KetherSlimeTextures;
      } else if (e.SlimeType == "Ruby") {
         return KetherRubySlimeTextures;
      } else if (e.SlimeType == "Topaz") {
         return KetherTopazSlimeTextures;
      } else {
         return e.SlimeType == "Sapphire" ? KetherSapphireSlimeTextures : KetherSlimeTextures;
      }
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.preRenderCallback((EntityKetherSlime)p_77041_1_, p_77041_2_);
   }

   protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.shouldRenderPass((EntityKetherSlime)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
      return this.getEntityTexture((EntityKetherSlime)p_110775_1_);
   }
}
