package web.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import utils.web.WebDriverManager;

@Slf4j
public class Execute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getWebDriver("chrome");
        driver.get("http://3.122.51.38/litecart/admin/login.php");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin", "gl_admin");

        AdminPanel adminPanel = new AdminPanel(driver);
        adminPanel.checkAllHeadings();
        System.out.println(adminPanel.checkAllHeadings());
        driver.quit();
    }
}
