package bot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
    private static final String PROPERTIES_URL = "app.properties";
    private static String botToken = "";
    private static String botName = "";

    public static String getToken() {
        if (botToken.equals("")) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(PROPERTIES_URL));
                botToken = (String) properties.get("bot_token");
            } catch (IOException e) {
                //ignored
            }
        }

        return botToken;
    }

    public static String getBotName() {
        if (botName.equals("")) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(PROPERTIES_URL));
                botName = (String) properties.get("bot_username");
            } catch (IOException e) {
                //ignored
            }
        }

        return botName;
    }
}
