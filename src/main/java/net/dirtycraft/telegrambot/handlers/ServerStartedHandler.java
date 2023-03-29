package net.dirtycraft.telegrambot.handlers;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.dirtycraft.telegrambot.config.ModConfigs;

public class ServerStartedHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_SERVER_STARTED_AND_READY_MESSAGE;

    public static void register()
    {
        if (!ENABLED) return;
        ServerLifecycleEvents.SERVER_STARTED.register((dispatcher) -> handle());
    }

    public static void handle()
    {
        LOGGER.info("Sending server started message");
        String output = API.sendMessage(ModConfigs.LANG_SERVER_STARTED_AND_READY_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send server started message");
        }
    }
}
