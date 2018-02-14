package PTC.Listener;

import PTC.Managers.ShopManager;
import PTC.Objects.Shop;
import PTC.Objects.WinkelItem;
import PTC.Utils.WinkelUtil;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopListener implements Listener {

    private HashMap<Player, ArrayList<WinkelItem>> winkelmandjes = new HashMap<Player, ArrayList<WinkelItem>>();

    @EventHandler
    public void handle(PlayerInteractAtEntityEvent entityEvent){
        Player p = entityEvent.getPlayer();
        Entity e = entityEvent.getRightClicked();
        if(e instanceof ArmorStand){
            ArmorStand stand = (ArmorStand) e;
            for(Shop shop : ShopManager.shops){
                if(shop.getCuboid().hasPlayerInside(p)){
                    String name = stand.getName();
                    if(name.equalsIgnoreCase("Medewerker")){
                        if(getWinkelMandje(p) != null){
                            ArrayList<WinkelItem> mand = getWinkelMandje(p);
                            double total = 0.0d;
                            for(WinkelItem item : mand){
                                total += item.price();
                            }
                            p.sendMessage("DEBUG: "+ total);
                            mand.clear();
                            winkelmandjes.remove(p);
                        } else {
                            p.sendMessage("Je hebt niks in je winkelmandje, je kunt niet verder.");
                        }
                    }
                    if(name.equalsIgnoreCase("Item")){
                        if(getWinkelMandje(p) != null){
                            ArrayList<WinkelItem> mand = getWinkelMandje(p);
                            mand.add(WinkelUtil.getItem("JorisZwaard"));
                        } else {
                            ArrayList<WinkelItem> mand = new ArrayList<WinkelItem>();
                            mand.add(WinkelUtil.getItem("JorisZwaard"));
                            winkelmandjes.put(p, mand);
                        }
                    }
                }
            }
        }
    }

    private ArrayList<WinkelItem> getWinkelMandje(Player p) {
        ArrayList<WinkelItem> winkelItems = new ArrayList<WinkelItem>();
        if(winkelmandjes.get(p) != null){
            return winkelmandjes.get(p);
        }
        return null;
    }
}
