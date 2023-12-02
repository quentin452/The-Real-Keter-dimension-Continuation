package com.KMOD.Events;

import com.KMOD.Container.ContainerEnergyConverter;
import com.KMOD.Container.ContainerEnergyEnchanter;
import com.KMOD.Container.ContainerGiftsBlock;
import com.KMOD.Gui.GuiEnergyConverter;
import com.KMOD.Gui.GuiEnergyEnchanter;
import com.KMOD.Gui.GuiGiftsBlock;
import com.KMOD.TileEntities.TileEntityEnergyConverter;
import com.KMOD.TileEntities.TileEntityEnergyEnchanter;
import com.KMOD.TileEntities.TileEntityGiftsBlock;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EventGuiHandler implements IGuiHandler {
   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      TileEntity tile_entity = world.getTileEntity(x, y, z);
      switch(id) {
      case 0:
         return new ContainerEnergyConverter(player.inventory, (TileEntityEnergyConverter)tile_entity);
      case 1:
         return new ContainerGiftsBlock(player.inventory, (TileEntityGiftsBlock)tile_entity);
      case 2:
         return new ContainerEnergyEnchanter(player.inventory, (TileEntityEnergyEnchanter)tile_entity);
      default:
         return null;
      }
   }

   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
      TileEntity tile_entity = world.getTileEntity(x, y, z);
      switch(id) {
      case 0:
         return new GuiEnergyConverter(player.inventory, (TileEntityEnergyConverter)tile_entity);
      case 1:
         return new GuiGiftsBlock(player.inventory, (TileEntityGiftsBlock)tile_entity);
      case 2:
         return new GuiEnergyEnchanter(player.inventory, (TileEntityEnergyEnchanter)tile_entity);
      default:
         return null;
      }
   }
}
