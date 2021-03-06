package me.TMAC_Kratos.InfiniteChests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.block.Sign;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InfiniteChestsPlayerListener
implements Listener
{
	private final InfiniteChests plugin;
	private final InfiniteChestsConfiguration Config;

	public InfiniteChestsPlayerListener(InfiniteChests plugin, InfiniteChestsConfiguration configs)
	{
		this.plugin = plugin;
		this.Config = configs;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block block = event.getClickedBlock();
			if (block.getType().name().contains("CHEST") && block.getType() != Material.ENDER_CHEST || block.getType() == Material.DISPENSER || block.getType() == Material.DROPPER || block.getType() == Material.FURNACE)
			{
				World world = event.getPlayer().getWorld();
				Location loc = event.getClickedBlock().getLocation();
				loc.setY(loc.getY() + 1.0D);
				Block signBlock = world.getBlockAt(loc);
				if ((signBlock.getType() == Material.WALL_SIGN) && (this.plugin.Config.getAllowedWorlds().contains(world.getName())))
				{
					Sign sign = (Sign)signBlock.getState();
					if ((sign.getLine(0).equalsIgnoreCase("[infiniteChest]")) || 
							(sign.getLine(0).equalsIgnoreCase("[infchest]")) || 
							(sign.getLine(0).equalsIgnoreCase("[ic]")) ||
							(sign.getLine(0).equalsIgnoreCase(ChatColor.BLUE+"[infchest]")) ||
							(sign.getLine(0).equalsIgnoreCase(ChatColor.BLUE+"[ic]")))
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
						if (mat == null) mat = Material.AIR;
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
							if (block.getType().name().contains("CHEST") && block.getType() != Material.ENDER_CHEST || block.getType() == Material.DISPENSER || block.getType() == Material.DROPPER) {
								List<Block> chests = new LinkedList<Block>();
								chests.add(world.getBlockAt(event.getClickedBlock().getLocation()));
								if (event.getClickedBlock().getRelative(BlockFace.SOUTH).getType().equals(event.getClickedBlock().getType())) {
									chests.add(event.getClickedBlock().getRelative(BlockFace.SOUTH));
								}
								if (event.getClickedBlock().getRelative(BlockFace.EAST).getType().equals(event.getClickedBlock().getType())) {
									chests.add(event.getClickedBlock().getRelative(BlockFace.EAST));
								}
								if (event.getClickedBlock().getRelative(BlockFace.WEST).getType().equals(event.getClickedBlock().getType())) {
									chests.add(event.getClickedBlock().getRelative(BlockFace.WEST));
								}
								if (event.getClickedBlock().getRelative(BlockFace.NORTH).getType().equals(event.getClickedBlock().getType())) {
									chests.add(event.getClickedBlock().getRelative(BlockFace.NORTH));
								}
								for (Iterator<Block> iterator = chests.iterator(); iterator.hasNext();)
								{
									if (block.getType().name().contains("CHEST") && block.getType() != Material.ENDER_CHEST || block.getType() == Material.DISPENSER || block.getType() == Material.DROPPER)
									{
										InventoryHolder chest = (InventoryHolder)iterator.next().getState();
										try
										{
											if (chest != null)
											{
												Inventory inv = chest.getInventory();
												inv.clear();
												if (mat != Material.AIR) {
													ItemStack stack;
													for (; (inv.firstEmpty() != -1) || (inv.firstEmpty() != 0); inv.setItem(inv.firstEmpty(), stack))
													{
														stack = new ItemStack(mat, amount,(byte)meta);

														inv.setItem(inv.firstEmpty(), stack);
													}

													iterator.next().getState().update();
												}
											}
										}
										catch (Exception localException) {}
									}

								}
							} else if (block.getType() == Material.FURNACE)
							{
								if (mat.name().contains("COAL") || mat== Material.LAVA_BUCKET || mat == Material.LOG || mat.name().contains("WOOD") && mat != Material.WOOD_DOOR || mat.name().contains("SAPLING") || mat.name().contains("CHEST") && mat != Material.ENDER_CHEST || mat == Material.TRAP_DOOR || mat == Material.BOOKSHELF || mat == Material.STICK)
								{
									Furnace furnace = (Furnace)event.getClickedBlock().getState();
									FurnaceInventory inv = furnace.getInventory();
									ItemStack stack = new ItemStack(mat.getId(), amount, (byte)meta);
									inv.setFuel(stack);  
								}
								else
								{
									if (mat == null || mat == Material.AIR)
									{
										event.getClickedBlock().getRelative(BlockFace.UP).setType(Material.AIR);
										world.dropItemNaturally(loc, new ItemStack(Material.SIGN, 1));
										event.getPlayer().sendMessage(ChatColor.DARK_RED+"Dumpster Mode Is Not Compatible With The Furnace!");
										event.setUseInteractedBlock(Result.DENY);
										event.setUseItemInHand(Result.DENY);
										return;
									}
									else
									{
										event.getClickedBlock().getRelative(BlockFace.UP).setType(Material.AIR);
										world.dropItemNaturally(loc, new ItemStack(Material.SIGN, 1));
										event.getPlayer().sendMessage(ChatColor.DARK_RED+"Invalid Fuel Type!");
										event.setUseInteractedBlock(Result.DENY);
										event.setUseItemInHand(Result.DENY);
										return;
									}
								}
							}
							else
							{
								event.getClickedBlock().getRelative(BlockFace.UP).setType(Material.AIR);
								world.dropItemNaturally(loc, new ItemStack(Material.SIGN, 1));
								event.getPlayer().sendMessage(ChatColor.DARK_RED+"Can Not Find A Valid Container!");
								event.setUseInteractedBlock(Result.DENY);
								event.setUseItemInHand(Result.DENY);
								return; 
							}
						}
					}
				}
			}
		}
	}
}