package com.KMOD.Entities;

import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKeherEnergy extends EntityThrowable {
   public EntityKeherEnergy(World p_i1773_1_) {
      super(p_i1773_1_);
   }

   public EntityKeherEnergy(World p_i1774_1_, EntityLivingBase p_i1774_2_) {
      super(p_i1774_1_, p_i1774_2_);
   }

   public EntityKeherEnergy(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
      super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
   }

   protected float getGravityVelocity() {
      return 0.0F;
   }

   protected void onImpact(MovingObjectPosition p_70184_1_) {
      if (p_70184_1_.entityHit != null) {
         p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 15.0F);
      }

      for(int i = 0; i < 8; ++i) {
         Random random = new Random();
         double d1 = (double)(random.nextInt(5) - random.nextInt(7));
         double d2 = (double)(random.nextInt(5) - random.nextInt(7));
         this.worldObj.spawnParticle("portal", this.posX, this.posY, this.posZ, d1, 1.5D, d2);
      }

      if (!this.worldObj.isRemote && p_70184_1_.entityHit == null) {
         this.setDead();
      }

   }
}
