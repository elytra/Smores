package com.calmbit.smores.imc;

import java.util.Locale;

public enum EnumDefaultSelection {
    IMC,
    OFF,
    ON;

    public static EnumDefaultSelection fromString(String string) {
        for(EnumDefaultSelection selection : EnumDefaultSelection.values()) {
            if(selection.toString().toLowerCase(Locale.ROOT) == string.toLowerCase(Locale.ROOT))
                return selection;
        }
        throw new IllegalArgumentException("Invalid value for EnumDefaultSelection - " + string);
    }
}
