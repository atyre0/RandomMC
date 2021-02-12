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
import org.bukkit.inventory.meta.ItemMeta;

public class RandomItems implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if (RandomMC.getInstance().getConfig().getBoolean("random-drops") == true) {
            Location location = event.getBlock().getLocation();
            World world = location.getWorld();

            event.getBlock().setType(Material.AIR);

            ItemStack randomItem;

            if (RandomMC.getInstance().getConfig().getBoolean("random-block-amounts") == true) {
                if (RandomMC.getInstance().getConfig().getBoolean("random-item-names") == true) {
                    randomItem = new ItemStack(RandomUtil.getRandomItem(), RandomUtil.generateRandomNumber(0, 64));
                    ItemMeta meta = randomItem.getItemMeta();

                    meta.setDisplayName(RandomUtil.getRandomItemName());
                } else {
                    randomItem = new ItemStack(RandomUtil.getRandomItem(), RandomUtil.generateRandomNumber(0, 64));
                }
            } else {
                if (RandomMC.getInstance().getConfig().getBoolean("random-item-names") == true) {
                    randomItem = new ItemStack(RandomUtil.getRandomItem());
                    ItemMeta meta = randomItem.getItemMeta();

                    meta.setDisplayName(RandomUtil.getRandomItemName());
                } else {
                    randomItem = new ItemStack(RandomUtil.getRandomItem());
                }
            }

            world.dropItemNaturally(location, randomItem);
        }
    }
}
