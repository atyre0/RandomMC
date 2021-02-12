package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class RandomBlockAmounts implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if (RandomMC.getInstance().getConfig().getBoolean("random-block-amounts") == true) {
            Location location = event.getBlock().getLocation();
            World world = location.getWorld();
            Material block = event.getBlock().getType();

            event.getBlock().setType(Material.AIR);

            ItemStack item = new ItemStack(block, RandomUtil.generateRandomNumber(0, 64));

            world.dropItemNaturally(location, item);
        }
    }
}
