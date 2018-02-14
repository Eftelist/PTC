package TrackedRides

import PTC.Core
import TrackedRides.Utils.BlockFaceHelper

class TrackedRidesAPI {
    init {
        if (Core.TrackedRides) {
            BlockFaceHelper.setup("spline_converter_test", 50, 70, 50)
        }
    }

}
