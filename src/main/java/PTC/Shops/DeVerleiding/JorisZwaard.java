package PTC.Shops.DeVerleiding;

import PTC.Managers.ShopManager;
import PTC.Objects.WinkelItemType;
import PTC.Utils.ArmorStandUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class JorisZwaard implements PTC.Objects.WinkelItem {

    public JorisZwaard(){
        if(!ShopManager.isInit("JorisZwaard")){
            ShopManager.setInitted("JorisZwaard");
            ItemStack itemStack = new ItemStack(Material.WOOD_SWORD,1);
            Location loc = new Location(Bukkit.getWorld("park"),749.5,63.67617,1891.5);
            ArmorStandUtil.spawnItem(loc, itemStack);
        }
    }

    public String getName() {
        return "Joris zwaard";
    }

    public WinkelItemType getType() {
        return WinkelItemType.ITEM;
    }

    public Object getObject() {
        ItemStack itemStack = new ItemStack(Material.WOOD_SWORD,1);
        return itemStack;
    }

    public double price() {
        return 50;
    }
}
