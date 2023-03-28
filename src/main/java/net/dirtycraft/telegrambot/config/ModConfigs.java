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

    public static boolean FEATURE_STARTING_SERVER_MESSAGE;
    public static boolean FEATURE_SERVER_STARTED_AND_READY_MESSAGE;
    public static boolean FEATURE_PLAYER_JOIN_MESSAGES;
    public static boolean FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST;
    public static boolean FEATURE_PLAYER_LEAVE_MESSAGES;
    public static boolean FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST;
    public static boolean FEATURE_PLAYER_DEATH_MESSAGES;
    public static boolean FEATURE_ADVANCEMENT_MADE_MESSAGES;
    public static boolean FEATURE_TG_SEND_MESSAGE_COMMAND;

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

        configs.addKeyValuePair(new Pair<>("feature.starting_server_message", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.server_started_and_ready_message", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_join_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_join_message_show_online_players_list", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_message_show_online_players_list", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_death_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.advancement_made_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.tg_send_message_command", true), "boolean");
    }

    private static void assignConfigs() {
        BOT_TOKEN = CONFIG.getOrDefault("telegram_bot_token", "");
        GROUP_ID = CONFIG.getOrDefault("telegram_group_id", "");
        ENABLED = CONFIG.getOrDefault("enabled", false);
        PROXY_TYPE = CONFIG.getOrDefault("proxy_type", "");
        PROXY_HOST = CONFIG.getOrDefault("proxy_host", "");
        PROXY_PORT = CONFIG.getOrDefault("proxy_port", "");

        FEATURE_STARTING_SERVER_MESSAGE = CONFIG.getOrDefault("feature.starting_server_message", true);
        FEATURE_SERVER_STARTED_AND_READY_MESSAGE = CONFIG.getOrDefault("feature.server_started_and_ready_message", true);
        FEATURE_PLAYER_JOIN_MESSAGES = CONFIG.getOrDefault("feature.player_join_messages", true);
        FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_join_message_show_online_players_list", true);
        FEATURE_PLAYER_LEAVE_MESSAGES = CONFIG.getOrDefault("feature.player_leave_messages", true);
        FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_leave_message_show_online_players_list", true);
        FEATURE_PLAYER_DEATH_MESSAGES = CONFIG.getOrDefault("feature.player_death_messages", true);
        FEATURE_ADVANCEMENT_MADE_MESSAGES = CONFIG.getOrDefault("feature.advancement_made_messages", true);
        FEATURE_TG_SEND_MESSAGE_COMMAND = CONFIG.getOrDefault("feature.tg_send_message_command", true);

        TelegramBot.LOGGER.info("All " + configs.getConfigsList().size() + " config options have been set properly");
    }
}