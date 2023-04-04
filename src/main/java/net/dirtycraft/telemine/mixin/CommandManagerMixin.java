package net.dirtycraft.telemine.mixin;

import com.mojang.brigadier.ParseResults;
import net.dirtycraft.telemine.Telemine;
import net.dirtycraft.telemine.config.ModConfigs;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CommandManager.class)
public class CommandManagerMixin {
    @Inject(at = @At("HEAD"), method = "execute")
    public void injected(ParseResults<ServerCommandSource> parseResults, String command, CallbackInfoReturnable<Integer> ci) {
        if (ModConfigs.FEATURE_MONITOR_COMMAND_EXECUTIONS) {
            ServerCommandSource serverCommandSource = (ServerCommandSource) parseResults.getContext().getSource();
            String playerName;
            try {
                playerName = serverCommandSource.getPlayer().getName().getString();
            } catch (Exception e) {
                playerName = "[Server]";
            }

            String messageToSend = ModConfigs.LANG_COMMAND_REPORT_MESSAGE.replaceAll("\\{player_name\\}", playerName);
            messageToSend = messageToSend.replaceAll("\\{command\\}", command);
            Telemine.LOGGER.info("Sending command executed message");
            String output;
            if (!ModConfigs.FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID.isEmpty()) {
                output = Telemine.API.sendMessage(messageToSend, ModConfigs.FEATURE_MONITOR_COMMAND_EXECUTIONS_CHAT_ID);
            } else {
                output = Telemine.API.sendMessage(messageToSend);
            }

            if (output.equals("ERROR")) {
                Telemine.LOGGER.error("Failed to send command executed message");
            }
        }
    }
}
