import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.Pages.Player;
import org.junit.jupiter.api.*;

public class videoPlayerTest
{
    static Playwright playwright;
    static Browser browser;
    static Page page;

    @BeforeAll
    static void setup()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void createPage()
    {
        page = browser.newPage();
    }

    @AfterEach
    void closePage()
    {
        page.close();
    }

    @AfterAll
    static void tearDown()
    {
        playwright.close();
    }

    @Test
    public void testVideoPlayer() throws InterruptedException {
        Player player = new Player(page);
//        Step 1: Open Youtube
        player.openYoutube();
//        Step 2: Pause and Play Video
        player.pauseAndPlay();
//        Step 3: Mute and Unmute the Volume
        player.changeVolume();
//        Step 4: Toggle Theater Mode
        player.cinemaMode();
//        Step 5: Toggle back to Default
        player.defaultView();
//        Step 5: Toggle Full Screen
        player.fullScreen();
//        Step 6: Exit Full Screen
        player.exitFullScreen();
//        Step 7: Play Next Video
        player.nextVideo();
    }
}