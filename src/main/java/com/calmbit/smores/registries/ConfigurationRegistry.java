package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.imc.EnumResourceSelection;
import com.calmbit.smores.materials.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.HashMap;
import java.util.Locale;

public class ConfigurationRegistry {

    public static final String CATEGORY_OVERRIDES = "overrides";

    public static String defaultConfiguration;
    public static HashMap<String, EnumResourceSelection> resourceConfigurations = new HashMap<>();
    public static HashMap<String, EnumResourceSelection> overridingDefaults = new HashMap<>();

    public static void init(Configuration config) {
        try {
            config.load();

            Property defaultProperty = config.get(Configuration.CATEGORY_GENERAL, "default", "imc");
            defaultConfiguration = defaultProperty.getString();

            for(EnumItem item : EnumItem.values()) {
                String key  ="all"+item.getName()+"s";
                Property itemProperty = config.get(CATEGORY_OVERRIDES, key , "unchanged");
                overridingDefaults.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
            }

            for(EnumAlloy alloy : EnumAlloy.values()) {
                for(EnumItem type : alloy.getTypes()) {
                    String key = type.getName().toLowerCase(Locale.ROOT)+alloy.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(Locale.ROOT),
                           key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumGem gem : EnumGem.values()) {
                for(EnumItem type : gem.getTypes()) {
                    String key = type.getName().toLowerCase(Locale.ROOT)+gem.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(Locale.ROOT),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMetal metal : EnumMetal.values()) {
                for(EnumItem type : metal.getTypes()) {
                    String key = type.getName().toLowerCase(Locale.ROOT)+metal.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(Locale.ROOT),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMisc misc : EnumMisc.values()) {
                for(EnumItem type : misc.getTypes()) {
                    String key = type.getName().toLowerCase(Locale.ROOT)+misc.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(Locale.ROOT),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumNether nether : EnumNether.values()) {
                for(EnumItem type : nether.getTypes()) {
                    String key = type.getName().toLowerCase(Locale.ROOT)+nether.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(Locale.ROOT),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

        }
        catch(Exception e) {
            Smores.LOG.error(e.getMessage());
        }
    }
}
