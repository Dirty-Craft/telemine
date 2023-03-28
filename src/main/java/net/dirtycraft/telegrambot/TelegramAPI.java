package net.dirtycraft.telegrambot;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

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

    public String getBaseURL()
    {
        return "https://api.telegram.org/bot" + botToken + "/";
    }

    public String call(String uri)
    {
        return call(uri, "GET");
    }

    public String call(String uri, String method)
    {
        if (!isValid()) return "ERROR";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(getBaseURL() + uri);
            connection = (HttpURLConnection) url.openConnection(
                    new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8889))
            );
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setConnectTimeout(10000);

            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
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
