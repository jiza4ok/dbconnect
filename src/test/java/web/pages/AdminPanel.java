package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.web.PageObj;
import web.AbstractPage;

import java.util.List;

public class AdminPanel extends AbstractPage {

    public AdminPanel(WebDriver webDriver) {
        super(webDriver);
    }


    By panelHeading = By.cssSelector(".panel-heading");
    By sideMenuList = By.cssSelector(".app");
    By submenuList = By.cssSelector(".doc");



    public boolean checkHeading(){

            return findList(panelHeading).size() > 0;

    }

    public boolean checkAllHeadings(){
        List< WebElement > sideMenu = findList(sideMenuList);
        for (int i = 0; i< sideMenu.size(); i++){
            sideMenu.get(i).click();
            List<WebElement>submenu = findList(submenuList);
            if(submenu.size()>0){
                System.out.println(submenu.size());
                for (int j=0;j<submenu.size(); j++){
                    submenu.get(j).click();
                    if (checkHeading()==false){return false;}
                }
            }
            else {
                if (checkHeading() == false) {return false;}
            }
        }
        return true;
    }
}
