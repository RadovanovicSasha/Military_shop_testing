package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    // Link "Uloguj se" postoji SAMO kada nisi ulogovan
    private final By linkZaLogovanje = By.linkText("Uloguj se"); // nova linija - a staro je: private final By loginLink = By.linkText("Uloguj se");

    // Link "O nama"
    private final By oNamaLink = By.linkText("O NAMA");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoggedIn() {
        return driver.findElements(linkZaLogovanje).isEmpty(); // nova linija - a staro je: return driver.findElements(loginLink).isEmpty();
    }

    public void openONama() {
        driver.findElement(oNamaLink).click();
    }
}
