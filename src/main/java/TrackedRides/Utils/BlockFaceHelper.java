package TrackedRides.Utils;

import PTC.Core;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BlockFaceHelper {

    public static void setup(String filename, int x, int y, int z) {
        Location loc = new Location(Core.getWorld(), x, y, z);
        Block startblock = loc.getBlock();
        Thread blockFaceUtil = new BlockFaceUtil(loc.getBlock());
        blockFaceUtil.run();
        List<Block> list = null;
        while (blockFaceUtil.isAlive()) {
            if (!blockFaceUtil.isAlive()) {
                break;
            }
        }
        list = BlockFaceUtil.list;
        ArrayList<Location> b1l = new ArrayList<Location>();
        for (Block aw : list) {
            if (aw.getData() == startblock.getData()) {
                b1l.add(aw.getLocation());
            }
        }
        File f = new File(Core.getInstance().getDataFolder() + "/" + filename + ".points");
        try {
            PrintWriter pi = new PrintWriter(f);
            pi.write("coords = [");
            for (Location loctemp : b1l) {
                double h = loctemp.getX() - loc.getX();
                double i = loctemp.getY() - loc.getY();
                double j = loctemp.getZ() - loc.getZ();
                String k = ",";
                pi.write("(" + h + k + i + k + j + "),\n");
            }
            pi.write("]");
            pi.close();
        } catch (FileNotFoundException e) {
            // TODO => Stacktrace in ErrorUtil
            e.printStackTrace();
        }
    }
}
