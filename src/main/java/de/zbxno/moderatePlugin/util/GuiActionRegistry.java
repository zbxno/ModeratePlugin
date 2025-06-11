package de.zbxno.moderatePlugin.util;

import de.zbxno.moderatePlugin.Actions.*;
import de.zbxno.moderatePlugin.Actions.Freeze.FreezeAction;
import de.zbxno.moderatePlugin.Actions.Freeze.FreezeActionOff;
import de.zbxno.moderatePlugin.Actions.Freeze.FreezeActionOn;
import de.zbxno.moderatePlugin.Actions.Jail.JailAction;
import de.zbxno.moderatePlugin.Actions.Jail.JailActionOff;
import de.zbxno.moderatePlugin.Actions.Jail.JailActionOn;
import de.zbxno.moderatePlugin.Actions.Mute.MuteAction;
import de.zbxno.moderatePlugin.Actions.Mute.MuteActionOff;
import de.zbxno.moderatePlugin.Actions.Mute.MuteActionOn;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class GuiActionRegistry {
    private static final Map<String, GuiAction> actions = new HashMap<>();



    public static void register(){
        actions.put("Warn Player", new WarnAction());
        actions.put("Show Inventory", new InventoryAction());
        actions.put("Kick Player", new KickAction());
        actions.put("Send Jail", new JailAction());
        actions.put("Mute Player", new MuteAction());
        actions.put("Freeze Player", new FreezeAction());
        actions.put("Ban Player", new BanAction());
        actions.put("unFreeze", new FreezeActionOff());
        actions.put("Freeze", new FreezeActionOn());
        actions.put("Social Spy", new SocialAction());
        actions.put("Jail", new JailActionOn());
        actions.put("unJail", new JailActionOff());
        actions.put("Mute", new MuteActionOn());
        actions.put("unMute", new MuteActionOff());


    }
    public static GuiAction getAction(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return null;

        String displayName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        return actions.get(displayName);
    }


    public static void registerAction(String displayName, GuiAction action) {
        actions.put(displayName, action);
    }
}
