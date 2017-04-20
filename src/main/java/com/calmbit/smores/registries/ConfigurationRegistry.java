package com.calmbit.smores.registries;

import com.calmbit.smores.imc.EnumResourceSelection;
import com.calmbit.smores.materials.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.ArrayList;
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

            for(EnumAlloyType alloy : EnumAlloyType.values()) {
                ArrayList<String> entries = alloy.getAllOreDictEntries();
                for(String entry : entries) {
                    Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, entry, "unchanged");
                    resourceConfigurations.put(entry, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumGemType gem : EnumGemType.values()) {
                ArrayList<String> entries = gem.getAllOreDictEntries();
                for(String entry : entries) {
                    Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, entry, "unchanged");
                    resourceConfigurations.put(entry, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMetalType metal : EnumMetalType.values()) {
                ArrayList<String> entries = metal.getAllOreDictEntries();
                for(String entry : entries) {
                    Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, entry, "unchanged");
                    resourceConfigurations.put(entry, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumMiscType misc : EnumMiscType.values()) {
                ArrayList<String> entries = misc.getAllOreDictEntries();
                for(String entry : entries) {
                    Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, entry, "unchanged");
                    resourceConfigurations.put(entry, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

            for(EnumNetherType nether : EnumNetherType.values()) {
                ArrayList<String> entries = nether.getAllOreDictEntries();
                for(String entry : entries) {
                    Property itemProperty = config.get(Configuration.CATEGORY_GENERAL, entry, "unchanged");
                    resourceConfigurations.put(entry, EnumResourceSelection.fromString(itemProperty.getString()));
                }
            }

        } catch(Exception e) {

        }
    }
}
