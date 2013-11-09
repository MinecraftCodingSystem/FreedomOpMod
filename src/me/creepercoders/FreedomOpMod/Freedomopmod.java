package me.creepercoders.FreedomOpMod;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;

import java.util.logging.Logger;

public class Freedomopmod extends JavaPlugin
{
  public static final Logger log = Logger.getLogger("minecraft-server");
  
  //
  public static Main plugin = null;
  public static Server server = Bukkit.getServer();
  public static String pluginName;
  public static String pluginVersion;
  public static String pluginAuthors;
  //
  public static final String noPermission = ChatColor.RED + "You don't have permission!";
  //
  
  @Override
  public void onEnable()
  {
    this.plugin = this;
    this.pluginName = plugin.getDescription().getName();
    this.pluginVersion = plugin.getDescription().getVersion();
    this.pluginAuthors = plugin.getDescription().getAuthors();
    
    log.info(pluginName + " v" + pluginVersion + " by [" + pluginAuthors + "] has been enabled!");
  }
  
  @Override
  public void onDisable()
  {
    log.info(pluginName + " has been disabled.");
  }
}
