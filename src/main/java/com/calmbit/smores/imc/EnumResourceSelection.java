package com.calmbit.smores.imc;

import java.util.Locale;

public enum EnumResourceSelection {
    UNCHANGED,
    FORCE_ON,
    FORCE_OFF,
    FORCE_ON_NORECIPE,
    FORCE_ON_RECIPE;

    public static EnumResourceSelection fromString(String string) {
        for(EnumResourceSelection selection : EnumResourceSelection.values()) {
            if(selection.toString().toLowerCase(Locale.ROOT).equals(string.toLowerCase(Locale.ROOT)))
                return selection;
        }
        throw new IllegalArgumentException("Invalid value for EnumResourceSelection - " + string);
    }
}
