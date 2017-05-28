/*
 * The MIT License (MIT)
 * =====================
 *
 * Copyright © 2017:
 *  Ethan Brooks (CalmBit),
 *  Isaac Ellingson (Falkreon),
 *  and contributors
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.elytradev.smores.world;

import com.elytradev.smores.blocks.BlockMetalOre;
import com.elytradev.smores.blocks.BlockNetherOre;
import com.elytradev.smores.materials.EnumMetal;
import com.elytradev.smores.materials.EnumNether;
import com.elytradev.smores.registries.BlockRegistry;
import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.ChunkProviderOverworld;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(chunkGenerator instanceof ChunkProviderOverworld) {
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.COPPER), 10, 32, 64, 8, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.TIN), 12, 16, 48, 6, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.LEAD), 12, 16, 64, 6, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.SILVER), 8, 4, 24, 6, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.NICKEL), 20, 16, 64, 4, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.PLATINUM), 5, 4, 32, 6, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.MITHRIL), 4, 16, 64, 5, BlockMatcher.forBlock(Blocks.STONE));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMetal.ZINC), 15, 16, 64, 6, BlockMatcher.forBlock(Blocks.STONE));
        }
        else if(chunkGenerator instanceof ChunkProviderHell) {
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockNetherOre.MATERIAL, EnumNether.NITRE), 20, 0, 128, 4, BlockMatcher.forBlock(Blocks.NETHERRACK));
            generateOre(world, random, chunkX, chunkZ, BlockRegistry.blockMetalOre.getDefaultState().withProperty(BlockNetherOre.MATERIAL, EnumNether.SULFUR), 30, 0, 32, 6, BlockMatcher.forBlock(Blocks.NETHERRACK));
        }
    }

    private void generateOre(World world, Random rand, int chunkX, int chunkZ, IBlockState blockState, int chances, int yMin, int yMax, int veinSize, Predicate<IBlockState> replacementPredicate)
    {
        int range = yMax-yMin;
        for(int i=0;i< chances;i++)
        {
            BlockPos pos = new BlockPos((chunkX*16) + rand.nextInt(16), yMin + rand.nextInt(range), (chunkZ*16) + rand.nextInt(16));
            WorldGenMinable oreGen = new WorldGenMinable(blockState, veinSize, replacementPredicate);
            oreGen.generate(world, rand, pos);
        }
    }
}
