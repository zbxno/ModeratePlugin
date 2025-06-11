package de.zbxno.moderatePlugin.Actions.Jail;


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
            JailAction.jailedPlayers.add(target.getUniqueId());
            World world = Bukkit.getWorld("world");
            Location jail = new Location(world, 16213, 88, 23336, 180f, 0f);
            target.teleport(jail);
            playerSenderJail.sendMessage(prefix + "The Player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET +" is now in Jail");
            playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            target.sendTitle(ChatColor.GRAY + "" + ChatColor.BOLD + "Jail!", ChatColor.GRAY + "Now you have time to think!", 20, 80, 40);
            target.playSound(target.getLocation(), Sound.ENTITY_STRAY_AMBIENT, 1.f, 1.f);
        }else {
            playerSenderJail.sendMessage(prefix + "The player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET +  " is already in Jail");
            playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
        }
    }
}
