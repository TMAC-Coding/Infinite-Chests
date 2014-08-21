package me.TMAC_Kratos.InfiniteChests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;

public class InfiniteChestsConfiguration
{
  private File pluginfolder;
  private File pluginconfig;
  private StackableLogger log;
  private List<String> allowedWorlds;
  boolean allowcolorcode;
  private InfiniteChests plugin;
  
  public InfiniteChestsConfiguration(InfiniteChests plugin)
  {
    this.log = new StackableLogger("InfiniteChests");
    this.plugin = plugin;
  }
  
 
  public void CreateConfiguration()
  {
	  plugin.saveDefaultConfig();
	    List<String> worlds = new ArrayList<String>();
	    World world;
	    for (Iterator<?> iterator = Bukkit.getWorlds().iterator(); iterator.hasNext(); worlds.add(world.getName())) {
	      world = (World)iterator.next();
	    }
	    plugin.getConfig().set("AllowedWorlds", worlds);
	    plugin.getConfig().set("Use-Color-Code", false);
	    plugin.saveConfig();
	    LoadConfiguration();
  }
  
  public boolean LoadConfiguration()
  {
	this.allowcolorcode = plugin.getConfig().getBoolean("Use-Color-Code");
    this.allowedWorlds = plugin.getConfig().getStringList("AllowedWorlds");
    this.log.info("Count: " + this.allowedWorlds.size());
    return true;
  }
  
  public File getPluginFolder()
  {
    return this.pluginfolder;
  }
  
  public File getConfigFile()
  {
    return this.pluginconfig;
  }
  
  public List<String> getAllowedWorlds()
  {
    return this.allowedWorlds;
  }
  
  public boolean AddAllowedWorld(String name)
  {
    return this.allowedWorlds.add(name);
  }
  
}
