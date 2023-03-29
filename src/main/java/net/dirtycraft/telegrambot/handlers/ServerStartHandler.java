package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import org.slf4j.Logger;
import net.dirtycraft.telegrambot.config.ModConfigs;

class ServerStartHandler {
    public static void handle(TelegramAPI API, Logger LOGGER) {
        LOGGER.info("Sending server started message");
        String output = API.sendMessage(ModConfigs.LANG_SERVER_STARTED_AND_READY_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send server started message");
        }
    }
}
