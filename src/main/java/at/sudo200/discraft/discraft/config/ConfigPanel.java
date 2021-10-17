package at.sudo200.discraft.discraft.config;

import com.mumfrey.liteloader.modconfig.ConfigPanelHost;

public class ConfigPanel implements com.mumfrey.liteloader.modconfig.ConfigPanel {

    /**
     * Panels should return the text to display at the top of the config panel
     * window.
     */
    @Override
    public String getPanelTitle() {
        return "Configure Discraft";
    }

    /**
     * Get the height of the content area for scrolling purposes, return -1 to
     * disable scrolling.
     */
    @Override
    public int getContentHeight() {
        return -1;
    }

    /**
     * Called when the panel is displayed, initialise the panel (read settings,
     * etc)
     *
     * @param host panel host
     */
    @Override
    public void onPanelShown(ConfigPanelHost host) {

    }

    /**
     * Called when the window is resized whilst the panel is active
     *
     * @param host panel host
     */
    @Override
    public void onPanelResize(ConfigPanelHost host) {

    }

    /**
     * Called when the panel is closed, panel should save settings
     */
    @Override
    public void onPanelHidden() {

    }

    /**
     * Called every tick
     *
     * @param host
     */
    @Override
    public void onTick(ConfigPanelHost host) {
    }

    /**
     * Draw the configuration panel
     *
     * @param host
     * @param mouseX
     * @param mouseY
     * @param partialTicks
     */
    @Override
    public void drawPanel(ConfigPanelHost host, int mouseX, int mouseY, float partialTicks) {

    }

    /**
     * Called when a mouse button is pressed
     *
     * @param host
     * @param mouseX
     * @param mouseY
     * @param mouseButton
     */
    @Override
    public void mousePressed(ConfigPanelHost host, int mouseX, int mouseY, int mouseButton) {

    }

    /**
     * Called when a mouse button is released
     *
     * @param host
     * @param mouseX
     * @param mouseY
     * @param mouseButton
     */
    @Override
    public void mouseReleased(ConfigPanelHost host, int mouseX, int mouseY, int mouseButton) {

    }

    /**
     * Called when the mouse is moved
     *
     * @param host
     * @param mouseX
     * @param mouseY
     */
    @Override
    public void mouseMoved(ConfigPanelHost host, int mouseX, int mouseY) {

    }

    /**
     * Called when a key is pressed
     *
     * @param host
     * @param keyChar
     * @param keyCode
     */
    @Override
    public void keyPressed(ConfigPanelHost host, char keyChar, int keyCode) {

    }
}
