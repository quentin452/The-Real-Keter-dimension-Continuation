package fr.keter.KMOD.WorldGens;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class KetherGenCrystals extends WorldGenerator {
   private Block field_150552_a;

   public KetherGenCrystals(Block p_i45452_1_) {
      this.field_150552_a = p_i45452_1_;
   }

   public void func_150550_a(Block p_150550_1_) {
      this.field_150552_a = p_150550_1_;
   }

   public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      for(int l = 0; l < 64; ++l) {
         int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if (p_76484_1_.isAirBlock(i1, j1, k1) && (!p_76484_1_.provider.hasNoSky || j1 < 255) && this.field_150552_a.canBlockStay(p_76484_1_, i1, j1, k1)) {
            p_76484_1_.setBlock(i1, j1, k1, this.field_150552_a);
         }
      }

      return true;
   }
}
