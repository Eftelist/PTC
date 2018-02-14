package PTC.Listener

import PTC.Systems.Bans.Bans
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPreLoginEvent

class PlayerPreLoginListener : Listener {

    @EventHandler
    fun onPre(preLoginEvent: PlayerPreLoginEvent) {
        if (Bans.contains(preLoginEvent.uniqueId)) {
            preLoginEvent.disallow(PlayerPreLoginEvent.Result.KICK_BANNED, Bans.getPlayerMessage(preLoginEvent.uniqueId))
        }
    }
}
