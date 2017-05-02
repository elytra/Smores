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

package com.elytradev.smores.registries;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {


    public static ItemBase itemIngot;
    public static ItemBase itemGem;
    public static ItemBase itemDust;
    public static ItemBase itemNugget;
    public static ItemBase itemPlate;
    public static ItemBase itemGear;

    public static void init()
    {
        itemIngot = registerItem(new ItemIngot()).setCreativeTab(Smores.smoresCreativeTab);
        itemGem = registerItem(new ItemGem()).setCreativeTab(Smores.smoresCreativeTab);
        itemDust = registerItem(new ItemDust()).setCreativeTab(Smores.smoresCreativeTab);
        itemNugget = registerItem(new ItemNugget()).setCreativeTab(Smores.smoresCreativeTab);
        itemPlate = registerItem(new ItemPlate()).setCreativeTab(Smores.smoresCreativeTab);
        itemGear = registerItem(new ItemGear()).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);

        if(item instanceof ItemBase)
        {
            ((ItemBase)item).registerItemModel();
        }
        if(item instanceof IOreDict)
        {
            ((IOreDict)item).registerOreDict();
        }
        return item;
    }
}
