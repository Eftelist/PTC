package PTC.Objects;

import java.util.ArrayList;

public interface Shop {

    String getName();

    Cuboid getCuboid();

    ArrayList<WinkelItem> getItems();

    ArrayList<Medewerker> getMedewerkers();

}
