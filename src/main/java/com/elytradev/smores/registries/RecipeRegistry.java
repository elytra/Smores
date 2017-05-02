/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017:
 * 	Ethan Brooks (CalmBit),
 * 	Isaac Ellingson (Falkreon),
 * 	and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.elytradev.smores.registries;

import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumGem;
import com.elytradev.smores.materials.EnumMetal;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeRegistry {
    public static void init() {
        // TODO: Disable the shit out of these.
        for(EnumMetal metal : EnumMetal.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemIngot, 1, metal.getId()), new Object[]{"NNN", "NNN", "NNN", 'N', "nugget"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemNugget, 9, metal.getId()), new Object[]{"ingot"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemGear, 1, metal.getId()), new Object[]{"*M*","MIM","*M*",'M',"ingot"+metal.getMaterialName(),'I',"ingotIron"}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockMetal, 1, metal.getId()), new Object[]{"III", "III", "III", 'I', "ingot"+ metal.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, metal.getId()), new Object[]{"block"+ metal.getMaterialName()}));

            GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockMetalOre, 1, metal.getId()), new ItemStack(ItemRegistry.itemIngot, 1, metal.getId()), 0.7f);
        }

        for(EnumAlloy alloy : EnumAlloy.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemIngot, 1, alloy.getId()), new Object[]{"NNN", "NNN", "NNN", 'N', "nugget"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemNugget, 9, alloy.getId()), new Object[]{"ingot"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.itemGear, 1, alloy.getId()), new Object[]{"*M*","MIM","*M*",'M',"ingot"+alloy.getMaterialName(),'I',"ingotIron"}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockAlloy, 1, alloy.getId()), new Object[]{"III", "III", "III", 'I', "ingot"+ alloy.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, alloy.getId()), new Object[]{"block"+ alloy.getMaterialName()}));
        }

        for(EnumGem gem : EnumGem.values()) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockGem, 1, gem.getId()), new Object[]{"GGG", "GGG", "GGG", 'G', "gem"+ gem.getMaterialName()}));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemGem, 9, gem.getId()), new Object[]{"block"+ gem.getMaterialName()}));

            GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockGemOre, 1, gem.getId()), new ItemStack(ItemRegistry.itemGem, 1, gem.getId()), 1.0f);

        }


    }
}
