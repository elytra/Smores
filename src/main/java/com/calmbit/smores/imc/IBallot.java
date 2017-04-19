package com.calmbit.smores.imc;

import com.sun.javaws.exceptions.InvalidArgumentException;

public interface IBallot<T, V> {
    void registerCandidate(T candidate);
    void voteInBallot(T candidate, V option) throws InvalidArgumentException;
}
