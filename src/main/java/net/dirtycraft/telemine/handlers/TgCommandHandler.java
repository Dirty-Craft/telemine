package net.dirtycraft.telemine.handlers;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.dirtycraft.telemine.config.ModConfigs;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class TgCommandHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_TG_SEND_MESSAGE_COMMAND;

    public static void register()
    {
        if (!ENABLED) return;
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> registerCommand(dispatcher));
    }

    public static void registerCommand(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(literal("tg")
                .then(argument("message", StringArgumentType.greedyString())
                        .executes(ctx -> handle(ctx.getSource(), StringArgumentType.getString(ctx, "message")))));
    }

    public static int handle(ServerCommandSource source, String message)
    {
        String playerName;
        try {
            playerName = source.getPlayer().getName().getString();
        } catch (Exception e) {
            playerName = "[Server]";
        }

        String output;
        String messageToBeSent = ModConfigs.LANG_TG_COMMAND_SEND_MESSAGE_FORMAT.replaceAll("\\{message\\}", message);
        try {
            output = API.sendMessage(messageToBeSent.replaceAll("\\{player_name\\}", playerName), ModConfigs.FEATURE_TG_SEND_MESSAGE_COMMAND_CHAT_ID);
        } catch (Exception e) {
            output = "ERROR";
        }

        if (output.equals("ERROR")) {
            source.sendMessage(Text.literal("Failed to send the message!"));
        } else {
            source.sendMessage(Text.literal("Message sent to the Telegram group successfully"));
        }

        return 0;
    }
}
