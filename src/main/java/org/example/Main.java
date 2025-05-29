package org.example;

import com.microsoft.playwright.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        String URL = "https://www.youtube.com/watch?v=OXvQH2xk6WI";
        page.navigate(URL);
        System.out.println("Title: " + page.title());
        page.waitForLoadState();
        Thread.sleep(1500);
        Locator pauseButton = page.locator("//button[contains(@class, 'ytp-play-button')]");
        pauseButton.click();
        Thread.sleep(2000);
        pauseButton.click();
        Locator volume = page.locator("//div[contains(@class, 'ytp-volume-icon')]");
        volume.click();
        Thread.sleep(1000);
        volume.click();
//        Thread.sleep(1500);
        Locator cinemaMode = page.locator("//button[@data-title-no-tooltip = \"Theater mode\"]");
        cinemaMode.click();
        Thread.sleep(1000);
        Locator defaultView = page.locator("//button[@data-title-no-tooltip = \"Default view\"]");
        defaultView.click();
        Locator fullScreen = page.locator("//button[@data-title-no-tooltip = \"Full screen\"]");
        fullScreen.click();
        Locator next = page.locator("//a[contains(@class, 'ytp-next-button')]");
        next.click();
    }
}