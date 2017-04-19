package com.calmbit.smores.imc;

import com.calmbit.smores.Smores;
import com.sun.javaws.exceptions.InvalidArgumentException;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class IMCHandler {

    public static void handleIMCMessage(FMLInterModComms.IMCMessage message) {
        final String[] split = message.key.split("\\(");

        if(split.length <= 0) {
            Smores.LOG.error("IMC Error - " + message.key + " doesn't seem to split correctly...");
            return;
        }

        switch(split[0]) {
            case "setRecipeEnabled":
                if(!message.isStringMessage())
                {
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
        if(candidate != null) {
            Boolean vote = key.matches("setRecipeEnabled\\(true\\)");
            try {
                RecipeBallot.INSTANCE.voteInBallot(candidate, vote);
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
