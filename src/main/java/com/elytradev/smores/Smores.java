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

package com.elytradev.smores;

import com.elytradev.smores.block.*;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.generic.SmoresCreativeTab;
import com.elytradev.smores.init.SmoresBlocks;
import com.elytradev.smores.item.*;
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumGem;
import com.elytradev.smores.materials.EnumMetal;
import com.elytradev.smores.materials.EnumNether;
import com.elytradev.smores.proxy.CommonProxy;
import com.elytradev.smores.registries.ConfigurationRegistry;
import com.elytradev.smores.registries.FluidRegistry;
import com.elytradev.smores.world.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Smores.MOD_ID,
        name = Smores.NAME,
        version = Smores.VERSION,
        guiFactory = "com.elytradev.smores.gui.SmoresGuiFactory")
@Mod.EventBusSubscriber
public final class Smores {

    public static final String MOD_ID = "smores";
    public static final String NAME = "Smores";
    public static final String VERSION = "1.12-0.1.0";

    public static final Logger LOG = LogManager.getLogger(Smores.NAME);

    @SidedProxy(
            clientSide = "com.elytradev.smores.proxy.ClientProxy",
            serverSide = "com.elytradev.smores.proxy.CommonProxy")
    public static CommonProxy PROXY;

    public static final CreativeTabs CREATIVE_TAB = new SmoresCreativeTab(Smores.MOD_ID);

    public static Configuration CONFIG;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        registerBlock(event.getRegistry(), new BlockMetalOre().setCreativeTab(CREATIVE_TAB));
        registerBlock(event.getRegistry(), new BlockGemOre().setCreativeTab(CREATIVE_TAB));
        registerBlock(event.getRegistry(), new BlockNetherOre().setCreativeTab(CREATIVE_TAB));
        registerBlock(event.getRegistry(), new BlockMetal().setCreativeTab(CREATIVE_TAB));
        registerBlock(event.getRegistry(), new BlockAlloy().setCreativeTab(CREATIVE_TAB));
        registerBlock(event.getRegistry(), new BlockGem().setCreativeTab(CREATIVE_TAB));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // item blocks
        registerItemBlock(event.getRegistry(), SmoresBlocks.metal_ore, EnumMetal.class);
        registerItemBlock(event.getRegistry(), SmoresBlocks.gem_ore, EnumGem.class);
        registerItemBlock(event.getRegistry(), SmoresBlocks.nether_ore, EnumNether.class);
        registerItemBlock(event.getRegistry(), SmoresBlocks.metal_block, EnumMetal.class);
        registerItemBlock(event.getRegistry(), SmoresBlocks.alloy_block, EnumAlloy.class);
        registerItemBlock(event.getRegistry(), SmoresBlocks.gem_block, EnumGem.class);

        // items
        registerItem(event.getRegistry(), new ItemIngot().setCreativeTab(CREATIVE_TAB));
        registerItem(event.getRegistry(), new ItemGem().setCreativeTab(CREATIVE_TAB));
        registerItem(event.getRegistry(), new ItemDust().setCreativeTab(CREATIVE_TAB));
        registerItem(event.getRegistry(), new ItemNugget().setCreativeTab(CREATIVE_TAB));
        registerItem(event.getRegistry(), new ItemPlate().setCreativeTab(CREATIVE_TAB));
        registerItem(event.getRegistry(), new ItemGear().setCreativeTab(CREATIVE_TAB));
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CONFIG = new Configuration(event.getSuggestedConfigurationFile());
        ConfigurationRegistry.init(CONFIG);
        FluidRegistry.init();
        PROXY.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    private static void registerBlock(IForgeRegistry<Block> registry, Block block) {
        registry.register(block);
    }

    private static void registerItem(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase) item).registerItemModel();
        } else if (item instanceof ItemBlock &&
                ((ItemBlock) item).getBlock() instanceof BlockBase) {
            ((BlockBase) ((ItemBlock) item).getBlock()).registerItemModel(((ItemBlock) item));
        } else {
            final ResourceLocation loc = Item.REGISTRY.getNameForObject(item);
            PROXY.registerItemRenderer(item, 0, loc.getResourcePath());
        }

        if (item instanceof IOreDict) {
            ((IOreDict) item).registerOreDict();
        } else if (item instanceof ItemBlock &&
                ((ItemBlock) item).getBlock() instanceof IOreDict) {
            ((IOreDict) ((ItemBlock) item).getBlock()).registerOreDict();
        }
    }

    private static <V extends Enum<V>> void registerItemBlock(IForgeRegistry<Item> registry, Block block, Class<V> enumClass) {
        registerItem(registry, new ItemBlockSubtyped<>(block, enumClass));
    }

}
