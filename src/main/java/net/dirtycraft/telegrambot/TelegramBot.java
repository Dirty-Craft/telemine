package net.dirtycraft.telegrambot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dirtycraft.telegrambot.config.ModConfigs;

public class TelegramBot implements ModInitializer {
	public static final String MOD_ID = "telegrambot";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		LOGGER.info("Hello Telegram Bot!");

		if (!ModConfigs.ENABLED) {
			LOGGER.warn("The mod is disabled");
		}
	}
}
