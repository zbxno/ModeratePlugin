package de.zbxno.moderatePlugin.Listeners;

import de.zbxno.moderatePlugin.ModeratePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class JoinListener implements Listener {

    @EventHandler

    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(ModeratePlugin.prefix +  "Welcome " + ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.RESET +  "!");
    }
}
