package de.zbxno.moderatePlugin.Actions.Freeze;

import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeActionOn implements GuiAction, Listener {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target){

        if (sender instanceof Player playerSender) {
            if (!(FreezeAction.frozenPlayers.contains(target.getUniqueId()))){
                playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                playerSender.sendMessage(prefix + "You froze the player " + ChatColor.YELLOW + target.getName());
                target.sendTitle(ChatColor.AQUA + "" + ChatColor.BOLD + "You have been iced!", ChatColor.AQUA + "Be carefull where you go!", 20, 80, 40);
                target.playSound(target.getLocation(), Sound.ENTITY_STRAY_AMBIENT, 1.f, 1.f);
                FreezeAction.frozenPlayers.add(target.getUniqueId());
            }else {
                playerSender.sendMessage(prefix + "Player alreay frozen!");
                playerSender.playSound(playerSender.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }

        }


    }

    @EventHandler

    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (e.getFrom().getBlockX() == e.getTo().getBlockX() &&
                e.getFrom().getBlockY() == e.getTo().getBlockY() &&
                e.getFrom().getBlockZ() == e.getTo().getBlockZ()) {
            return;
        }
        if (FreezeAction.frozenPlayers.contains(p.getUniqueId())){
            e.setCancelled(true);
        }
    }
}
