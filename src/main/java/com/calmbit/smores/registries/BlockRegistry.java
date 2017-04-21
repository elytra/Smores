package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.blocks.*;
import com.calmbit.smores.generic.IBlockBase;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.items.ItemBlockEnumSubtyped;
import com.calmbit.smores.materials.EnumAlloyType;
import com.calmbit.smores.materials.EnumGemType;
import com.calmbit.smores.materials.EnumMetalType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class BlockRegistry {

    public static BlockBase blockMetalOre;
    public static BlockBase blockGemOre;
    public static BlockBase blockMetal;
    public static BlockBase blockAlloy;
    public static BlockBase blockGem;

    public static void init()
    {
        blockMetalOre = registerBlock(new BlockMetalOre(), EnumMetalType.class).setCreativeTab(Smores.smoresCreativeTab);
        blockGemOre = registerBlock(new BlockGemOre(), EnumGemType.class).setCreativeTab(Smores.smoresCreativeTab);
        blockMetal = registerBlock(new BlockMetal(), EnumMetalType.class).setCreativeTab(Smores.smoresCreativeTab);
        blockAlloy = registerBlock(new BlockAlloy(), EnumAlloyType.class).setCreativeTab(Smores.smoresCreativeTab);
        blockGem = registerBlock(new BlockGem(), EnumGemType.class).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Block & IBlockBase, V extends Enum> T registerBlock(T block, Class<V> enumClass)
    {
        GameRegistry.register(block);

        if(block instanceof IOreDict)
        {
            ((IOreDict)block).registerOreDict();
        }

        try {
            ItemBlock itemBlockInstance = new ItemBlockEnumSubtyped<V>(block, enumClass);
            GameRegistry.register(itemBlockInstance);
            block.registerItemModel(itemBlockInstance);
            if(itemBlockInstance instanceof IOreDict)
            {
                ((IOreDict)itemBlockInstance).registerOreDict();
            }
        }
        catch(Exception e) {
            Smores.LOG.error(e.getStackTrace());
        }

        return block;
    }
}
