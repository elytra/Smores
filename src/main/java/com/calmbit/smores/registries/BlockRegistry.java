package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.blocks.*;
import com.calmbit.smores.generic.IBlockBase;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.items.ItemBlockSubtyped;
import com.calmbit.smores.materials.EnumAlloy;
import com.calmbit.smores.materials.EnumGem;
import com.calmbit.smores.materials.EnumMetal;
import com.calmbit.smores.materials.EnumNether;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class BlockRegistry {

    public static BlockBase blockMetalOre;
    public static BlockBase blockGemOre;
    public static BlockBase blockNetherOre;
    public static BlockBase blockMetal;
    public static BlockBase blockAlloy;
    public static BlockBase blockGem;

    public static void init()
    {
        blockMetalOre = registerBlock(new BlockMetalOre(), EnumMetal.class).setCreativeTab(Smores.smoresCreativeTab);
        blockGemOre = registerBlock(new BlockGemOre(), EnumGem.class).setCreativeTab(Smores.smoresCreativeTab);
        blockNetherOre = registerBlock(new BlockNetherOre(), EnumNether.class).setCreativeTab(Smores.smoresCreativeTab);
        blockMetal = registerBlock(new BlockMetal(), EnumMetal.class).setCreativeTab(Smores.smoresCreativeTab);
        blockAlloy = registerBlock(new BlockAlloy(), EnumAlloy.class).setCreativeTab(Smores.smoresCreativeTab);
        blockGem = registerBlock(new BlockGem(), EnumGem.class).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Block & IBlockBase, V extends Enum<V>> T registerBlock(T block, Class<V> enumClass)
    {
        GameRegistry.register(block);

        if(block instanceof IOreDict)
        {
            ((IOreDict)block).registerOreDict();
        }

        try {
            ItemBlock itemBlockInstance = new ItemBlockSubtyped<V>(block, enumClass);
            GameRegistry.register(itemBlockInstance);
            block.registerItemModel(itemBlockInstance);
        }
        catch(Exception e) {
            Smores.LOG.error(e.getStackTrace());
        }

        return block;
    }
}
