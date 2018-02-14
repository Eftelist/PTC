package PTC.Systems.Bans

import PTC.Core
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.YamlConfiguration

import java.io.File
import java.io.IOException
import java.util.ArrayList
import java.util.UUID

class Bans {
    init {
        file = File(Core.instance?.dataFolder, "bans.yml")
        val yamlConfiguration = YamlConfiguration()
        try {
            yamlConfiguration.load(file)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InvalidConfigurationException) {
            e.printStackTrace()
        }

        config = yamlConfiguration
    }

    companion object {

        var file: File = File(Core.instance?.dataFolder, "bans.yml")
        var config: YamlConfiguration =  YamlConfiguration()

        operator fun contains(uniqueId: UUID): Boolean {
            var bool = false
            for (list in config.getStringList("players")) {
                if (uniqueId.toString().equals(list, ignoreCase = true)) {
                    bool = true
                }
            }
            return bool
        }

        fun ban(uuid: UUID, reason: String) {
            if (!contains(uuid)) {
                val already = config.getStringList("players")
                already.add(uuid.toString())
                config.set("players", already)
                config.set("reason." + uuid.toString(), reason);
                try {
                    config.save(file)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }

        fun unban(uuid: UUID) {
            if (contains(uuid)) {
                val already = config.getStringList("players")
                already.remove(uuid.toString())
                config.set("players", already)
                try {
                    config.save(file)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }

        fun getPlayerMessage(uuid: UUID): String {
            var test: String = ""
            if (contains(uuid)) {
                val already: String = config.getString("reason." + uuid.toString())
                test = already;
            }
            return test;
        }
    }
}
