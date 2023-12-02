package com.KMOD.Entities;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityKetherButterfly extends EntityFlying implements IMob {
   public int courseChangeCooldown;
   public double waypointX;
   public double waypointY;
   public double waypointZ;
   private Entity targetedEntity;
   private int aggroCooldown;
   public int prevAttackCounter;
   public int attackCounter;
   private int explosionStrength = 1;

   public EntityKetherButterfly(World p_i1735_1_) {
      super(p_i1735_1_);
      this.setSize(0.3F, 0.3F);
      this.isImmuneToFire = true;
      this.experienceValue = 15;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_110182_bF() {
      return this.dataWatcher.getWatchableObjectByte(16) != 0;
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
      if (this.isEntityInvulnerable()) {
         return false;
      } else if ("fireball".equals(p_70097_1_.getDamageType()) && p_70097_1_.getEntity() instanceof EntityPlayer) {
         super.attackEntityFrom(p_70097_1_, 1000.0F);
         return true;
      } else {
         return super.attackEntityFrom(p_70097_1_, p_70097_2_);
      }
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, (byte)0);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
   }

   protected void updateEntityActionState() {
      if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
         this.posX = 9999.0D;
         this.posY = 9999.0D;
         this.posZ = 9999.0D;
         this.setDead();
      }

      this.despawnEntity();
      this.prevAttackCounter = this.attackCounter;
      double d0 = this.waypointX - this.posX;
      double d1 = this.waypointY - this.posY;
      double d2 = this.waypointZ - this.posZ;
      if (this.rand.nextInt(2) == 1) {
         this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 20.0F);
      }

      if (this.rand.nextInt(2) == 2) {
         this.waypointY = this.posY - (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 22.0F);
      }

      double d3 = d0 * d0 + d1 * d1 + d2 * d2;
      if (this.posY >= 124.0D) {
         this.posY = 123.0D;
         this.waypointY = this.posY - (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 35.0F);
      } else if (this.posY < 94.0D) {
         this.posY = 95.0D;
         this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 35.0F);
      }

      if (d3 < 1.0D || d3 > 3600.0D) {
         this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
         if (this.rand.nextInt(2) == 1) {
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 3.0F);
         }

         if (this.rand.nextInt(2) == 2) {
            this.waypointY = this.posY - (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 22.0F);
         }

         this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
      }

      if (this.courseChangeCooldown-- <= 0) {
         this.courseChangeCooldown += this.rand.nextInt(5) + 2;
         d3 = (double)MathHelper.sqrt_double(d3);
         if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
            this.motionX += d0 / d3 * 0.1D;
            this.motionY += d1 / d3 * 0.1D;
            this.motionZ += d2 / d3 * 0.1D;
         } else {
            this.waypointX = this.posX;
            this.waypointY = this.posY;
            this.waypointZ = this.posZ;
         }
      }

      if (this.targetedEntity != null && this.targetedEntity.isDead) {
         this.targetedEntity = null;
      }

      if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
         this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);
         if (this.targetedEntity != null) {
            this.aggroCooldown = 20;
         }
      }

      double d4 = 64.0D;
      if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d4 * d4) {
         double d5 = this.targetedEntity.posX - this.posX;
         double d6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
         double d7 = this.targetedEntity.posZ - this.posZ;
         this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / 3.1415927F;
         if (this.canEntityBeSeen(this.targetedEntity)) {
            if (this.attackCounter == 10) {
            }

            ++this.attackCounter;
            if (this.attackCounter == 20) {
            }
         } else if (this.attackCounter > 0) {
            --this.attackCounter;
         }
      } else {
         this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / 3.1415927F;
         if (this.attackCounter > 0) {
            --this.attackCounter;
         }
      }

      if (!this.worldObj.isRemote) {
         byte b1 = this.dataWatcher.getWatchableObjectByte(16);
         byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);
         if (b1 != b0) {
            this.dataWatcher.updateObject(16, b0);
         }
      }

   }

   private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
      double d4 = (this.waypointX - this.posX) / p_70790_7_;
      double d5 = (this.waypointY - this.posY) / p_70790_7_;
      double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
      AxisAlignedBB axisalignedbb = this.boundingBox.copy();

      for(int i = 1; (double)i < p_70790_7_; ++i) {
         axisalignedbb.offset(d4, d5, d6);
         if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty()) {
            return false;
         }

         if (this.posY < 125.0D) {
            return true;
         }
      }

      if (this.posY < 125.0D && this.shouldFly()) {
         return true;
      } else {
         return false;
      }
   }

   private boolean shouldFly() {
      EntityPlayer k = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 32.0D);
      return k != null;
   }

   protected String getLivingSound() {
      return null;
   }

   protected String getHurtSound() {
      return null;
   }

   protected String getDeathSound() {
      return null;
   }

   protected Item getDropItem() {
      return KMOD_Main.SmallWings;
   }

   protected float getSoundVolume() {
      return 0.0F;
   }

   public boolean getCanSpawnHere() {
      return this.rand.nextInt(5) == 0 && super.getCanSpawnHere() && this.posY > 94.0D;
   }

   public int getMaxSpawnedInChunk() {
      return 1;
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
   }
}
