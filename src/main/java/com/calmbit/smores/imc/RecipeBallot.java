package com.calmbit.smores.imc;

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
