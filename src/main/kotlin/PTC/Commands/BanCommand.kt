package PTC.Commands

import PTC.Helpers.Messages
import PTC.Helpers.Permissions
import PTC.Systems.Bans.Bans
import com.google.common.base.Joiner
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BanCommand  : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
            if (sender.hasPermission(Permissions.BAN)) {
                var target: Player = Bukkit.getPlayer(args[0]);

                var name:String = Messages.title;
                var temp = ""
                var started = false;
                for (i in 1..args.size - 1) {
                    if(!started){
                        started = true
                        temp = temp.plus(args[i])
                    } else {
                        temp = temp.plus(args[i - 1])
                    }
                }
                val period: String = "Pernament";
                val colors = ChatColor.translateAlternateColorCodes('&', temp)
                val banstring = Messages.ban1.plus("\n").plus("\n").plus(Messages.ban2).plus(temp).plus("\n").plus(Messages.ban3).plus(period)
                Bukkit.getBanList(BanList.Type.NAME).addBan(target.name, banstring, null, "Console");
                Bans.ban(target.uniqueId, banstring);
                target.kickPlayer(banstring)
            } else {
                sender.sendMessage(Messages.noPermission)
            }
        return false
    }
}