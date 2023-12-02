package com.KMOD.DamageSource;

import com.KMOD.Entities.EntityDarkEnergy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.Explosion;

public class DamageSourceExtends extends DamageSource {
   public static DamageSourceExtends inFire = (new DamageSourceExtends("inFire")).setFireDamage();
   public static DamageSourceExtends onFire = (new DamageSourceExtends("onFire")).setDamageBypassesArmor().setFireDamage();
   public static DamageSourceExtends lava = (new DamageSourceExtends("lava")).setFireDamage();
   public static DamageSourceExtends inWall = (new DamageSourceExtends("inWall")).setDamageBypassesArmor();
   public static DamageSourceExtends drown = (new DamageSourceExtends("drown")).setDamageBypassesArmor();
   public static DamageSourceExtends starve = (new DamageSourceExtends("starve")).setDamageBypassesArmor().setDamageIsAbsolute();
   public static DamageSourceExtends cactus = new DamageSourceExtends("cactus");
   public static DamageSourceExtends fall = (new DamageSourceExtends("fall")).setDamageBypassesArmor();
   public static DamageSourceExtends outOfWorld = (new DamageSourceExtends("outOfWorld")).setDamageBypassesArmor().setDamageAllowedInCreativeMode();
   public static DamageSourceExtends generic = (new DamageSourceExtends("generic")).setDamageBypassesArmor();
   public static DamageSourceExtends magic = (new DamageSourceExtends("magic")).setDamageBypassesArmor().setMagicDamage();
   public static DamageSourceExtends wither = (new DamageSourceExtends("wither")).setDamageBypassesArmor();
   public static DamageSourceExtends anvil = new DamageSourceExtends("anvil");
   public static DamageSourceExtends fallingBlock = new DamageSourceExtends("fallingBlock");
   private boolean isUnblockable;
   private boolean isDamageAllowedInCreativeMode;
   private boolean damageIsAbsolute;
   private float hungerDamage = 0.3F;
   private boolean fireDamage;
   private boolean projectile;
   private boolean difficultyScaled;
   private boolean magicDamage;
   private boolean explosion;
   public String damageType;

   public static DamageSourceExtends causeMobDamage(EntityLivingBase p_76358_0_) {
      return new EntityDamageSourceExtends("mob", p_76358_0_);
   }

   public static DamageSourceExtends causePlayerDamage(EntityPlayer p_76365_0_) {
      return new EntityDamageSourceExtends("player", p_76365_0_);
   }

   public static DamageSourceExtends causeArrowDamage(EntityArrow p_76353_0_, Entity p_76353_1_) {
      return (new EntityDamageSourceIndirectExtends("arrow", p_76353_0_, p_76353_1_)).setProjectile();
   }

   public static DamageSourceExtends causeFireballDamage(EntityFireball p_76362_0_, Entity p_76362_1_) {
      return p_76362_1_ == null ? (new EntityDamageSourceIndirectExtends("onFire", p_76362_0_, p_76362_0_)).setFireDamage().setProjectile() : (new EntityDamageSourceIndirectExtends("fireball", p_76362_0_, p_76362_1_)).setFireDamage().setProjectile();
   }

   public static DamageSourceExtends causeDarkEnergyDamage(EntityDarkEnergy p_76362_0_, Entity p_76362_1_) {
      return p_76362_1_ == null ? (new EntityDamageSourceIndirectExtends("onDarkEnergyDamage", p_76362_0_, p_76362_0_)).setProjectile() : (new EntityDamageSourceIndirectExtends("DarkrEnergy", p_76362_0_, p_76362_1_)).setProjectile();
   }

   public static DamageSourceExtends causeThrownDamage(Entity p_76356_0_, Entity p_76356_1_) {
      return (new EntityDamageSourceIndirectExtends("thrown", p_76356_0_, p_76356_1_)).setProjectile();
   }

   public static DamageSourceExtends causeIndirectMagicDamage(Entity p_76354_0_, Entity p_76354_1_) {
      return (new EntityDamageSourceIndirectExtends("indirectMagic", p_76354_0_, p_76354_1_)).setDamageBypassesArmor().setMagicDamage();
   }

   public static DamageSourceExtends causeThornsDamage(Entity p_92087_0_) {
      return (new EntityDamageSourceExtends("thorns", p_92087_0_)).setMagicDamage();
   }

   public static DamageSourceExtends setExplosionSource(Explosion p_94539_0_) {
      return p_94539_0_ != null && p_94539_0_.getExplosivePlacedBy() != null ? (new EntityDamageSourceExtends("explosion.player", p_94539_0_.getExplosivePlacedBy())).setDifficultyScaled().setExplosion() : (new DamageSourceExtends("explosion")).setDifficultyScaled().setExplosion();
   }

   public boolean isProjectile() {
      return this.projectile;
   }

   public DamageSourceExtends setProjectile() {
      this.projectile = true;
      return this;
   }

   public boolean isExplosion() {
      return this.explosion;
   }

   public DamageSourceExtends setExplosion() {
      this.explosion = true;
      return this;
   }

   public boolean isUnblockable() {
      return this.isUnblockable;
   }

   public float getHungerDamage() {
      return this.hungerDamage;
   }

   public boolean canHarmInCreative() {
      return this.isDamageAllowedInCreativeMode;
   }

   public boolean isDamageAbsolute() {
      return this.damageIsAbsolute;
   }

   public DamageSourceExtends(String p_i1566_1_) {
      super(p_i1566_1_);
      this.damageType = p_i1566_1_;
   }

   public Entity getSourceOfDamage() {
      return this.getEntity();
   }

   public Entity getEntity() {
      return null;
   }

   public DamageSourceExtends setDamageBypassesArmor() {
      this.isUnblockable = true;
      this.hungerDamage = 0.0F;
      return this;
   }

   public DamageSourceExtends setDamageAllowedInCreativeMode() {
      this.isDamageAllowedInCreativeMode = true;
      return this;
   }

   public DamageSourceExtends setDamageIsAbsolute() {
      this.damageIsAbsolute = true;
      this.hungerDamage = 0.0F;
      return this;
   }

   public DamageSourceExtends setFireDamage() {
      this.fireDamage = true;
      return this;
   }

   public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
      EntityLivingBase entitylivingbase1 = p_151519_1_.func_94060_bK();
      String s = "death.attack." + this.damageType;
      String s1 = s + ".player";
      return entitylivingbase1 != null && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[]{p_151519_1_.func_145748_c_(), entitylivingbase1.func_145748_c_()}) : new ChatComponentTranslation(s, new Object[]{p_151519_1_.func_145748_c_()});
   }

   public boolean isFireDamage() {
      return this.fireDamage;
   }

   public String getDamageType() {
      return this.damageType;
   }

   public DamageSourceExtends setDifficultyScaled() {
      this.difficultyScaled = true;
      return this;
   }

   public boolean isDifficultyScaled() {
      return this.difficultyScaled;
   }

   public boolean isMagicDamage() {
      return this.magicDamage;
   }

   public DamageSourceExtends setMagicDamage() {
      this.magicDamage = true;
      return this;
   }
}
