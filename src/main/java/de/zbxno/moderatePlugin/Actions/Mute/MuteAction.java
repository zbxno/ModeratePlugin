package de.zbxno.moderatePlugin.Actions.Mute;


import de.zbxno.moderatePlugin.Commands.ModerateCommand;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import de.zbxno.moderatePlugin.util.GuiTargetManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MuteAction implements GuiAction {
    public static final Set<UUID> mutePlayers = new HashSet<>();
    @Override
    public void execute(CommandSender sender, Player target){
        Player moderator = (Player) sender;
        if (sender instanceof Player playerSender){
            Inventory muteInv = ModeratePlugin.gui.getMuteInv();
            playerSender.openInventory(muteInv);
            ModerateCommand.PlayerWithMuteInv.addPlayer(playerSender);
            GuiTargetManager.setTarget(moderator, target);
        }

    }
}
