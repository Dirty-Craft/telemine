package net.dirtycraft.telegrambot;

class TelegramAPI {
    public boolean enabled = false;
    public String botToken = null;
    public String groupID = null;
    public String proxy = null;

    public boolean stringIsEmpty(String value)
    {
        return value == null || value.trim().isEmpty();
    }

    public boolean isValid()
    {
        if (!enabled) return false;
        if (stringIsEmpty(botToken)) return false;
        if (stringIsEmpty(groupID)) return false;

        return true;
    }
}
