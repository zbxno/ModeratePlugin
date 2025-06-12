package de.zbxno.moderatePlugin.Actions.Freeze;

import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FreezeActionOff implements GuiAction, Listener {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target){
        if (sender instanceof Player playerSender){
            if (FreezeAction.frozenPlayers.contains(target.getUniqueId())){
                FreezeAction.frozenPlayers.remove(target.getUniqueId());
                playerSender.sendMessage(prefix + ChatColor.WHITE + "You unfroze " + ChatColor.GOLD + target.getName() + ChatColor.WHITE + ". He can finally move!");
                playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                target.sendMessage(prefix + ChatColor.WHITE + "You have been unfrozen by " + ChatColor.GOLD + sender.getName() + ChatColor.WHITE + ". Go wild!");
                target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }else {
                playerSender.sendMessage(prefix + ChatColor.GOLD + target.getName() + ChatColor.WHITE + " is not frozen.");
                playerSender.playSound(playerSender.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        }
    }
}
