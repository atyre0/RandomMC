package me.atyre.randommc;

import me.atyre.randommc.challenges.RandomBlockAmounts;
import me.atyre.randommc.challenges.RandomDrops;
import me.atyre.randommc.challenges.RandomEggs;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomMC extends JavaPlugin {

    private static RandomMC instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();

        getCommand("random").setExecutor(new RandomCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new RandomDrops(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomBlockAmounts(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomEggs(), this);
    }

    @Override
    public void onDisable() {
        instance = null;

    }

    public static RandomMC getInstance() {
        return instance;
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
