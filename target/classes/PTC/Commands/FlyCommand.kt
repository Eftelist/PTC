package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand : CommandExecutor {


    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permissions.FLY)) {
                sender.allowFlight = true;
                sender.isFlying = true
            } else {
                sender.sendMessage(Messages.noPermission)
            }
        } else {
            sender.sendMessage(Messages.notPlayer)
        }
        return false
    }
}
