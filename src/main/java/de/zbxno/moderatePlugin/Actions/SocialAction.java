package de.zbxno.moderatePlugin.Actions;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.*;


public class SocialAction implements GuiAction, Listener {

    private static final int MAX_MESSAGES = 10000;
    private final Map<UUID, LinkedList<String>> chatLog = new HashMap<>();
    private final String prefix = ModeratePlugin.prefix;



    @Override
    public void execute(CommandSender sender, Player target) {
        sender.sendMessage(prefix + ChatColor.RED + "currentyl disabled");
        /*
        List<String> messages = chatLog.containsKey(target.getUniqueId())
                ? chatLog.get(target.getUniqueId())
                : Collections.emptyList();

        if (messages.isEmpty()) {
            sender.sendMessage(prefix + ChatColor.RED + "No saved messages from the player!");
            return;
        }

        sender.sendMessage(prefix + ChatColor.AQUA + "----- Chat Log for " + target.getName() + " -----");
        for (String msg : messages) {
            sender.sendMessage(prefix + msg);
        }

        */
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        String message = e.getMessage();

        chatLog.computeIfAbsent(uuid, k -> new LinkedList<>());
        LinkedList<String> messages = chatLog.get(uuid);

        if (messages.size() >= MAX_MESSAGES) {
            messages.removeFirst(); // Remove oldest
        }

        messages.addLast(message);


        Bukkit.getLogger().info("[Debug] Stored chat from " + player.getName() + ": " + message);
    }
}