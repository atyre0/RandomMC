package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RandomItemNames implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if (RandomMC.getInstance().getConfig().getBoolean("random-item-names") == true) {
            Location location = event.getPlayer().getLocation();
            World world = location.getWorld();
            Material block = event.getBlock().getType();

            event.getBlock().setType(Material.AIR);

            ItemStack item = new ItemStack(block);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(RandomUtil.getRandomItemName());

            world.dropItemNaturally(location, item);
        }
    }

}
