package fr.keter.KMOD.Entities;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCaveGuardian extends EntityFlying implements IMob, IBossDisplayData {
   private Entity targetedEntity;
   private int aggroCooldown;
   public int prevAttackCounter;
   public int attackCounter;
   private int explosionStrength = 3;

   public EntityCaveGuardian(World p_i1735_1_) {
      super(p_i1735_1_);
      this.setSize(5.0F, 5.0F);
      this.isImmuneToFire = true;
      this.experienceValue = 1500;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_110182_bF() {
      return this.dataWatcher.getWatchableObjectByte(16) != 0;
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
      if (p_70097_1_.isExplosion()) {
         this.setHealth(this.getHealth() - 25.0F);
      } else {
         this.setHealth(150.0F);
      }

      return true;
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, (byte)0);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
   }

   public void onUpdate() {
      super.onUpdate();
      this.motionX = 0.0D;
      this.motionY = 0.0D;
      this.motionZ = 0.0D;
   }

   protected void updateEntityActionState() {
      this.motionX = 0.0D;
      this.motionY = 0.0D;
      this.motionZ = 0.0D;
      if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
         this.posX = 9999.0D;
         this.posY = 9999.0D;
         this.posZ = 9999.0D;
         this.setDead();
      }

      this.despawnEntity();
      this.prevAttackCounter = this.attackCounter;
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
               this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
               EntityDarkEnergy entitylargefireball = new EntityDarkEnergy(this.worldObj, this, d5, d6, d7);
               entitylargefireball.field_92057_e = this.explosionStrength;
               double d8 = 4.0D;
               Vec3 vec3 = this.getLook(1.0F);
               entitylargefireball.posX = this.posX + vec3.xCoord * d8;
               entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
               entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
               this.worldObj.spawnEntityInWorld(entitylargefireball);
               this.attackCounter = -40;
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

   protected void onDeathUpdate() {
      this.createChestWithItems(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
      EntityMorf em = new EntityMorf(this.worldObj);
      em.setPosition(this.posX, this.posY, this.posZ);
      this.worldObj.spawnEntityInWorld(em);
      if (!this.isDead) {
         this.setDead();
      }

   }

   public int findFreeChestSlot() {
      Random random = new Random();
      int slot = random.nextInt(32);
      return slot;
   }

   private void createChestWithItems(int p_70975_1_, int p_70975_2_) {
      Random random = new Random();
      this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, Blocks.chest);
      this.worldObj.setBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX + 1, (int)this.posY - 1, (int)this.posZ, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX - 1, (int)this.posY - 1, (int)this.posZ, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ + 1, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX, (int)this.posY - 1, (int)this.posZ - 1, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX + 1, (int)this.posY - 1, (int)this.posZ - 1, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX + 1, (int)this.posY - 1, (int)this.posZ + 1, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX - 1, (int)this.posY - 1, (int)this.posZ - 1, KMOD_Main.KetherGrass);
      this.worldObj.setBlock((int)this.posX - 1, (int)this.posY - 1, (int)this.posZ + 1, KMOD_Main.KetherGrass);
      TileEntityChest tileentitychest = (TileEntityChest)this.worldObj.getTileEntity((int)this.posX, (int)this.posY, (int)this.posZ);
      int RandomChestSlot1 = random.nextInt(32);
      int RandomChestSlot2 = random.nextInt(32);
      int RandomChestSlot3 = random.nextInt(32);
      int RandomChestSlot4 = random.nextInt(32);
      int RandomChestSlot5 = random.nextInt(32);
      int RandomChestSlot6 = random.nextInt(32);
      int RandomChestSlot7 = random.nextInt(32);
      int RandomChestSlot8 = random.nextInt(32);
      int RandomChestSlot9 = random.nextInt(32);
      int RandomChestSlot10 = random.nextInt(32);
      int RandomChestSlot11 = random.nextInt(32);
      int RandomChestSlot12 = random.nextInt(32);
      int RandomChestSlot13 = random.nextInt(32);
      int crystalsrandomquantity = random.nextInt(50);
      int r1 = random.nextInt(32);
      int r2 = random.nextInt(6);
      int r3 = random.nextInt(35);
      int r4 = random.nextInt(15);
      if (tileentitychest != null && tileentitychest.getSizeInventory() > 0) {
         ItemStack itemstack = new ItemStack(KMOD_Main.JumpBoots, 1);
         tileentitychest.setInventorySlotContents(RandomChestSlot1, itemstack);
         ItemStack itemstack1 = new ItemStack(KMOD_Main.KetherWand, 1);
         tileentitychest.setInventorySlotContents(RandomChestSlot2, itemstack1);
         ItemStack itemstack2 = new ItemStack(KMOD_Main.APieceOfCloth, r2);
         tileentitychest.setInventorySlotContents(RandomChestSlot3, itemstack2);
         ItemStack itemstack3 = new ItemStack(KMOD_Main.Crystals, crystalsrandomquantity);
         tileentitychest.setInventorySlotContents(RandomChestSlot4, itemstack3);
         ItemStack itemstack5 = new ItemStack(KMOD_Main.DarkEnergy, r1);
         tileentitychest.setInventorySlotContents(RandomChestSlot5, itemstack5);
         ItemStack itemstack7 = new ItemStack(KMOD_Main.BlueFlowerEssence, r3);
         tileentitychest.setInventorySlotContents(RandomChestSlot7, itemstack7);
         ItemStack itemstack8 = new ItemStack(KMOD_Main.RedFlowerEssence, r3);
         tileentitychest.setInventorySlotContents(RandomChestSlot8, itemstack8);
         ItemStack itemstack9 = new ItemStack(KMOD_Main.YellowFlowerEssence, r3);
         tileentitychest.setInventorySlotContents(RandomChestSlot9, itemstack9);
         ItemStack itemstack10 = new ItemStack(KMOD_Main.LonsdaleiteGem, r2);
         tileentitychest.setInventorySlotContents(RandomChestSlot10, itemstack10);
         ItemStack itemstack12 = new ItemStack(KMOD_Main.Pytajnik, r4);
         tileentitychest.setInventorySlotContents(RandomChestSlot12, itemstack12);
         ItemStack itemstack11 = new ItemStack(KMOD_Main.LegendaryMagicWand, 1);
         tileentitychest.setInventorySlotContents(RandomChestSlot11, itemstack11);
         ItemStack itemstack13 = new ItemStack(KMOD_Main.GravityWand, 1);
         tileentitychest.setInventorySlotContents(RandomChestSlot13, itemstack13);
         ItemStack itemstack6 = new ItemStack(KMOD_Main.KetherKey, 1);
         tileentitychest.setInventorySlotContents(RandomChestSlot6, itemstack6);
      }

   }

   protected String getLivingSound() {
      return "mob.ghast.moan";
   }

   protected String getHurtSound() {
      return "mob.ghast.scream";
   }

   protected String getDeathSound() {
      return "mob.ghast.death";
   }

   protected Item getDropItem() {
      return KMOD_Main.DarkEnergy;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
      int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);

      int k;
      for(k = 0; k < j; ++k) {
         this.dropItem(KMOD_Main.DarkEnergy, 1);
      }

      j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

      for(k = 0; k < j; ++k) {
         this.dropItem(KMOD_Main.DarkEnergy, 1);
      }

   }

   protected float getSoundVolume() {
      return 10.0F;
   }

   public boolean getCanSpawnHere() {
      return this.rand.nextInt(100) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.posY > 105.0D;
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
