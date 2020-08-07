package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class acessarPortal {
    String url;
    WebDriver driver;


    @Before
    public void Iniciar() {
        url = "https://portal.brq.com/";
        System.setProperty("webdriver.chrome.driver", "Drivers/chrome/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void finalizar() {
     driver.quit();

    }

    @Given("^User abre o portal da BRQ$")
    public void user_abre_o_portal_da_BRQ() throws Throwable {
        driver.get(url);
        System.out.println("Passo 1 - Acessar o portal");
    }

    @And("^Digita o \"([^\"]*)\" e a \"([^\"]*)\"$")
    public void digita_o_e_a(String login, String senha) throws Throwable {
        driver.findElement(By.id("txtUsuario")).click();
        driver.findElement(By.id("txtUsuario")).clear();
        driver.findElement(By.id("txtUsuario")).sendKeys(login);
        driver.findElement(By.id("txtSenha")).click();
        driver.findElement(By.id("txtSenha")).clear();
        driver.findElement(By.id("txtSenha")).sendKeys(senha);
        driver.findElement(By.id("btnEntrar")).click();

        System.out.println("Passo 2 - Digitar Login e Senha");

    }

    @Then("^User clica no icone do relogio$")
    public void user_clica_no_icone_do_relogio() throws Throwable {
        //driver.findElement(By.id("lnkWidgetBaterPonto")).click();
        Thread.sleep(3000);
        System.out.println("Passo 3 - Clicar no botao do Relogio");

    }

    @Then("^clica no botao registrar$")
    public void clica_no_botao_registrar() throws Throwable {
        //driver.findElement(By.id("btnIncluirBatidaModalBaterPonto")).click();

        System.out.println("Passo 4 - Clicar no botao registrar");
    }

    @Then("^user aloca as \"([^\"]*)\" em aberto no \"([^\"]*)\"$")
    public void user_aloca_as_em_aberto_no(String hora, String projeto) throws Throwable {

        Assert.assertEquals("00:00", driver.findElement(By.id("txtHoras")).getText());


        if (hora == "00:00") {
            System.out.println(" Passo 5 - Nada a Fazer");
            driver.quit();
        } else

            driver.findElement(By.id("s2id_txtProjetoApontamento")).click();
        Thread.sleep(3000);
        Select drpproject = new Select(driver.findElement(By.id("txtProjetoApontamento")));
        drpproject.selectByValue("23811");
        driver.findElement(By.id("btnSalvarApontamento")).click();
        driver.findElement(By.id("btnOkModalAlerta")).click();
        System.out.println("Passo 6 - Horas Alocadas com Sucesso");
    }
}