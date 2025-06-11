package de.zbxno.moderatePlugin.Actions.Freeze;


import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.util.GuiAction;
import de.zbxno.moderatePlugin.util.ManageGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FreezeAction implements GuiAction, Listener {

    public static final Set<UUID> frozenPlayers = new HashSet<>();

    @Override
    public void execute(CommandSender sender, Player target){
        Inventory freezeInv = new ManageGUI().getFreezeInv();
        if (sender instanceof Player playerSenderFreeze){
            playerSenderFreeze.openInventory(freezeInv);
            ModerateCommand.PlayerWithFreezeInv.addPlayer(playerSenderFreeze);
        }
    }

}
