package de.zbxno.moderatePlugin.Actions;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class KickAction implements GuiAction {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target) {
        if (sender instanceof Player playerSender){
           if (target != null && target.isOnline()){
               playerSender.sendMessage(prefix + "The player " + ChatColor.YELLOW + target.getName() +ChatColor.RESET + " has been kicked!");
               playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f,1f);
               target.kickPlayer(ChatColor.RED + "You were kicked! Please read the roles!");
           }
        }
    }
}
