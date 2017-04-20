package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.imc.EnumResourceSelection;
import com.calmbit.smores.materials.EnumItemType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.HashMap;

public class ConfigurationRegistry {

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
                Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, key , "unchanged");
                overridingDefaults.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
            }

        }
        catch(Exception e) {
            Smores.LOG.error(e.getMessage());
        }
    }
}
