package tests.web;

import controllers.ConfigLoader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;


@Epic("Demo Tests")
@Feature("Local Library")
public class LibraryTests {


  @BeforeMethod
  public void setup(){
    ConfigLoader.loadUserConfigToSystemProperties();
  }

  @DataProvider(name = "Books")
  public static Object[][] books() {
    return new Object[][]{
        {"Book1", "Lewis", "Summary1", "215788", "Fiction"},
        {"Book2", "Kenobi", "Summary2", "215789", "Non-fiction"}
    };
  }


  @Test(description = "Add new book to catalogue", dataProvider = "Books")
  public void addNewBook(String title, String author, String summary, String isbn, String genre) {
    new BasePage().navigateToUrl()
        .verifyIfMainLibraryPageOpen()
        .clickCreateNewBook()
        .verifyIfNewBookRegisterPageOpen()
        .fillBookTitle(title)
        .fillAuthor(author)
        .fillSummary(summary)
        .fillIsbn(isbn)
        .selectGerne(genre)
        .clickSubmitButton()
        .verifyIfBookDetailsPageOpen()
        .verifyNewBookDetailsShown(title, author, summary, isbn, genre);
  }

  @Test(description = "Verify newly added book is listed in catalogue", dataProvider = "Books")
  public void verifyNewlyAddedBookIsInCatalogue(String title, String author, String summary, String isbn, String genre) {
    new BasePage().navigateToUrl()
        .verifyIfMainLibraryPageOpen()
        .clickAllBooks()
        .verifyIfAllBooksListPageOpen()
        .verifyNewlyAddedBookIsVisible(title, author);
  }

}
