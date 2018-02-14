package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SpeedCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permissions.SPEED)) {
                if (args.size > 0) {
                    if (Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[0]) <= 10) {
                        sender.flySpeed = java.lang.Float.parseFloat(args[0]) / 10
                        sender.walkSpeed = java.lang.Float.parseFloat(args[0]) / 10
                    }
                } else {
                    sender.sendMessage(Messages.color1.toString() + "Command usage " + Messages.gray + "> " + Messages.color2 + "/speed (1-15)")
                }
            } else {
                sender.sendMessage(Messages.noPermission)
            }
        } else {
            sender.sendMessage(Messages.notPlayer)
        }
        return false
    }
}
