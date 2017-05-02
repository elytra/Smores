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

package com.elytradev.smores;

import com.elytradev.smores.generic.SmoresCreativeTab;
import com.elytradev.smores.proxy.CommonProxy;
import com.elytradev.smores.registries.*;
import com.elytradev.smores.world.WorldGen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Smores.SMORES_MOD_ID, name = Smores.SMORES_NAME, version = Smores.SMORES_VERSION, guiFactory = "SmoresGuiFactory")
public class Smores {
    public static final String SMORES_MOD_ID = "smores";
    public static final String SMORES_NAME = "Smores";
    public static final String SMORES_VERSION = "1.11.2-1.0.0.0";

    public static final SmoresCreativeTab smoresCreativeTab = new SmoresCreativeTab(SMORES_MOD_ID);

    @Mod.Instance(SMORES_MOD_ID)
    public static Smores instance;

    public static Configuration CONFIG;

    @SidedProxy(clientSide = "ClientProxy", serverSide = "CommonProxy")
    public static CommonProxy proxy;

    public static final Logger LOG = LogManager.getLogger(SMORES_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println(SMORES_NAME + " is starting up!");
        CONFIG = new Configuration(event.getSuggestedConfigurationFile());
        ConfigurationRegistry.init(CONFIG);
        BlockRegistry.init();
        ItemRegistry.init();
        FluidRegistry.init();
        proxy.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
        RecipeRegistry.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void onIMC(FMLInterModComms.IMCEvent event) {
        for(FMLInterModComms.IMCMessage message : event.getMessages()) {
            
        }
    }
}
