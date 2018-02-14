package PTC.Utils;

import PTC.Managers.ShopManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ArmorStandUtil {

    public static ArmorStand spawn(World w, double v, double v1, double v2, String medewerker, String eendjeJob, boolean b) {
        Location loc = new Location(w,v,v1,v2);
        ArmorStand as = loc.getWorld().spawn(loc, ArmorStand.class);
        as.setGravity(b);
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta)itemStack.getItemMeta();
        meta.setOwner(medewerker);
        itemStack.setItemMeta(meta);
        as.setHelmet(itemStack);
        as.setCustomName("Medewerker");
        as.setCustomNameVisible(true);
        ShopManager.stands.add(as);
        return as;
    }

    public static void spawnItem(Location loc, ItemStack itemStack) {
        World w = loc.getWorld();
        ArmorStand stand= w.spawn(loc, ArmorStand.class);
        stand.setGravity(false);
        stand.setHelmet(itemStack);
        stand.setCustomName("Item");
        stand.setCustomNameVisible(false);
        stand.setVisible(true);
        ShopManager.stands.add(stand);
    }
}
