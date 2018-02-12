package PTC;

import PTC.Managers.CommandManager;
import TrackedRides.TrackedRidesAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;


public class Core extends JavaPlugin {

    private static Core instance = null;
    public static boolean TrackedRides = true;
    private static CommandManager commandManager = null;
    private static World world = null;

    public static World getWorld() {
        return world;
    }

    @Override
    public void onEnable() {
        instance = this;
        world = Bukkit.getWorld("Disneyland");
        setupManagers();
        setupTrackedRides();
    }

    // TODO => Deleten... ;)
    private void setupTrackedRides() {
        TrackedRidesAPI api = new TrackedRidesAPI();
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
