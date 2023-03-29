package net.dirtycraft.telemine.handlers;

import net.dirtycraft.telemine.config.ModConfigs;

public class StartingServerHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_STARTING_SERVER_MESSAGE;

    public static void register()
    {
        if (!ENABLED) return;
        handle();
    }

    public static void handle()
    {
        LOGGER.info("Sending starting server message");
        String output = API.sendMessage(ModConfigs.LANG_STARTING_SERVER_MESSAGE);

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send starting server message");
        }
    }
}