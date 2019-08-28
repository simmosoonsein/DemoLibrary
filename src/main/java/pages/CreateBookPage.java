package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateBookPage {


  private WebElement titleTextfield = $(By.id("title"));
  private WebElement authorDropdown = $(By.id("author"));
  private WebElement summaryTextfield = $(By.id("summary"));
  private WebElement isbnTextfield = $(By.id("isbn"));
  private ElementsCollection genreCheckbox = $$(By.className("checkbox-input"));
  private WebElement submitButton = $(By.className("btn-primary"));
  private final int NON_FICTION_INDEX = 0;
  private final int FICTION_INDEX = 1;


  @Step("Verify that New Book input page is open")
  public CreateBookPage verifyIfPageOpen() {
    assertThat("Create Book page not opened!",
        titleTextfield.isDisplayed() && submitButton.isDisplayed() && isbnTextfield.isDisplayed());
    return this;
  }

  @Step("Fill book title")
  public CreateBookPage fillBookTitle(String title) {
    titleTextfield.sendKeys(title);
    return this;
  }

  @Step("Fill author")
  public CreateBookPage fillAuthor(String author) {
    List<WebElement> authors = authorDropdown.findElements(By.tagName("option"));
    for (WebElement authorDropdownValue : authors) {
      if (authorDropdownValue.getText().contains(author)) {
        authorDropdownValue.click();
      }
    }
    return this;
  }

  @Step("Fill summary")
  public CreateBookPage fillSummary(String summary) {
    summaryTextfield.sendKeys(summary);
    return this;
  }

  @Step("Fill isbn")
  public CreateBookPage fillIsbn(String isbn) {
    isbnTextfield.sendKeys(isbn);
    return this;
  }

  @Step("Select genre")
  public CreateBookPage selectGerne(String genre) {
    switch (genre) {
      case "Non-fiction":
        genreCheckbox.get(NON_FICTION_INDEX).click();
        break;
      case "Fiction":
        genreCheckbox.get(FICTION_INDEX).click();
        break;
      default:
        throw new Error("Genre not defined in test method: " + genre);
    }
    return this;
  }

  @Step("Click 'Submit' button")
  public BookDetailsPage clickSubmitButton() {
    submitButton.click();
    return new BookDetailsPage();
  }

}
