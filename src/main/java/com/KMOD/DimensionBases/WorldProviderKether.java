package com.KMOD.DimensionBases;

import com.KMOD.Main.KMOD_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderKether extends WorldProvider {
   public void registerWorldChunkManager() {
      this.worldChunkMgr = new WorldChunkManagerHell(KMOD_Main.KetherBiome, 0.1F);
      this.dimensionId = 8;
   }

   public IChunkProvider createChunkGenerator() {
      return new ChunkProviderKether(this.worldObj, this.worldObj.getSeed(), false);
   }

   public String getDimensionName() {
      return "Kether";
   }

   public ChunkCoordinates getEntrancePortalLocation() {
      return new ChunkCoordinates(0, 80, 0);
   }

   public boolean canRespawnHere() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float getCloudHeight() {
      return 20.0F;
   }
}
