package fr.keter.KMOD.DimensionBases;

import fr.keter.KMOD.Entities.EntityEyeBright;
import fr.keter.KMOD.Entities.EntityKetherBoar;
import fr.keter.KMOD.Entities.EntityKetherButterfly;
import fr.keter.KMOD.Entities.EntityKetherCow;
import fr.keter.KMOD.Entities.EntityKetherCrocodile;
import fr.keter.KMOD.Entities.EntityKetherGhast;
import fr.keter.KMOD.Entities.EntityKetherSlime;
import fr.keter.KMOD.Entities.EntityLame;
import fr.keter.KMOD.Entities.EntityLostyGhost;
import fr.keter.KMOD.Entities.EntityStoneDevourer;
import fr.keter.KMOD.Main.KMOD_Main;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseKether extends BiomeGenBase {
   protected static final Height height_Kether = new Height(1.5F, 0.6F);

   public BiomeGenBaseKether(int p_i45373_1_) {
      super(p_i45373_1_);
      this.setBiomeName("Kether Biome");
      this.setHeight(height_Kether);
      this.setTemperatureRainfall(2.0F, 0.0F);
      this.spawnableCaveCreatureList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableMonsterList.clear();
      this.spawnableWaterCreatureList.clear();
      this.spawnableCreatureList.add(new SpawnListEntry(EntityStoneDevourer.class, 15, 3, 5));
      this.spawnableCreatureList.add(new SpawnListEntry(EntityKetherSlime.class, 10, 1, 4));
      this.spawnableCreatureList.add(new SpawnListEntry(EntityKetherBoar.class, 15, 2, 4));
      this.spawnableCreatureList.add(new SpawnListEntry(EntityLame.class, 10, 2, 5));
      this.spawnableMonsterList.add(new SpawnListEntry(EntityEyeBright.class, 10, 1, 4));
      this.spawnableMonsterList.add(new SpawnListEntry(EntityKetherGhast.class, 4, 1, 5));
      this.spawnableMonsterList.add(new SpawnListEntry(EntityLostyGhost.class, 4, 1, 3));
      this.spawnableMonsterList.add(new SpawnListEntry(EntityKetherCrocodile.class, 6, 1, 2));
      this.spawnableCreatureList.add(new SpawnListEntry(EntityKetherButterfly.class, 15, 3, 7));
      this.spawnableCreatureList.add(new SpawnListEntry(EntityKetherCow.class, 20, 2, 6));
   }

   public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      this.topBlock = KMOD_Main.KetherGrass;
      this.field_150604_aj = 0;
      this.fillerBlock = KMOD_Main.KetherDirt;
      this.genBiomeTerrainKethers(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   public final void genBiomeTerrainKethers(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_) {
      boolean flag = true;
      Block block = this.topBlock;
      byte b0 = (byte)(this.field_150604_aj & 255);
      Block block1 = this.fillerBlock;
      int k = -1;
      int l = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
      int i1 = p_150560_5_ & 15;
      int j1 = p_150560_6_ & 15;
      int k1 = p_150560_3_.length / 256;

      for(int l1 = 255; l1 >= 0; --l1) {
         int i2 = (j1 * 16 + i1) * k1 + l1;
         if (l1 <= 94) {
            p_150560_3_[i2] = Blocks.air;
         } else {
            Block block2 = p_150560_3_[i2];
            if (block2 != null && block2.getMaterial() != Material.air) {
               if (block2 == KMOD_Main.KetherStone) {
                  if (k == -1) {
                     if (l <= 0) {
                        block = null;
                        b0 = 0;
                        block1 = KMOD_Main.KetherStone;
                     } else if (l1 >= 59 && l1 <= 64) {
                        block = this.topBlock;
                        b0 = (byte)(this.field_150604_aj & 255);
                        block1 = this.fillerBlock;
                     }

                     if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
                        if (this.getFloatTemperature(p_150560_5_, l1, p_150560_6_) < 0.15F) {
                           block = Blocks.ice;
                           b0 = 0;
                        } else {
                           block = Blocks.water;
                           b0 = 0;
                        }
                     }

                     k = l;
                     if (l1 >= 62) {
                        p_150560_3_[i2] = block;
                        p_150560_4_[i2] = b0;
                     } else if (l1 < 56 - l) {
                        block = null;
                        block1 = KMOD_Main.KetherStone;
                        p_150560_3_[i2] = Blocks.gravel;
                     } else {
                        p_150560_3_[i2] = block1;
                     }
                  } else if (k > 0) {
                     --k;
                     p_150560_3_[i2] = block1;
                     if (k == 0 && block1 == Blocks.sand) {
                        k = p_150560_2_.nextInt(4) + Math.max(0, l1 - 63);
                        block1 = Blocks.sandstone;
                     }
                  }
               }
            } else {
               k = -1;
            }
         }
      }

   }
}
