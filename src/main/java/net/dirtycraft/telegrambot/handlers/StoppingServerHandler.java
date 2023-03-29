package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import net.dirtycraft.telegrambot.config.ModConfigs;
import org.spongepowered.asm.mixin.Final;

public class StoppingServerHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_SERVER_SHUTDOWN_MESSAGE;

    public static void register()
    {
        if (!ENABLED) return;
        ServerLifecycleEvents.SERVER_STOPPING.register((dispatcher) -> handle());
    }

    public static void handle()
    {
        LOGGER.info("Sending shutting server down message");
        String output = API.sendMessage(ModConfigs.LANG_SERVER_SHUTDOWN_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send shutting server down message");
        }
    }
}
