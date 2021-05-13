package cz.czechitas.selenium;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyAutomatizaceDomaciUkolJW {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
//        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void existujiciUcetPrihlaseni() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");

        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        tlacitkoPrihlasit.click();
        WebElement userName = prohlizec.findElement(By.id("email"));
        userName.sendKeys("jarka.parkova@seznam.cz");
        WebElement userPassword = prohlizec.findElement(By.id("password"));
        userPassword.sendKeys("123456Ac");
        WebElement loginButton = prohlizec.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement zalogovano = prohlizec.findElement(By.xpath("//*[text() ='Přihlášen']"));
        Assertions.assertNotNull(zalogovano);

        System.out.println("TEST prihlaseni existujiciho uctu probehl OK");

    }



    @Test
    public void prihlasenyUcetVybereKurz() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");

        //WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[text()= 'Přihlásit                ']"));
        tlacitkoPrihlasit.click();
        WebElement userName = prohlizec.findElement(By.id("email"));
        userName.sendKeys("jarka.parkova@seznam.cz");
        WebElement userPassword = prohlizec.findElement(By.id("password"));
        userPassword.sendKeys("123456Ac");
        WebElement loginButton = prohlizec.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement tlacitkoProRodice = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/pro-rodice']"));
        tlacitkoProRodice.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/zaci/pridat']"));
        tlacitkoVytvoritPrihlasku.click();
        WebElement tlacitkoInfoWeb = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/11-trimesicni-kurzy-webu']"));
        tlacitkoInfoWeb.click();
        WebElement tlacitkoPrihlasitWeb = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/zaci/pridat/41-html-1']"));
        tlacitkoPrihlasitWeb.click();

        WebElement vyberTerminSeznam = prohlizec.findElement(By.xpath("//div[@class='filter-option-inner-inner']"));
        vyberTerminSeznam.click();
        WebElement vyberTermin = prohlizec.findElement(By.id("bs-select-1"));
        vyberTermin.click();

        WebElement jmenoPrihlaseneho = prohlizec.findElement(By.id("forename"));
        jmenoPrihlaseneho.sendKeys("Jarda");
        WebElement prijmeniPrihlaseneho = prohlizec.findElement(By.id("surname"));
        prijmeniPrihlaseneho.sendKeys("Petarda");
        WebElement datumNarozeniPrihlaseneho = prohlizec.findElement(By.id("birthday"));
        datumNarozeniPrihlaseneho.sendKeys("1.1.2014");
        WebElement platbaSlozenkou = prohlizec.findElement(By.xpath("//label[@for='payment_postal_order']"));
        platbaSlozenkou.click();
        WebElement souhlasSPodminky = prohlizec.findElement(By.xpath("//label[@for='terms_conditions']"));
        souhlasSPodminky.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("//input[@class='btn btn-primary mt-3']"));
        vytvoritPrihlasku.click();

//        WebElement polickoJmenoRodice = prohlizec.findElement(By.id("parent_name"));
//        String jmenoRodice = polickoJmenoRodice.getAttribute("value");

        WebElement potvrzeniPrihlaseni = prohlizec.findElement(By.xpath("//a[text() = 'Stáhnout potvrzení o přihlášení']"));
        Assertions.assertEquals("a",potvrzeniPrihlaseni.getTagName());

    }


    @Test
    public void rodicVybereKurzPakPrihlaseni() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");

        //WebElement tlacitkoInfoProgramovani = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/31-trimesicni-kurzy-programova']"));
        WebElement tlacitkoInfoProgramovani = prohlizec.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/div/div[2]/a"));
        tlacitkoInfoProgramovani.click();

        WebElement tlacitkoPrihlasitJava = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/zaci/pridat/71-java-1']"));
        tlacitkoPrihlasitJava.click();

        WebElement userName = prohlizec.findElement(By.id("email"));
        userName.sendKeys("jarka.parkova@seznam.cz");
        WebElement userPassword = prohlizec.findElement(By.id("password"));
        userPassword.sendKeys("123456Ac");
        WebElement loginButton = prohlizec.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


        WebElement vyberTerminSeznam = prohlizec.findElement(By.xpath("//div[@class='filter-option-inner-inner']"));
        vyberTerminSeznam.click();
        WebElement vyberTermin = prohlizec.findElement(By.id("bs-select-1"));
        vyberTermin.click();

        WebElement jmenoPrihlaseneho = prohlizec.findElement(By.id("forename"));
        jmenoPrihlaseneho.sendKeys("Jarina");
        WebElement prijmeniPrihlaseneho = prohlizec.findElement(By.id("surname"));
        prijmeniPrihlaseneho.sendKeys("Petardina");
        WebElement datumNarozeniPrihlaseneho = prohlizec.findElement(By.id("birthday"));
        datumNarozeniPrihlaseneho.sendKeys("2.2.2010");
        WebElement platbaBankPrevodem = prohlizec.findElement(By.xpath("//label[@for='payment_transfer']"));
        platbaBankPrevodem.click();
        WebElement souhlasSPodminky = prohlizec.findElement(By.xpath("//label[@for='terms_conditions']"));
        souhlasSPodminky.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("//input[@class='btn btn-primary mt-3']"));
        vytvoritPrihlasku.click();

        WebElement potvrzeniPrihlaseni = prohlizec.findElement(By.xpath("//*[text() = 'Stáhnout potvrzení o přihlášení']"));
        Assertions.assertEquals("a",potvrzeniPrihlaseni.getTagName());
    }


    @Test
    public void kontrolaJmenaUzivatele() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");

        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        tlacitkoPrihlasit.click();
        WebElement userName = prohlizec.findElement(By.id("email"));
        userName.sendKeys("jarka.parkova@seznam.cz");
        WebElement userPassword = prohlizec.findElement(By.id("password"));
        userPassword.sendKeys("123456Ac");
        WebElement loginButton = prohlizec.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement tlacitkoDetailPrihlasky = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[5]/td[5]/div/a[1]"));
        tlacitkoDetailPrihlasky.click();
        WebElement polickoJmenoPrijmeniZakonnehoZastupce = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/table/tbody/tr[10]/td[2]"));
        String jmenoPrijmeniZakonnehoZastupce = polickoJmenoPrijmeniZakonnehoZastupce.getText();

        Assertions.assertEquals("Jarka Parkova",jmenoPrijmeniZakonnehoZastupce);

        System.out.println("TEST kontroly jmena rodice probehl OK");

    }


    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
