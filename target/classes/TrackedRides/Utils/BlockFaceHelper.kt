package TrackedRides.Utils

import PTC.Core
import org.bukkit.Location
import org.bukkit.block.Block
import java.io.File
import java.io.FileNotFoundException
import java.io.PrintWriter
import java.util.*

object BlockFaceHelper {

    fun setup(filename: String, x: Int, y: Int, z: Int) {
        val loc = Location(Core.world, x.toDouble(), y.toDouble(), z.toDouble())
        val startblock = loc.block
        val blockFaceUtil = BlockFaceUtil(loc.block)
        blockFaceUtil.run()
        var list: List<Block>? = null
        while (blockFaceUtil.isAlive) {
            if (!blockFaceUtil.isAlive) {
                break
            }
        }
        list = BlockFaceUtil.list
        val b1l = ArrayList<Location>()
        for (aw in list) {
            if (aw.data == startblock.data) {
                b1l.add(aw.location)
            }
        }
        val f = File(Core.instance?.dataFolder, filename + ".points")
        try {
            val pi = PrintWriter(f)
            pi.write("coords = [")
            for (loctemp in b1l) {
                val h = loctemp.x - loc.x
                val i = loctemp.y - loc.y
                val j = loctemp.z - loc.z
                val k = ","
                pi.write("($h$k$i$k$j),\n")
            }
            pi.write("]")
            pi.close()
        } catch (e: FileNotFoundException) {
            // TODO => Stacktrace in ErrorUtil
            e.printStackTrace()
        }

    }
}
