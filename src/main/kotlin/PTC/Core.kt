package PTC

import PTC.Managers.CommandManager
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
    }

    // TODO => Deleten... ;)
    private fun setupTrackedRides() {
        val api = TrackedRidesAPI()
    }

    private fun setupManagers() {
        commandManager = CommandManager()
    }

    override fun onDisable() {
        instance = null
    }

    companion object {

        var instance: Core? = null
            private set
        var TrackedRides = true
        var commandManager: CommandManager? = null
            private set
        var world: World? = null
            private set
    }
}
