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

package com.elytradev.smores.world;

import com.elytradev.smores.block.BlockMetalOre;
import com.elytradev.smores.block.BlockNetherOre;
import com.elytradev.smores.init.SmoresBlocks;
import com.elytradev.smores.materials.EnumMaterial;
import com.google.common.base.Predicate;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

	private static final Predicate<IBlockState> IS_BLOCK_ROCK = (blockState) -> blockState.getMaterial() == Material.ROCK;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (chunkGenerator instanceof ChunkGeneratorOverworld) {
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.COPPER),
					10, 32, 64, 8, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.TIN), 12,
					16, 48, 6, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.LEAD), 12,
					16, 64, 6, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.SILVER),
					8, 4, 24, 6, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.NICKEL),
					20, 16, 64, 4, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.PLATINUM),
					5, 4, 32, 6, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.MITHRIL),
					4, 16, 64, 5, IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ, SmoresBlocks.metal_ore.getDefaultState().withProperty(BlockMetalOre.METAL, EnumMaterial.ZINC), 15,
					16, 64, 6, IS_BLOCK_ROCK);
		} else if (chunkGenerator instanceof ChunkGeneratorHell) {
			generateOre(world, random, chunkX, chunkZ,
					SmoresBlocks.nether_ore.getDefaultState().withProperty(BlockNetherOre.MINERAL, EnumMaterial.NITRE), 30, 0, 128, 4,
					IS_BLOCK_ROCK);
			generateOre(world, random, chunkX, chunkZ,
					SmoresBlocks.nether_ore.getDefaultState().withProperty(BlockNetherOre.MINERAL, EnumMaterial.SULFUR), 30, 0, 48, 6,
					IS_BLOCK_ROCK);
		}
	}

	private void generateOre(World world, Random rand, int chunkX, int chunkZ, IBlockState blockState, int chances, int yMin, int yMax, int veinSize,
			Predicate<IBlockState> replacementPredicate) {
		int range = yMax - yMin;
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos((chunkX * 16) + rand.nextInt(16), yMin + rand.nextInt(range), (chunkZ * 16) + rand.nextInt(16));
			WorldGenMinable oreGen = new WorldGenMinable(blockState, veinSize, replacementPredicate);
			oreGen.generate(world, rand, pos);
		}
	}

}
