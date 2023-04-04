package net.dirtycraft.telemine.config;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class ModConfigProvider implements SimpleConfig.DefaultConfig {
    private String configContents = "";

    public List<Pair> getConfigsList() {
        return configsList;
    }

    private final List<Pair> configsList = new ArrayList<>();

    public void addKeyValuePair(Pair<String, ?> keyValuePair, String comment) {
        configsList.add(keyValuePair);

        if (keyValuePair.getFirst().equals("enabled")) {
            configContents += "# This one can enable/disable the whole mod\n" +
                    "# Allowed values are \"true\" and \"false\"\n";
        }

        if (keyValuePair.getFirst().equals("telegram.bot_token")) {
            configContents += "# Here you have to set bot token and also group chat id\n";
        }

        if (keyValuePair.getFirst().equals("proxy.host")) {
            configContents += "# You can set a HTTP proxy for calling the Telegram APIs if you want\n";
        }

        if (keyValuePair.getFirst().equals("feature.starting_server_message")) {
            configContents += "# The `feature.*` options can be used to enable/disable different features\n" +
                    "# All the features and enabled by default\n" +
                    "# Allowed values are \"true\" and \"false\"\n";
        }

        if (keyValuePair.getFirst().equals("lang.starting_server_message")) {
            configContents += "# The `lang.*` options can be used to customize different messages that bot sends in the group\n" +
                    "# Also you can use `\\n` to break the line and write multiline content\n";
        }

        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + "\n";

        if (
                keyValuePair.getFirst().equals("enabled") ||
                keyValuePair.getFirst().equals("telegram.group_id") ||
                keyValuePair.getFirst().equals("feature.tg_send_message_command") ||
                keyValuePair.getFirst().equals("proxy.port")
        ) {
            configContents += "\n";
        }
    }

    @Override
    public String get(String namespace) {
        return configContents;
    }
}