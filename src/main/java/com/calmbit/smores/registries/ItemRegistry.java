package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {


    public static ItemBase itemIngot;
    public static ItemBase itemGem;
    public static ItemBase itemDust;
    public static ItemBase itemPlate;
    public static ItemBase itemGear;

    public static void init()
    {
        itemIngot = registerItem(new ItemIngot()).setCreativeTab(Smores.smoresCreativeTab);
        itemGem = registerItem(new ItemGem()).setCreativeTab(Smores.smoresCreativeTab);
        itemDust = registerItem(new ItemDust()).setCreativeTab(Smores.smoresCreativeTab);
        itemPlate = registerItem(new ItemPlate()).setCreativeTab(Smores.smoresCreativeTab);
        itemGear = registerItem(new ItemGear()).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);

        if(item instanceof ItemBase)
        {
            ((ItemBase)item).registerItemModel();
        }
        if(item instanceof IOreDict)
        {
            ((IOreDict)item).registerOreDict();
        }
        return item;
    }
}
