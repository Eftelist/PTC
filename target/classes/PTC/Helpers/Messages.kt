package PTC.Helpers

import org.bukkit.ChatColor

object Messages {

    var color1 = ChatColor.GOLD
    var color2 = ChatColor.DARK_GRAY
    var gray = ChatColor.GRAY

    var noPermission = ChatColor.RED.toString() + "You don't have permissions for this command"
    var broadcast = ChatColor.translateAlternateColorCodes('&',"&8[&6Omroep&8]&7")
    var notPlayer = "You are not a player"
    var title: String = ChatColor.translateAlternateColorCodes('&',"&9PieckCraft");

    var ban1: String = t("&c&l&nJe bent verbannen van PieckCraft");
    var ban2: String = t("&cBanreden: ");
    var ban3: String = t("&cPeriode: ");

    var atrbroadcast1: String = ChatColor.translateAlternateColorCodes('&',"&8[&6Omroep&8]&7 ");
    var atrbroadcastopen =  ChatColor.translateAlternateColorCodes('&'," is nu geopend! &o(Klik hier)");
    var atrbroadcastclose =  ChatColor.translateAlternateColorCodes('&'," is nu gesloten");

    private fun t(s: String): String {
        return ChatColor.translateAlternateColorCodes('&',s);
    }


}
