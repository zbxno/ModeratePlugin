package de.zbxno.moderatePlugin;

import de.zbxno.moderatePlugin.Actions.Freeze.FreezeActionOn;

import de.zbxno.moderatePlugin.Actions.Mute.MuteActionOn;
import de.zbxno.moderatePlugin.Actions.SocialAction;
import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.Commands.SetJail;
import de.zbxno.moderatePlugin.Commands.SetSpawn;
import de.zbxno.moderatePlugin.Commands.SpawnCommand;
import de.zbxno.moderatePlugin.Listeners.JoinListener;
import de.zbxno.moderatePlugin.Listeners.ModerateActions;
import de.zbxno.moderatePlugin.util.GuiActionRegistry;
import de.zbxno.moderatePlugin.util.ManageGUI;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModeratePlugin extends JavaPlugin {

    public static ManageGUI gui;
    @Override
    public void onEnable() {

        gui = new ManageGUI();

        GuiActionRegistry.register();

        getLogger().info("ModeratePlugin activated");

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new ModerateActions(), this);
        getServer().getPluginManager().registerEvents(new FreezeActionOn(), this);
        getServer().getPluginManager().registerEvents(new MuteActionOn(), this);
        getServer().getPluginManager().registerEvents(new SocialAction(), this);

        this.getCommand("moderate").setExecutor(new ModerateCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setjail").setExecutor(new SetJail());
        this.getCommand("setspawn").setExecutor(new SetSpawn());


    }


    @Override
    public void onDisable() {

    }


    public static String prefix = ChatColor.WHITE +   " [" + ChatColor.AQUA + ChatColor.BOLD + "MP" + ChatColor.WHITE + "] " + ChatColor.GRAY+ "- " + ChatColor.RESET;


}


