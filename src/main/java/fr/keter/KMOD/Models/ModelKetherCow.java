package fr.keter.KMOD.Models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelKetherCow extends ModelQuadruped {
   public ModelKetherCow() {
      super(12, 0.0F);
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
      this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
      this.head.setTextureOffset(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
      this.head.setTextureOffset(22, 0).addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
      this.body = new ModelRenderer(this, 18, 4);
      this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
      this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
      this.body.setTextureOffset(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1);
      --this.leg1.rotationPointX;
      ++this.leg2.rotationPointX;
      ModelRenderer var10000 = this.leg1;
      var10000.rotationPointZ += 0.0F;
      var10000 = this.leg2;
      var10000.rotationPointZ += 0.0F;
      --this.leg3.rotationPointX;
      ++this.leg4.rotationPointX;
      --this.leg3.rotationPointZ;
      --this.leg4.rotationPointZ;
      this.field_78151_h += 2.0F;
   }
}