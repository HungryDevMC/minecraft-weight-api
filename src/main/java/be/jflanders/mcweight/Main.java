package be.jflanders.mcweight;

import be.jflanders.mcweight.frameworks.ConfigurationFile;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        try {
            ConfigurationFile.createDefaults();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            getInstance().getServer().shutdown();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}