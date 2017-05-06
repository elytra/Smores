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
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumGem;
import com.elytradev.smores.materials.EnumMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeRegistry {
    public static void init() {
        // TODO: Disable the shit out of these.
        for(EnumMetal metal : EnumMetal.values()) {
            constructShapedOreRecipe("ingot"+metal.getMaterialName(),1, new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + metal.getMaterialName()});
            constructShapelessOreRecipe("nugget"+metal.getMaterialName(), 9, new Object[]{"ingot" + metal.getMaterialName()});
            constructShapedOreRecipe("gear"+metal.getMaterialName(), 1, new Object[]{"*M*", "MIM", "*M*", 'M', "ingot" + metal.getMaterialName(), 'I', "ingotIron"});
            constructShapedOreRecipe("block"+metal.getMaterialName(), 1, new Object[]{"III", "III", "III", 'I', "ingot"+ metal.getMaterialName()});
            constructShapelessOreRecipe("ingot"+metal.getMaterialName(), 9, new Object[]{"block"+ metal.getMaterialName()});
            constructSmeltingRecipe("ore"+metal.getMaterialName(),"ingot"+metal.getMaterialName(),0.7f);
        }

        for(EnumAlloy alloy : EnumAlloy.values()) {
            constructShapedOreRecipe("ingot"+alloy.getMaterialName(),1, new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + alloy.getMaterialName()});
            constructShapelessOreRecipe("nugget"+alloy.getMaterialName(), 9, new Object[]{"ingot" + alloy.getMaterialName()});
            constructShapedOreRecipe("gear"+alloy.getMaterialName(), 1, new Object[]{"*M*", "MIM", "*M*", 'M', "ingot" + alloy.getMaterialName(), 'I', "ingotIron"});
            constructShapedOreRecipe("block"+alloy.getMaterialName(), 1, new Object[]{"III", "III", "III", 'I', "ingot"+ alloy.getMaterialName()});
            constructShapelessOreRecipe("ingot"+alloy.getMaterialName(), 9, new Object[]{"block"+ alloy.getMaterialName()});
            constructSmeltingRecipe("ore"+alloy.getMaterialName(),"ingot"+alloy.getMaterialName(),0.7f);
        }

        for(EnumGem gem : EnumGem.values()) {
            constructShapedOreRecipe("block"+gem.getMaterialName(), 1,new Object[]{"GGG", "GGG", "GGG", 'G', "gem" + gem.getMaterialName()});
            constructShapelessOreRecipe("gem"+gem.getMaterialName(), 9, new Object[]{"block"+ gem.getMaterialName()});
            constructSmeltingRecipe("ore"+gem.getMaterialName(), "gem"+gem.getMaterialName(), 1.0f);
        }
    }

    private static void constructShapedOreRecipe(String product, int count, Object[] recipe) {
        NonNullList<ItemStack> products = OreDictionary.getOres(product);
        if(products.size() <= 0) {
            Smores.LOG.error("Couldn't get an OreDict reference for " + product + " - failed to register recipe!");
        }
        else {
            ItemStack productStack = products.get(0).copy();
            productStack.setCount(count);
            GameRegistry.addRecipe(new ShapedOreRecipe(productStack, recipe));
        }
    }

    private static void constructShapelessOreRecipe(String product, int count, Object[] recipe) {
        NonNullList<ItemStack> products = OreDictionary.getOres(product);
        if(products.size() <= 0) {
            Smores.LOG.error("Couldn't get an OreDict reference for " + product + " - failed to register recipe!");
        }
        else {
            ItemStack productStack = products.get(0).copy();
            productStack.setCount(count);
            GameRegistry.addRecipe(new ShapelessOreRecipe(productStack, recipe));
        }
    }

    private static void constructSmeltingRecipe(String supply, String product, float exp) {
        NonNullList<ItemStack> supplies = OreDictionary.getOres(supply);
        NonNullList<ItemStack> products = OreDictionary.getOres(product);

        if(supplies.size() != 0 && products.size() != 0) {
            ItemStack supplyStack = supplies.get(0).copy();
            ItemStack productStack = products.get(0).copy();
            GameRegistry.addSmelting(supplyStack, productStack , exp);
        }
    }
}
