package com.calmbit.smores.imc;

import com.sun.javaws.exceptions.InvalidArgumentException;

public enum EnumResourceSelection {
    UNCHANGED,
    FORCE_ON,
    FORCE_OFF,
    FORCE_ON_NORECIPE,
    FORCE_ON_RECIPE;

    public static EnumResourceSelection fromString(String string) throws InvalidArgumentException {
        for(EnumResourceSelection selection : EnumResourceSelection.values()) {
            if(selection.toString().toLowerCase().equals(string.toLowerCase()))
                return selection;
        }
        throw new InvalidArgumentException(new String[]{"Invalid value for EnumResourceSelection - " + string});
    }
}
