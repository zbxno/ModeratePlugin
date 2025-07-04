package de.zbxno.moderatePlugin.Actions.Mute;


import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteActionOff implements GuiAction {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target){
        if (sender instanceof Player playerSender){
            if (MuteAction.mutePlayers.contains(target.getUniqueId())){
                MuteAction.mutePlayers.remove(target.getUniqueId());
                playerSender.sendMessage(prefix + "You unmuted the player " + ChatColor.YELLOW + target.getName());
                playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.WHITE  + "You can write now"));
                target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }else {
                playerSender.sendMessage(prefix + "Player is not muted");
                playerSender.playSound(playerSender.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        }
    }
}
