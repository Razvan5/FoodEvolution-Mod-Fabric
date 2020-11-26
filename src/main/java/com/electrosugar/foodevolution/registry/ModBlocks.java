package com.electrosugar.foodevolution.registry;

import com.electrosugar.foodevolution.FoodEvolution;
import com.electrosugar.foodevolution.blocks.Pot;
import com.mojang.datafixers.types.templates.Tag;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public final static Block POT = new Pot(FabricBlockSettings.
            of(Material.METAL).
            hardness(4.0f));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(FoodEvolution.MOD_ID, "pot"), POT);
    }
}
