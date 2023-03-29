package net.dirtycraft.telegrambot.commands;

import static net.minecraft.server.command.CommandManager.*;
import net.minecraft.text.Text;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.dirtycraft.telegrambot.TelegramAPI;

public class TgCommand {
    public static TelegramAPI API;
    public static String MESSAGE_FORMAT;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, TelegramAPI theAPI, String messageFormat) {
        API = theAPI;
        MESSAGE_FORMAT = messageFormat;
        dispatcher.register(literal("tg")
                .then(argument("message", StringArgumentType.greedyString())
                .executes(ctx -> execute(ctx.getSource(), StringArgumentType.getString(ctx, "message")))));
    }

    public static int execute(ServerCommandSource source, String message)
    {
        String playerName;
        try {
            playerName = source.getPlayer().getName().getString();
        } catch (Exception e) {
            playerName = "[Server]";
        }

        String output;
        String messageToBeSent = MESSAGE_FORMAT.replaceAll("\\{message\\}", message);
        try {
            output = API.sendMessage(messageToBeSent.replaceAll("\\{player_name\\}", playerName));
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
