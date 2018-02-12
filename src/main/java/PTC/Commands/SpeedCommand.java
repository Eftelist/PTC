package PTC.Commands;

import PTC.Helpers.Messages;
import PTC.Helpers.Permissions;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(Permissions.SPEED)){
                if(args.length > 0){
                    if(Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[0]) <= 15) {
                        p.setFlySpeed(Float.parseFloat(args[0]));
                        p.setWalkSpeed(Float.parseFloat(args[0]));
                    }
                } else {
                    p.sendMessage(Messages.color1 + "Command usage " + Messages.gray + "> " + Messages.color2 +"/speed (1-15)");
                }
            } else {
                p.sendMessage(Messages.noPermission);
            }
        } else {
            sender.sendMessage(Messages.notPlayer);
        }
        return false;
    }
}
