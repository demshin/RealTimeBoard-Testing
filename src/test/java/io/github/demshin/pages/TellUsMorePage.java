package io.github.demshin.pages;

import io.github.demshin.utils.Generators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TellUsMorePage extends GenericPage {
    private static final String PAGE_URL = "https://realtimeboard.com/signup/";

    public TellUsMorePage() {
        super(false);
    }

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlideTitle;

    @FindBy(css = "select[ng-options='option as option.label for option in ctrl.roles.options']")
    private WebElement selectRoleDropdown;

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlideTitle.getText().equals("Tell us more\nabout yourself");
    }

    public void selectRole() {
        String role = Generators.randomRole();
        Select dropdown = new Select(selectRoleDropdown);
        dropdown.selectByVisibleText(role);

      //  selectRoleDropdown.click();

    }
}
