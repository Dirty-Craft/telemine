package net.dirtycraft.telemine.config;

import com.mojang.datafixers.util.Pair;
import net.dirtycraft.telemine.Telemine;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean ENABLED = false;


    public static String BOT_TOKEN = "";
    public static String CHAT_ID = "";


    public static String PROXY_HOST = "";
    public static String PROXY_PORT = "";


    public static boolean FEATURE_STARTING_SERVER_MESSAGE = true;
    public static String FEATURE_STARTING_SERVER_MESSAGE_CHAT_ID = "";
    public static String LANG_STARTING_SERVER_MESSAGE = "Starting the server...";


    public static boolean FEATURE_SERVER_STARTED_AND_READY_MESSAGE = true;
    public static String FEATURE_SERVER_STARTED_AND_READY_MESSAGE_CHAT_ID = "";
    public static String LANG_SERVER_STARTED_AND_READY_MESSAGE = "Server is up!";


    public static boolean FEATURE_SERVER_SHUTDOWN_MESSAGE = true;
    public static String FEATURE_SERVER_SHUTDOWN_MESSAGE_CHAT_ID = "";
    public static String LANG_SERVER_SHUTDOWN_MESSAGE = "Shutting down the server...";


    public static boolean FEATURE_PLAYER_JOIN_MESSAGES = true;
    public static String FEATURE_PLAYER_JOIN_MESSAGES_CHAT_ID = "";
    public static String LANG_PLAYER_JOIN_MESSAGE = "{name} joined the server";


    public static boolean FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = true;
    public static boolean FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = true;
    public static String LANG_ONLINE_PLAYERS_LIST_MESSAGE = "There are {count} of a max of {max_count} players online: {list}";


    public static boolean FEATURE_PLAYER_LEAVE_MESSAGES = true;
    public static String FEATURE_PLAYER_LEAVE_MESSAGES_CHAT_ID = "";
    public static String LANG_PLAYER_LEFT_MESSAGE = "{name} left the server";


    public static boolean FEATURE_PLAYER_DEATH_MESSAGES = true;
    public static String FEATURE_PLAYER_DEATH_MESSAGES_CHAT_ID = "";
    public static String LANG_PLAYER_DEATH_MESSAGE = "{player_name} {death_message}";


    public static boolean FEATURE_ADVANCEMENT_MADE_MESSAGES = true;
    public static String FEATURE_ADVANCEMENT_MADE_MESSAGES_CHAT_ID = "";
    public static String LANG_ADVANCEMENT_MADE_MESSAGE = "{advancement_message}";


    public static boolean FEATURE_MONITOR_COMMAND_EXECUTIONS = false;
    public static String FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID = "";
    public static String LANG_COMMAND_REPORT_MESSAGE = "{player_name} entered a command: {command}";


    public static boolean FEATURE_TG_SEND_MESSAGE_COMMAND = true;
    public static String FEATURE_TG_SEND_MESSAGE_COMMAND_CHAT_ID = "";
    public static String LANG_TG_COMMAND_SEND_MESSAGE_FORMAT = "{player_name}: {message}";


    public static boolean FEATURE_VILLAGER_DEATH_MESSAGE = false;
    public static String FEATURE_VILLAGER_DEATH_MESSAGE_CHAT_ID = "";
    public static String LANG_VILLAGER_DEATH_MESSAGE = "{death_message} at {location}";


    public static String LANG_GENERAL_MESSAGE_HEADER = "";
    public static String LANG_GENERAL_MESSAGE_FOOTER = "";


    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Telemine.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("enabled", ENABLED), "boolean");

        configs.addKeyValuePair(new Pair<>("telegram.bot_token", BOT_TOKEN), "String");
        configs.addKeyValuePair(new Pair<>("telegram.chat_id", CHAT_ID), "String");

        configs.addKeyValuePair(new Pair<>("proxy.host", PROXY_HOST), "String");
        configs.addKeyValuePair(new Pair<>("proxy.port", PROXY_PORT), "String");

        configs.addKeyValuePair(new Pair<>("feature.starting_server_message", FEATURE_STARTING_SERVER_MESSAGE), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.starting_server_message_chat_id", FEATURE_STARTING_SERVER_MESSAGE_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.starting_server_message", LANG_STARTING_SERVER_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.server_started_and_ready_message", FEATURE_SERVER_STARTED_AND_READY_MESSAGE), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.server_started_and_ready_message_chat_id", FEATURE_SERVER_STARTED_AND_READY_MESSAGE_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.server_started_and_ready_message", LANG_SERVER_STARTED_AND_READY_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.server_shutdown_message", FEATURE_SERVER_SHUTDOWN_MESSAGE), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.server_shutdown_message_chat_id", FEATURE_SERVER_SHUTDOWN_MESSAGE_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.server_shutdown_message", LANG_SERVER_SHUTDOWN_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.player_join_messages", FEATURE_PLAYER_JOIN_MESSAGES), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_join_messages_chat_id", FEATURE_PLAYER_JOIN_MESSAGES_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_join_message", LANG_PLAYER_JOIN_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.player_join_message_show_online_players_list", FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_message_show_online_players_list", FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST), "boolean");
        configs.addKeyValuePair(new Pair<>("lang.online_players_list_message", LANG_ONLINE_PLAYERS_LIST_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.player_leave_messages", FEATURE_PLAYER_LEAVE_MESSAGES), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_leave_messages_chat_id", FEATURE_PLAYER_LEAVE_MESSAGES_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_left_message", LANG_PLAYER_LEFT_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.player_death_messages", FEATURE_PLAYER_DEATH_MESSAGES), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.player_death_messages_chat_id", FEATURE_PLAYER_DEATH_MESSAGES_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.player_death_message", LANG_PLAYER_DEATH_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.advancement_made_messages", FEATURE_ADVANCEMENT_MADE_MESSAGES), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.advancement_made_messages_chat_id", FEATURE_ADVANCEMENT_MADE_MESSAGES_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.advancement_made_message", LANG_ADVANCEMENT_MADE_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.monitor_command_executions", FEATURE_MONITOR_COMMAND_EXECUTIONS), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.monitor_command_executions_chat_id", FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.command_report_message", LANG_COMMAND_REPORT_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("feature.tg_send_message_command", FEATURE_TG_SEND_MESSAGE_COMMAND), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.tg_send_message_command_chat_id", FEATURE_TG_SEND_MESSAGE_COMMAND_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.tg_command_send_message_format", LANG_TG_COMMAND_SEND_MESSAGE_FORMAT), "String");

        configs.addKeyValuePair(new Pair<>("feature.villager_death_message", FEATURE_VILLAGER_DEATH_MESSAGE), "boolean");
        configs.addKeyValuePair(new Pair<>("feature.villager_death_message_chat_id", FEATURE_VILLAGER_DEATH_MESSAGE_CHAT_ID), "String");
        configs.addKeyValuePair(new Pair<>("lang.villager_death_message", LANG_VILLAGER_DEATH_MESSAGE), "String");

        configs.addKeyValuePair(new Pair<>("lang.general_message_header", LANG_GENERAL_MESSAGE_HEADER), "String");
        configs.addKeyValuePair(new Pair<>("lang.general_message_footer", LANG_GENERAL_MESSAGE_FOOTER), "String");
    }

    private static void assignConfigs() {
        ENABLED = CONFIG.getOrDefault("enabled", ENABLED);

        BOT_TOKEN = CONFIG.getOrDefault("telegram.bot_token", BOT_TOKEN);
        CHAT_ID = CONFIG.getOrDefault("telegram.chat_id", CHAT_ID);

        PROXY_HOST = CONFIG.getOrDefault("proxy.host", PROXY_HOST);
        PROXY_PORT = CONFIG.getOrDefault("proxy.port", PROXY_PORT);

        FEATURE_STARTING_SERVER_MESSAGE = CONFIG.getOrDefault("feature.starting_server_message", FEATURE_STARTING_SERVER_MESSAGE);
        FEATURE_STARTING_SERVER_MESSAGE_CHAT_ID = CONFIG.getOrDefault("feature.starting_server_message_chat_id", CHAT_ID);
        LANG_STARTING_SERVER_MESSAGE = CONFIG.getOrDefault("lang.starting_server_message", LANG_STARTING_SERVER_MESSAGE);

        FEATURE_SERVER_STARTED_AND_READY_MESSAGE = CONFIG.getOrDefault("feature.server_started_and_ready_message", FEATURE_SERVER_STARTED_AND_READY_MESSAGE);
        FEATURE_SERVER_STARTED_AND_READY_MESSAGE_CHAT_ID = CONFIG.getOrDefault("feature.server_started_and_ready_message_chat_id", CHAT_ID);
        LANG_SERVER_STARTED_AND_READY_MESSAGE = CONFIG.getOrDefault("lang.server_started_and_ready_message", LANG_SERVER_STARTED_AND_READY_MESSAGE);

        FEATURE_SERVER_SHUTDOWN_MESSAGE = CONFIG.getOrDefault("feature.server_shutdown_message", FEATURE_SERVER_SHUTDOWN_MESSAGE);
        FEATURE_SERVER_SHUTDOWN_MESSAGE_CHAT_ID = CONFIG.getOrDefault("feature.server_shutdown_message_chat_id", CHAT_ID);
        LANG_SERVER_SHUTDOWN_MESSAGE = CONFIG.getOrDefault("lang.server_shutdown_message", LANG_SERVER_SHUTDOWN_MESSAGE);

        FEATURE_PLAYER_JOIN_MESSAGES = CONFIG.getOrDefault("feature.player_join_messages", FEATURE_PLAYER_JOIN_MESSAGES);
        FEATURE_PLAYER_JOIN_MESSAGES_CHAT_ID = CONFIG.getOrDefault("feature.player_join_messages_chat_id", CHAT_ID);
        LANG_PLAYER_JOIN_MESSAGE = CONFIG.getOrDefault("lang.player_join_message", LANG_PLAYER_JOIN_MESSAGE);

        FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_join_message_show_online_players_list", FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST);
        FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST = CONFIG.getOrDefault("feature.player_leave_message_show_online_players_list", FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST);
        LANG_ONLINE_PLAYERS_LIST_MESSAGE = CONFIG.getOrDefault("lang.online_players_list_message", LANG_ONLINE_PLAYERS_LIST_MESSAGE);

        FEATURE_PLAYER_LEAVE_MESSAGES = CONFIG.getOrDefault("feature.player_leave_messages", FEATURE_PLAYER_LEAVE_MESSAGES);
        FEATURE_PLAYER_LEAVE_MESSAGES_CHAT_ID = CONFIG.getOrDefault("feature.player_leave_messages_chat_id", CHAT_ID);
        LANG_PLAYER_LEFT_MESSAGE = CONFIG.getOrDefault("lang.player_left_message", LANG_PLAYER_LEFT_MESSAGE);

        FEATURE_PLAYER_DEATH_MESSAGES = CONFIG.getOrDefault("feature.player_death_messages", FEATURE_PLAYER_DEATH_MESSAGES);
        FEATURE_PLAYER_DEATH_MESSAGES_CHAT_ID = CONFIG.getOrDefault("feature.player_death_messages_chat_id", CHAT_ID);
        LANG_PLAYER_DEATH_MESSAGE = CONFIG.getOrDefault("lang.player_death_message", LANG_PLAYER_DEATH_MESSAGE);

        FEATURE_ADVANCEMENT_MADE_MESSAGES = CONFIG.getOrDefault("feature.advancement_made_messages", FEATURE_ADVANCEMENT_MADE_MESSAGES);
        FEATURE_ADVANCEMENT_MADE_MESSAGES_CHAT_ID = CONFIG.getOrDefault("feature.advancement_made_messages_chat_id", CHAT_ID);
        LANG_ADVANCEMENT_MADE_MESSAGE = CONFIG.getOrDefault("lang.advancement_made_message", LANG_ADVANCEMENT_MADE_MESSAGE);

        FEATURE_MONITOR_COMMAND_EXECUTIONS = CONFIG.getOrDefault("feature.monitor_command_executions", FEATURE_MONITOR_COMMAND_EXECUTIONS);
        FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID = CONFIG.getOrDefault("feature.monitor_command_executions_chat_id", FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID);
        LANG_COMMAND_REPORT_MESSAGE = CONFIG.getOrDefault("lang.command_report_message", LANG_COMMAND_REPORT_MESSAGE);

        FEATURE_TG_SEND_MESSAGE_COMMAND = CONFIG.getOrDefault("feature.tg_send_message_command", FEATURE_TG_SEND_MESSAGE_COMMAND);
        FEATURE_TG_SEND_MESSAGE_COMMAND_CHAT_ID = CONFIG.getOrDefault("feature.tg_send_message_command_chat_id", CHAT_ID);
        LANG_TG_COMMAND_SEND_MESSAGE_FORMAT = CONFIG.getOrDefault("lang.tg_command_send_message_format", LANG_TG_COMMAND_SEND_MESSAGE_FORMAT);

        FEATURE_VILLAGER_DEATH_MESSAGE = CONFIG.getOrDefault("feature.villager_death_message", FEATURE_VILLAGER_DEATH_MESSAGE);
        FEATURE_VILLAGER_DEATH_MESSAGE_CHAT_ID = CONFIG.getOrDefault("feature.villager_death_message_chat_id", CHAT_ID);
        LANG_VILLAGER_DEATH_MESSAGE = CONFIG.getOrDefault("lang.villager_death_message", LANG_VILLAGER_DEATH_MESSAGE);

        LANG_GENERAL_MESSAGE_HEADER = CONFIG.getOrDefault("lang.general_message_header", LANG_GENERAL_MESSAGE_HEADER);
        LANG_GENERAL_MESSAGE_FOOTER = CONFIG.getOrDefault("lang.general_message_footer", LANG_GENERAL_MESSAGE_FOOTER);

        Telemine.LOGGER.info("All " + configs.getConfigsList().size() + " config options have been set properly");
    }
}
