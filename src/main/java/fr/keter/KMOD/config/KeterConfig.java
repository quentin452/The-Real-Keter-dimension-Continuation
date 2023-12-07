package fr.keter.KMOD.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.keter.KMOD.Main.KMOD_Main;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class KeterConfig {
    public static Configuration config;
    private static final List<ConfigCategory> allCategories = new ArrayList();
    private static String CATEOGY_BIOMES;

    public static int utumnoid;

    private static void setupCategories() {
        CATEOGY_BIOMES = makeCategory("biome ids");
    }

    private static String makeCategory(String name) {
        ConfigCategory category = config.getCategory(name);
        category.setLanguageKey(KMOD_Main.getModContainer().getModId() + ".config." + name);
        allCategories.add(category);
        return name;
    }

    public static void setupAndLoad(FMLPreInitializationEvent event) {
        config = new Configuration(new File(event.getModConfigurationDirectory(), "therealketer.cfg"));
        setupCategories();
        load();
    }


    public static void load() {
        utumnoid = config.get(CATEOGY_BIOMES, "BiomeGenBaseKeter", 100, "Biome id config").getInt();
        if (config.hasChanged()) {
            config.save();
        }
    }
}
