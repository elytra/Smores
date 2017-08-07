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

package com.elytradev.smores.blocks;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.items.ItemDust;
import com.elytradev.smores.materials.EnumNether;
import com.elytradev.smores.registries.ItemRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BlockNetherOre extends BlockBase implements IOreDict {

    public static PropertyEnum<EnumNether> MATERIAL = PropertyEnum.create("material", EnumNether.class);

    public BlockNetherOre() {
        super(Material.ROCK, "nether_ore");
        this.setHardness(3.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.getDefaultState().withProperty(MATERIAL, EnumNether.SULFUR));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MATERIAL);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(MATERIAL).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumNether.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        int iterator = 0;
        for(EnumNether material : EnumNether.values()) {
            list.add(new ItemStack(itemIn, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumNether material : EnumNether.values()) {
            Smores.PROXY.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(ItemRegistry.itemDust, 1 + RANDOM.nextInt(3), ItemDust.getMaterialIndex(state.getValue(MATERIAL).getMaterialName())));
        return drops;
    }


    @Override
    public void registerOreDict() {
        for(EnumNether material : EnumNether.values()) {
            OreDictionary.registerOre("ore"+material.getMaterialName(), new ItemStack(this, 1, material.getId()));
        }
    }
}
