package fr.keter.KMOD.Main;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderLiving;

public class ServerProxy {
   public void registerRenderThings() {
   }

   public int addArmor(String Armor) {
      return RenderingRegistry.addNewArmourRendererPrefix(Armor);
   }

   public void addNamesToClient() {
   }

   public void addNamesToServer() {
      KMOD_Main.clientSide.addNamesToClient();
   }

   public void renderEntity(Class entity, RenderLiving renderLiving) {
   }
}
