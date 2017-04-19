package com.calmbit.smores.imc;


public interface IBallotBox<T, V extends Enum> {
    void vote(T candidate, V option);
    Object getUnderlyingBox();
}
