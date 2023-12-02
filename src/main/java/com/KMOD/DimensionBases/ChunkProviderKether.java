package com.KMOD.DimensionBases;

import com.KMOD.Main.KMOD_Main;
import com.KMOD.WorldGens.KetherGenBlueFruit;
import com.KMOD.WorldGens.KetherGenCanopyTree;
import com.KMOD.WorldGens.KetherGenClouds;
import com.KMOD.WorldGens.KetherGenFlowersMulti;
import com.KMOD.WorldGens.KetherGenGlowingKetherGrass;
import com.KMOD.WorldGens.KetherGenHealingFlower;
import com.KMOD.WorldGens.KetherGenHemp;
import com.KMOD.WorldGens.KetherGenHugeTrees;
import com.KMOD.WorldGens.KetherGenLifeTree;
import com.KMOD.WorldGens.KetherGenLonsdaleiteTree;
import com.KMOD.WorldGens.KetherGenMovingSands;
import com.KMOD.WorldGens.KetherGenMycena;
import com.KMOD.WorldGens.KetherGenNormalTrees;
import com.KMOD.WorldGens.KetherGenTallGrass;
import com.KMOD.WorldGens.WorldGenKetherFlowers;
import com.KMOD.WorldGens.WorldGenKetherMegaPineTree;
import com.KMOD.WorldGens.NewTestTrees.KetherGenTree1;
import com.KMOD.WorldGens.NewTestTrees.KetherGenTree2;
import com.KMOD.WorldGens.NewTestTrees.KetherGenTree3;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Post;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Pre;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;

public class ChunkProviderKether implements IChunkProvider {
   private Random rand;
   private NoiseGeneratorOctaves field_147431_j;
   private NoiseGeneratorOctaves field_147432_k;
   private NoiseGeneratorOctaves field_147429_l;
   private NoiseGeneratorPerlin field_147430_m;
   public NoiseGeneratorOctaves noiseGen5;
   public NoiseGeneratorOctaves noiseGen6;
   public NoiseGeneratorOctaves mobSpawnerNoise;
   private World worldObj;
   private final boolean mapFeaturesEnabled;
   private WorldType field_147435_p;
   private final double[] field_147434_q;
   private final float[] parabolicField;
   private double[] stoneNoise = new double[256];
   private MapGenBase caveGenerator = new MapGenCaves();
   private BiomeGenBase[] biomesForGeneration;
   double[] field_147427_d;
   double[] field_147428_e;
   double[] field_147425_f;
   double[] field_147426_g;
   int[][] field_73219_j = new int[32][32];
   public boolean treegenerated;
   private ArrayList trees;
   private ArrayList flowers;

   public ChunkProviderKether(World p_i2006_1_, long p_i2006_2_, boolean p_i2006_4_) {
      this.worldObj = p_i2006_1_;
      this.mapFeaturesEnabled = p_i2006_4_;
      this.field_147435_p = p_i2006_1_.getWorldInfo().getTerrainType();
      this.rand = new Random(p_i2006_2_);
      this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
      this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
      this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
      this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
      this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
      this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
      this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
      this.field_147434_q = new double[825];
      this.parabolicField = new float[25];
      this.treegenerated = false;

      for(int j = -2; j <= 2; ++j) {
         for(int k = -2; k <= 2; ++k) {
            float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
            this.parabolicField[j + 2 + (k + 2) * 5] = f;
         }
      }

      NoiseGenerator[] noiseGens = new NoiseGenerator[]{this.field_147431_j, this.field_147432_k, this.field_147429_l, this.field_147430_m, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise};
      noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2006_1_, this.rand, noiseGens);
      this.field_147431_j = (NoiseGeneratorOctaves)noiseGens[0];
      this.field_147432_k = (NoiseGeneratorOctaves)noiseGens[1];
      this.field_147429_l = (NoiseGeneratorOctaves)noiseGens[2];
      this.field_147430_m = (NoiseGeneratorPerlin)noiseGens[3];
      this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
      this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
      this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
      this.trees = new ArrayList(1);
      this.trees.add(new KetherGenHugeTrees(false, 15, 25, 3, 3));
      this.trees.add(new WorldGenKetherMegaPineTree(true, true));
      this.trees.add(new KetherGenNormalTrees(true));
      this.trees.add(new KetherGenCanopyTree(true));
      this.trees.add(new KetherGenTree1());
      this.trees.add(new KetherGenTree2());
      this.trees.add(new KetherGenTree3());
      this.flowers = new ArrayList(1);
      this.flowers.add(new KetherGenFlowersMulti(KMOD_Main.KetherLightBlueRose));
      this.flowers.add(new KetherGenFlowersMulti(KMOD_Main.KetherBlueRose));
      this.flowers.add(new KetherGenFlowersMulti(KMOD_Main.KetherPurpleRose));
      this.flowers.add(new KetherGenFlowersMulti(KMOD_Main.KetherBlackRose));
      this.flowers.add(new WorldGenKetherFlowers(KMOD_Main.KetherYellowFlower));
      this.flowers.add(new WorldGenKetherFlowers(KMOD_Main.KetherBlueFlower));
      this.flowers.add(new WorldGenKetherFlowers(KMOD_Main.KetherRedFlower));
      this.flowers.add(new KetherGenHealingFlower(KMOD_Main.HealingFlower));
      this.flowers.add(new KetherGenGlowingKetherGrass());
      this.flowers.add(new KetherGenHemp());
      this.flowers.add(new KetherGenBlueFruit());
      this.flowers.add(new KetherGenMycena(KMOD_Main.Mycena));
   }

   public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) {
      byte b0 = 63;
      this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
      this.func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);

      for(int k = 0; k < 4; ++k) {
         int l = k * 5;
         int i1 = (k + 1) * 5;

         for(int j1 = 0; j1 < 4; ++j1) {
            int k1 = (l + j1) * 33;
            int l1 = (l + j1 + 1) * 33;
            int i2 = (i1 + j1) * 33;
            int j2 = (i1 + j1 + 1) * 33;

            for(int k2 = 0; k2 < 32; ++k2) {
               double d0 = 0.125D;
               double d1 = this.field_147434_q[k1 + k2];
               double d2 = this.field_147434_q[l1 + k2];
               double d3 = this.field_147434_q[i2 + k2];
               double d4 = this.field_147434_q[j2 + k2];
               double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
               double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
               double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
               double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;

               for(int l2 = 0; l2 < 8; ++l2) {
                  double d9 = 0.25D;
                  double d10 = d1;
                  double d11 = d2;
                  double d12 = (d3 - d1) * d9;
                  double d13 = (d4 - d2) * d9;

                  for(int i3 = 0; i3 < 4; ++i3) {
                     int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                     short short1 = 256;
                     j3 -= short1;
                     double d14 = 0.25D;
                     double d16 = (d11 - d10) * d14;
                     double d15 = d10 - d16;

                     for(int k3 = 0; k3 < 4; ++k3) {
                        if ((d15 += d16) > 0.0D) {
                           p_147424_3_[j3 += short1] = KMOD_Main.KetherStone;
                        } else if (k2 * 8 + l2 < b0) {
                           p_147424_3_[j3 += short1] = Blocks.water;
                        } else {
                           p_147424_3_[j3 += short1] = null;
                        }
                     }

                     d10 += d12;
                     d11 += d13;
                  }

                  d1 += d5;
                  d2 += d6;
                  d3 += d7;
                  d4 += d8;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_) {
      ReplaceBiomeBlocks event = new ReplaceBiomeBlocks(this, p_147422_1_, p_147422_2_, p_147422_3_, p_147422_4_, p_147422_5_, this.worldObj);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.getResult() != Result.DENY) {
         double d0 = 0.03125D;
         this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, (double)(p_147422_1_ * 16), (double)(p_147422_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

         for(int k = 0; k < 16; ++k) {
            for(int l = 0; l < 16; ++l) {
               BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
               biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
            }
         }

      }
   }

   public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
      return this.provideChunk(p_73158_1_, p_73158_2_);
   }

   public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
      this.rand.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
      Block[] ablock = new Block[65536];
      byte[] abyte = new byte[65536];
      this.func_147424_a(p_73154_1_, p_73154_2_, ablock);
      this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      this.replaceBlocksForBiome(p_73154_1_, p_73154_2_, ablock, abyte, this.biomesForGeneration);
      this.caveGenerator.func_151539_a(this, this.worldObj, p_73154_1_, p_73154_2_, ablock);
      if (this.mapFeaturesEnabled) {
      }

      Chunk chunk = new Chunk(this.worldObj, ablock, abyte, p_73154_1_, p_73154_2_);
      byte[] abyte1 = chunk.getBiomeArray();

      for(int k = 0; k < abyte1.length; ++k) {
         abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
      }

      chunk.generateSkylightMap();
      return chunk;
   }

   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
      double d0 = 684.412D;
      double d1 = 1700.412D;
      double d2 = 512.0D;
      double d3 = 512.0D;
      this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
      this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
      this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 1024.412D, 720.412D, 380.412D);
      this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 1230.412D, 680.412D, 400.412D);
      boolean flag1 = false;
      boolean flag = false;
      int l = 0;
      int i1 = 0;
      double d4 = 8.5D;

      for(int j1 = 0; j1 < 5; ++j1) {
         for(int k1 = 0; k1 < 5; ++k1) {
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            byte b0 = 2;
            BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

            for(int l1 = -b0; l1 <= b0; ++l1) {
               for(int i2 = -b0; i2 <= b0; ++i2) {
                  BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                  float f3 = biomegenbase1.rootHeight;
                  float f4 = biomegenbase1.heightVariation;
                  if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
                     f3 = 1.0F + f3 * 2.0F;
                     f4 = 1.0F + f4 * 4.0F;
                  }

                  float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
                  if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
                     f5 /= 2.0F;
                  }

                  f += f4 * f5;
                  f1 += f3 * f5;
                  f2 += f5;
               }
            }

            f /= f2;
            f1 /= f2;
            f = f * 0.9F + 0.1F;
            f1 = (f1 * 4.0F - 1.0F) / 8.0F;
            double d12 = this.field_147426_g[i1] / 8000.0D;
            if (d12 < 0.0D) {
               d12 = -d12 * 0.3D;
            }

            d12 = d12 * 3.0D - 2.0D;
            if (d12 < 0.0D) {
               d12 /= 2.0D;
               if (d12 < -1.0D) {
                  d12 = -1.0D;
               }

               d12 /= 1.4D;
               d12 /= 2.0D;
            } else {
               if (d12 > 1.0D) {
                  d12 = 1.0D;
               }

               d12 /= 8.0D;
            }

            ++i1;
            double d13 = (double)f1;
            double d14 = (double)f;
            d13 += d12 * 0.2D;
            d13 = d13 * 8.5D / 8.0D;
            double d5 = 8.5D + d13 * 4.0D;

            for(int j2 = 0; j2 < 33; ++j2) {
               double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
               if (d6 < 0.0D) {
                  d6 *= 4.0D;
               }

               double d7 = this.field_147428_e[l] / 512.0D;
               double d8 = this.field_147425_f[l] / 512.0D;
               double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
               double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
               if (j2 > 29) {
                  double d11 = (double)((float)(j2 - 29) / 3.0F);
                  d10 = d10 * (1.0D - d11) + -10.0D * d11;
               }

               this.field_147434_q[l] = d10;
               ++l;
            }
         }
      }

   }

   public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      BlockFalling.fallInstantly = true;
      int k = p_73153_2_ * 16;
      int l = p_73153_3_ * 16;
      BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
      this.rand.setSeed(this.worldObj.getSeed());
      long i1 = this.rand.nextLong() / 2L * 2L + 1L;
      long j1 = this.rand.nextLong() / 2L * 2L + 1L;
      this.rand.setSeed((long)p_73153_2_ * i1 + (long)p_73153_3_ * j1 ^ this.worldObj.getSeed());
      boolean flag = false;
      int x;
      int z;
      int k1;
      if (this.rand.nextInt(2) == 1) {
         x = k + this.rand.nextInt(16);
         z = l + this.rand.nextInt(16);
         k1 = this.worldObj.getTopSolidOrLiquidBlock(x, z);
         if ((this.worldObj.getBlock(x, k1, z) == KMOD_Main.KetherGrass || this.worldObj.getBlock(x, k1 - 1, z) == KMOD_Main.KetherGrass) && this.worldObj.getBlock(x, k1 + 5, z) == Blocks.air) {
            if (this.rand.nextInt(200) == 27) {
               (new KetherGenLonsdaleiteTree(true)).generate(this.worldObj, this.rand, x, k1, z);
            } else {
               ((WorldGenerator)this.trees.get(this.rand.nextInt(this.trees.size()))).generate(this.worldObj, this.rand, x, k1, z);
            }
         }
      }

      x = k + this.rand.nextInt(16);
      z = l + this.rand.nextInt(16);
      k1 = this.worldObj.getTopSolidOrLiquidBlock(x, z);
      if (this.worldObj.getBlock(x, k1 - 1, z) == KMOD_Main.KetherGrass) {
         ((WorldGenerator)this.flowers.get(this.rand.nextInt(this.flowers.size()))).generate(this.worldObj, this.rand, x, k1, z);
      }

      x = k + this.rand.nextInt(16);
      z = l + this.rand.nextInt(16);
      k1 = this.worldObj.getTopSolidOrLiquidBlock(x, z);
      if (this.worldObj.getBlock(x, k1 - 1, z) == KMOD_Main.KetherGrass) {
         (new KetherGenTallGrass()).generate(this.worldObj, this.rand, x, k1, z);
      }

      if (this.rand.nextInt(2) == 1) {
         x = k + this.rand.nextInt(16);
         z = l + this.rand.nextInt(16);
         k1 = this.rand.nextInt(200);
         if (this.worldObj.isAirBlock(x, k1, z) && this.worldObj.isAirBlock(x, k1 + 5, z) && this.worldObj.isAirBlock(x, k1 - 5, z) && this.worldObj.isAirBlock(x + 5, k1, z) && this.worldObj.isAirBlock(x - 5, k1, z) && this.worldObj.isAirBlock(x, k1, z + 5) && this.worldObj.isAirBlock(x, k1, z - 5) && this.worldObj.isAirBlock(x + 5, k1, z + 5) && this.worldObj.isAirBlock(x + 5, k1, z - 5) && this.worldObj.isAirBlock(x - 5, k1, z - 5) && this.worldObj.isAirBlock(x - 5, k1, z + 5)) {
            (new KetherGenClouds()).generate(this.worldObj, this.rand, x, k1, z);
         }
      }

      if (this.rand.nextInt(50) == 7) {
         x = k + this.rand.nextInt(16);
         z = l + this.rand.nextInt(16);
         k1 = this.worldObj.getTopSolidOrLiquidBlock(x, z);
         if (this.worldObj.getBlock(x, k1, z) == KMOD_Main.KetherGrass || this.worldObj.getBlock(x, k1 + 1, z) == KMOD_Main.KetherGrass) {
            (new KetherGenMovingSands(KMOD_Main.MovingSands)).generate(this.worldObj, this.rand, x, k1, z);
         }
      }

      MinecraftForge.EVENT_BUS.post(new Pre(p_73153_1_, this.worldObj, this.rand, p_73153_2_, p_73153_3_, flag));
      if (!this.treegenerated) {
         int iii = 0;
         int jjj = 175;
         int kkk = 0;
         (new KetherGenLifeTree()).generate(this.worldObj, this.rand, iii, jjj, kkk);
         this.treegenerated = true;
      }

      boolean doGen = TerrainGen.populate(p_73153_1_, this.worldObj, this.rand, p_73153_2_, p_73153_3_, flag, EventType.DUNGEON);

      for(k1 = 0; doGen && k1 < 1; ++k1) {
      }

      if (TerrainGen.populate(p_73153_1_, this.worldObj, this.rand, p_73153_2_, p_73153_3_, flag, EventType.ANIMALS)) {
         SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
      }

      k += 8;
      l += 8;
      doGen = TerrainGen.populate(p_73153_1_, this.worldObj, this.rand, p_73153_2_, p_73153_3_, flag, EventType.ICE);

      for(k1 = 0; doGen && k1 < 16; ++k1) {
         for(int l1 = 0; l1 < 16; ++l1) {
            int i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);
            if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l)) {
               this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice, 0, 2);
            }

            if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true)) {
               this.worldObj.setBlock(k1 + k, i2, l1 + l, Blocks.snow_layer, 0, 2);
            }
         }
      }

      MinecraftForge.EVENT_BUS.post(new Post(p_73153_1_, this.worldObj, this.rand, p_73153_2_, p_73153_3_, flag));
      BlockFalling.fallInstantly = false;
   }

   public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public void saveExtraData() {
   }

   public boolean unloadQueuedChunks() {
      return false;
   }

   public boolean canSave() {
      return true;
   }

   public String makeString() {
      return "RandomLevelSource";
   }

   public int getLoadedChunkCount() {
      return 0;
   }

   public void recreateStructures(int p_82695_1_, int p_82695_2_) {
      if (this.mapFeaturesEnabled) {
      }

   }

   public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      return null;
   }

   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
      return null;
   }
}
