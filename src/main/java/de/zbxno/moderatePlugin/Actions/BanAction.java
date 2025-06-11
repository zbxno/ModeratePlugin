package de.zbxno.moderatePlugin.Actions;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BanAction implements GuiAction, Listener {

    private final String prefix = ModeratePlugin.prefix;


    @Override
    public void execute(CommandSender sender, Player target) {
        if (sender instanceof Player playerSender) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Banned by " + sender.getName(), null, sender.getName());
            target.kickPlayer("You have been banned!");

            playerSender.sendMessage(prefix +  "Player " + ChatColor.YELLOW + target.getName() +  " has been banned.");
            playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1f);
        }
    }
}
