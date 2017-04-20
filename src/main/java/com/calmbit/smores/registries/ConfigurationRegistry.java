package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.imc.EnumResourceSelection;
import com.calmbit.smores.materials.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.HashMap;

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

            for(EnumItemType item : EnumItemType.values()) {
                String key  ="all"+item.getName()+"s";
                Property itemProperty = config.get(CATEGORY_OVERRIDES, key , "unchanged");
                overridingDefaults.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
            }

            for(EnumAlloyType alloy : EnumAlloyType.values()) {
                for(EnumItemType type : alloy.getTypes()) {
                    String key = type.getName().toLowerCase()+alloy.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(),
                           key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumGemType gem : EnumGemType.values()) {
                for(EnumItemType type : gem.getTypes()) {
                    String key = type.getName().toLowerCase()+gem.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMetalType metal : EnumMetalType.values()) {
                for(EnumItemType type : metal.getTypes()) {
                    String key = type.getName().toLowerCase()+metal.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMiscType misc : EnumMiscType.values()) {
                for(EnumItemType type : misc.getTypes()) {
                    String key = type.getName().toLowerCase()+misc.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(),
                            key, "unchanged");
                    resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumNetherType nether : EnumNetherType.values()) {
                for(EnumItemType type : nether.getTypes()) {
                    String key = type.getName().toLowerCase()+nether.getMaterialName();
                    Property itemProperty = config.get(CATEGORY_OVERRIDES+"."+type.getName().toLowerCase(),
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
