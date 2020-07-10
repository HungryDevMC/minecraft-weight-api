package be.jflanders.mcweight;

import be.jflanders.mcweight.Main;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public enum ConfigurationFile {

    CONFIG("config.yml");

    @Getter
    private String path;

    public FileConfiguration value() {
        return YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder(), path));
    }

    /**
     * Copies yml configuration files from resources to the plugin server folder when they exist,
     * otherwise it creates an empty configuration file
     */
    public static void createDefaults() throws IOException {
        for (ConfigurationFile configuration : ConfigurationFile.values()) {
            File customConfigFile = new File(Main.getInstance().getDataFolder(), configuration.path);
            if (!customConfigFile.exists()) {
                if (Main.getInstance().getResource(configuration.path) != null) {
                    Main.getInstance().saveResource(configuration.path, false);
                } else {
                    configuration.value().save(customConfigFile);
                }
            }
        }
    }

}