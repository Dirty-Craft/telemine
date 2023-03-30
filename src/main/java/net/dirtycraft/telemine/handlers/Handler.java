package net.dirtycraft.telemine.handlers;

import net.dirtycraft.telemine.Api;
import net.dirtycraft.telemine.Telemine;
import net.dirtycraft.telemine.config.ModConfigs;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;

import java.util.Arrays;

public class Handler {
    public static final Logger LOGGER = Telemine.LOGGER;
    public static final Api API = Telemine.API;

    public static String getOnlinePlayersList(MinecraftServer server, boolean include, String playerName)
    {
        String[] playerNames = server.getPlayerManager().getPlayerNames();

        if (include) {
            playerNames = Arrays.copyOf(playerNames, playerNames.length + 1);
            playerNames[playerNames.length - 1] = playerName;
        } else {
            String[] newArray = new String[playerNames.length - 1];
            int counter = 0;
            for (int i = 0; i < playerNames.length; i++) {
                if (!playerNames[i].equals(playerName)) {
                    newArray[counter] = playerNames[i];
                    counter++;
                }
            }
            playerNames = newArray;
        }

        return ModConfigs.LANG_ONLINE_PLAYERS_LIST_MESSAGE.replaceAll("\\{list\\}", String.join(", ", playerNames))
                .replaceAll("\\{count\\}", Integer.toString(playerNames.length))
                .replaceAll("\\{max_count\\}", Integer.toString(server.getMaxPlayerCount()));
    }
}
