package com.KMOD.Entities;

import com.KMOD.Main.KMOD_Main;
import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntityKetherSlime extends EntityLiving implements IMob {
   public float squishAmount;
   public float squishFactor;
   public float prevSquishFactor;
   private int slimeJumpDelay;
   Random random = new Random();
   public String SlimeType;
   Random r = new Random();

   public EntityKetherSlime(World p_i1742_1_) {
      super(p_i1742_1_);
      int i = 1 << this.rand.nextInt(3);
      this.yOffset = 0.0F;
      this.slimeJumpDelay = this.rand.nextInt(20) + 10;
      this.setSlimeSize(i);
      int ii = this.random.nextInt(6);
      if (ii == 1) {
         this.setSlimeType("Ruby");
      }

      if (ii == 2) {
         this.setSlimeType("Topaz");
      }

      if (ii == 3) {
         this.setSlimeType("Sapphire");
      }

      if (ii == 4 || ii == 5 || ii == 6 || ii == 7 || ii == 8 || ii == 9 || ii == 10 || ii == 0) {
         this.setSlimeType("Normal");
      }

   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, new Byte((byte)1));
   }

   protected void setSlimeSize(int p_70799_1_) {
      this.dataWatcher.updateObject(16, new Byte((byte)p_70799_1_));
      this.setSize(0.6F * (float)p_70799_1_, 0.6F * (float)p_70799_1_);
      this.setPosition(this.posX, this.posY, this.posZ);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(p_70799_1_ * p_70799_1_));
      this.setHealth(this.getMaxHealth());
      this.experienceValue = p_70799_1_;
   }

   protected void setSlimeType(String Type) {
      this.SlimeType = Type;
   }

   public String getSlimeType() {
      return this.SlimeType;
   }

   public int getSlimeSize() {
      return this.dataWatcher.getWatchableObjectByte(16);
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
      super.writeEntityToNBT(p_70014_1_);
      p_70014_1_.setInteger("Size", this.getSlimeSize() - 1);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
      super.readEntityFromNBT(p_70037_1_);
      int i = p_70037_1_.getInteger("Size");
      if (i < 0) {
         i = 0;
      }

      this.setSlimeSize(i + 1);
   }

   protected String getSlimeParticle() {
      return "slime";
   }

   protected String getJumpSound() {
      return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
   }

   public void onUpdate() {
      if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0) {
         this.isDead = true;
      }

      this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
      this.prevSquishFactor = this.squishFactor;
      boolean flag = this.onGround;
      super.onUpdate();
      int i;
      if (this.onGround && !flag) {
         i = this.getSlimeSize();

         for(int j = 0; j < i * 8; ++j) {
            float f = this.rand.nextFloat() * 3.1415927F * 2.0F;
            float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
            float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
            float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
            this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0D, 0.0D, 0.0D);
         }

         if (this.makesSoundOnLand()) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.squishAmount = -0.5F;
      } else if (!this.onGround && flag) {
         this.squishAmount = 1.0F;
      }

      this.alterSquishAmount();
      if (this.worldObj.isRemote) {
         i = this.getSlimeSize();
         this.setSize(0.6F * (float)i, 0.6F * (float)i);
      }

   }

   protected void updateEntityActionState() {
      this.despawnEntity();
      EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
      if (entityplayer != null) {
         this.faceEntity(entityplayer, 10.0F, 20.0F);
      }

      if (this.onGround && this.slimeJumpDelay-- <= 0) {
         this.slimeJumpDelay = this.getJumpDelay();
         if (entityplayer != null) {
            this.slimeJumpDelay /= 3;
         }

         this.isJumping = true;
         if (this.makesSoundOnJump()) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
         }

         this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
         this.moveForward = (float)(1 * this.getSlimeSize());
      } else {
         this.isJumping = false;
         if (this.onGround) {
            this.moveStrafing = this.moveForward = 0.0F;
         }
      }

   }

   protected void alterSquishAmount() {
      this.squishAmount *= 0.6F;
   }

   protected int getJumpDelay() {
      return this.rand.nextInt(20) + 10;
   }

   protected EntityKetherSlime createInstance() {
      return new EntityKetherSlime(this.worldObj);
   }

   public void setDead() {
      int i = this.getSlimeSize();
      if (!this.worldObj.isRemote && i > 1 && this.getHealth() <= 0.0F) {
         int j = 2 + this.rand.nextInt(3);

         for(int k = 0; k < j; ++k) {
            float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
            float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
            EntityKetherSlime entityslime = this.createInstance();
            entityslime.setSlimeSize(i / 2);
            entityslime.setSlimeType(this.getSlimeType());
            entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
            this.worldObj.spawnEntityInWorld(entityslime);
         }
      }

      super.setDead();
   }

   public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
      if (this.canDamagePlayer()) {
         int i = this.getSlimeSize();
         if (this.canEntityBeSeen(p_70100_1_) && this.getDistanceSqToEntity(p_70100_1_) < 0.6D * (double)i * 0.6D * (double)i && p_70100_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getAttackStrength())) {
            this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
         }
      }

   }

   protected boolean canDamagePlayer() {
      return this.getSlimeSize() > 1;
   }

   protected int getAttackStrength() {
      return this.getSlimeSize();
   }

   protected String getHurtSound() {
      return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
   }

   protected String getDeathSound() {
      return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
   }

   protected Item getDropItem() {
      if (this.SlimeType == "Normal") {
         return Items.slime_ball;
      } else if (this.SlimeType == "Topaz") {
         return KMOD_Main.TopazGem;
      } else if (this.SlimeType == "Ruby") {
         return KMOD_Main.RubyGem;
      } else {
         return this.SlimeType == "Sapphire" ? KMOD_Main.SapphireGem : Items.slime_ball;
      }
   }

   public boolean getCanSpawnHere() {
      Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
      if (this.worldObj.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(this.rand, this.worldObj)) {
         return false;
      } else {
         BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
         if (biomegenbase == KMOD_Main.KetherBiome && this.rand.nextFloat() < 0.5F && this.rand.nextFloat() < this.worldObj.getCurrentMoonPhaseFactor() && this.worldObj.getBlockLightValue(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) <= this.rand.nextInt(8)) {
            return super.getCanSpawnHere();
         } else {
            return this.rand.nextInt(5) == 0 && chunk.getRandomWithSeed(987234911L).nextInt(5) == 0 && this.posY < 40.0D ? super.getCanSpawnHere() : false;
         }
      }
   }

   protected float getSoundVolume() {
      return 0.4F * (float)this.getSlimeSize();
   }

   public int getVerticalFaceSpeed() {
      return 0;
   }

   protected boolean makesSoundOnJump() {
      return this.getSlimeSize() > 0;
   }

   protected boolean makesSoundOnLand() {
      return this.getSlimeSize() > 2;
   }
}
