package PTC.Commands;

import PTC.Helpers.Messages;
import PTC.Helpers.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(Permissions.FLY)){
                p.setFlying(true);
            } else {
                p.sendMessage(Messages.noPermission);
            }
        } else {
            sender.sendMessage(Messages.notPlayer);
        }
        return false;
    }
}
