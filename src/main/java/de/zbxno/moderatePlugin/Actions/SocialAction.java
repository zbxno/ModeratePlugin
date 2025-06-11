package de.zbxno.moderatePlugin.Actions;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.*;

public class SocialAction implements GuiAction, Listener {
    String prefix = ModeratePlugin.prefix;


    @Override
    public void execute(CommandSender sender, Player target){
        sender.sendMessage(prefix+ ChatColor.RED +  "This Action is currently disabled!");
    }
}
