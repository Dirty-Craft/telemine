package net.dirtycraft.telegrambot.config;

import com.mojang.datafixers.util.Pair;
import net.dirtycraft.telegrambot.TelegramBot;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String BOT_TOKEN;
    public static String PROXY_TYPE;
    public static String PROXY_HOST;
    public static String PROXY_PORT;
    public static String GROUP_ID;
    public static boolean ENABLED;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(TelegramBot.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("telegram_bot_token", ""), "String");
        configs.addKeyValuePair(new Pair<>("telegram_group_id", ""), "String");
        configs.addKeyValuePair(new Pair<>("proxy_type", ""), "String");
        configs.addKeyValuePair(new Pair<>("proxy_host", ""), "String");
        configs.addKeyValuePair(new Pair<>("proxy_port", ""), "String");
        configs.addKeyValuePair(new Pair<>("enabled", false), "boolean");
    }

    private static void assignConfigs() {
        BOT_TOKEN = CONFIG.getOrDefault("telegram_bot_token", "");
        GROUP_ID = CONFIG.getOrDefault("telegram_group_id", "");
        ENABLED = CONFIG.getOrDefault("enabled", false);
        PROXY_TYPE = CONFIG.getOrDefault("proxy_type", "");
        PROXY_HOST = CONFIG.getOrDefault("proxy_host", "");
        PROXY_PORT = CONFIG.getOrDefault("proxy_port", "");

        TelegramBot.LOGGER.info("All " + configs.getConfigsList().size() + " config options have been set properly");
    }
}