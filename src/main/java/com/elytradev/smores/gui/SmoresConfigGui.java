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

package com.elytradev.smores.gui;

import com.elytradev.smores.Smores;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class SmoresConfigGui extends GuiConfig {

	public SmoresConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getCategories(), Smores.MOD_ID, false, true, "Smores Config");
	}

	public static List<IConfigElement> getCategories() {
		List<IConfigElement> categories = new ArrayList<>();

		// TODO: New Concrete config system?
		/*categories.addAll(new ConfigElement(Smores.CONFIG.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements());

		ConfigElement overrides = new ConfigElement(Smores.CONFIG.getCategory(SmoresConfiguration.CATEGORY_OVERRIDES));
		for (EnumItem item : EnumItem.values()) {
			overrides.getChildElements().add(new ConfigElement(
					Smores.CONFIG.getCategory(SmoresConfiguration.CATEGORY_OVERRIDES + "." + item.getName().toLowerCase(Locale.ROOT))));
		}

		categories.add(overrides);*/
		return categories;
	}

}
