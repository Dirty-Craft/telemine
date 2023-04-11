# Telemine - A MineCraft mod
This is a very useful mod for SMP servers.
Usually when you a MineCraft survival server that you play on it with your friends, you also have a Telegram group.
This mod helps you to have lots interactions between server and your group.

These are some features:

- Sends a message when starting the server
- Sends a message when server is fully started and ready
- Sends a message when shutting down the server
- Sends player join/leave messages and list of the online players in the group
- Sends the death messages
- Adds `/tg` command that allows players to send a message in the group from the server chat and you can send multiline messages by using `%n` where ever you want to break the line
- Ability to set general header and footer for all of messages
- Ability to set HTTP proxy for calling Telegram APIs
- Sends a message when a command gets executed on the server and can be used by server owner to monitor what server operators do
- Sends villager death messages and the death location and killer
- Every feature is configurable and can be enabled/disabled
- Ability to set different features to send their messages to different chats
- All text messages are customizable in the config

### Configuration

```properties
# This one can enable/disable the whole mod
# Allowed values are "true" and "false"
enabled=true

# Here you have to set bot token and also group chat id
telegram.bot_token=
telegram.chat_id=

# You can set a HTTP proxy for calling the Telegram APIs if you want
proxy.host=
proxy.port=

# The `feature.*` options can be used to enable/disable different features
# All the features and enabled by default
# Allowed values are "true" and "false"

# The `lang.*` options can be used to customize different messages that bot sends in the group
# Also you can use `\n` to break the line and write multiline content

# The `feature.*_chat_id` options can be used to set different features to send their messages to different chats
# If you want them to send the messages to the main chat (telegram.chat_id), just leave them blank

feature.starting_server_message=true
feature.starting_server_message_chat_id=
lang.starting_server_message=Starting the server...

feature.server_started_and_ready_message=true
feature.server_started_and_ready_message_chat_id=
lang.server_started_and_ready_message=Server is up!

feature.server_shutdown_message=true
feature.server_shutdown_message_chat_id=
lang.server_shutdown_message=Shutting down the server...

feature.player_join_messages=true
feature.player_join_messages_chat_id=
lang.player_join_message={name} joined the server

feature.player_join_message_show_online_players_list=true
feature.player_leave_message_show_online_players_list=true
lang.online_players_list_message=There are {count} of a max of {max_count} players online: {list}\nServer TPS: {tps}

feature.player_leave_messages=true
feature.player_leave_messages_chat_id=
lang.player_left_message={name} left the server

feature.player_death_messages=true
feature.player_death_messages_chat_id=
lang.player_death_message={player_name} {death_message}

feature.advancement_made_messages=true
feature.advancement_made_messages_chat_id=
lang.advancement_made_message={advancement_message}

feature.monitor_command_executions=false
feature.monitor_command_executions_chat_id=
lang.command_report_message={player_name} entered a command: {command}

feature.tg_send_message_command=true
feature.tg_send_message_command_chat_id=
lang.tg_command_send_message_format={player_name}: {message}

lang.general_message_header=

lang.general_message_footer=
```

## Authors
This project is created by [parsampsh](https://github.com/parsampsh)
and is a part of [Dirty Craft project](https://github.com/Dirty-Craft)
and is licensed under [MIT License](LICENSE).

## Contribution
If you want to contribute to this project,
you can checkout the [TODO list](TODO.md) and
[Issues](https://github.com/Dirty-Craft/telemine/issues).
