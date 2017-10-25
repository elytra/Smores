/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017:
 *     Ethan Brooks (CalmBit),
 *     Isaac Ellingson (Falkreon),
 *     and contributors
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

import com.elytradev.smores.Smores;
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumGem;
import com.elytradev.smores.materials.EnumMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RecipeRegistry {

	private static void constructShapedOreRecipe(RegistryEvent.Register<IRecipe> event, String registryName, String product, int count, Object[] recipe) {
		NonNullList<ItemStack> products = OreDictionary.getOres(product);
		if (products.size() <= 0) {
			Smores.LOG.error("Couldn't get an OreDict reference for " + product + " - failed to register recipe!");
		} else {
			ItemStack productStack = products.get(0).copy();
			productStack.setCount(count);
			event.getRegistry().register(new ShapedOreRecipe(null, productStack, recipe).setRegistryName(Smores.MOD_ID, registryName));
		}
	}

	private static void constructShapelessOreRecipe(RegistryEvent.Register<IRecipe> event, String registryName, String product, int count, Object[] recipe) {
		NonNullList<ItemStack> products = OreDictionary.getOres(product);

		if (products.size() <= 0) {
			Smores.LOG.error("Couldn't get an OreDict reference for " + product + " - failed to register recipe!");
		} else {
			ItemStack productStack = products.get(0).copy();
			productStack.setCount(count);
			event.getRegistry().register(new ShapelessOreRecipe(null, productStack, recipe).setRegistryName(Smores.MOD_ID, registryName));
		}
	}

	private static void constructSmeltingRecipe(String supply, String product, float exp) {
		NonNullList<ItemStack> supplies = OreDictionary.getOres(supply);
		NonNullList<ItemStack> products = OreDictionary.getOres(product);

		if (supplies.size() != 0 && products.size() != 0) {
			ItemStack supplyStack = supplies.get(0).copy();
			ItemStack productStack = products.get(0).copy();
			GameRegistry.addSmelting(supplyStack, productStack, exp);
		}
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

		// TODO: Disable the shit out of these.

		for (EnumMetal metal : EnumMetal.values()) {

			constructShapedOreRecipe(event, "gear" + metal.getMaterialName(),
					"gear" + metal.getMaterialName(), 1,
					new Object[]{" M ", "MIM", " M ", 'M', "ingot" + metal.getMaterialName(), 'I', "ingotIron"});

			constructSmeltingRecipe("dust"+metal.getMaterialName(),
					"ingot"+metal.getMaterialName(), 0.7f);

			// Subverting vanilla recipes (or attempting to) is a Bad Thing(TM)
			if (metal != EnumMetal.IRON && metal != EnumMetal.GOLD) {

				constructShapedOreRecipe(event, "ingot" + metal.getMaterialName() + "FromNugget",
						"ingot" + metal.getMaterialName(), 1,
						new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + metal.getMaterialName()});

				constructShapelessOreRecipe(event, "nugget" + metal.getMaterialName(),
						"nugget" + metal.getMaterialName(), 9, new Object[]{"ingot" + metal.getMaterialName()});

				constructShapedOreRecipe(event, "block" + metal.getMaterialName(), "block" + metal.getMaterialName(), 1,
						new Object[]{"III", "III", "III", 'I', "ingot" + metal.getMaterialName()});

				constructShapelessOreRecipe(event, "ingot" + metal.getMaterialName()+ "FromBlock",
						"ingot" + metal.getMaterialName(), 9, new Object[]{"block" + metal.getMaterialName()});

				constructSmeltingRecipe("ore" + metal.getMaterialName(), "ingot" + metal.getMaterialName(), 0.7f);
			}
		}

		for (EnumAlloy alloy : EnumAlloy.values()) {
	
			constructShapedOreRecipe(event, "gear" + alloy.getMaterialName(),
					"gear" + alloy.getMaterialName(), 1,
					new Object[]{" M ", "MIM", " M ", 'M', "ingot" + alloy.getMaterialName(), 'I', "ingotIron"});

			constructSmeltingRecipe("dust"+alloy.getMaterialName(),
					"ingot"+alloy.getMaterialName(), 0.7f);
			
			constructShapedOreRecipe(event, "ingot" + alloy.getMaterialName()+"FromNugget",
					"ingot" + alloy.getMaterialName(), 1,
					new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + alloy.getMaterialName()});

			constructShapelessOreRecipe(event, "nugget" + alloy.getMaterialName(),
					"nugget" + alloy.getMaterialName(), 9, new Object[]{"ingot" + alloy.getMaterialName()});

			constructShapedOreRecipe(event, "block" + alloy.getMaterialName(),
					"block" + alloy.getMaterialName(), 1,
					new Object[]{"III", "III", "III", 'I', "ingot" + alloy.getMaterialName()});

			constructShapelessOreRecipe(event, "ingot" + alloy.getMaterialName()+"FromBlock",
					"ingot" + alloy.getMaterialName(), 9, new Object[]{"block" + alloy.getMaterialName()});

			constructSmeltingRecipe("ore" + alloy.getMaterialName(), "ingot" + alloy.getMaterialName(), 0.7f);
		}

		for (EnumGem gem : EnumGem.values()) {
			constructShapedOreRecipe(event, "block" + gem.getMaterialName(),
					"block" + gem.getMaterialName(), 1, new Object[]{"GGG", "GGG", "GGG", 'G', "gem" + gem.getMaterialName()});

			constructShapelessOreRecipe(event, "gem" + gem.getMaterialName(),
					"gem" + gem.getMaterialName(), 9, new Object[]{"block" + gem.getMaterialName()});

			constructSmeltingRecipe("ore" + gem.getMaterialName(), "gem" + gem.getMaterialName(), 1.0f);
		}
	}

}
