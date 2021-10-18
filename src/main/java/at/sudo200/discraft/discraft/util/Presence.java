package at.sudo200.discraft.discraft.util;

import net.arikia.dev.drpc.DiscordRichPresence;

public class Presence extends DiscordRichPresence.Builder {
    private static long startTime = System.currentTimeMillis();

    /**
     * Initiates a new instance of the Presence builder.
     * Wrapped in subclass for convenience.
     *
     * @param state String representing the player's current state.
     * @see DiscordRichPresence
     */
    public Presence(String state) {
        super(state);

        final String text = getClass().getPackage() != null && getClass().getPackage().getImplementationVersion() != null
                ? "Minecraft " + getClass().getPackage().getImplementationVersion()
                : "Minecraft";
        setStartTimestamps(startTime);
        setBigImage("grass", text);
    }
}
