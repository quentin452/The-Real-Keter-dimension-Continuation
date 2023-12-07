package fr.keter.KMOD.Main;

import net.minecraft.client.renderer.entity.RenderLiving;

public class ServerProxy {
   public void registerRenderThings() {
   }

   public int addArmor(String Armor) {
       return 0;
   }

   public void addNamesToClient() {
   }

   public void addNamesToServer() {
      KMOD_Main.clientSide.addNamesToClient();
   }

   public void renderEntity(Class entity, RenderLiving renderLiving) {
   }
}
