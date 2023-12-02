package fr.keter.KMOD.Events;

import fr.keter.KMOD.Main.KMOD_Main;
import fr.keter.KMOD.WorldGens.KetherGenBlueFruit;
import fr.keter.KMOD.WorldGens.KetherGenClouds;
import fr.keter.KMOD.WorldGens.KetherGenCrystals;
import fr.keter.KMOD.WorldGens.KetherGenFlowersMulti;
import fr.keter.KMOD.WorldGens.KetherGenGlowingKetherGrass;
import fr.keter.KMOD.WorldGens.KetherGenGoldenGrove;
import fr.keter.KMOD.WorldGens.KetherGenHealingFlower;
import fr.keter.KMOD.WorldGens.KetherGenHemp;
import fr.keter.KMOD.WorldGens.KetherGenMycena;
import fr.keter.KMOD.WorldGens.KetherGenTallGrass;
import fr.keter.KMOD.WorldGens.KetherGenTheGreatCave;
import fr.keter.KMOD.WorldGens.WorldGenDarkChamber;
import fr.keter.KMOD.WorldGens.WorldGenKetherFlowers;
import fr.keter.KMOD.WorldGens.WorldGenMinableKether;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class EventWorldGenKether implements IWorldGenerator {
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
      switch(world.provider.dimensionId) {
      case 8:
         this.generateKether(world, random, chunkX * 16, chunkZ * 16);
      default:
      }
   }

   private void generateKether(World world, Random random, int x, int z) {
      this.addOreSpawn(KMOD_Main.MagicStone, world, random, x, z, 16, 16, 10 + random.nextInt(10), 10 + random.nextInt(7), 90, 175);
      this.addOreSpawn(KMOD_Main.RubyOre, world, random, x, z, 16, 16, 5 + random.nextInt(10), 3 + random.nextInt(5), 90, 175);
      this.addOreSpawn(KMOD_Main.TopazOre, world, random, x, z, 16, 16, 5 + random.nextInt(10), 3 + random.nextInt(5), 90, 175);
      this.addOreSpawn(KMOD_Main.SapphireOre, world, random, x, z, 16, 16, 5 + random.nextInt(10), 3 + random.nextInt(5), 90, 175);
      this.addOreSpawn(KMOD_Main.MalachiteOre, world, random, x, z, 16, 16, 10 + random.nextInt(10), 7 + random.nextInt(5), 90, 175);
      this.addOreSpawn(KMOD_Main.ShadowOre, world, random, x, z, 16, 16, 4 + random.nextInt(7), 3 + random.nextInt(4), 90, 175);
      this.addOreSpawn(KMOD_Main.SaintOre, world, random, x, z, 16, 16, 3 + random.nextInt(5), 2 + random.nextInt(3), 90, 175);
      this.addOreSpawn(KMOD_Main.AdamantiumOre, world, random, x, z, 16, 16, 2 + random.nextInt(4), 1 + random.nextInt(2), 150, 225);
      this.GrowCrystals(world, random, x, z, 16, 16, 1, 94, 240);
      this.SpawnDarkChamber(world, random, x, z, 16, 16, 1, 20, 90);
      this.SpawnTheGreatCave(world, random, x, z, 16, 16, 1, 20, 90);
      this.SpawnGoldenGrove(world, random, x, z, 16, 16, 1, 20, 90);
   }

   public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         (new WorldGenMinableKether(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
      }

   }

   public void SpawnGlowingKetherGrass(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      for(int xx = 90; xx < 156; ++xx) {
         int posX = blockXPos + random.nextInt(maxX);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass) && random.nextInt(3) == 2) {
            (new KetherGenGlowingKetherGrass()).generate(world, random, posX, xx, posZ);
         }
      }

   }

   public void PopulateWithKetherTallGrass(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      for(int xx = 90; xx < 156; ++xx) {
         int posX = blockXPos + random.nextInt(maxX);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenTallGrass()).generate(world, random, posX, xx, posZ);
         }
      }

   }

   public void GrowHemp(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenHemp()).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowYellowFlowers(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new WorldGenKetherFlowers(KMOD_Main.KetherYellowFlower)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowBlueFlowers(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new WorldGenKetherFlowers(KMOD_Main.KetherBlueFlower)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowRedFlowers(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new WorldGenKetherFlowers(KMOD_Main.KetherRedFlower)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void AddMycenia(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenMycena(KMOD_Main.Mycena)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowCrystals(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenCrystals(KMOD_Main.Crystals)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowBlueFruit(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenBlueFruit()).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void SpawnDarkChamber(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && random.nextInt(1250) == 50) {
            (new WorldGenDarkChamber()).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void SpawnGoldenGrove(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && random.nextInt(2500) == 50) {
            (new KetherGenGoldenGrove()).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void GrowHealingFlower(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && (world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, posY - 1, posZ) == KMOD_Main.KetherGrass)) {
            (new KetherGenHealingFlower(KMOD_Main.HealingFlower)).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void SpawnTheGreatCave(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && random.nextInt(2500) == 50) {
            (new KetherGenTheGreatCave()).generate(world, random, posX, posY, posZ);
         }
      }

   }

   public void SpawnFlowers1(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      if (random.nextInt(40) == 1) {
         for(int xx = 90; xx < 150; ++xx) {
            int posX = blockXPos + random.nextInt(maxX);
            int posZ = blockZPos + random.nextInt(maxZ);
            if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass)) {
               (new KetherGenFlowersMulti(KMOD_Main.KetherBlackRose)).generate(world, random, posX, xx, posZ);
            }
         }
      }

   }

   public void SpawnFlowers2(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      if (random.nextInt(40) == 1) {
         for(int xx = 90; xx < 150; ++xx) {
            int posX = blockXPos + random.nextInt(maxX);
            int posZ = blockZPos + random.nextInt(maxZ);
            if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass)) {
               (new KetherGenFlowersMulti(KMOD_Main.KetherPurpleRose)).generate(world, random, posX, xx, posZ);
            }
         }
      }

   }

   public void SpawnFlowers3(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      if (random.nextInt(40) == 1) {
         for(int xx = 90; xx < 150; ++xx) {
            int posX = blockXPos + random.nextInt(maxX);
            int posZ = blockZPos + random.nextInt(maxZ);
            if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass)) {
               (new KetherGenFlowersMulti(KMOD_Main.KetherBlueRose)).generate(world, random, posX, xx, posZ);
            }
         }
      }

   }

   public void SpawnFlowers4(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ) {
      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      if (random.nextInt(40) == 1) {
         for(int xx = 90; xx < 150; ++xx) {
            int posX = blockXPos + random.nextInt(maxX);
            int posZ = blockZPos + random.nextInt(maxZ);
            if (world.isAirBlock(posX, xx, posZ) && (world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherDirt || world.getBlock(posX, xx - 1, posZ) == KMOD_Main.KetherGrass)) {
               (new KetherGenFlowersMulti(KMOD_Main.KetherLightBlueRose)).generate(world, random, posX, xx, posZ);
            }
         }
      }

   }

   public void PopulateWithClouds(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int chancesToSpawn, int minY, int maxY) {
      assert maxY > minY : "The maximum Y must be greater than the Minimum Y";

      assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";

      assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";

      assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";

      assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

      int diffBtwnMinMaxY = maxY - minY;

      for(int x = 0; x < chancesToSpawn; ++x) {
         int posX = blockXPos + random.nextInt(maxX);
         int posY = minY + random.nextInt(diffBtwnMinMaxY);
         int posZ = blockZPos + random.nextInt(maxZ);
         if (world.isAirBlock(posX, posY, posZ) && world.isAirBlock(posX, posY - 15, posZ) && world.isAirBlock(posX, posY + 15, posZ) && random.nextInt(3) == 2) {
            (new KetherGenClouds()).generate(world, random, posX, posY, posZ);
         }
      }

   }
}
