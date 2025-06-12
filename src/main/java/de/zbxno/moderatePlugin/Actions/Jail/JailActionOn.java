package de.zbxno.moderatePlugin.Actions.Jail;


import de.zbxno.moderatePlugin.Commands.SetJail;
import de.zbxno.moderatePlugin.Commands.SetSpawn;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JailActionOn implements GuiAction {
    String prefix = ModeratePlugin.prefix;

    @Override
    public void execute(CommandSender sender, Player target){
        Player playerSenderJail = (Player) sender;
        if (!(JailAction.jailedPlayers.contains(target.getUniqueId()))){
            if (SetJail.jailPos != null){
                if (SetSpawn.spawnPos != null){
                    target.teleport(SetJail.jailPos);
                }else {
                    playerSenderJail.sendMessage(prefix + ChatColor.RED + "Spawn Position empty /setspawn <set>");
                    return;
                }
            }else {
                playerSenderJail.sendMessage(prefix + ChatColor.RED + "Jail Position empty /setjail <set>");
                return;
            }
            JailAction.jailedPlayers.add(target.getUniqueId());
            playerSenderJail.sendMessage(prefix + "The Player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET +" is now in Jail");
            playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            target.sendTitle(ChatColor.GRAY + "" + ChatColor.BOLD + "Jail!", ChatColor.GRAY + "Now you have time to think!", 20, 80, 40);
            target.playSound(target.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.f, 1.f);
        }else {
            playerSenderJail.sendMessage(prefix + "The player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET +  " is already in Jail");
            playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
        }
    }
}
