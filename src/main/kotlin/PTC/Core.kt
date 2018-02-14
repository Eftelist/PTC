package PTC

import PTC.Listener.PlayerPreLoginListener
import PTC.Listener.PoiListener
import PTC.Listener.ShopListener
import PTC.Managers.CommandManager
import PTC.Managers.ShopManager
import PTC.Systems.Bans.Bans
import TrackedRides.TrackedRidesAPI
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin

class Core : JavaPlugin() {

    override fun onEnable() {
        instance = this
        world = Bukkit.getWorld("Disneyland")
        setupManagers()
        setupTrackedRides()
        setupListeners()
    }

    private fun setupListeners() {
        Bukkit.getPluginManager().registerEvents(PlayerPreLoginListener(), this);
        Bukkit.getPluginManager().registerEvents(PoiListener(), this)
        Bukkit.getPluginManager().registerEvents(ShopListener(), this)
    }

    // TODO => Deleten... ;)
    private fun setupTrackedRides() {
        val api = TrackedRidesAPI()
    }

    private fun setupManagers() {
        commandManager = CommandManager()
        BanSystem = Bans()
        shopSystem = ShopManager()
    }

    override fun onDisable() {
        shopSystem?.uninstall();
        instance = null
    }

    companion object {
        var BanSystem: Bans? = null
        var shopSystem: ShopManager? = null
        var instance: Core? = null
            private set
        var TrackedRides = true
        var commandManager: CommandManager? = null
            private set
        var world: World? = null
            private set
    }
}
