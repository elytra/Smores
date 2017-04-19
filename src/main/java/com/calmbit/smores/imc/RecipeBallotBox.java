package com.calmbit.smores.imc;

import com.calmbit.smores.Smores;

import java.util.HashMap;

public class RecipeBallotBox implements IBallotBox<RecipeVoteCandidate, EnumRecipeVoteOption> {

    private HashMap<RecipeVoteCandidate, HashMap<EnumRecipeVoteOption, Integer>> ballotBox =
            new HashMap<RecipeVoteCandidate, HashMap<EnumRecipeVoteOption, Integer>>();

    @Override
    public void vote(RecipeVoteCandidate candidate, EnumRecipeVoteOption option) {
        if (this.ballotBox.containsKey(candidate)) {
            this.ballotBox.get(candidate).put(option, this.ballotBox.get(candidate).get(option)+1);
        }
        else {
            Smores.LOG.error("Ballot box error - candidate for RecipeBallotBox " +  candidate.toString() + " wasn't registered!");
        }
    }

    @Override
    public Object getUnderlyingBox() {
        return ballotBox;
    }
}
