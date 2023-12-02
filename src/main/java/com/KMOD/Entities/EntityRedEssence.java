package com.KMOD.Entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRedEssence extends EntityThrowable {
   public EntityRedEssence(World p_i1773_1_) {
      super(p_i1773_1_);
   }

   public EntityRedEssence(World p_i1774_1_, EntityLivingBase p_i1774_2_) {
      super(p_i1774_1_, p_i1774_2_);
   }

   public EntityRedEssence(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
      super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
   }

   protected void onImpact(MovingObjectPosition p_70184_1_) {
      if (p_70184_1_.entityHit != null) {
         p_70184_1_.entityHit.setFire(8);
      }

      for(int i = 0; i < 8; ++i) {
         this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
      }

      if (!this.worldObj.isRemote) {
         this.setDead();
      }

   }
}
