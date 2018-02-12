package PTC.Commands;

import PTC.Helpers.Messages;
import PTC.Helpers.Permissions;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(Permissions.GAMEMODE)){
                if(args.length > 0){
                    if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
                        p.setGameMode(GameMode.SURVIVAL);
                    }
                    if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")){
                        p.setGameMode(GameMode.CREATIVE);
                    }
                    if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")){
                        p.setGameMode(GameMode.ADVENTURE);
                    }
                    if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")){
                        p.setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    p.sendMessage(Messages.color1 + "Command usage " + Messages.gray + "> " + Messages.color2 +"/gm (0,1,2,3)");
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
