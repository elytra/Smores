package com.calmbit.smores.imc;

public interface IBallot<T, V extends Enum> {
    void registerCandidate(T candidate);
    void voteInBallot(T candidate, V option);
}
