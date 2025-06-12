package de.zbxno.moderatePlugin.Actions.Jail;


import de.zbxno.moderatePlugin.Commands.SetSpawn;
import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
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
                target.teleport(SetSpawn.spawnPos);
            }else {
                playerSenderJail.sendMessage(prefix + "The player " + ChatColor.YELLOW + target.getName() + ChatColor.RESET + " is not in Jail right now!");
                playerSenderJail.playSound(playerSenderJail.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        }
    }
}
