package de.zbxno.moderatePlugin.Listeners;

import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiActionRegistry;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class ModerateActions implements Listener {

    String prefix = ModeratePlugin.prefix;

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir() || !clickedItem.hasItemMeta()) return;

        boolean hasOpenGui =
                ModerateCommand.PlayerWithModInv.hasGuiOpen(p) ||
                        ModerateCommand.PlayerWithFreezeInv.hasGuiOpen(p) ||
                        ModerateCommand.PlayerWithJailInv.hasGuiOpen(p) ||
                        ModerateCommand.PlayerWithShowInv.hasGuiOpen(p) ||
                        ModerateCommand.PlayerWithMuteInv.hasGuiOpen(p);

        if (!hasOpenGui) return;

        e.setCancelled(true);

        GuiAction action = GuiActionRegistry.getAction(clickedItem);
        if (action != null) {
            action.execute(p, p);
        }
    }



    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if (ModerateCommand.PlayerWithModInv.hasGuiOpen(p)){
            ModerateCommand.PlayerWithModInv.removePlayer(p);
        }
        if (ModerateCommand.PlayerWithFreezeInv.hasGuiOpen(p)){
            ModerateCommand.PlayerWithFreezeInv.removePlayer(p);
        }
        if (ModerateCommand.PlayerWithJailInv.hasGuiOpen(p)){
            ModerateCommand.PlayerWithJailInv.removePlayer(p);
        }
        if (ModerateCommand.PlayerWithShowInv.hasGuiOpen(p)){
            ModerateCommand.PlayerWithShowInv.removePlayer(p);
            p.sendMessage(prefix + "you closed the Inventory!");
        }
        if (ModerateCommand.PlayerWithMuteInv.hasGuiOpen(p)){
            ModerateCommand.PlayerWithMuteInv.removePlayer(p);
        }
    }
}
