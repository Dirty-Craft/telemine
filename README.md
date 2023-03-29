# MineCraft Server Telegram Bot
This is a very useful mod for SMP servers.
Usually when you a MineCraft survival server that you play on it with your friends, you also have a Telegram group.
This mod helps you to have lots interactions between server and your group.

These are some features:

- Sends a message when starting the server
- Sends a message when server is fully started and ready
- Sends a message when shutting down the server
- Sends player join/leave messages and list of the online players in the group
- Sends the death messages
- Sends the advancement messages
- Adds `/tg` command that allows players to send a message in the group from the server chat
- Every feature is configurable and can be enabled/disabled
- All text messages are customizable in the config

### Configuration

```properties
# This one can enable/disable the whole mod
# Allowed values are "true" and "false"
enabled=false

# Here you have to set bot token and also group chat id
telegram.bot_token=
telegram.group_id=

# You can set a proxy for calling the Telegram APIs if you want
proxy.type=
proxy.host=
proxy.port=
# The proxy.type can be "http" or "socks". Example:
#proxy.type=socks
#proxy.host=127.0.0.1
#proxy.port=1080

# The `feature.*` options can be used to enable/disable different features
# All the features and enabled by default
# Allowed values are "true" and "false"
feature.starting_server_message=true
feature.server_started_and_ready_message=true
feature.server_shutdown_message=true
feature.player_join_messages=true
feature.player_join_message_show_online_players_list=true
feature.player_leave_messages=true
feature.player_leave_message_show_online_players_list=true
feature.player_death_messages=true
feature.advancement_made_messages=true
feature.tg_send_message_command=true

# The `lang.*` options can be used to customize different messages that bot sends in the group
lang.starting_server_message=Starting the server...
lang.server_started_and_ready_message=Server is up!
lang.server_shutdown_message=Shutting down the server...
lang.online_players_list_message=Online players in the server: {list}
lang.player_join_message={name} joined the server
lang.player_left_message={name} left the server
lang.player_death_message={death_message}
lang.tg_command_send_message_format={player_name}: {message}
lang.advancement_made_message={advancement_message}
```

## Authors
This project is created by [parsampsh](https://github.com/parsampsh)
and is a part of [Dirty Craft project](https://github.com/Dirty-Craft)
and is licensed under [MIT License](LICENSE).

## Contribution
If you want to contribute to this project,
you can checkout the [TODO list](TODO.md) and
[Issues](https://github.com/Dirty-Craft/telemine).
