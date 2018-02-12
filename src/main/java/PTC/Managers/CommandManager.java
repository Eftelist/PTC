package PTC.Managers;

import PTC.Commands.BroadcastCommand;
import PTC.Commands.FlyCommand;
import PTC.Commands.GamemodeCommand;
import PTC.Commands.SpeedCommand;
import PTC.Core;
import org.bukkit.plugin.Plugin;

public class CommandManager {

    public CommandManager(){
        registerCommands();
    }

    private void registerCommands() {
        Core core = Core.getInstance();
        core.getCommand("bc").setExecutor(new BroadcastCommand());
        core.getCommand("gm").setExecutor(new GamemodeCommand());
        core.getCommand("fly").setExecutor(new FlyCommand());
        core.getCommand("speed").setExecutor(new SpeedCommand());
    }
}
