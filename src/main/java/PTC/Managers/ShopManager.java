package PTC.Managers;

import PTC.Objects.Shop;
import PTC.Shops.DeVerleiding.DeVerleiding;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;

public class ShopManager {

    public static ArrayList<ArmorStand> stands = new ArrayList<ArmorStand>();
    public static ArrayList<Shop> shops = new ArrayList<Shop>();
    public static ArrayList<String> init = new ArrayList<String>();

    public ShopManager(){
        shops.add(new DeVerleiding());
    }

    public void uninstall(){
        for(ArmorStand stand : stands){
            stand.remove();
        }
        shops.clear();
    }

    public static boolean isInit(String jorisZwaard) {
        boolean bool = false;
        for(String string : init) {
            if (jorisZwaard.equalsIgnoreCase(string)) {
                bool = true;
            }
        }
        return bool;
    }

    public static void setInitted(String jorisZwaard) {
        if(!isInit(jorisZwaard)){
            init.add(jorisZwaard);
        }
    }
}
