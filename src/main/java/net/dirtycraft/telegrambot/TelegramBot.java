package net.dirtycraft.telegrambot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dirtycraft.telegrambot.config.ModConfigs;
import java.net.Proxy;

public class TelegramBot implements ModInitializer {
	public static final String MOD_ID = "telegrambot";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final TelegramAPI API = new TelegramAPI();

	@Override
	public void onInitialize() {
		LOGGER.info("Loading configuration");
		ModConfigs.registerConfigs();

		if (!ModConfigs.ENABLED) {
			//LOGGER.warn("The mod is disabled");
		} else if (ModConfigs.BOT_TOKEN == "") {
			LOGGER.warn("The Telegram bot token is not set in the configs");
		} else if (ModConfigs.GROUP_ID == "") {
			LOGGER.warn("The Telegram group ID is not set in the configs");
		} else {
			API.enabled = true;
			API.botToken = ModConfigs.BOT_TOKEN;
			API.groupID = ModConfigs.GROUP_ID;
			API.proxyType = ModConfigs.PROXY_TYPE;
			API.proxyHost = ModConfigs.PROXY_HOST;
			API.proxyPort = ModConfigs.PROXY_PORT;
		}

		if (!API.isValid()) {
			LOGGER.warn("The mod is disabled");
		} else {
			String output = "ERROR";
			try {
				output = API.call("getme");
			} catch (Exception e) {
				output = "ERROR";
			}

			if (output.equals("ERROR")) {
				API.enabled = false;
				LOGGER.error("Failed to connect to the bot");
			} else {
				LOGGER.info("Connected to the bot successfully: " + output);
			}
		}
	}
}
