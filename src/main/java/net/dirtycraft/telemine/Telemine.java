package net.dirtycraft.telemine;

import net.dirtycraft.telemine.handlers.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dirtycraft.telemine.config.ModConfigs;

public class Telemine implements ModInitializer {
	public static final String MOD_ID = "telemine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Api API = new Api();

	@Override
	public void onInitialize() {
		LOGGER.info("Loading configuration");
		ModConfigs.registerConfigs();

		if (!ModConfigs.ENABLED) {
			//LOGGER.warn("The mod is disabled");
		} else if (ModConfigs.BOT_TOKEN == "") {
			LOGGER.warn("The Telegram bot token is not set in the configs");
		} else if (ModConfigs.CHAT_ID == "") {
			LOGGER.warn("The Telegram chat ID is not set in the configs");
		} else {
			API.enabled = true;
			API.botToken = ModConfigs.BOT_TOKEN;
			API.groupID = ModConfigs.CHAT_ID;
			API.proxyHost = ModConfigs.PROXY_HOST;
			API.proxyPort = ModConfigs.PROXY_PORT;
		}

		if (!API.isValid()) {
			LOGGER.warn("The mod is disabled");
		} else {
			String output = "ERROR";
			try {
				output = API.get("getme");
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

		if (API.isValid()) {
			Handler.boot();
			TgCommandHandler.register();
			StartingServerHandler.register();
			ServerStartedHandler.register();
			StoppingServerHandler.register();
			PlayerDeathHandler.register();
			PlayerJoinHandler.register();
			PlayerLeaveHandler.register();
			VillagerDeathHandler.register();
		}
	}
}
