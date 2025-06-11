package de.zbxno.moderatePlugin.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ManageGUI {

    ItemStack nameItem(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setEnchantmentGlintOverride(false);
            meta.setDisplayName(ChatColor.GOLD + name);
            item.setItemMeta(meta);
        }
        return item;
    }

    private final Inventory FreezeInv;

    private final Inventory modInv;

    private final Inventory JailInv;

    private final Inventory MuteInv;

    public ManageGUI() {

        modInv = Bukkit.createInventory(null,5*9, "Moderate Inventory");

        ItemStack Anvil = new ItemStack(Material.ANVIL);
        ItemStack Compass = new ItemStack(Material.COMPASS);
        ItemStack Feather = new ItemStack(Material.FEATHER);
        ItemStack ironDoor = new ItemStack(Material.IRON_DOOR);
        ItemStack redStoneTorch = new ItemStack(Material.REDSTONE_TORCH);
        ItemStack snowBall = new ItemStack(Material.SNOWBALL);
        ItemStack enderEye = new ItemStack(Material.ENDER_EYE);
        ItemStack redStoneBlock = new ItemStack(Material.REDSTONE_BLOCK);

        modInv.setItem(10, nameItem(Anvil, "Warn Player"));
        modInv.setItem(12, nameItem(Compass, "Show Inventory"));
        modInv.setItem(14, nameItem(Feather, "Kick Player"));
        modInv.setItem(16, nameItem(ironDoor, "Send Jail"));
        modInv.setItem(28, nameItem(redStoneTorch, "Mute Player"));
        modInv.setItem(30, nameItem(snowBall, "Freeze Player"));
        modInv.setItem(32, nameItem(enderEye, "Social Spy"));
        modInv.setItem(34, nameItem(redStoneBlock, "Ban Player"));

        FreezeInv = Bukkit.createInventory(null, 3*9, "FreezeInv");

        ItemStack Freeze = new ItemStack(Material.GREEN_WOOL);
        ItemStack unFreeze = new ItemStack(Material.RED_WOOL);

        FreezeInv.setItem(12, nameItem(Freeze, "Freeze"));
        FreezeInv.setItem(14, nameItem(unFreeze, "unFreeze"));

        JailInv = Bukkit.createInventory(null, 3*9, "JailInv");

        ItemStack Jail = new ItemStack(Material.GREEN_WOOL);
        ItemStack unJail = new ItemStack(Material.RED_WOOL);

        JailInv.setItem(12, nameItem(Jail, "Jail"));
        JailInv.setItem(14, nameItem(unJail, "unJail"));

        MuteInv = Bukkit.createInventory(null, 3*9, "MuteInv");

        ItemStack Mute = new ItemStack(Material.GREEN_WOOL);
        ItemStack unMute = new ItemStack(Material.RED_WOOL);

        MuteInv.setItem(12, nameItem(Mute, "Mute"));
        MuteInv.setItem(14, nameItem(unMute, "unMute"));




    }
    public Inventory getFreezeInv(){
        return FreezeInv;
    }
    public Inventory getModInv() {
        return modInv;
    }
    public Inventory getJailInv() {
        return JailInv;
    }
    public Inventory getMuteInv() {
        return MuteInv;
    }
}
