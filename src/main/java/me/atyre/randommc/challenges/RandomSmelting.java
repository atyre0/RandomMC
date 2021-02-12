package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class RandomSmelting implements Listener {
    @EventHandler
    public void onFurnace(FurnaceSmeltEvent event) {
        if (RandomMC.getInstance().getConfig().getBoolean("random-smelting") == true) {
            Material smeltedResult = event.getResult().getType();
            ArrayList<Material> materials = new ArrayList<Material>();

            for (Material material : Material.values()) {
                materials.add(material);

                if (RandomMC.getInstance().getConfig().getBoolean("illegal-items") == false) {
                    materials.remove(Material.BEDROCK);
                    materials.remove(Material.BARRIER);
                }

                materials.remove(Material.AIR);
            }

            if (materials.contains(smeltedResult)) {
                event.setResult(new ItemStack(RandomUtil.getRandomItem()));
            }
        }
    }
}
