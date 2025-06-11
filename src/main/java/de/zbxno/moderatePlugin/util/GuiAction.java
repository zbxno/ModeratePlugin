package de.zbxno.moderatePlugin.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface GuiAction {
        void execute(CommandSender sender, Player target);
}


