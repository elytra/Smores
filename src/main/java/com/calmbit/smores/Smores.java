package com.calmbit.smores;

import com.calmbit.smores.generic.SmoresCreativeTab;
import com.calmbit.smores.proxy.CommonProxy;
import com.calmbit.smores.registries.BlockRegistry;
import com.calmbit.smores.registries.FluidRegistry;
import com.calmbit.smores.registries.ItemRegistry;
import com.calmbit.smores.registries.RecipeRegistry;
import com.calmbit.smores.world.WorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Smores.SMORES_MOD_ID, name = Smores.SMORES_NAME, version = Smores.SMORES_VERSION)
public class Smores {
    public static final String SMORES_MOD_ID = "smores";
    public static final String SMORES_NAME = "Smores";
    public static final String SMORES_VERSION = "1.11.2-1.0.0.0";

    public static final SmoresCreativeTab smoresCreativeTab = new SmoresCreativeTab(SMORES_MOD_ID);

    @Mod.Instance(SMORES_MOD_ID)
    public static Smores instance;

    @SidedProxy(clientSide = "com.calmbit.smores.proxy.ClientProxy", serverSide = "com.calmbit.smores.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger LOG = LogManager.getLogger(SMORES_NAME);


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println(SMORES_NAME + " is starting up!");
        BlockRegistry.init();
        ItemRegistry.init();
        FluidRegistry.init();
        proxy.init();
        RecipeRegistry.init();
        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
