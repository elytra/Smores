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

package com.elytradev.smores.registries;

import com.elytradev.smores.imc.EnumResourceSelection;
import net.minecraftforge.common.config.Configuration;

import java.util.HashMap;

public class SmoresConfiguration {

	public static final String CATEGORY_OVERRIDES = "overrides";

	public static String defaultConfiguration;
	public static HashMap<String, EnumResourceSelection> resourceConfigurations = new HashMap<>();
	public static HashMap<String, EnumResourceSelection> overridingDefaults = new HashMap<>();

	public static void init(Configuration config) {
		/*try {
			config.load();

			Property defaultProperty = config.get(Configuration.CATEGORY_GENERAL, "default", "imc");
			defaultConfiguration = defaultProperty.getString();

			for (EnumItem item : EnumItem.values()) {
				String key = "all" + item.getName() + "s";
				Property itemProperty = config.get(CATEGORY_OVERRIDES, key, "unchanged");
				overridingDefaults.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
			}

			for (EnumAlloy alloy : EnumAlloy.values()) {
				for (EnumItem type : alloy.getTypes()) {
					String key = type.getName().toLowerCase(Locale.ROOT) + alloy.getMaterialName();
					Property itemProperty = config.get(CATEGORY_OVERRIDES + "." + type.getName().toLowerCase(Locale.ROOT),
							key, "unchanged");
					resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
				}
			}

			for (EnumGem gem : EnumGem.values()) {
				for (EnumItem type : gem.getTypes()) {
					String key = type.getName().toLowerCase(Locale.ROOT) + gem.getMaterialName();
					Property itemProperty = config.get(CATEGORY_OVERRIDES + "." + type.getName().toLowerCase(Locale.ROOT),
							key, "unchanged");
					resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
				}
			}

			for (EnumMetal metal : EnumMetal.values()) {
				for (EnumItem type : metal.getTypes()) {
					String key = type.getName().toLowerCase(Locale.ROOT) + metal.getMaterialName();
					Property itemProperty = config.get(CATEGORY_OVERRIDES + "." + type.getName().toLowerCase(Locale.ROOT),
							key, "unchanged");
					resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
				}
			}

			for (EnumMisc misc : EnumMisc.values()) {
				for (EnumItem type : misc.getTypes()) {
					String key = type.getName().toLowerCase(Locale.ROOT) + misc.getMaterialName();
					Property itemProperty = config.get(CATEGORY_OVERRIDES + "." + type.getName().toLowerCase(Locale.ROOT),
							key, "unchanged");
					resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
				}
			}

			for (EnumNether nether : EnumNether.values()) {
				for (EnumItem type : nether.getTypes()) {
					String key = type.getName().toLowerCase(Locale.ROOT) + nether.getMaterialName();
					Property itemProperty = config.get(CATEGORY_OVERRIDES + "." + type.getName().toLowerCase(Locale.ROOT),
							key, "unchanged");
					resourceConfigurations.put(key, EnumResourceSelection.fromString(itemProperty.getString()));
				}
			}
		} catch (Exception e) {
			Smores.LOG.error(e.getMessage());
		}*/
	}
}
