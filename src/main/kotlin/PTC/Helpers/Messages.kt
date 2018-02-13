package PTC.Helpers

import org.bukkit.ChatColor

object Messages {

    var color1 = ChatColor.GOLD
    var color2 = ChatColor.DARK_GRAY
    var gray = ChatColor.GRAY

    var noPermission = ChatColor.RED.toString() + "You don't have permissions for this command"
    var broadcast = color1.toString() + "Broadcast " + color2 + ">"
    var notPlayer = "You are not a player"
}
