package TrackedRides.Utils

import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import java.util.*

class BlockFaceUtil(private val relaa: Block) : Thread() {
    private val faces = BlockFace.values()
    private var started: Boolean = false

    // very pseudo code so don't copy pasta, also doesn't take into account the conditions or looping
    private fun recursiveMethod(someBlock: Block, blockList: MutableList<Block>) {
        val start = someBlock.location
        for (face in faces) {
            val rela = someBlock.getRelative(face)
            if (!blockList.contains(rela) && rela.type == someBlock.type) {
                blockList.add(rela)
            } else if (blockList.contains(rela) && rela.x.toDouble() == start.x && rela.y.toDouble() == start.y && rela.z.toDouble() == start.z) {
                this.interrupt()
            }
        }
    }

    override fun run() {
        if (!started) {
            started = true
            recursiveMethod(relaa, BlockFaceUtil.list)
        }
    }

    companion object {

        var list: MutableList<Block> = ArrayList()
    }

}
