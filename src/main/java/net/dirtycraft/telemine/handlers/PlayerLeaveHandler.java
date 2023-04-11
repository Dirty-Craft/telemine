package net.dirtycraft.telemine.handlers;

import net.dirtycraft.telemine.config.ModConfigs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;

public class PlayerLeaveHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_PLAYER_LEAVE_MESSAGES;

    public static void register()
    {
        if (!ENABLED) return;
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> handle(handler, server));
    }

    public static void handle(ServerPlayNetworkHandler handler, MinecraftServer server)
    {
        LOGGER.info("Sending player leave message");

        String playerName = handler.player.getName().getString();
        String message;

        if (ModConfigs.FEATURE_PLAYER_LEAVE_MESSAGE_SHOW_ONLINE_PLAYERS_LIST) {
            message = ModConfigs.LANG_PLAYER_LEFT_MESSAGE.replaceAll("\\{name\\}", playerName) + "\n\n" + getOnlinePlayersList(server, false, playerName);
        } else {
            message = ModConfigs.LANG_PLAYER_LEFT_MESSAGE.replaceAll("\\{name\\}", playerName);
        }

        new Thread(() -> {
            String output = API.sendMessage(message, ModConfigs.FEATURE_PLAYER_LEAVE_MESSAGES_CHAT_ID);

            if (output.equals("ERROR")) {
                LOGGER.error("Failed to send player leave message");
            }
        }).start();
    }
}
