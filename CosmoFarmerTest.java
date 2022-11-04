package river;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Jack Noll
 */


public class CosmoFarmerTest {

  WebDriver driver = null;

  @Before
  public void setup() {
    System.out.println("Started setup.");
    driver = new FirefoxDriver();
    driver.navigate().to("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/index.php");
    System.out.println("Startup complete.");
  }

  @Test
  public void websiteUp() {
   System.out.println("Started websiteUp test.");
   Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/index.php", driver.getCurrentUrl());
   System.out.println("Completed websiteUp test.");
  }

  @Test
  public void checkExpertLinks() {
    System.out.println("Started checkExpertLinks test.");
    driver.findElement(By.xpath("//*[@id='mainNav']/li[3]/a")).click();
    driver.findElement(By.linkText("Pete")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/pete.php", driver.getCurrentUrl());
    driver.findElement(By.xpath("//*[@id='mainNav']/li[3]/a")).click();
    driver.findElement(By.linkText("Dave")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/dave.php", driver.getCurrentUrl());
    driver.findElement(By.xpath("//*[@id='mainNav']/li[3]/a")).click();
    driver.findElement(By.linkText("Nan")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/nan.php", driver.getCurrentUrl());
    System.out.println("Completed checkExpertLinks test.");
  }

  @Test
  public void validateExpertForms() {
    System.out.println("Started validateExpertForms test.");
    driver.findElement(By.xpath("//*[@id='mainNav']/li[3]/a")).click();
    driver.findElement(By.linkText("Pete")).click();
    driver.findElement(By.id("name")).sendKeys("Jack");
    driver.findElement(By.id("email")).sendKeys("jrnoll@vt.edu");
    driver.findElement(By.id("comment")).sendKeys("This is a comment");
    //sadly I had to disable the send button on all the experts, spammers were sending me emails with the feature on
    Assert.assertEquals("Jack", driver.findElement(By.id("name")).getAttribute("value"));
    Assert.assertEquals("jrnoll@vt.edu", driver.findElement(By.id("email")).getAttribute("value"));
    Assert.assertEquals("This is a comment", driver.findElement(By.id("comment")).getAttribute("value"));
    System.out.println("Completed validateExpertForms test.");
  }

  @Test
  public void checkStoreLinks() {
    System.out.println("Started checkStoreLinks test.");
    driver.findElement(By.xpath("//*[@id=\"mainNav\"]/li[4]")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php", driver.getCurrentUrl());
    driver.findElement(By.linkText("Next")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php?pageNum_rsProducts=1&totalRows_rsProducts=27",
      driver.getCurrentUrl());
    driver.findElement(By.linkText("Next")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php?pageNum_rsProducts=2&totalRows_rsProducts=27",
      driver.getCurrentUrl());
    driver.findElement(By.linkText("First")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php?pageNum_rsProducts=0&totalRows_rsProducts=27",
      driver.getCurrentUrl());
    driver.findElement(By.linkText("Last")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php?pageNum_rsProducts=2&totalRows_rsProducts=27",
      driver.getCurrentUrl());
    System.out.println("Completed checkStoreLinks test.");
  }

  @Test
  public void validateStoreContents() {
    System.out.println("Started validateStoreContents test.");
    driver.findElement(By.xpath("//*[@id=\"mainNav\"]/li[4]")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/storeIndex.php");
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "COSMOFARMER ONLINE STORE");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/p[1]")).getText()
      .contains("Products 1 to 12 of 27"));
    driver.findElement(By.linkText("Next")).click();
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "COSMOFARMER ONLINE STORE");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/p[1]")).getText()
      .contains("Products 13 to 24 of 27"));
    driver.findElement(By.linkText("Next")).click();
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "COSMOFARMER ONLINE STORE");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/p[1]")).getText()
        .contains("Products 25 to 27 of 27"));
    System.out.println("Completed validateStoreContents test.");
  }

  @Test
  public void testProductLinks() {
    System.out.println("Started testProductLinks test.");
    driver.findElement(By.linkText("Clothing")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/category.php?categoryID=5",
      driver.getCurrentUrl());
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "CLOTHING");
    driver.findElement(By.linkText("Pest Control")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/category.php?categoryID=4",
      driver.getCurrentUrl());
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "PEST CONTROL");
      driver.findElement(By.linkText("Plants")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/category.php?categoryID=1",
      driver.getCurrentUrl());
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "PLANTS");
      driver.findElement(By.linkText("Seeds")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/category.php?categoryID=2",
      driver.getCurrentUrl());
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "SEEDS");
      driver.findElement(By.linkText("Tools")).click();
    Assert.assertEquals("https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/category.php?categoryID=3",
      driver.getCurrentUrl());
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "TOOLS");
    System.out.println("Completed testProductLinks test.");
  }

  @Test
  public void testSubscribe() {
    System.out.println("Started testSubscribe test.");
    driver.findElement(By.linkText("Subscribe")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/subscribe.php");
    driver.findElement(By.id("name")).sendKeys("Jack");
    driver.findElement(By.id("email")).sendKeys("jrnoll@vt.edu");
    driver.findElement(By.id("comment")).sendKeys("This is a comment");
    //sadly I had to disable the send button on the subscribe page, spammers were sending me emails with the feature on
    Assert.assertEquals("Jack", driver.findElement(By.id("name")).getAttribute("value"));
    Assert.assertEquals("jrnoll@vt.edu", driver.findElement(By.id("email")).getAttribute("value"));
    Assert.assertEquals("This is a comment", driver.findElement(By.id("comment")).getAttribute("value"));
    System.out.println("Completed testSubscribe test.");
  }

  @Test
  public void testContactUs() {
    System.out.println("Started testContactUs test.");
    driver.findElement(By.linkText("Contact Us")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://naturalherding.com/Jack/Chia_Vet/cosmo_shop/ContactUs.php");
    driver.findElement(By.id("name")).sendKeys("Jack");
    driver.findElement(By.id("email")).sendKeys("jrnoll@vt.edu");
    driver.findElement(By.id("comment")).sendKeys("This is a comment");
    //sadly I had to disable the send button on the contact us page, spammers were sending me emails with the feature on
    Assert.assertEquals("Jack", driver.findElement(By.id("name")).getAttribute("value"));
    Assert.assertEquals("jrnoll@vt.edu", driver.findElement(By.id("email")).getAttribute("value"));
    Assert.assertEquals("This is a comment", driver.findElement(By.id("comment")).getAttribute("value"));
    System.out.println("Completed testContactUs test.");
  }

  @Test
  public void verifyFooter() {
    System.out.println("Started verifyFooter test.");
    Assert.assertEquals("Copyright 2012, CosmoFarmer @ Naturalherding.com",
      driver.findElement(By.xpath("//*[@id=\"container\"]/footer/p")).getText());
    System.out.println("SCompleted verifyFooter test.");
  }

  @After
  public void shutdown() {
    System.out.println("Started shutdown.");
    driver.close();
    System.out.println("Shutdown complete.");
  }

}
