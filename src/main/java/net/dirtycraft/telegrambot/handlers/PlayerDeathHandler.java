package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import net.dirtycraft.telegrambot.config.ModConfigs;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

public class PlayerDeathHandler {
    public static void handle(TelegramAPI API, Logger LOGGER, DamageSource damageSource, ServerPlayerEntity player) {
        LOGGER.info("Sending player death message");
        String playerName = player.getName().getString();
        String deathMessage = StringUtils.replaceOnce(damageSource.getDeathMessage(player).getString(), playerName + " ", "");
        String output = API.sendMessage(
                ModConfigs.LANG_PLAYER_DEATH_MESSAGE.replaceAll("\\{death_message\\}", deathMessage)
                        .replaceAll("\\{player_name\\}", playerName)
        );

        if (output.equals("ERROR")) {
            LOGGER.error("Failed to send player death message");
        }
    }
}
