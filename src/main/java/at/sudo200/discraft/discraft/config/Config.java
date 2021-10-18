package at.sudo200.discraft.discraft.config;

/**
 * stores and retrieves config
 */
public class Config {
    private static final Config instance;

    private String clientID = "450485984333660181";

    private final String startingMsg = "Starting the game";
    private String menuMsg = "In the menu";
    private String singleplayerMsg = "Playing Singleplayer";
    private  String multiplayerMsg = "Playing Multiplayer";

    private  String singleplayerDetailFormat = "In world \"$WORLDNAME$\"";
    private  String multiplayerDetailFormat = "On $SERVERNAME$";

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
     * @param clientID Discord application id
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
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
     * @param menuMsg Message shown while in main menu or game menu
     */
    public void setMenuMsg(String menuMsg) {
        this.menuMsg = menuMsg;
    }

    /**
     * @return Message shown while in singleplayer
     */
    public String getSingleplayerMsg() {
        return singleplayerMsg;
    }

    /**
     * @param singleplayerMsg Message shown while in singleplayer
     */
    public void setSingleplayerMsg(String singleplayerMsg) {
        this.singleplayerMsg = singleplayerMsg;
    }

    /**
     * @return Message shown while in multiplayer
     */
    public String getMultiplayerMsg() {
        return multiplayerMsg;
    }

    /**
     * @param multiplayerMsg Message shown while in multiplayer
     */
    public void setMultiplayerMsg(String multiplayerMsg) {
        this.multiplayerMsg = multiplayerMsg;
    }


    /**
     * @return Detail string while in singleplayer; format string
     */
    public String getSingleplayerDetailFormat() {
        return singleplayerDetailFormat;
    }

    /**
     * @param singleplayerDetailFormat Detail string while in singleplayer; format string
     */
    public void setSingleplayerDetailFormat(String singleplayerDetailFormat) {
        this.singleplayerDetailFormat = singleplayerDetailFormat;
    }

    /**
     * @return Detail string while in multiplayer; format string
     */
    public String getMultiplayerDetailFormat() {
        return multiplayerDetailFormat;
    }

    /**
     * @param multiplayerDetailFormat Detail string while in multiplayer; format string
     */
    public void setMultiplayerDetailFormat(String multiplayerDetailFormat) {
        this.multiplayerDetailFormat = multiplayerDetailFormat;
    }
}
