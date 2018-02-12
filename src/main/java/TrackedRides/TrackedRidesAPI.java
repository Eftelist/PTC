package TrackedRides;

import PTC.Core;
import TrackedRides.Utils.BlockFaceHelper;

public class TrackedRidesAPI {

    public TrackedRidesAPI() {
        if (Core.TrackedRides) {
            BlockFaceHelper.setup("spline_converter_test", 50, 70, 50);
        }
    }

}
