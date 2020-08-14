
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilis.FunctionalTestExtended;

import static org.junit.Assert.*;


public
class BasicTest extends FunctionalTestExtended {
    String baseUrl = "https://www.themoviedb.org/";



    @Test
    public
    void test1_testNavigationPanel () {
        driver.get (baseUrl);

        driver.findElement (By.xpath ("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/a")).click ();
        driver.findElement (By.xpath ("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/div/ul/li[1]/a")).click ();

        WebElement navigationBtn =
                driver.findElement (By.xpath ("//*[@id=\"media_v4\"]/div/div/div[1]/h2"));
        assertTrue (navigationBtn.isDisplayed ());
        assertEquals (navigationBtn.getText (), "Popular Movies");
        WebElement searchBtn =
                driver.findElement (By.xpath ("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[4]/p/a"));
        assertTrue (searchBtn.isEnabled ());

    }

    @Test
    public
    void test2_basicSearchViaSearchBox () {
        driver.get (baseUrl);
        driver.findElement (By.xpath ("//*[@id=\"inner_search_v4\"]")).
                sendKeys ("Parasite");
        driver.findElement (By.xpath ("//*[@id=\"inner_search_form\"]/input")).click ();

        WebElement searchResultsBtn =
                driver.findElement (By.xpath ("//*[@id=\"main\"]/section/div/div/div[1]/div/h3"));
        assertTrue (searchResultsBtn.isDisplayed ());
        assertEquals (searchResultsBtn.getText (), "Search Results");

        // TODO each element of list items contains search string

    }

    @Test
    public
    void test3_basicSearchViaSearchIcon () {
        driver.get (baseUrl);
        driver.findElement (By.xpath ("/html/body/div[1]/header/div[1]/div/div[2]/ul/li[5]/a[1]/span")).click ();
        driver.findElement (By.xpath ("//*[@id=\"search_v4\"]")).
                sendKeys ("Parasite");

        // TODO Autocomplete list items contains search string

        driver.findElement (By.xpath ("//*[@id=\"search_v4\"]")).sendKeys (Keys.ENTER);
        WebElement searchResultsBtn =
                driver.findElement (By.xpath ("//*[@id=\"main\"]/section/div/div/div[1]/div/h3"));
        assertTrue (searchResultsBtn.isDisplayed ());
        assertEquals (searchResultsBtn.getText (), "Search Results");


        driver.findElement (By.xpath ("//*[@id=\"search_v4\"]")).
                sendKeys ("Parasate");


        // TODO extend to more cases e.g low & upper register, fuzzy search etc.
    }

    @Test
    public
    void test4_searchUsingFilters () {
        driver.get (baseUrl);

        driver.findElement (By.xpath ("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/a")).click ();
        driver.findElement (By.xpath ("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/div/ul/li[1]/a")).click ();

        WebElement navigationBtn =
                driver.findElement (By.xpath ("//*[@id=\"media_v4\"]/div/div/div[1]/h2"));
        assertTrue (navigationBtn.isDisplayed ());
        assertEquals (navigationBtn.getText (), "Popular Movies");

        WebElement searchBtn =
                driver.findElement (By.xpath ("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[4]/p/a"));
        assertTrue (searchBtn.isDisplayed ());
        assertEquals (searchBtn.getText (),"Search");

        driver.findElement (By.xpath ("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[2]/div[1]")).click ();

    //TODO scroll down the page to find this btn ->  driver.findElement (By.xpath ("//*[@id=\"with_genres\"]/li[13]/a")).click ();

        assertTrue (searchBtn.isEnabled ());
        searchBtn.click ();



    }

}