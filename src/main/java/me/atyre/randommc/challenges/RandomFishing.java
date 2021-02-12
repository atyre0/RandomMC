package me.atyre.randommc.challenges;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class RandomFishing implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        event.getCaught();
    }
}
