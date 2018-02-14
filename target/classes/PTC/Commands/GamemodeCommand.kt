package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GamemodeCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permissions.GAMEMODE)) {
                if (args.size > 0) {
                    if (args[0].equals("0", ignoreCase = true) || args[0].equals("survival", ignoreCase = true)) {
                        sender.gameMode = GameMode.SURVIVAL
                    }
                    if (args[0].equals("1", ignoreCase = true) || args[0].equals("creative", ignoreCase = true)) {
                        sender.gameMode = GameMode.CREATIVE
                    }
                    if (args[0].equals("2", ignoreCase = true) || args[0].equals("adventure", ignoreCase = true)) {
                        sender.gameMode = GameMode.ADVENTURE
                    }
                    if (args[0].equals("3", ignoreCase = true) || args[0].equals("spectator", ignoreCase = true)) {
                        sender.gameMode = GameMode.SPECTATOR
                    }
                } else {
                    sender.sendMessage(Messages.color1.toString() + "Command usage " + Messages.gray + "> " + Messages.color2 + "/gm (0,1,2,3)")
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
