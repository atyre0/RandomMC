package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class RandomEggs implements Listener {

    @EventHandler
    public void onChickenSpawn(CreatureSpawnEvent event) {
        if (RandomMC.getInstance().getConfig().getBoolean("random-eggs") == true) {
            if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEggHit(ProjectileHitEvent event) {
        if (RandomMC.getInstance().getConfig().getBoolean("random-eggs") == true) {
            if (event.getEntity() instanceof Egg) {
                Location location = event.getEntity().getLocation();
                World world = location.getWorld();

                EntityType randomEntity = RandomUtil.getRandomLivingEntity();

                world.spawnEntity(location, randomEntity);
            }
        }
    }
}
