package com.calmbit.smores.imc;

import com.calmbit.smores.Smores;
import net.minecraft.item.crafting.IRecipe;

import java.util.HashMap;

public class RecipeVoteCandidate {
    private static HashMap<String, RecipeVoteCandidate> RECIPE_CANDIDATES = new HashMap<>();

    public String recipeName;
    public IRecipe recipeImpl;

    public RecipeVoteCandidate(String recipeName, IRecipe recipeImpl) {
        this.recipeName = recipeName;
        this.recipeImpl = recipeImpl;
    }

    public static void registerRecipeCandidate(RecipeVoteCandidate candidate) {
        RECIPE_CANDIDATES.put(candidate.recipeName, candidate);
    }

    public static RecipeVoteCandidate getRecipeCandidate(String recipeName) {
        if(!RECIPE_CANDIDATES.containsKey(recipeName)) {
            Smores.LOG.error("RecipeVoteCandidate error - cannot find candidate with name " + recipeName);
            return null;
        }

        return RECIPE_CANDIDATES.get(recipeName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  RecipeVoteCandidate) {
            return ((RecipeVoteCandidate)obj).recipeName == this.recipeName;
        }
        return false;
    }
}
