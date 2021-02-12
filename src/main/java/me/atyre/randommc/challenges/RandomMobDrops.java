package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class RandomMobDrops implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (RandomMC.getInstance().getConfig().getBoolean("random-mob-drops") == true) {
        }
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
