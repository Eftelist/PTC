package PTC.Managers

import PTC.Commands.*
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
        core?.getCommand("ban")?.executor = BanCommand()
        core?.getCommand("atrcast")?.executor = ATRBroadcast()
        core?.getCommand("pcanima")?.executor = AnimationCommand()
        core?.getCommand("unban")?.executor = UnbanCommand()
    }
}
