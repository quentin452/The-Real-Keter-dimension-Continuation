package fr.keter.KMOD.Events;

import fr.keter.KMOD.Container.ContainerEnergyConverter;
import fr.keter.KMOD.Container.ContainerEnergyEnchanter;
import fr.keter.KMOD.Container.ContainerGiftsBlock;
import fr.keter.KMOD.Gui.GuiEnergyConverter;
import fr.keter.KMOD.Gui.GuiEnergyEnchanter;
import fr.keter.KMOD.Gui.GuiGiftsBlock;
import fr.keter.KMOD.TileEntities.TileEntityEnergyConverter;
import fr.keter.KMOD.TileEntities.TileEntityEnergyEnchanter;
import fr.keter.KMOD.TileEntities.TileEntityGiftsBlock;
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
