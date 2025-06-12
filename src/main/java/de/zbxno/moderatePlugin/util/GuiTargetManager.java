package de.zbxno.moderatePlugin.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuiTargetManager {
    private static final Map<UUID, Player> targets = new HashMap<>();

    public static void setTarget(Player moderator, Player target) {

        targets.put(moderator.getUniqueId(), target.getPlayer());
    }

    public static Player getTarget(Player moderator) {
        return targets.get(moderator.getUniqueId());
    }

    public static void removeTarget(Player moderator) {
        targets.remove(moderator.getUniqueId());
    }
}

