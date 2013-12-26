package me.creepercoders.FreedomOpMod;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class FreedomOpMod extends JavaPlugin
{
  public static final Logger log = Bukkit.getLogger();
  
  //
  public static Main plugin = null;
  public static Server server = Bukkit.getServer();
  public static String pluginName;
  public static String pluginVersion;
  public static String pluginAuthors;
  //
  public static final String noPermission = ChatColor.RED + "You don't have permission!";
  public static final String notFromConsole = "This command may not be used from the console.";
  public static final String playerIsOpped = ChatColor.YELLOW + "You are now op!";
  public static final String playerIsNotOpped = ChatColor.YELLOW + "You are no longer op!";
  //
  
  @Override
  public void onEnable()
  {
    this.plugin = this;
    this.pluginName = plugin.getDescription().getName();
    this.pluginVersion = plugin.getDescription().getVersion();
    
    log.info(pluginName + " v" + pluginVersion + " by buildcarter8,Paldiu,wild1145 and darthsalamon has been enabled!");
  }
  
  @Override
  public void onDisable()
  {
    log.info(pluginName + " has been disabled.");
  }
}
