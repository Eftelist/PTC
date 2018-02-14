package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import PTC.Systems.Bans.Bans
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class UnbanCommand  : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (sender.hasPermission(Permissions.BAN)) {
            var target: OfflinePlayer? = Bukkit.getOfflinePlayer(args[0])
            if(Bans.contains(target?.uniqueId!!)){
                Bans.unban(target?.uniqueId!!);
                Bukkit.getBanList(BanList.Type.NAME).pardon(target?.name);
            }
        } else {
            sender.sendMessage(Messages.noPermission)
        }
        return false
    }
}