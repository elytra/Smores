package com.calmbit.smores.gui;

import com.calmbit.smores.Smores;
import com.calmbit.smores.materials.EnumItem;
import com.calmbit.smores.registries.ConfigurationRegistry;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SmoresConfigGui extends GuiConfig {
    public SmoresConfigGui(GuiScreen parentScreen) {
        super(parentScreen, getCategories(), Smores.SMORES_MOD_ID, false, true, "Smores Config");
    }

    public static List<IConfigElement> getCategories() {
        List<IConfigElement> categories = new ArrayList<>();

        for(IConfigElement element : new ConfigElement(Smores.CONFIG.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements())
        {
            categories.add(element);
        }

        ConfigElement overrides = new ConfigElement(Smores.CONFIG.getCategory(ConfigurationRegistry.CATEGORY_OVERRIDES));
        for(EnumItem item : EnumItem.values()) {
            overrides.getChildElements().add(new ConfigElement(Smores.CONFIG.getCategory(ConfigurationRegistry.CATEGORY_OVERRIDES+"."+item.getName().toLowerCase(Locale.ROOT))));
        }

        categories.add(overrides);
        return categories;
    }
}
