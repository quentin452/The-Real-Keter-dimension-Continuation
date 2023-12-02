package com.KMOD.Main;

import com.KMOD.Entities.EntityBlueEssence;
import com.KMOD.Entities.EntityCaveGuardian;
import com.KMOD.Entities.EntityDarkEnergy;
import com.KMOD.Entities.EntityDemonEye;
import com.KMOD.Entities.EntityEyeBright;
import com.KMOD.Entities.EntityKeherEnergy;
import com.KMOD.Entities.EntityKetherBoar;
import com.KMOD.Entities.EntityKetherButterfly;
import com.KMOD.Entities.EntityKetherCow;
import com.KMOD.Entities.EntityKetherCrocodile;
import com.KMOD.Entities.EntityKetherFlyingBoar;
import com.KMOD.Entities.EntityKetherGhast;
import com.KMOD.Entities.EntityKetherSlime;
import com.KMOD.Entities.EntityLame;
import com.KMOD.Entities.EntityLostyGhost;
import com.KMOD.Entities.EntityMorf;
import com.KMOD.Entities.EntityRedEssence;
import com.KMOD.Entities.EntitySimple;
import com.KMOD.Entities.EntityStoneDevourer;
import com.KMOD.Entities.EntityYellowEssence;
import com.KMOD.Models.ModelKetherCow;
import com.KMOD.Models.ModelStoneDevourer;
import com.KMOD.Rendering.RenderCaveGuardian;
import com.KMOD.Rendering.RenderCrystals;
import com.KMOD.Rendering.RenderDarkEnergy;
import com.KMOD.Rendering.RenderDemonEye;
import com.KMOD.Rendering.RenderEyeBright;
import com.KMOD.Rendering.RenderFlowerEssence;
import com.KMOD.Rendering.RenderHealingFlower;
import com.KMOD.Rendering.RenderKetherBoar;
import com.KMOD.Rendering.RenderKetherButterfly;
import com.KMOD.Rendering.RenderKetherCow;
import com.KMOD.Rendering.RenderKetherCrocodile;
import com.KMOD.Rendering.RenderKetherEnergy;
import com.KMOD.Rendering.RenderKetherFlyingBoar;
import com.KMOD.Rendering.RenderKetherGhast;
import com.KMOD.Rendering.RenderKetherSlime;
import com.KMOD.Rendering.RenderKetherStonePillarBase;
import com.KMOD.Rendering.RenderKetherStonePillarCenter;
import com.KMOD.Rendering.RenderKetherStonePillarTop;
import com.KMOD.Rendering.RenderKetherYellowStoneBrickPillarBase;
import com.KMOD.Rendering.RenderKetherYellowStoneBrickPillarCenter;
import com.KMOD.Rendering.RenderKetherYellowStoneBrickPillarTop;
import com.KMOD.Rendering.RenderLame;
import com.KMOD.Rendering.RenderLostyGhost;
import com.KMOD.Rendering.RenderMorf;
import com.KMOD.Rendering.RenderMycena;
import com.KMOD.Rendering.RenderSimple;
import com.KMOD.Rendering.RenderStoneDevourer;
import com.KMOD.TileEntities.TileEntityCrystals;
import com.KMOD.TileEntities.TileEntityEnergyConverter;
import com.KMOD.TileEntities.TileEntityEnergyEnchanter;
import com.KMOD.TileEntities.TileEntityGiftsBlock;
import com.KMOD.TileEntities.TileEntityHealingFlower;
import com.KMOD.TileEntities.TileEntityKetherStonePillarBase;
import com.KMOD.TileEntities.TileEntityKetherStonePillarCenter;
import com.KMOD.TileEntities.TileEntityKetherStonePillarTop;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarBase;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarCenter;
import com.KMOD.TileEntities.TileEntityKetherYellowStoneBrickPillarTop;
import com.KMOD.TileEntities.TileEntityMycena;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSlime;

public class KMOD_Main_Entities {
   public static void init() {
      GameRegistry.registerTileEntity(TileEntityMycena.class, "TileEntityMycena");
      GameRegistry.registerTileEntity(TileEntityCrystals.class, "TileEntityCrystals");
      GameRegistry.registerTileEntity(TileEntityHealingFlower.class, "TileEntityHealingFlower");
      GameRegistry.registerTileEntity(TileEntityKetherStonePillarBase.class, "TileEntityKetherStonePillarBase");
      GameRegistry.registerTileEntity(TileEntityKetherStonePillarCenter.class, "TileEntityKetherStonePillarCenter");
      GameRegistry.registerTileEntity(TileEntityKetherStonePillarTop.class, "TileEntityKetherStonePillarTop");
      GameRegistry.registerTileEntity(TileEntityKetherYellowStoneBrickPillarBase.class, "TileEntityKetherYellowStoneBrickBase");
      GameRegistry.registerTileEntity(TileEntityKetherYellowStoneBrickPillarCenter.class, "TileEntityKetherYellowStoneBrickPillarCenter");
      GameRegistry.registerTileEntity(TileEntityKetherYellowStoneBrickPillarTop.class, "TileEntityKetherYellowStoneBrickPillarTop");
      GameRegistry.registerTileEntity(TileEntityEnergyConverter.class, "TileEntityEnergyConverter");
      GameRegistry.registerTileEntity(TileEntityGiftsBlock.class, "TileEntityGiftsBlock");
      GameRegistry.registerTileEntity(TileEntityEnergyEnchanter.class, "TileEntityEnergyEnchanter");
      EntityRegistry.registerModEntity(EntityYellowEssence.class, "YellowEssence", 49, KMOD_Main.instance, 160, 3, true);
      LanguageRegistry.instance().addStringLocalization("entity.YellowEssence.name", "Yellow Essence");
      EntityRegistry.registerModEntity(EntityBlueEssence.class, "BlueEssence", 50, KMOD_Main.instance, 160, 3, true);
      LanguageRegistry.instance().addStringLocalization("entity.BlueEssence.name", "Blue Essence");
      EntityRegistry.registerModEntity(EntityRedEssence.class, "RedEssence", 51, KMOD_Main.instance, 160, 3, true);
      LanguageRegistry.instance().addStringLocalization("entity.RedEssence.name", "Red Essence");
      EntityRegistry.registerModEntity(EntityKeherEnergy.class, "KetherEnergy", 52, KMOD_Main.instance, 160, 3, true);
      LanguageRegistry.instance().addStringLocalization("entity.KetherEnergy.name", "Kether Energy");
      EntityRegistry.registerModEntity(EntityDarkEnergy.class, "DarkEnergy", 59, KMOD_Main.instance, 160, 3, true);
      LanguageRegistry.instance().addStringLocalization("entity.DarkEnergy.name", "Dark Energy");
      EntityRegistry.registerGlobalEntityID(EntityKetherGhast.class, "Dementor", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Dementor.name", "Dementor");
      EntityRegistry.registerGlobalEntityID(EntityStoneDevourer.class, "Stone Devourer", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Stone Devourer.name", "Stone Devourer");
      EntityRegistry.registerGlobalEntityID(EntityKetherSlime.class, "Kether Slime", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Slime.name", "Kether Slime");
      EntityRegistry.registerGlobalEntityID(EntityKetherBoar.class, "Kether Boar", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Boar.name", "Kether Boar");
      EntityRegistry.registerGlobalEntityID(EntityEyeBright.class, "Eye Bright", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Eye Bright.name", "Eye Bright");
      EntityRegistry.registerGlobalEntityID(EntityDemonEye.class, "Demon Eye", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Demon Eye.name", "Demon Eye");
      EntityRegistry.registerGlobalEntityID(EntityMorf.class, "Morf", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Morf.name", "Morf");
      EntityRegistry.registerGlobalEntityID(EntityLame.class, "Lame", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Lame.name", "Lame");
      EntityRegistry.registerGlobalEntityID(EntityLostyGhost.class, "Losty Ghost", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Losty Ghost.name", "Losty Ghost");
      EntityRegistry.registerGlobalEntityID(EntityKetherCrocodile.class, "Kether Crocodile", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Crocodile.name", "Kether Crocodile");
      EntityRegistry.registerGlobalEntityID(EntityCaveGuardian.class, "Cave Guardian", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Cave Guardian.name", "Cave Guardian");
      EntityRegistry.registerGlobalEntityID(EntityKetherButterfly.class, "Kether Butterfly", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Butterfly.name", "Kether Butterfly");
      EntityRegistry.registerGlobalEntityID(EntityKetherFlyingBoar.class, "Kether Flying Boar", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Flying Boar.name", "Kether Flying Boar");
      EntityRegistry.registerGlobalEntityID(EntityKetherCow.class, "Kether Cow", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Kether Cow.name", "Kether Cow");
      EntityRegistry.registerGlobalEntityID(EntitySimple.class, "Drago", EntityRegistry.findGlobalUniqueEntityId(), 1461248, 12886784);
      LanguageRegistry.instance().addStringLocalization("entity.Drago.name", "Drago");
   }

   @SideOnly(Side.CLIENT)
   public static void addRendereres() {
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMycena.class, new RenderMycena());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystals.class, new RenderCrystals());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHealingFlower.class, new RenderHealingFlower());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherStonePillarBase.class, new RenderKetherStonePillarBase());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherStonePillarCenter.class, new RenderKetherStonePillarCenter());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherStonePillarTop.class, new RenderKetherStonePillarTop());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherYellowStoneBrickPillarBase.class, new RenderKetherYellowStoneBrickPillarBase());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherYellowStoneBrickPillarCenter.class, new RenderKetherYellowStoneBrickPillarCenter());
      ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKetherYellowStoneBrickPillarTop.class, new RenderKetherYellowStoneBrickPillarTop());
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherGhast.class, new RenderKetherGhast());
      RenderingRegistry.registerEntityRenderingHandler(EntityStoneDevourer.class, new RenderStoneDevourer(new ModelStoneDevourer(), 0.2F));
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherSlime.class, new RenderKetherSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherBoar.class, new RenderKetherBoar());
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherFlyingBoar.class, new RenderKetherFlyingBoar());
      RenderingRegistry.registerEntityRenderingHandler(EntityEyeBright.class, new RenderEyeBright());
      RenderingRegistry.registerEntityRenderingHandler(EntityDemonEye.class, new RenderDemonEye());
      RenderingRegistry.registerEntityRenderingHandler(EntityDarkEnergy.class, new RenderDarkEnergy(1.0F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMorf.class, new RenderMorf());
      RenderingRegistry.registerEntityRenderingHandler(EntityLame.class, new RenderLame());
      RenderingRegistry.registerEntityRenderingHandler(EntityLostyGhost.class, new RenderLostyGhost());
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherCrocodile.class, new RenderKetherCrocodile());
      RenderingRegistry.registerEntityRenderingHandler(EntityYellowEssence.class, new RenderFlowerEssence(KMOD_Main.YellowFlowerEssence));
      RenderingRegistry.registerEntityRenderingHandler(EntityBlueEssence.class, new RenderFlowerEssence(KMOD_Main.BlueFlowerEssence));
      RenderingRegistry.registerEntityRenderingHandler(EntityRedEssence.class, new RenderFlowerEssence(KMOD_Main.RedFlowerEssence));
      RenderingRegistry.registerEntityRenderingHandler(EntityKeherEnergy.class, new RenderKetherEnergy(KMOD_Main.KetherEnergy));
      RenderingRegistry.registerEntityRenderingHandler(EntityCaveGuardian.class, new RenderCaveGuardian());
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherButterfly.class, new RenderKetherButterfly());
      RenderingRegistry.registerEntityRenderingHandler(EntityKetherCow.class, new RenderKetherCow(new ModelKetherCow(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySimple.class, new RenderSimple());
   }
}