package be.jflanders.mcweight;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        try {
            ConfigurationFile.createDefaults();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            Main.getInstance().getServer().shutdown();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
