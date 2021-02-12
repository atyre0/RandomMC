package me.atyre.randommc;

import org.bukkit.entity.*;

public enum ProjectileType {

    ARROW("Arrow", Arrow.class),
    EGG("Egg", Egg.class),
    ENDER_PEARL("ThrownEnderpearl", EnderPearl.class),
    FIREBALL("Fireball", Fireball.class),
    FISH("Fish", Fish.class),
    FISH_HOOK("FishHook", FishHook.class),
    LARGE_FIREBALL("LargeFireball", LargeFireball.class),
    SMALL_FIREBALL("SmallFireball", SmallFireball.class),
    SNOWBALL("Snowball", Snowball.class),
    THROWN_EXP_BOTTLE("ThrownExpBottle", ThrownExpBottle.class),
    THROWN_POTION("ThrownPotion", ThrownPotion.class),
    WITHER_SKULL("WitherSkull", WitherSkull.class);

    private String name;
    private Class<? extends Entity> projectileEntityClass;

    ProjectileType(String name, Class<? extends Entity> projectileEntityClass) {
        this.name = name;
        this.projectileEntityClass = projectileEntityClass;
    }

    public String getName() {
        return this.name;
    }

    public Class<? extends Entity> getProjectileEntityClass() {
        return this.projectileEntityClass;
    }

}
