package PTC.Shops.DeVerleiding;

import PTC.Objects.Cuboid;
import PTC.Objects.Medewerker;
import PTC.Objects.Skin;
import PTC.Objects.WinkelItem;
import PTC.Utils.ArmorStandUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;

public class DeVerleiding implements PTC.Objects.Shop {

    private String name;
    private Cuboid cuboid;
    private ArrayList<WinkelItem> items = new ArrayList<WinkelItem>();
    private ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();

    public DeVerleiding(){
        this.name = "De Verleiding";
        World w = Bukkit.getWorld("park");
        this.cuboid = new Cuboid(new Cuboid(new Location(w,756,79,1901),new Location(w, 736,64,1890)));
        ArmorStand stand = ArmorStandUtil.spawn(w,748.0,64.68,1898.0, Skin.MEDEWERKER, "EendjeJob", false);
        this.medewerkers.add(new Medewerker(stand, "Job",this));
        this.items.add(new JorisZwaard());
    }

    public String getName() {
        return this.name;
    }

    public Cuboid getCuboid() {
        return this.cuboid;
    }

    public ArrayList<WinkelItem> getItems() {
        return this.items;
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return this.medewerkers;
    }
}
