package de.zbxno.moderatePlugin.Commands;

import de.zbxno.moderatePlugin.ModeratePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetSpawn implements CommandExecutor {
    String prefix = ModeratePlugin.prefix;
    public static Location spawnPos;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(args.length == 0)) {

                String subcommand = args[0].toLowerCase();

                if (subcommand.equals("set")){
                    Location jail = p.getLocation();
                    spawnPos = jail;
                    p.sendMessage(prefix + "Spawn Position set!");
                }else if (subcommand.equals("reset")){
                    spawnPos = null;
                    p.sendMessage(prefix + "saved Spawn postion resetted!");
                }else {
                    p.sendMessage(prefix + "unkown subcommand!");
                }
            }else {
                p.sendMessage(prefix + ChatColor.RED + "Use: /setspawn <set|reset>");

            }


        }else {
            sender.sendMessage(prefix + "only players can use this command!");
        }

        return false;
    }
}
