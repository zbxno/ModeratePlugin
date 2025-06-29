package de.zbxno.moderatePlugin.Actions;




import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class InventoryAction implements GuiAction, Listener {
    String prefix = ModeratePlugin.prefix;

    @Override
    public void execute(CommandSender sender, Player target) {
        Player senderPlayer = (Player) sender;
        Inventory targetInv = Bukkit.createInventory(null, 45, target.getName()  +  "'s Inventory");
        targetInv.setContents(target.getInventory().getContents());

        ItemStack[] armor = target.getInventory().getArmorContents();
        for (int i = 0; i < armor.length; i++) {
            targetInv.setItem(36 + i, armor[i]);
        }

        senderPlayer.openInventory(targetInv);
        ModerateCommand.PlayerWithShowInv.addPlayer(senderPlayer);
        senderPlayer.sendMessage(prefix + "You opened " + ChatColor.YELLOW + target.getName() + ChatColor.RESET +  "'s inventory");
        senderPlayer.playSound(senderPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f,1f);
    }


}