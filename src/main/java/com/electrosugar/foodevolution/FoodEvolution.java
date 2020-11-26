package com.electrosugar.foodevolution;

import com.electrosugar.foodevolution.registry.ModBlocks;
import com.electrosugar.foodevolution.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class FoodEvolution implements ModInitializer {

    public static final String MOD_ID = "foodevo";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
