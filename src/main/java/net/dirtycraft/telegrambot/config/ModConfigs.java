package net.dirtycraft.telegrambot.config;

import com.mojang.datafixers.util.Pair;
import net.dirtycraft.telegrambot.TelegramBot;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean ENABLED;
    public static String BOT_TOKEN;
    public static String GROUP_ID;
    public static String PROXY_TYPE;
    public static String PROXY_HOST;
    public static String PROXY_PORT;

    public static boolean FEATURE_STARTING_SERVER_MESSAGE;
    public static boolean FEATURE_SERVER_STARTED_AND_READY_MESSAGE;
    public static boolean FEATURE_SERVER_SHUTDOWN_MESSAGE;
    public static boolean FEATURE_PLAYER_JOIN_MESSAGES;
    public static boolean FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST;
    public static boolean FEATURE_PLAYER_LEAVE_MESSAGES;
    public static boolean FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST;
    public static boolean FEATURE_PLAYER_DEATH_MESSAGES;
    public static boolean FEATURE_ADVANCEMENT_MADE_MESSAGES;
    public static boolean FEATURE_TG_SEND_MESSAGE_COMMAND;

    public static String LANG_STARTING_SERVER_MESSAGE;
    public static String LANG_SERVER_STARTED_AND_READY_MESSAGE;
    public static String LANG_SERVER_SHUTDOWN_MESSAGE;
    public static String LANG_ONLINE_PLAYERS_LIST_MESSAGE;
    public static String LANG_PLAYER_JOIN_MESSAGE;
    public static String LANG_PLAYER_LEFT_MESSAGE;
    public static String LANG_PLAYER_DEATH_MESSAGE;
    public static String LANG_ADVANCEMENT_MADE_MESSAGE;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(TelegramBot.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("enabled", false), "boolean");

        configs.addKeyValuePair(new Pair<>("telegram.bot_token", ""), "String");
        configs.addKeyValuePair(new Pair<>("telegram.group_id", ""), "String");

        configs.addKeyValuePair(new Pair<>("proxy.type", ""), "String");
        configs.addKeyValuePair(new Pair<>("proxy.host", ""), "String");
        configs.addKeyValuePair(new Pair<>("proxy.port", ""), "String");

        configs.addKeyValuePair(new Pair<>("feature.starting_server_message", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.server_started_and_ready_message", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.server_shutdown_message", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_join_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_join_message_show_online_players_list", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_message_show_online_players_list", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_death_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.advancement_made_messages", true), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.tg_send_message_command", true), "boolean");

        configs.addKeyValuePair(new Pair<>("lang.starting_server_message", "Starting the server..."), "String");
        configs.addKeyValuePair(new Pair<>("lang.server_started_and_ready_message", "Server is up!"), "String");
        configs.addKeyValuePair(new Pair<>("lang.server_shutdown_message", "Shutting down the server..."), "String");
        configs.addKeyValuePair(new Pair<>("lang.online_players_list_message", "Online players in the server: {list}"), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_join_message", "{name} joined the server"), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_left_message", "{name} left the server"), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_death_message", "{death_message}"), "String");
        configs.addKeyValuePair(new Pair<>("lang.advancement_made_message", "{advancement_message}"), "String");
    }

    private static void assignConfigs() {
        ENABLED = CONFIG.getOrDefault("enabled", false);

        BOT_TOKEN = CONFIG.getOrDefault("telegram.bot_token", "");
        GROUP_ID = CONFIG.getOrDefault("telegram.group_id", "");

        PROXY_TYPE = CONFIG.getOrDefault("proxy.type", "");
        PROXY_HOST = CONFIG.getOrDefault("proxy.host", "");
        PROXY_PORT = CONFIG.getOrDefault("proxy.port", "");

        FEATURE_STARTING_SERVER_MESSAGE = CONFIG.getOrDefault("feature.starting_server_message", true);
        FEATURE_SERVER_STARTED_AND_READY_MESSAGE = CONFIG.getOrDefault("feature.server_started_and_ready_message", true);
        FEATURE_SERVER_SHUTDOWN_MESSAGE = CONFIG.getOrDefault("feature.server_shutdown_message", true);
        FEATURE_PLAYER_JOIN_MESSAGES = CONFIG.getOrDefault("feature.player_join_messages", true);
        FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_join_message_show_online_players_list", true);
        FEATURE_PLAYER_LEAVE_MESSAGES = CONFIG.getOrDefault("feature.player_leave_messages", true);
        FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_leave_message_show_online_players_list", true);
        FEATURE_PLAYER_DEATH_MESSAGES = CONFIG.getOrDefault("feature.player_death_messages", true);
        FEATURE_ADVANCEMENT_MADE_MESSAGES = CONFIG.getOrDefault("feature.advancement_made_messages", true);
        FEATURE_TG_SEND_MESSAGE_COMMAND = CONFIG.getOrDefault("feature.tg_send_message_command", true);

        LANG_STARTING_SERVER_MESSAGE = CONFIG.getOrDefault("lang.starting_server_message", "Starting the server...");
        LANG_SERVER_STARTED_AND_READY_MESSAGE = CONFIG.getOrDefault("lang.server_started_and_ready_message", "Server is up!");
        LANG_SERVER_SHUTDOWN_MESSAGE = CONFIG.getOrDefault("lang.server_shutdown_message", "Shutting down the server...");
        LANG_ONLINE_PLAYERS_LIST_MESSAGE = CONFIG.getOrDefault("lang.online_players_list_message", "Online players in the server: {list}");
        LANG_PLAYER_JOIN_MESSAGE = CONFIG.getOrDefault("lang.player_join_message", "{name} joined the server");
        LANG_PLAYER_LEFT_MESSAGE = CONFIG.getOrDefault("lang.player_left_message", "{name} left the server");
        LANG_PLAYER_DEATH_MESSAGE = CONFIG.getOrDefault("lang.player_death_message", "{death_message}");
        LANG_ADVANCEMENT_MADE_MESSAGE = CONFIG.getOrDefault("lang.advancement_made_message", "{advancement_message}");

        TelegramBot.LOGGER.info("All " + configs.getConfigsList().size() + " config options have been set properly");
    }
}