package net.dirtycraft.telegrambot.handlers;

import net.dirtycraft.telegrambot.TelegramAPI;
import net.dirtycraft.telegrambot.config.ModConfigs;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Final;

public class PlayerDeathHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_PLAYER_DEATH_MESSAGES;

    public static void register()
    {
        if (!ENABLED) return;
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if (entity instanceof ServerPlayerEntity) {
                handle(damageSource, (ServerPlayerEntity) entity);
            }
        });
    }
    public static void handle(DamageSource damageSource, ServerPlayerEntity player)
    {
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
