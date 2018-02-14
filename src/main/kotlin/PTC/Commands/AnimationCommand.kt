package PTC.Commands

import PTC.Core
import PTC.Helpers.Messages
import PTC.Utils.ArmorStandAnimator
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import java.io.File

class AnimationCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        if (sender is Player) {
            val player: Player = sender as Player
            val file: File = File(Core.instance?.dataFolder,"test.anima")
            val armorstand: ArmorStand = player.getWorld().spawn(player.getLocation(),ArmorStand::class.java)
            armorstand.setGravity(false)
            val asw: ArmorStandAnimator = ArmorStandAnimator(file, armorstand)
            System.err.print(asw.isInterpolated)
            asw.play()
            var run : BukkitRunnable = ASTUpdater(asw)
            run.runTaskTimer(Core.instance,0,0);
            Bukkit.broadcastMessage(asw.frames.size.toString());
        } else {
            sender.sendMessage(Messages.notPlayer)
        }
        return false
    }
}

class ASTUpdater(val anima:ArmorStandAnimator) : BukkitRunnable() {
    override fun run() {
        anima.update();
    }
}
