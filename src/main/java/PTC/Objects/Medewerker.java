package PTC.Objects;

import org.bukkit.entity.ArmorStand;

public class Medewerker {

    private ArmorStand stand;


    public Medewerker(ArmorStand stand, String job, Shop shop) {
        this.stand = stand;
    }

    public ArmorStand getStand() {
        return stand;
    }

    public void setStand(ArmorStand stand) {
        this.stand = stand;
    }
}
