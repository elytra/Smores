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

package com.elytradev.smores.imc;

import com.elytradev.smores.Smores;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class IMCHandler {

	public static void handleIMCMessage(FMLInterModComms.IMCMessage message) {
		final String[] split = message.key.split("\\(");

		if (split.length <= 0) {
			Smores.LOG.error("IMC Error - " + message.key + " doesn't seem to split correctly...");
			return;
		}

		switch (split[0]) {
			case "setRecipeEnabled":
				if (!message.isStringMessage()) {
					Smores.LOG.error("IMC Error - voteRecipe requires a string message, got " + message.getMessageType().toString());
					return;
				}
				handleRecipeVote(message.key, message.getStringValue());
				break;
		}
	}

	private static void handleRecipeVote(String key, String value) {
		RecipeVoteCandidate candidate = RecipeVoteCandidate.getRecipeCandidate(value);

		// Really stupid temporary hack, plzfix
		if (candidate != null) {
			Boolean vote = key.matches("setRecipeEnabled\\(true\\)");
			try {
				RecipeBallot.INSTANCE.voteInBallot(candidate, vote);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

}
