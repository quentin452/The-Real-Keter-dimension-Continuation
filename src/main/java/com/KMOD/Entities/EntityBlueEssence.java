package com.KMOD.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlueEssence extends EntityThrowable {
   public EntityBlueEssence(World p_i1773_1_) {
      super(p_i1773_1_);
   }

   public EntityBlueEssence(World p_i1774_1_, EntityLivingBase p_i1774_2_) {
      super(p_i1774_1_, p_i1774_2_);
   }

   public EntityBlueEssence(World p_i1775_1_, double d, double d1, double d2) {
      super(p_i1775_1_, d, d1, d2);
   }

   protected void onImpact(MovingObjectPosition p_70184_1_) {
      if (p_70184_1_.entityHit != null) {
         p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5.0F);
      }

      for(int i = 0; i < 8; ++i) {
         this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
      }

      if (!this.worldObj.isRemote) {
         this.setDead();
      }

   }
}
