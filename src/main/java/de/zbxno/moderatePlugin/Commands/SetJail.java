package de.zbxno.moderatePlugin.Commands;

import de.zbxno.moderatePlugin.ModeratePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetJail implements CommandExecutor {
    String prefix = ModeratePlugin.prefix;
    public static Location jailPos;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(args.length == 0)) {
                String subcommand = args[0].toLowerCase();
                if (subcommand.equals("set")){
                    Location jail = p.getLocation();
                    jailPos = jail;
                    p.sendMessage(prefix + "Jail Position set!");
                }else if (subcommand.equals("reset")){
                    jailPos = null;
                    p.sendMessage(prefix + "saved Jail postion resetted!");
                }else {
                    p.sendMessage(prefix + "unkown subcommand!");
                }
            }else {
                p.sendMessage(prefix + ChatColor.RED + "Use: /jailPos <set|reset>");

            }


        }else {
            sender.sendMessage(prefix + "only players can use this command!");
        }

        return false;
    }
}
