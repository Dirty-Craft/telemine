package net.dirtycraft.telemine.handlers;

import net.dirtycraft.telemine.config.ModConfigs;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class VillagerDeathHandler extends Handler {
    public static boolean ENABLED = ModConfigs.FEATURE_VILLAGER_DEATH_MESSAGE;

    public static void register()
    {
        if (!ENABLED) return;

        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> handle(entity, damageSource));
    }

    public static void handle(LivingEntity entity, DamageSource damageSource)
    {
        boolean isVillager = entity.getType() == EntityType.VILLAGER;

        if (isVillager) {
            LOGGER.info("Sending villager death message");
            String deathMessage = damageSource.getDeathMessage(entity).getString();

            String position;
            try {
                position = Double.toString(entity.getPos().x) + ", "
                        + Double.toString(entity.getPos().y) + ", "
                        + Double.toString(entity.getPos().z);
            } catch (Exception e) {
                position = "unknown";
            }

            String finalMessage = ModConfigs.LANG_VILLAGER_DEATH_MESSAGE.replaceAll("\\{death_message\\}", deathMessage)
                    .replaceAll("\\{location\\}", position);

            String output = API.sendMessage(finalMessage, ModConfigs.FEATURE_VILLAGER_DEATH_MESSAGE_CHAT_ID);

            if (output.equals("ERROR")) {
                LOGGER.error("Failed to send villager death message");
            }
        }
    }
}
