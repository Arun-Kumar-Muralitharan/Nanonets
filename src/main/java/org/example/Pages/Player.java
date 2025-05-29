package org.example.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Player
{
    private final Page page;

    public Player(Page page)
    {
        this.page = page;
    }

//    Locators
    private final String URL = "https://www.youtube.com/watch?v=OXvQH2xk6WI";
    private final String pauseButton = "//button[contains(@class, 'ytp-play-button')]";
    private final String volume = "//div[contains(@class, 'ytp-volume-icon')]";
    private final String cinemaMode = "//button[@data-title-no-tooltip = \"Theater mode\"]";
    private final String defaultView = "//button[@data-title-no-tooltip = 'Default view']";
    private final String fullScreen = "//button[@data-title-no-tooltip = \"Full screen\"]";
    private final String next = "//a[contains(@class, 'ytp-next-button')]";

    /**
     * Call this method to open the Youtube Video
     */
    public void openYoutube()
    {
        page.navigate(URL);
    }

    /**
     * Call this method to pause and play the video
     * @throws InterruptedException
     */
    public void pauseAndPlay() throws InterruptedException
    {
        Locator pauseOrPlay = page.locator(pauseButton);
        pauseOrPlay.click();
        Thread.sleep(1500);
        pauseOrPlay.click();
    }

    /**
     * Call this method to Mute and Unmute the volume
     * @throws InterruptedException
     */
    public void changeVolume() throws InterruptedException
    {
        Locator volumeControl = page.locator(volume);
        volumeControl.click();
        Thread.sleep(1500);
        volumeControl.click();
    }

    /**
     * Call this method to open the Cinema Mode
     * @throws InterruptedException
     */
    public void cinemaMode() throws InterruptedException
    {
        Locator theaterMode = page.locator(cinemaMode);
        theaterMode.click();
        Thread.sleep(1500);
    }

    /**
     * Call this methid to toggle to default view
     * @throws InterruptedException
     */
    public void defaultView() throws InterruptedException
    {
        Locator defaultScreen = page.locator(defaultView);
        defaultScreen.click();
        Thread.sleep(1000);
    }

    /**
     * Call this method to enter Full Screen Mode
     * @throws InterruptedException
     */
    public void fullScreen() throws InterruptedException
    {
        Locator screen = page.locator(fullScreen);
        screen.click();
        Thread.sleep(1000);
    }

    /**
     * Call this method to exit full Screen
     */
    public void exitFullScreen()
    {
        page.keyboard().press("F");
    }

    /**
     * Call this method to click next video
     * @throws InterruptedException
     */
    public void nextVideo() throws InterruptedException
    {
        Locator nextVideo = page.locator(next);
        nextVideo.click();
        page.waitForLoadState();
        Thread.sleep(1500);
    }
}
