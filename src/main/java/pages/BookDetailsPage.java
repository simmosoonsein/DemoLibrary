package pages;

import static org.hamcrest.MatcherAssert.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookDetailsPage extends BasePage {


  private String pageContentText = pageContent.getText();

  @Step("Verify that Book Details page is open")
  public BookDetailsPage verifyIfBookDetailsPageOpen() {
    assertThat("Book Details page not opened!",
        pageContent.findElement(By.tagName("h1")).getText().contains("Title:"));
    return this;
  }

  @Step("Verify that new Book Details are shown")
  public void verifyNewBookDetailsShown(String title, String author, String summary, String isbn,
      String genre) {

    assertThat("Book Details are not displayed!",
        pageContentText.contains(title) && pageContentText.contains(author) && pageContentText
            .contains(summary) && pageContentText.contains(isbn) && pageContentText
            .contains(genre));
  }


}
