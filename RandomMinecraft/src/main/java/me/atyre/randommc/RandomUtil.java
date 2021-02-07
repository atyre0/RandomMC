package me.atyre.randommc;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtil {

    public static Material getRandomItem() {
        ArrayList<Material> materials = new ArrayList<Material>();

        for (Material material : Material.values()) {
            materials.add(material);

            if (RandomMC.getInstance().getConfig().getBoolean("illegal-random-drops") == false) {
                materials.remove(Material.BEDROCK);
                materials.remove(Material.BARRIER);
            }

            materials.remove(Material.AIR);
        }

        Random random = new Random();

        Material randomMaterial = materials.get(random.nextInt(materials.size()));

        return randomMaterial;
    }

    public static EntityType getRandomLivingEntity() {
        ArrayList<EntityType> entities = new ArrayList<EntityType>();

        for (EntityType entity : EntityType.values()) {
            if (entity.isAlive() && entity.isSpawnable()) {
                entities.add(entity);
            }
        }

        Random random = new Random();

        EntityType randomEntity = entities.get(random.nextInt(entities.size()));

        return randomEntity;
    }

    public static EntityType getRandomProjectile() {
        ArrayList<EntityType> projectiles = new ArrayList<EntityType>();

        for (EntityType entity : EntityType.values()) {
            if (entity.isP)
        }

        Random random = new Random();

        ProjectileType randomProjectile = projectiles.get(random.nextInt(projectiles.size()));

        return randomProjectile;
    }

    public static int generateRandomNumber(int n1, int n2) {
        Random random = new Random();
        return random.nextInt(n2 - n1) + n1;
    }
}
