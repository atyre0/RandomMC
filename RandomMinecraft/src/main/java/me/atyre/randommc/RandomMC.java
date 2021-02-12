package me.atyre.randommc;

import me.atyre.randommc.challenges.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomMC extends JavaPlugin {

    private static RandomMC instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        getCommand("random").setExecutor(new RandomCommand());
        registerChallenges();

        System.out.println("[RandomMC] Plugin is now enabled.");
    }

    @Override
    public void onDisable() {
        instance = null;

        System.out.println("[RandomMC] Plugin is now disabled.");

    }

    public static RandomMC getInstance() {
        return instance;
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void registerChallenges() {
        Bukkit.getServer().getPluginManager().registerEvents(new RandomItems(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomBlockAmounts(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomEggs(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomCraftingRecipes(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomMobDrops(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomItemNames(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RandomSmelting(), this);
    }
}
