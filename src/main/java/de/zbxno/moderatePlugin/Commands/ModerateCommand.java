package de.zbxno.moderatePlugin.Commands;

import de.zbxno.moderatePlugin.ModeratePlugin;
import de.zbxno.moderatePlugin.util.ManageGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public class ModerateCommand implements CommandExecutor{

    public static class PlayerWithModInv {

        private static final Set<Player> PlayerWithModInv = new HashSet<>();

        public static void addPlayer(Player player) {
            PlayerWithModInv.add(player);
        }

        public static void removePlayer(Player player) {
            PlayerWithModInv.remove(player);
        }

        public static boolean hasGuiOpen(Player player) {
            return PlayerWithModInv.contains(player);
        }
    }

    public static class PlayerWithFreezeInv {

        private static final Set<Player> PlayerWithFreezeInv = new HashSet<>();

        public static void addPlayer(Player player) {
            PlayerWithFreezeInv.add(player);
        }

        public static void removePlayer(Player player) {
            PlayerWithFreezeInv.remove(player);
        }

        public static boolean hasGuiOpen(Player player) {
            return PlayerWithFreezeInv.contains(player);
        }
    }

    public static class PlayerWithJailInv {

        private static final Set<Player> PlayerWithJailInv = new HashSet<>();

        public static void addPlayer(Player player) {
            PlayerWithJailInv.add(player);
        }

        public static void removePlayer(Player player) {
            PlayerWithJailInv.remove(player);
        }

        public static boolean hasGuiOpen(Player player) {
            return PlayerWithJailInv.contains(player);
        }
    }

    public static class PlayerWithShowInv {

        private static final Set<Player> PlayerWithShowInv = new HashSet<>();

        public static void addPlayer(Player player) {
            PlayerWithShowInv.add(player);
        }

        public static void removePlayer(Player player) {
            PlayerWithShowInv.remove(player);
        }

        public static boolean hasGuiOpen(Player player) {
            return PlayerWithShowInv.contains(player);
        }
    }
    public static class PlayerWithMuteInv {

        private static final Set<Player> PlayerWithMuteInv = new HashSet<>();

        public static void addPlayer(Player player) {
            PlayerWithMuteInv.add(player);
        }

        public static void removePlayer(Player player) {
            PlayerWithMuteInv.remove(player);
        }

        public static boolean hasGuiOpen(Player player) {
            return PlayerWithMuteInv.contains(player);
        }
    }


    @Override
    public boolean onCommand(CommandSender s, Command command, String string, String[] args) {
        String prefix = ModeratePlugin.prefix;
        if (s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission("moderate.command")){
                if (args.length == 1){
                    String playerName = args[0];
                    Player target = Bukkit.getPlayerExact(playerName);
                    if (!(target == null)){
                        PlayerWithModInv.addPlayer(p);
                        Inventory modInv = new ManageGUI().getModInv();
                        p.openInventory(modInv);
                        p.sendMessage(prefix + "You are now moderaiting " + ChatColor.YELLOW + target.getName());
                    }else {
                        p.sendMessage(prefix + ChatColor.RED + "The Player " + ChatColor.RED + playerName + ChatColor.RED + " does not exist!");
                    }

                }else {
                    p.sendMessage(prefix + ChatColor.RED + "Use: /moderate <player>");
                }

            }else{
                p.sendMessage(prefix + ChatColor.RED + "You dont have permissions!");
            }

        }else{
            s.sendMessage(prefix + " You are not a player!");
        }


        return true;
    }

}
