/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017:
 *     Ethan Brooks (CalmBit),
 *     Isaac Ellingson (Falkreon),
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

package com.elytradev.smores.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.Locale;

public class ItemBlockSubtyped<T extends Enum<T>> extends ItemBlock {

    private T[] typedEnumConstants;

    public ItemBlockSubtyped(Block block, Class<T> enumClass) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        typedEnumConstants = enumClass.getEnumConstants();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + typedEnumConstants[stack.getItemDamage()].toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

}
