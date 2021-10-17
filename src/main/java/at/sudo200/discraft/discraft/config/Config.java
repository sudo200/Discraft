package at.sudo200.discraft.discraft.config;

/**
 * stores and retrieves config
 */
public class Config {
    private static final Config instance;

    private final String clientID = "450485984333660181";

    private final String startingMsg = "Starting the game";
    private final String menuMsg = "In the menu";
    private final String singleplayerMsg = "Playing Singleplayer";
    private final String multiplayerMsg = "Playing Multiplayer";

    private final String singleplayerDetailFormat = "In world \"%WORLDNAME%\"";
    private final String multiplayerDetailFormat = "On %SERVERNAME%";

    static {
        instance = new Config();
    }

    private Config() {
    }

    /**
     * @return instance
     * @see Config
     */
    public static Config get() {
        return instance;
    }

    /**
     * @return Discord application id
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * @return Message shown during startup
     */
    public String getStartingMsg() {
        return startingMsg;
    }

    /**
     * @return Message shown while in main menu or game menu
     */
    public String getMenuMsg() {
        return menuMsg;
    }

    /**
     * @return Message shown while in singleplayer
     */
    public String getSingleplayerMsg() {
        return singleplayerMsg;
    }

    /**
     * @return Message shown while in multiplayer
     */
    public String getMultiplayerMsg() {
        return multiplayerMsg;
    }

    /**
     * @return Detail string while in singleplayer; format string
     */
    public String getSingleplayerDetailFormat() {
        return singleplayerDetailFormat;
    }

    /**
     * @return Detail string while in multiplayer; format string
     */
    public String getMultiplayerDetailFormat() {
        return multiplayerDetailFormat;
    }
}
