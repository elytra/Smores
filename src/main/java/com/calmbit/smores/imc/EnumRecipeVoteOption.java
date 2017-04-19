package com.calmbit.smores.imc;

public enum EnumRecipeVoteOption {
    INVALID,
    ON,
    NO_RECIPE;

    public static EnumRecipeVoteOption fromString(String str) {
        str = str.toLowerCase();
        switch(str) {
            case "on":
                return ON;
            case "no_recipe":
                return NO_RECIPE;
            default:
                return INVALID;
        }
    }
}
