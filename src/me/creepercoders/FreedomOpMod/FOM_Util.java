package me.creepercoders.FreedomOpMod;

import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.*;

import java.util.*;
import java.io.*;

public class FOM_Util
{
    protected Freedomopmod plugin;
    protected Server server = Bukkit.getServer();
    private static final List<String> Developers = Arrays.asList("wild1145", "DarthSalamon", "Paldiu");
    
    public static String 
    
    private FOM_Util()
    {
        throw new AssertionError();
    }
    
    public static void bcastMsg(String message, ChatColor color)
    {
        for (Player p : server.getOnlinePlayers())
        {
            p.sendMessage((color == null ? "" : color) + message);
        }
    }
    
    public static void bcastMsg(String message)
    {
        FOM_Util.bcastMsg(message, null);
    }
    
    public static void playerMsg(CommandSender sender, String message, ChatColor color)
    {
        sender.sendMessage(color + message);
    }

    public static void playerMsg(CommandSender sender, String message)
    {
        FOM_Util.playerMsg(sender, message, ChatColor.GRAY);
    }
    
    public static void adminAction(String adminName, String action, boolean red)
    {
        FOM_Util.bcastMsg(adminName + " - " + action + (red ? ChatColor.RED : ChatColor.BLUE));
    }
    
    public static void accessWorld(CommandSender sender, String targetworld)
    {
        if (sender instanceof Player)
        {
            Player sender_p = (Player) sender;

            if (sender_p.getWorld().getName().equalsIgnoreCase(targetworld))
            {
                sender.sendMessage(ChatColor.GRAY + "Going to spawn.");
                sender_p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                return;
            }

            for (World world : Bukkit.getWorlds())
            {
                if (world.getName().equalsIgnoreCase(targetworld))
                {
                    sender.sendMessage(ChatColor.GRAY + "Going to world: " + targetworld);
                    sender_p.teleport(world.getSpawnLocation());
                    return;
                }
            }

            sender.sendMessage(ChatColor.GRAY + "World " + targetworld + " does not exist!");
        }
        else
        {
            sender.sendMessage(plugin.NOT_FROM_CONSOLE);
        }
    }
    
    //Thanks to Madgeek & Darth for the config system!
    public static void createDefaultConfiguration(String name, File plugin_file)
    {
        Freedomopmod fom = Freedomopmod.plugin;

        File actual = new File(fom.getDataFolder(), name);
        if (!actual.exists())
        {
            FOM_Log.info("Installing default configuration file template: " + actual.getPath());
            InputStream input = null;
            try
            {
                JarFile file = new JarFile(plugin_file);
                ZipEntry copy = file.getEntry(name);
                if (copy == null)
                {
                    FOM_Log.severe("Unable to read default configuration: " + actual.getPath());
                    return;
                }
                input = file.getInputStream(copy);
            }
            catch (IOException ioex)
            {
                FOM_Log.severe("Unable to read default configuration: " + actual.getPath());
            }
            if (input != null)
            {
                FileOutputStream output = null;

                try
                {
                    fom.getDataFolder().mkdirs();
                    output = new FileOutputStream(actual);
                    byte[] buf = new byte[8192];
                    int length;
                    while ((length = input.read(buf)) > 0)
                    {
                        output.write(buf, 0, length);
                    }

                    FOM_Log.info("Default configuration file written: " + actual.getPath());
                }
                catch (IOException ioex)
                {
                    FOM_Log.severe("Unable to write default configuration: " + actual.getPath() + "\n" + ExceptionUtils.getStackTrace(ioex));
                }
                finally
                {
                    try
                    {
                        if (input != null)
                        {
                            input.close();
                        }
                    }
                    catch (IOException ioex)
                    {
                    }

                    try
                    {
                        if (output != null)
                        {
                            output.close();
                        }
                    }
                    catch (IOException ioex)
                    {
                    }
                }
            }
        }
    }
    
    @Deprecated
    public static boolean isUserAdmin(CommandSender user)
    {
        return FOM_AdminList.isUserAdmin(user);
    }
}
