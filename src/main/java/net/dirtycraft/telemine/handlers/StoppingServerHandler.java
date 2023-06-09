package net.dirtycraft.telemine.handlers;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.dirtycraft.telemine.config.ModConfigs;

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

        new Thread(() -> {
            String output = API.sendMessage(ModConfigs.LANG_SERVER_SHUTDOWN_MESSAGE, ModConfigs.FEATURE_SERVER_SHUTDOWN_MESSAGE_CHAT_ID);

            if (output.equals("ERROR")) {
                LOGGER.error("Failed to send shutting server down message");
            }
        }).start();
    }
}
