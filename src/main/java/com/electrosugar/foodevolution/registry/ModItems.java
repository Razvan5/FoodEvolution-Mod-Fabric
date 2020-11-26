package com.electrosugar.foodevolution.registry;

import com.electrosugar.foodevolution.FoodEvolution;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item FRESH_WATER = new Item(new Item.Settings().group(ItemGroup.FOOD));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(FoodEvolution.MOD_ID, "fresh_water"), FRESH_WATER);
    }
}
