/*
 * The MIT License (MIT)
 * =====================
 *
 * Copyright © 2017:
 *  Ethan Brooks (CalmBit),
 *  Isaac Ellingson (Falkreon),
 *  and contributors
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.elytradev.smores.registries;

import com.elytradev.smores.Smores;
import com.elytradev.smores.blocks.*;
import com.elytradev.smores.generic.IBlockBase;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.items.ItemBlockSubtyped;
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumGem;
import com.elytradev.smores.materials.EnumMetal;
import com.elytradev.smores.materials.EnumNether;
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

        try {
            ItemBlock itemBlockInstance = new ItemBlockSubtyped<V>(block, enumClass);
            GameRegistry.register(itemBlockInstance);
            block.registerItemModel(itemBlockInstance);
        }
        catch(Exception e) {
            Smores.LOG.error(e.getStackTrace());
        }

        if(block instanceof IOreDict)
        {
            ((IOreDict)block).registerOreDict();
        }

        return block;
    }
}
