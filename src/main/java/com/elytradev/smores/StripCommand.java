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

package com.elytradev.smores;

import java.util.Locale;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.chunk.Chunk;

public class StripCommand extends CommandBase {

	@Override
	public String getName() {
		return "strip";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "command.strip.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender instanceof EntityPlayer) {
			Chunk chunk = sender.getEntityWorld().getChunkFromBlockCoords(sender.getPosition());
			for(int y=0; y<256; y++) {
				for(int x=0; x<16; x++) {
					for(int z=0; z<16; z++) {
						IBlockState state = chunk.getBlockState(x, y, z);
						if (state.getBlock()==Blocks.BEDROCK) continue;
						ResourceLocation loc = state.getBlock().getRegistryName();
						if (loc!=null) {
							//Figure out if state is an ore
							String registryName = loc.getResourcePath().toLowerCase(Locale.ROOT);
							if (registryName.contains("ore")) {
								//Skip this block
							} else {
								BlockPos globalPos = new BlockPos(chunk.x << 4 | x & 15, y, chunk.z << 4 | z & 15);
								sender.getEntityWorld().setBlockToAir(globalPos);
								//chunk.setBlockState(new BlockPos(x,y,z), Blocks.AIR.getDefaultState());
							}
						}
					}
				}
			}
			chunk.markDirty();
		} else {
			
			sender.sendMessage(new TextComponentTranslation("command.strip.nonplayer"));
		}
	}

}
