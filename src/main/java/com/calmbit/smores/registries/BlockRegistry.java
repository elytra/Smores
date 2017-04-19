package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.blocks.BlockBase;
import com.calmbit.smores.blocks.BlockGemOre;
import com.calmbit.smores.blocks.BlockMetalOre;
import com.calmbit.smores.generic.IBlockBase;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.items.ItemBlockGemOre;
import com.calmbit.smores.items.ItemBlockMetalOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class BlockRegistry {

    public static BlockBase blockMetalOre;
    public static BlockBase blockGemOre;
    public static void init()
    {
        blockMetalOre = registerBlock(new BlockMetalOre(), ItemBlockMetalOre.class).setCreativeTab(Smores.smoresCreativeTab);
        blockGemOre = registerBlock(new BlockGemOre(), ItemBlockGemOre.class).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Block & IBlockBase> T registerBlock(T block, Class<? extends ItemBlock> itemBlock)
    {
        GameRegistry.register(block);

        if(block instanceof IOreDict)
        {
            ((IOreDict)block).registerOreDict();
        }

        try {
            ItemBlock itemBlockInstance = itemBlock.getConstructor(Block.class).newInstance(block);
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
