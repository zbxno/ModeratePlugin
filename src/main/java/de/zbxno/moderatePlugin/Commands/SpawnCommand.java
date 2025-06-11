package de.zbxno.moderatePlugin.Commands;

import de.zbxno.moderatePlugin.Actions.Jail.JailAction;
import de.zbxno.moderatePlugin.ModeratePlugin;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SpawnCommand implements CommandExecutor {
    String prefix = ModeratePlugin.prefix;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (!(JailAction.jailedPlayers.contains(p.getUniqueId()))){
                World world = Bukkit.getWorld("world");
                Location spawn = new Location(world, 16215,90,23349 ,180, 0);
                p.teleport(spawn);
                p.sendMessage(prefix + "Teleported to spawn");

            }else {
                p.sendMessage(prefix + ChatColor.RED + "You are currently in Jail! Nice try buddy");
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f,1f);
            }
        }
        return false;
    }
}
