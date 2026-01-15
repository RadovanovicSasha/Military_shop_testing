package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class MilitaryShopSmokeTests extends BaseTest {

    @Test(groups = {"Smoke"})
    public void smoke_loginPageHasFields() {
        // Provera da login forma postoji (username, password, login dugme)
        Assert.assertTrue(driver.findElements(By.id("username")).size() > 0, "Nema username polja");
        Assert.assertTrue(driver.findElements(By.id("password")).size() > 0, "Nema password polja");
        Assert.assertTrue(driver.findElements(By.name("login")).size() > 0, "Nema login dugmeta");
    }

    @Test(groups = {"Smoke"})
    public void smoke_openONamaPage() {
        // Otvori home pa klik na "O NAMA"
        driver.get("https://www.militaryshop.rs/");
        HomePage homePage = new HomePage(driver);
        homePage.openONama();

        // Provera da je otvorena prava stranica (URL sadrži /o-nama/)
        Assert.assertTrue(driver.getCurrentUrl().contains("/o-nama"), "Nije otvorena 'O nama' stranica!");
    }
}
