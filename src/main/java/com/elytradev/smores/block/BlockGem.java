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

package com.elytradev.smores.block;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumGem;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Locale;

public class BlockGem extends BlockBase implements IOreDict {

    public static PropertyEnum<EnumGem> GEM = PropertyEnum.create("gem", EnumGem.class);

    public BlockGem() {
        super(Material.IRON, "gem_block");
        this.setHardness(5.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.getDefaultState().withProperty(GEM, EnumGem.RUBY));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GEM);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(GEM).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(GEM, EnumGem.values()[meta]);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        int iterator = 0;
        for (EnumGem gem : EnumGem.values()) {
            items.add(new ItemStack(this, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block) {
        int iterator = 0;
        for (EnumGem material : EnumGem.values()) {
            Smores.PROXY.registerItemRenderer(block, iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }

    @Override
    public void registerOreDict() {
        for (EnumGem material : EnumGem.values()) {
            OreDictionary.registerOre("block" + material.getMaterialName(), new ItemStack(this, 1, material.getId()));
        }
    }

}
