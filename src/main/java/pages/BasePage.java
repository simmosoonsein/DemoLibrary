package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {


  WebElement pageContent = $(By.className("col-sm-10"));
  private WebElement newBookUrl = $(By.linkText("Create new book"));
  private WebElement allBooksUrl = $(By.linkText("All books"));


  @Step("Navigage to given URL")
  public BasePage navigateToUrl() {
    open(System.getProperty("test.url"));
    return this;
  }

  @Step("Verify that Local Library Homepage is open")
  public BasePage verifyIfMainLibraryPageOpen() {
    assertThat("Local Library Homepage page not opened!",
        pageContent.findElement(By.tagName("h1")).getText().equals("Local Library Home")
            && newBookUrl.isDisplayed() && allBooksUrl.isDisplayed());
    return this;
  }

  @Step("Click on 'Create new book' menu ")
  public CreateBookPage clickCreateNewBook() {
    newBookUrl.click();
    return new CreateBookPage();
  }

  @Step("Click on 'All books' menu ")
  public AllBooksPage clickAllBooks() {
    allBooksUrl.click();
    return new AllBooksPage();
  }
}
