package me.TMAC_Kratos.InfiniteChests;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Directional;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class InfiniteChestsBlockListener
  implements Listener
{
  private final InfiniteChests plugin;
  private final InfiniteChestsConfiguration Config;
  
  public InfiniteChestsBlockListener(InfiniteChests plugin, InfiniteChestsConfiguration configs)
  {
    this.plugin = plugin;
    this.Config = configs;
  }
  @EventHandler
  public void onBlockDispense(BlockDispenseEvent event)
  {
    Block block = event.getBlock();
    if (this.plugin.Config.getAllowedWorlds().contains(block.getWorld().getName()))
    {
      World world = block.getWorld();
      Location loc = block.getLocation();
      loc.setY(loc.getY() + 1.0D);
      Block signBlock = world.getBlockAt(loc);
    	  Directional data = (Directional)event.getBlock().getState().getData();
      BlockFace face = data.getFacing().getOppositeFace();
      Block blockfacehigh = event.getBlock().getRelative(face);
      Location bfhl = blockfacehigh.getLocation();
      bfhl.setY(bfhl.getY() + 1.0D);
      Block signBlock2 = world.getBlockAt(bfhl);
      if (signBlock2.getType() == Material.WALL_SIGN) {
        signBlock = signBlock2;
      } else if (signBlock.getType() != Material.WALL_SIGN) {
        if ((event.getBlock().getRelative(BlockFace.NORTH).getType() == Material.SIGN) || (event.getBlock().getRelative(BlockFace.NORTH).getType() == Material.WALL_SIGN) || (event.getBlock().getRelative(BlockFace.NORTH).getType() == Material.SIGN_POST)) {
          signBlock = event.getBlock().getRelative(BlockFace.NORTH);
        } else if ((event.getBlock().getRelative(BlockFace.EAST).getType() == Material.SIGN) || (event.getBlock().getRelative(BlockFace.EAST).getType() == Material.WALL_SIGN) || (event.getBlock().getRelative(BlockFace.EAST).getType() == Material.SIGN_POST)) {
          signBlock = event.getBlock().getRelative(BlockFace.EAST);
        } else if ((event.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.SIGN) || (event.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.WALL_SIGN) || (event.getBlock().getRelative(BlockFace.SOUTH).getType() == Material.SIGN_POST)) {
          signBlock = event.getBlock().getRelative(BlockFace.SOUTH);
        } else if ((event.getBlock().getRelative(BlockFace.WEST).getType() == Material.SIGN) || (event.getBlock().getRelative(BlockFace.WEST).getType() == Material.WALL_SIGN) || (event.getBlock().getRelative(BlockFace.WEST).getType() == Material.SIGN_POST)) {
          signBlock = event.getBlock().getRelative(BlockFace.WEST);
        } else {
          return;
        }
      }
      Sign sign = (Sign)signBlock.getState();
      if ((sign.getLine(0).equalsIgnoreCase("[infinitechest]")) || 
        (sign.getLine(0).equalsIgnoreCase("[infchest]")) || 
        (sign.getLine(0).equalsIgnoreCase("[ic]")))
      {
    	  Material mat = null;
          String[] lineargs = (String[])null;
          String mats = null;
          String metas = null;
          if (sign.getLine(1).contains(":"))
          {
            lineargs = sign.getLine(1).split(":");
            mats = lineargs[0];
            metas = lineargs[1];
          }
          else
          {
          	metas = "0";
            mats = sign.getLine(1);
          }
          try
          {
            if (Integer.parseInt(mats.toUpperCase()) != -1) {
              mat = Material.getMaterial(Integer.parseInt(mats));
            } else {
              mat = Material.getMaterial(mats.toUpperCase());
            }
          }
          catch (NumberFormatException e)
          {
            mat = Material.getMaterial(mats.toUpperCase());
          }
          if (mat != null)
          {
          	int meta = 0;
          	try
              {
                if (Integer.parseInt(metas) != -1) {
                  meta = Integer.parseInt(metas);
                } 
              }
              catch (NumberFormatException e)
              {
              	meta = 0;
              	}
          	int amount = 64;
          	try
              {
                if (Integer.parseInt(sign.getLine(2)) != -1) {
                  amount = Integer.parseInt(sign.getLine(2));
                } 
              }
              catch (NumberFormatException e)
              {
              	amount = 64;
              }
          	if (amount > 64) amount = 64;
        if (mat != null)
        {
        	
          InventoryHolder disp = (InventoryHolder) world.getBlockAt(block.getLocation()).getState();
          if (disp != null)
          {
            for (Inventory inv = disp.getInventory(); inv.firstEmpty() != -1; world.getBlockAt(block.getLocation()).getState().update())
            {
              ItemStack stack;
                stack = new ItemStack(mat.getId(), amount, (byte)meta);
              
              inv.setItem(inv.firstEmpty(), stack);
            }
            return;
          }
          return;
        }
      }
    }
    }
  }
  @EventHandler
  public void onSignChange(SignChangeEvent event)
  {
    if ((event.getLine(0).equalsIgnoreCase("[infinitechest]")) || 
      (event.getLine(0).equalsIgnoreCase("[infchest]")) || 
      (event.getLine(0).equalsIgnoreCase("[ic]")) ||
      (event.getLine(0).equalsIgnoreCase("ChatColor.Blue+[ic]")) ||
      (event.getLine(0).equalsIgnoreCase("ChatColor.Blue+[infchest]")))
    {
      Player player = event.getPlayer();      
        if (!(player.hasPermission("infinitechests.placesign")) && !(player.isOp()))
        {
          Location loc = event.getBlock().getLocation();
          World world = event.getBlock().getWorld();
          event.getBlock().setType(Material.AIR);
          world.dropItemNaturally(loc, new ItemStack(Material.SIGN, 1));
          event.getPlayer().sendMessage("You Don't Have Permisison To Create An InfiniteChest!");
          return;
        }
        Material mat = null;
        String[] lineargs = (String[])null;
        String mats = null;
        String amount = null;
        if (event.getLine(1).contains(":"))
        {
          lineargs = event.getLine(1).split(":");
          mats = lineargs[0];
          amount = lineargs[1];
        }
        else
        {
          amount = "15";
          mats = event.getLine(1);
        }
        try
        {
          if (Integer.parseInt(mats.toUpperCase()) != -1) {
            mat = Material.getMaterial(Integer.parseInt(mats));
          } else {
            mat = Material.getMaterial(mats.toUpperCase());
          }
        }
        catch (NumberFormatException e)
        {
          mat = Material.getMaterial(mats.toUpperCase());
        }
        int num;
        try
        {
          num = Integer.parseInt(amount);
        }
        catch (NumberFormatException e)
        {
          event.getPlayer().sendMessage("Invalid stack amount! example: 64");
          num = -1;
        }
        if (mat == null && !(mats.equalsIgnoreCase("dumpster") || mats.equalsIgnoreCase("bin")))
        {
          event.getPlayer().sendMessage("Invalid Material! example: WOOD:5, Dumpster, or Bin");
          Location loc = event.getBlock().getLocation();
          World world = event.getBlock().getWorld();
          event.getBlock().setType(Material.AIR);
          world.dropItemNaturally(loc, new ItemStack(Material.SIGN, 1));
        } 
        if (event.getLine(0).contains("[inf") && this.plugin.Config.allowcolorcode)
		        {
	        event.setLine(0,"ChatColor.Blue+[infchest]");
		        }
        if (event.getLine(0).equalsIgnoreCase("[ic]") && this.plugin.Config.allowcolorcode)
		        {
	        event.setLine(0, "ChatColor.Blue+[ic]");
		        }
      }
  }
}
