package me.atyre.randommc.challenges;

import me.atyre.randommc.RandomMC;
import me.atyre.randommc.RandomUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class RandomCraftingRecipes implements Listener {

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        if (RandomMC.getInstance().getConfig().getBoolean("random-crafting-recipes") == true) {
            Material itemResult = event.getRecipe().getResult().getType();
            ArrayList<Material> materials = new ArrayList<Material>();

            for (Material material : Material.values()) {
                materials.add(material);

                if (RandomMC.getInstance().getConfig().getBoolean("illegal-items") == false) {
                    materials.remove(Material.BEDROCK);
                    materials.remove(Material.BARRIER);
                }

                materials.remove(Material.AIR);
            }

            if (materials.contains(itemResult)) {
                event.getInventory().setResult(new ItemStack(RandomUtil.getRandomItem()));
            }
        }
    }
}
