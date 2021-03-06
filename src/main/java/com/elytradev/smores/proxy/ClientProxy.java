/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018
 *     Ethan Brooks (CalmBit),
 *     Isaac Ellingson (Falkreon),
 *     Una Thompson (unascribed),
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

package com.elytradev.smores.proxy;

import com.elytradev.smores.Smores;
import com.elytradev.smores.block.BlockFluidSmores;
import com.elytradev.smores.generic.IItemModelRegisterable;
import com.elytradev.smores.item.ItemBlockProduct;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientProxy extends CommonProxy {

	private static class ModelRegistrationCandidate {
		public final Item item;
		public final IItemModelRegisterable registerable;
		public ModelRegistrationCandidate(Item item, IItemModelRegisterable registerable) {
			this.item = item;
			this.registerable = registerable;
		}
	}

	private List<ModelRegistrationCandidate> modelRegistrationCandidates = Lists.newArrayList();
	
	@Override
	public void init() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		if (item instanceof ItemBlockProduct) {
			ItemBlockProduct subtyped = (ItemBlockProduct) item;
			Block blockFromItem = subtyped.getBlock();
			IBlockState blockState = blockFromItem.getStateFromMeta(meta);
			String variant = blockState.toString();
			Pattern pattern = Pattern.compile("smores:.*\\[(.*)]");
			Matcher matcher = pattern.matcher(variant);
			if (matcher.find()) {
				ModelLoader.setCustomModelResourceLocation(subtyped, meta,
						new ModelResourceLocation(Item.REGISTRY.getNameForObject(subtyped), matcher.group(1)));
			}
		} else if (item instanceof ItemBlock && ((ItemBlock)item).getBlock() instanceof BlockFluidSmores) {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("forge:fluid"));
		} else {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Smores.MOD_ID + ":" + id, "inventory"));
		}
	}
	
	@Override
	public void addModelRegistrationCandidate(Item item, IItemModelRegisterable registerable) {
		modelRegistrationCandidates.add(new ModelRegistrationCandidate(item, registerable));
	}
	
	@SubscribeEvent
	public void onRegisterModels(ModelRegistryEvent e) {
		for (ModelRegistrationCandidate candidate : modelRegistrationCandidates) {
			candidate.registerable.registerItemModel(candidate.item);
		}
	}

}
