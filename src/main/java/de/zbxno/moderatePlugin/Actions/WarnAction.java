package de.zbxno.moderatePlugin.Actions;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnAction implements GuiAction {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target){
        if (sender instanceof Player playerSender) {
            target.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You have been warned", ChatColor.RED + "please be carefull", 10,70,20);
            target.playSound(target.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1f, 1f);
            playerSender.sendMessage(prefix + "You warned " +ChatColor.YELLOW +  target.getName());
        }
    }
}
