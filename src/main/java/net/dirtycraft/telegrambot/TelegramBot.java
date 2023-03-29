package net.dirtycraft.telegrambot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dirtycraft.telegrambot.config.ModConfigs;
import net.dirtycraft.telegrambot.commands.TgCommand;
import net.dirtycraft.telegrambot.handlers.ServerStartHandler;
import net.dirtycraft.telegrambot.handlers.StartingServerHandler;
import java.net.Proxy;
import static net.minecraft.server.command.CommandManager.*;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
//import net.fabricmc.fabric.api.event.server.ServerStartCallback;

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
			if (ModConfigs.FEATURE_STARTING_SERVER_MESSAGE) {
				StartingServerHandler.handle(API, LOGGER);
			}

			if (ModConfigs.FEATURE_TG_SEND_MESSAGE_COMMAND) {
				CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> TgCommand.register(dispatcher, API, ModConfigs.LANG_TG_COMMAND_SEND_MESSAGE_FORMAT));
			}

			if (ModConfigs.FEATURE_SERVER_STARTED_AND_READY_MESSAGE) {
				//ServerStartCallback.EVENT.register((dispatcher, registryAccess, environment) -> ServerStartHandler.handle(API, LOGGER));
			}
		}
	}
}
