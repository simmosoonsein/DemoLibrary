package pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllBooksPage extends BasePage {


  @Step("Verify that Local Library Homepage is open")
  public AllBooksPage verifyIfPageOpen() {
    assertThat("Local Library Homepage page not opened!",
        pageContent.findElement(By.tagName("h1")).getText().equals("Book List"));
    return this;
  }

  @Step("Search for created book")
  public void verifyNewlyAddedBookIsVisible(String title, String author) {
    assertTrue("Cannot find book with parameters: " + title + " and " + author,
        checkIfBookIsVisibleInList(title, author));
  }

  private boolean checkIfBookIsVisibleInList(String title, String author) {
    List<WebElement> books = pageContent.findElements(By.tagName("li"));
    for (WebElement book : books) {
      if ((book.getText()).contains(title) && book.getText().contains(author)) {
        return true;
      }
    }
    return false;
  }

}
