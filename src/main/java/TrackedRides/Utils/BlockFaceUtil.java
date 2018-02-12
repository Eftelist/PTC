package TrackedRides.Utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.ArrayList;
import java.util.List;

public class BlockFaceUtil extends Thread {

    public static List<Block> list = new ArrayList<Block>();
    private final BlockFace[] faces = BlockFace.values();
    private final Block relaa;
    private boolean started;

    public BlockFaceUtil(Block start) {
        relaa = start;
    }

    // very pseudo code so don't copy pasta, also doesn't take into account the conditions or looping
    private void recursiveMethod(Block someBlock, List<Block> blockList) {
        Location start = someBlock.getLocation();
        for (BlockFace face : faces) {
            Block rela = someBlock.getRelative(face);
            if (!blockList.contains(rela) && rela.getType() == someBlock.getType()) {
                blockList.add(rela);
            } else if (blockList.contains(rela) && rela.getX() == start.getX() && rela.getY() == start.getY() && rela.getZ() == start.getZ()) {
                this.interrupt();
            }
        }
    }

    @Override
    public void run() {
        if (!started) {
            started = true;
            recursiveMethod(relaa, BlockFaceUtil.list);
        }
    }

}
