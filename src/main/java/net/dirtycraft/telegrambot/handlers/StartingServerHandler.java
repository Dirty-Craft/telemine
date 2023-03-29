package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import org.slf4j.Logger;
import net.dirtycraft.telegrambot.config.ModConfigs;

class StartingServerHandler {
    public static void handle(TelegramAPI API, Logger LOGGER)
    {
        LOGGER.info("Sending starting server message");
        String output = API.sendMessage(ModConfigs.LANG_STARTING_SERVER_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send starting server message");
        }
    }
}