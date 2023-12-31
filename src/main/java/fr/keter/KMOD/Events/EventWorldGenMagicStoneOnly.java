package fr.keter.KMOD.Events;

import fr.keter.KMOD.Main.KMOD_Main;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class EventWorldGenMagicStoneOnly implements IWorldGenerator {
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
      switch(world.provider.dimensionId) {
      case 0:
         this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
      default:
      }
   }

   private void generateSurface(World world, Random random, int x, int z) {
      this.addOreSpawn(KMOD_Main.MagicStone, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 5, 50);
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
         (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
      }

   }
}
