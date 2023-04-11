package net.dirtycraft.telemine.handlers;

import net.dirtycraft.telemine.config.ModConfigs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;

public class PlayerJoinHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_PLAYER_JOIN_MESSAGES;

    public static void register()
    {
        if (!ENABLED) return;
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> handle(handler, sender, server));
    }

    public static void handle(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server)
    {
        LOGGER.info("Sending player join message");

        String playerName = handler.player.getName().getString();
        String message;

        if (ModConfigs.FEATURE_PLAYER_JOIN_MESSAGE_SHOW_ONLINE_PLAYERS_LIST) {
            message = ModConfigs.LANG_PLAYER_JOIN_MESSAGE.replaceAll("\\{name\\}", playerName) + "\n\n" + getOnlinePlayersList(server, true, playerName);
        } else {
            message = ModConfigs.LANG_PLAYER_JOIN_MESSAGE.replaceAll("\\{name\\}", playerName);
        }

        new Thread(() -> {
            String output = API.sendMessage(message, ModConfigs.FEATURE_PLAYER_JOIN_MESSAGES_CHAT_ID);

            if (output.equals("ERROR")) {
                LOGGER.error("Failed to send player join message");
            }
        }).start();
    }
}
