package net.dirtycraft.telegrambot;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Api {
    public boolean enabled = false;
    public String botToken = null;
    public String groupID = null;
    public String proxyType = null;

    public String proxyHost = null;
    public String proxyPort = null;

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

    public String getBaseURL()
    {
        return "https://api.telegram.org/bot" + botToken + "/";
    }

    public String get(String uri)
    {
        return call(uri, "GET", "");
    }

    public String post(String uri, String payloadJson)
    {
        return call(uri, "POST", payloadJson);
    }

    public String sendMessage(String text)
    {
        TelegramBot.LOGGER.info("Sending a message to the Telegram group: " + text);
        return post("sendMessage", "chat_id=" + groupID + "&text=" + text);
    }

    public String call(String uri, String method, String payload)
    {
        if (!isValid()) return "ERROR";

        HttpURLConnection connection = null;
        try {
            boolean proxyEnabled = false;
            Proxy proxy = null;
            int intProxyPort = 0;

            if (stringIsEmpty(proxyPort)) {
                intProxyPort = 0;
            } else {
                intProxyPort = Integer.parseInt(proxyPort);
            }

            if (proxyType.equals("http")) {
                proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, intProxyPort));
            } else if (proxyType.equals("socks")) {
                proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyHost, intProxyPort));
            }

            URL url = new URL(getBaseURL() + uri);

            if (proxy == null) {
                connection = (HttpURLConnection) url.openConnection();
            } else {
                connection = (HttpURLConnection) url.openConnection(proxy);
            }

            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setConnectTimeout(10000);

            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            if (method.equals("POST")) {
                byte[] input = payload.getBytes("utf-8");
                wr.write(input, 0, input.length);
            }
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
