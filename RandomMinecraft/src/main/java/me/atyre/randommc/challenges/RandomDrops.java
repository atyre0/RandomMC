package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class RandomDrops implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if (RandomMC.getInstance().getConfig().getBoolean("random-drops") == true) {
            Location location = event.getBlock().getLocation();
            World world = location.getWorld();

            event.getBlock().setType(Material.AIR);

            ItemStack randomItem;

            if (RandomMC.getInstance().getConfig().getBoolean("random-block-amounts") == true) {
                randomItem = new ItemStack(RandomUtil.getRandomItem(), RandomUtil.generateRandomNumber(0, 64));
            } else {
                randomItem = new ItemStack(RandomUtil.getRandomItem());
            }

            world.dropItemNaturally(location, randomItem);
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        event.getDrops().clear();

        ItemStack randomItem;

        if (RandomMC.getInstance().getConfig().getBoolean("random-block-amounts") == true) {
            randomItem = new ItemStack(RandomUtil.getRandomItem(), RandomUtil.generateRandomNumber(0, 64));
        } else {
            randomItem = new ItemStack(RandomUtil.getRandomItem());
        }

        event.getDrops().add(randomItem);
    }
}
