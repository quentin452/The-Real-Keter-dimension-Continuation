package com.KMOD.Entities;

import com.KMOD.Main.KMOD_Main;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityKetherCrocodile extends EntityZombie {
   private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final AttributeModifier field_110190_br;
   private int angerLevel = 400;
   private int randomSoundDelay;
   private Entity field_110191_bu;
   private boolean uglaskany;
   Random r = new Random();

   public EntityKetherCrocodile(World p_i1739_1_) {
      super(p_i1739_1_);
      this.isImmuneToFire = true;
      this.experienceValue = 40;
      this.uglaskany = false;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(field_110186_bp).setBaseValue(0.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
   }

   protected boolean isAIEnabled() {
      return false;
   }

   public void onUpdate() {
      if (KMOD_Main.instance.getSEtap() == 1) {
         if (this.r.nextInt(10) == 5) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
            this.experienceValue = 10;
         }
      } else if (KMOD_Main.instance.getSEtap() == 2) {
         if (this.r.nextInt(8) == 5) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
            this.experienceValue = 10;
         }
      } else if (KMOD_Main.instance.getSEtap() == 3) {
         if (this.r.nextInt(6) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
            this.experienceValue = 20;
         }
      } else if (KMOD_Main.instance.getSEtap() == 4) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
            this.experienceValue = 40;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
            this.experienceValue = 30;
         }
      } else if (KMOD_Main.instance.getSEtap() == 5) {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
         this.experienceValue = 40;
      } else if (KMOD_Main.instance.getSEtap() == 6) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 50;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
            this.experienceValue = 40;
         }
      } else if (KMOD_Main.instance.getSEtap() == 7) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 55;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
            this.experienceValue = 40;
         }
      } else if (KMOD_Main.instance.getSEtap() == 8) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 60;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
            this.experienceValue = 45;
         }
      } else if (KMOD_Main.instance.getSEtap() == 9) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
            this.experienceValue = 70;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
            this.experienceValue = 60;
         }
      } else if (KMOD_Main.instance.getSEtap() == 10) {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
         this.experienceValue = 70;
      } else if (KMOD_Main.instance.isSBest()) {
         if (this.r.nextInt(3) == 1) {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.5D);
            this.experienceValue = 100;
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
            this.experienceValue = 80;
         }
      } else if (KMOD_Main.instance.isSHostile()) {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
         this.experienceValue = 1;
      } else {
         this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
         this.experienceValue = 40;
      }

      if (this.uglaskany) {
         this.angerLevel = 0;
      }

      if (this.field_110191_bu != this.entityToAttack && !this.worldObj.isRemote) {
         IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
         iattributeinstance.removeModifier(field_110190_br);
         if (this.entityToAttack != null) {
            iattributeinstance.applyModifier(field_110190_br);
         }
      }

      this.field_110191_bu = this.entityToAttack;
      super.onUpdate();
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
      p_70014_1_.setShort("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
      this.angerLevel = p_70037_1_.getShort("Anger");
   }

   protected Entity findPlayerToAttack() {
      return this.angerLevel == 0 ? null : super.findPlayerToAttack();
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
      if (this.isEntityInvulnerable()) {
         return false;
      } else {
         Entity entity = p_70097_1_.getEntity();
         if (entity instanceof EntityPlayer) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for(int i = 0; i < list.size(); ++i) {
               Entity entity1 = (Entity)list.get(i);
               if (entity1 instanceof EntityKetherCrocodile) {
                  EntityKetherCrocodile entitypigzombie = (EntityKetherCrocodile)entity1;
                  entitypigzombie.becomeAngryAt(entity);
               }
            }

            this.becomeAngryAt(entity);
         }

         return super.attackEntityFrom(p_70097_1_, p_70097_2_);
      }
   }

   private void becomeAngryAt(Entity p_70835_1_) {
      this.entityToAttack = p_70835_1_;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
      int j = this.rand.nextInt(2 + p_70628_2_);

      int k;
      for(k = 0; k < j; ++k) {
         this.dropItem(KMOD_Main.KetherCrocodileTooth, 1);
      }

      j = this.rand.nextInt(2 + p_70628_2_);

      for(k = 0; k < j; ++k) {
         this.dropItem(KMOD_Main.KetherCrocodileLeather, 1);
      }

   }

   public boolean interact(EntityPlayer p_70085_1_) {
      return false;
   }

   protected void dropRareDrop(int p_70600_1_) {
      this.dropItem(KMOD_Main.RubySword, 1);
   }

   public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
      super.onSpawnWithEgg(p_110161_1_);
      this.setVillager(false);
      return p_110161_1_;
   }

   static {
      field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.45D, 0)).setSaved(false);
   }
}
