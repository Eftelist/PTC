package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import com.google.common.base.Joiner
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ATRBroadcast  : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (args.size > 0) {
            if (sender.hasPermission(Permissions.ATRBroadcast)) {
                if(args[0] == "open"){
                    Bukkit.broadcastMessage(Messages.atrbroadcast1.plus(ChatColor.translateAlternateColorCodes('&',args[1])).plus(Messages.atrbroadcastopen));
                }
                if(args[0] == "close"){
                    Bukkit.broadcastMessage(Messages.atrbroadcast1.plus(ChatColor.translateAlternateColorCodes('&',args[1])).plus(Messages.atrbroadcastclose));
                }
            } else {
                sender.sendMessage(Messages.noPermission)
            }
        } else {
            sender.sendMessage(Messages.color1.toString() + "Command usage " + Messages.gray + "> " + Messages.color2 + "/bc (Message)")
        }
        return false
    }
}
