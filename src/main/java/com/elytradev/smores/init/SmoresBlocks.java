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

package com.elytradev.smores.init;

import com.elytradev.smores.Smores;
import com.elytradev.smores.block.BlockSubtyped;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * A final class containing all of the various blocks in Smores.
 */
@GameRegistry.ObjectHolder(Smores.MOD_ID)
public final class SmoresBlocks {

	public static final BlockSubtyped metal_ore = null;
	public static final BlockSubtyped gem_ore = null;
	public static final BlockSubtyped nether_ore = null;
	public static final BlockSubtyped metal_block = null;
	public static final BlockSubtyped alloy_block = null;
	public static final BlockSubtyped gem_block = null;

	private SmoresBlocks() {
	}

}
