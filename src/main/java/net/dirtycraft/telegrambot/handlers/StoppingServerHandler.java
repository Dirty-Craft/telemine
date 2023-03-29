package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import org.slf4j.Logger;
import net.dirtycraft.telegrambot.config.ModConfigs;

public class StoppingServerHandler {
    public static void handle(TelegramAPI API, Logger LOGGER) {
        LOGGER.info("Sending shutting server down message");
        String output = API.sendMessage(ModConfigs.LANG_SERVER_SHUTDOWN_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send shutting server down message");
        }
    }
}
