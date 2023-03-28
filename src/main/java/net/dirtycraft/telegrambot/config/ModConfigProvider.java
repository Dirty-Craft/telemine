package net.dirtycraft.telegrambot.config;

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