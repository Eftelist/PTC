package PTC.Commands;

import PTC.Helpers.Messages;
import PTC.Helpers.Permissions;
import com.google.common.base.Joiner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length > 0){
            if(sender.hasPermission(Permissions.BROADCAST)){
                String temp = Joiner.on(" ").join((Object[])args);
                String colors = ChatColor.translateAlternateColorCodes('&', temp);
                Bukkit.broadcastMessage(Messages.broadcast + " " + colors);
            } else {
                sender.sendMessage(Messages.noPermission);
            }
        } else {
            sender.sendMessage(Messages.color1 + "Command usage " + Messages.gray + "> " + Messages.color2 +"/bc (Message)");
        }
        return false;
    }
}
