package com.KMOD.Main;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

public class ClientProxy extends ServerProxy {
   public static RenderManager rm;

   @SideOnly(Side.CLIENT)
   public void registerRenderThings() {
      KMOD_Main_Entities.addRendereres();
   }

   public void addNamesToClient() {
   }

   public void renderEntity(Class entity, RenderLiving renderLiving) {
      RenderingRegistry.registerEntityRenderingHandler(entity, renderLiving);
   }

   public int addArmor(String Armor) {
      return RenderingRegistry.addNewArmourRendererPrefix(Armor);
   }
}
