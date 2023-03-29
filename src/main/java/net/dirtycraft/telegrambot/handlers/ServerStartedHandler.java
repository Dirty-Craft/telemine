package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import net.dirtycraft.telegrambot.config.ModConfigs;
import org.spongepowered.asm.mixin.Final;

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
