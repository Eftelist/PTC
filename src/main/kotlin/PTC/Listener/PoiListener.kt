package PTC.Listener

import PTC.Core
import org.apache.commons.lang3.StringUtils
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import sun.audio.AudioPlayer.player
import org.inventivetalent.menubuilder.inventory.InventoryMenuBuilder
import org.inventivetalent.menubuilder.inventory.ItemListener
import java.io.File


class PoiListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        var player: Player = event.getPlayer()
        var stack: ItemStack = ItemStack(Material.NETHER_STAR, 1);
        var meta: ItemMeta = stack.itemMeta;
        meta.displayName = "Intressante warps";
        stack.setItemMeta(meta);
        player.inventory.setItem(4, stack);
    }

    @EventHandler
    fun onUse(event: PlayerInteractEvent) {
        if(event.item.hasItemMeta()){
            if(event.item.itemMeta.displayName == "Intressante warps"){
                event.isCancelled = true;
                PoiMenu.open(event.player);
            }
        }
    }

    class PoiMenu {
        companion object {
            var fil: File = File(Core.instance?.dataFolder, "warps.yml")
            fun open(player: Player){
                val config = YamlConfiguration.loadConfiguration(fil);
                val warps = config.getStringList("warps")
                val size = config.getInt("size")
                var menu = InventoryMenuBuilder().withSize(size * 9)
                        .withTitle(ChatColor.translateAlternateColorCodes('&',"&nIntressante warps"));
                var ind = 0;
                for(i in warps){
                    val ist = ItemStack(Material.NAME_TAG,1);
                    val ism = ist.itemMeta;
                    ism.displayName = "Warp: " + StringUtils.capitalize(i);
                    ist.itemMeta = ism;
                    menu = menu.withItem(ind, ist, ItemListener() { player: Player, clickType: ClickType, itemStack: ItemStack ->
                            player.performCommand("warp " + i);
                    }, ClickType.LEFT);
                    ind += 1
                }
                menu.show(player);
            }
        }
    }
}