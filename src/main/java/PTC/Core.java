package PTC;

import PTC.Managers.CommandManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private static Core instance = null;
    private static CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        setupManagers();
    }

    private void setupManagers() {
        commandManager = new CommandManager();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Core getInstance() {
        return instance;
    }

    public static CommandManager getCommandManager() {
        return commandManager;
    }
}
