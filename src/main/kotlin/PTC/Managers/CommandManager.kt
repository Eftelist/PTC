package PTC.Managers

import PTC.Commands.BroadcastCommand
import PTC.Commands.FlyCommand
import PTC.Commands.GamemodeCommand
import PTC.Commands.SpeedCommand
import PTC.Core

class CommandManager {
    init {
        registerCommands()
    }

    private fun registerCommands() {
        val core: Core? = Core.instance
        core?.getCommand("bc")?.executor = BroadcastCommand()
        core?.getCommand("gm")?.executor = GamemodeCommand()
        core?.getCommand("fly")?.executor = FlyCommand()
        core?.getCommand("speed")?.executor = SpeedCommand()
    }
}
