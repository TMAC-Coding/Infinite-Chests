package me.TMAC_Kratos.InfiniteChests;

import java.io.File;
import java.io.PrintStream;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteChests
  extends JavaPlugin
{
  private InfiniteChestsBlockListener blockListener;
  private InfiniteChestsPlayerListener playerListener;
  public InfiniteChestsConfiguration Config;
  public StackableLogger log;
  public PluginManager pm;
  
  public InfiniteChests()
  {
    this.log = new StackableLogger("InfiniteChests");
  }
  
  public void onDisable() {}
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.log.info("Loading " + pdfFile.getName() + "...");
    LoadConfiguration();
    this.blockListener = new InfiniteChestsBlockListener(this, this.Config);
    this.playerListener = new InfiniteChestsPlayerListener(this, this.Config);
    this.pm = getServer().getPluginManager();
    this.pm.registerEvents(blockListener,this);
    this.pm.registerEvents(playerListener,this);
    System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
  }
  
 
  public void LoadConfiguration()
  {
    this.Config = new InfiniteChestsConfiguration(this);
    if (!new File(getDataFolder().toString()).exists())
    {
      
        this.Config.CreateConfiguration();
        this.log.info("New Configuration file created. All worlds are allowed to use InfiniteChests.");
        this.log.info("You can of course change that in the config.yml file in the plugins folder!");
      
    }
    else {
    	this.Config.LoadConfiguration();
    }
  }
}
