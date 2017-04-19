package com.calmbit.smores.imc;

import com.calmbit.smores.Smores;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class IMCHandler {

    public static void handleIMCMessage(FMLInterModComms.IMCMessage message) {
        final String[] split = message.key.split("@");

        if(split.length <= 0) {
            Smores.LOG.error("IMC Error - " + message.key + " doesn't seem to split correctly...");
            return;
        }

        switch(split[0]) {
            case "voteRecipe":
                if(!message.isStringMessage())
                {
                    Smores.LOG.error("IMC Error - voteRecipe requires a string message, got " + message.getMessageType().toString());
                    return;
                }
                handleRecipeVote(message.key.replaceFirst("voteRecipe@",""), message.getStringValue());
                break;
        }
    }

    private static void handleRecipeVote(String key, String value) {
        RecipeVoteCandidate candidate = RecipeVoteCandidate.getRecipeCandidate(key);
        EnumRecipeVoteOption option = EnumRecipeVoteOption.fromString(value);

        if(candidate != null) {
            RecipeBallot.INSTANCE.voteInBallot(candidate, option);
        }
    }
}
