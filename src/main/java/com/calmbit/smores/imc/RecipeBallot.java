package com.calmbit.smores.imc;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;

public class RecipeBallot implements IBallot<RecipeVoteCandidate,Boolean> {

    private HashMap<RecipeVoteCandidate, HashMap<Boolean, Integer>> ballotBox ;


    public static RecipeBallot INSTANCE = new RecipeBallot();

    private RecipeBallot() {
        this.ballotBox = new HashMap<>();
    }

    @Override
    public void registerCandidate(RecipeVoteCandidate candidate) {
        this.ballotBox.put(candidate, new HashMap<>());
    }

    @Override
    public void voteInBallot(RecipeVoteCandidate candidate, Boolean option) throws InvalidArgumentException {
        if(!ballotBox.containsKey(candidate)) {
            throw new InvalidArgumentException(new String[]{"Candidate " + candidate.recipeName + " hasn't been registered in the ballot"});
        }
        this.ballotBox.get(candidate).put(option, this.ballotBox.get(candidate).get(option)+1);
    }

}
