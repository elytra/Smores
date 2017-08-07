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

package com.elytradev.smores.imc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class RecipeBallot {

    private HashMap<RecipeVoteCandidate, ArrayList<Optional<Boolean>>> ballotBox;


    public static RecipeBallot INSTANCE = new RecipeBallot();

    private RecipeBallot() {
        this.ballotBox = new HashMap<>();
    }

    public void registerCandidate(RecipeVoteCandidate candidate) {
        this.ballotBox.put(candidate, new ArrayList<>());
    }

    public void voteInBallot(RecipeVoteCandidate candidate, Boolean option) {
        if(!ballotBox.containsKey(candidate)) {
            throw new IllegalArgumentException("Candidate " + candidate.recipeName + " hasn't been registered in the ballot");
        }
        this.ballotBox.get(candidate).add(Optional.ofNullable(option));
    }

    public boolean tallyVotes(RecipeVoteCandidate candidate) {
        //Optional<Boolean> result =  ballotBox.get(candidate).stream().reduce(Optional.empty(), )
        return false;
    }

}
