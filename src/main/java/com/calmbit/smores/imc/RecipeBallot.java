package com.calmbit.smores.imc;

public class RecipeBallot implements IBallot<RecipeVoteCandidate,EnumRecipeVoteOption> {

    RecipeBallotBox ballotBox;

    public static RecipeBallot INSTANCE = new RecipeBallot();

    private RecipeBallot() {
        this.ballotBox = new RecipeBallotBox();
    }

    @Override
    public void registerCandidate(RecipeVoteCandidate candidate) {

    }

    @Override
    public void voteInBallot(RecipeVoteCandidate candidate, EnumRecipeVoteOption option) {
        this.ballotBox.vote(candidate, option);
    }

}
