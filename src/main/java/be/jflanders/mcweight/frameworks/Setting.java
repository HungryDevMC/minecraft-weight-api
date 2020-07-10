package be.jflanders.mcweight.frameworks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sun.security.krb5.Config;

import java.util.HashMap;

@AllArgsConstructor
@Getter
public enum Setting {

    WEIGHT_ACACIA_DOOR(ConfigurationFile.WEIGHT, "acacia_door");

    public static final HashMap<Setting, String> CONFIGURATION_VALUES = new HashMap<>();

    private ConfigurationFile ymlFile;
    private String valuePath;

    public String value() {
        return CONFIGURATION_VALUES.get(this);
    }

    public int intValue() {
        return Integer.parseInt(CONFIGURATION_VALUES.get(this));
    }

    public double doubleValue() {
        return Double.parseDouble(CONFIGURATION_VALUES.get(this));
    }

    public boolean booleanValue() {
        return Boolean.parseBoolean(CONFIGURATION_VALUES.get(this));
    }

}
