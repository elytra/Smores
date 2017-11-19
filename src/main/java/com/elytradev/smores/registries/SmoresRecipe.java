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
import com.elytradev.smores.materials.*;
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

@Mod.EventBusSubscriber
public class SmoresRecipe {

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

		for(EnumMaterial material : EnumMaterial.values()){
			if (material.hasProduct(EnumProduct.GEAR)) {
				constructShapedOreRecipe(event, "gear" + material.getMaterialName(),
						"gear" + material.getMaterialName(), 1,
						new Object[]{" M ", "MIM", " M ", 'M', "ingot" + material.getMaterialName(), 'I', "ingotIron"});
			}

			if (material.hasProduct(EnumProduct.INGOT) && material.hasProduct(EnumProduct.DUST)) {
				constructSmeltingRecipe("dust"+material.getMaterialName(),
						"ingot"+material.getMaterialName(), 0.7f);
			}

			if(material.hasProduct(EnumProduct.NUGGET)) {
				constructShapedOreRecipe(event, "ingot" + material.getMaterialName() + "FromNugget",
						"ingot" + material.getMaterialName(), 1,
						new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + material.getMaterialName()});

				constructShapelessOreRecipe(event, "nugget" + material.getMaterialName(),
						"nugget" + material.getMaterialName(), 9, new Object[]{"ingot" + material.getMaterialName()});

			}

			if((material.hasProduct(EnumProduct.METAL_BLOCK) || material.hasProduct(EnumProduct.ALLOY_BLOCK))
					&& material.hasProduct(EnumProduct.INGOT)) {
				constructShapedOreRecipe(event, "block" + material.getMaterialName(),
						"block" + material.getMaterialName(), 1,
						new Object[]{"III", "III", "III", 'I', "ingot" + material.getMaterialName()});

				constructShapelessOreRecipe(event, "ingot" + material.getMaterialName()+ "FromBlock",
						"ingot" + material.getMaterialName(), 9, new Object[]{"block" + material.getMaterialName()});
			}

			if(material.hasProduct(EnumProduct.METAL_ORE) || material.hasProduct(EnumProduct.INGOT)) {
				constructSmeltingRecipe("ore" + material.getMaterialName(), "ingot" + material.getMaterialName(), 0.7f);
			}

			if(material.hasProduct(EnumProduct.GEM_BLOCK) && material.hasProduct(EnumProduct.GEM)) {
				constructShapedOreRecipe(event, "block" + material.getMaterialName(),
						"block" + material.getMaterialName(), 1, new Object[]{"GGG", "GGG", "GGG", 'G', "gem" + material.getMaterialName()});

				constructShapelessOreRecipe(event, "gem" + material.getMaterialName(),
						"gem" + material.getMaterialName(), 9, new Object[]{"block" + material.getMaterialName()});
			}

			if(material.hasProduct(EnumProduct.GEM_ORE) && material.hasProduct(EnumProduct.GEM)) {
				constructSmeltingRecipe("ore" + material.getMaterialName(), "gem" + material.getMaterialName(), 1.0f);
			}
		}
		

		// Custom Dust Recipes

		constructShapelessOreRecipe(event, "dustBronzeAlloy", "dustBronze", 4,
				new Object[]{"dustCopper","dustCopper","dustCopper","dustTin"});

		constructShapelessOreRecipe(event, "dustBrassAlloy", "dustBrass", 3,
				new Object[]{"dustCopper", "dustCopper", "dustZinc"});

		constructShapelessOreRecipe(event, "dustInvarAlloy", "dustInvar", 3,
				new Object[]{"dustIron", "dustIron", "dustNickel"});

		constructShapelessOreRecipe(event, "dustElectrumAlloy", "dustElectrum", 2,
				new Object[]{"dustGold", "dustSilver"});

	}

}
