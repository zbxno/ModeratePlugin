package de.zbxno.moderatePlugin.Actions.Jail;


import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.util.GuiAction;
import de.zbxno.moderatePlugin.util.GuiTargetManager;
import de.zbxno.moderatePlugin.util.ManageGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class JailAction implements GuiAction {
    public static final Set<UUID> jailedPlayers = new HashSet<>();

    @Override
    public void execute(CommandSender sender, Player target){
        Player moderator = (Player) sender;
        if (sender instanceof Player playerSender) {
            Inventory JailInv = new ManageGUI().getJailInv();
            playerSender.openInventory(JailInv);
            ModerateCommand.PlayerWithJailInv.addPlayer(playerSender);
            GuiTargetManager.setTarget(moderator, target);
        }
    }
}
