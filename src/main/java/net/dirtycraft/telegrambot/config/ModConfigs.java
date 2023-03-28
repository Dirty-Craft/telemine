package net.dirtycraft.telegrambot.config;

import com.mojang.datafixers.util.Pair;
import net.dirtycraft.telegrambot.TelegramBot;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String BOT_TOKEN;
    public static String GROUP_ID;
    public static boolean ENABLED;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(TelegramBot.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("telegram_bot_token", "<put the bot token here>"), "String");
        configs.addKeyValuePair(new Pair<>("telegram_group_id", "<put the group id here>"), "String");
        configs.addKeyValuePair(new Pair<>("enabled", false), "boolean");
    }

    private static void assignConfigs() {
        BOT_TOKEN = CONFIG.getOrDefault("telegram_bot_token", "");
        GROUP_ID = CONFIG.getOrDefault("telegram_group_id", "");
        ENABLED = CONFIG.getOrDefault("enabled", false);

        TelegramBot.LOGGER.info("All " + configs.getConfigsList().size() + " have been set properly");
    }
}