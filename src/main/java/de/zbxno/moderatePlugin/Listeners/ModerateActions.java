package de.zbxno.moderatePlugin.Listeners;

import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiActionRegistry;
import de.zbxno.moderatePlugin.util.GuiAction;
import de.zbxno.moderatePlugin.util.GuiTargetManager;
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
        Player moderator = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir() || !clickedItem.hasItemMeta()) return;

        boolean hasOpenGui =
                ModerateCommand.PlayerWithModInv.hasGuiOpen(moderator) ||
                        ModerateCommand.PlayerWithFreezeInv.hasGuiOpen(moderator) ||
                        ModerateCommand.PlayerWithJailInv.hasGuiOpen(moderator) ||
                        ModerateCommand.PlayerWithShowInv.hasGuiOpen(moderator) ||
                        ModerateCommand.PlayerWithMuteInv.hasGuiOpen(moderator);

        if (!hasOpenGui) return;

        e.setCancelled(true);


        Player target = GuiTargetManager.getTarget(moderator);
        if (target == null) {
            moderator.sendMessage("§cFehler: Kein Zielspieler gefunden.");
            return;
        }

        GuiAction action = GuiActionRegistry.getAction(clickedItem);
        if (action != null) {
            action.execute(moderator, target);

        }

    }


    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player moderator = (Player) e.getPlayer();

        if (ModerateCommand.PlayerWithModInv.hasGuiOpen(moderator)){
            ModerateCommand.PlayerWithModInv.removePlayer(moderator);
        }
        if (ModerateCommand.PlayerWithFreezeInv.hasGuiOpen(moderator)){
            ModerateCommand.PlayerWithFreezeInv.removePlayer(moderator);
        }
        if (ModerateCommand.PlayerWithJailInv.hasGuiOpen(moderator)){
            ModerateCommand.PlayerWithJailInv.removePlayer(moderator);
        }
        if (ModerateCommand.PlayerWithShowInv.hasGuiOpen(moderator)){
            ModerateCommand.PlayerWithShowInv.removePlayer(moderator);
            moderator.sendMessage(prefix + "you closed the Inventory!");
        }
        if (ModerateCommand.PlayerWithMuteInv.hasGuiOpen(moderator)){
            ModerateCommand.PlayerWithMuteInv.removePlayer(moderator);
        }
        GuiTargetManager.removeTarget(moderator);
    }

}
