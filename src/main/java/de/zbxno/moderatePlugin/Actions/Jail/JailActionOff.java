package de.zbxno.moderatePlugin.Actions.Jail;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class JailActionOff implements GuiAction {

    String prefix = ModeratePlugin.prefix;

    @Override
    public void execute(CommandSender sender, Player target){
        if (sender instanceof Player playerSenderJail) {
            if (JailAction.jailedPlayers.contains(target.getUniqueId())){
                JailAction.jailedPlayers.remove(target.getUniqueId());
                playerSenderJail.sendMessage(prefix + "You unJailed the player " + ChatColor.YELLOW + target.getName());
                playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + "" + ChatColor.BOLD + "You're not in the Jail anymore"));
                target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                World world = Bukkit.getWorld("world");
                Location spawn = new Location(world, 16215,90,23349 ,180, 0);
                target.teleport(spawn);
            }else {
                playerSenderJail.sendMessage(prefix + "The player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET + " is not in Jail right now!");
                playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        }
    }
}
