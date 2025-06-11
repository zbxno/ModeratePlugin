package de.zbxno.moderatePlugin.Actions.Mute;



import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.GuiAction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class MuteActionOn implements GuiAction , Listener {
    String prefix = ModeratePlugin.prefix;
    @Override
    public void execute(CommandSender sender, Player target){
        if (sender instanceof Player playerSender){
            if (!(MuteAction.mutePlayers.contains(target.getUniqueId()))){
                playerSender.playSound(playerSender.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                playerSender.sendMessage(prefix + "You muted the player " + ChatColor.YELLOW + target.getName());
                target.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You have been Muted!", ChatColor.RED + "Be carefull what you say!", 20, 80, 40);
                target.playSound(target.getLocation(), Sound.ENTITY_STRAY_AMBIENT, 1.f, 1.f);
                MuteAction.mutePlayers.add(target.getUniqueId());
            }else {
                playerSender.sendMessage(prefix + "Player alreay muted!");
                playerSender.playSound(playerSender.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
            }

        }
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if (MuteAction.mutePlayers.contains(p.getUniqueId())){
            e.setCancelled(true);
            p.sendMessage(prefix + ChatColor.RED + "You cant chat. You are muted!");
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1f, 1f);
        }
    }
}
