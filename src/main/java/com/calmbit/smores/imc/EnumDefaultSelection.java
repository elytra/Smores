package com.calmbit.smores.imc;

import com.sun.javaws.exceptions.InvalidArgumentException;

public enum EnumDefaultSelection {
    IMC,
    OFF,
    ON;

    public static EnumDefaultSelection fromString(String string) throws InvalidArgumentException {
        for(EnumDefaultSelection selection : EnumDefaultSelection.values()) {
            if(selection.toString().toLowerCase() == string.toLowerCase())
                return selection;
        }
        throw new InvalidArgumentException(new String[]{"Invalid value for EnumDefaultSelection - " + string});
    }
}
