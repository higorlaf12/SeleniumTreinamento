package com.SeleniumAprendendo.SeleniumAprendendo.AprendendoSelenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class registerGmailTest {

    private static WebDriver driver;

    @BeforeClass
    public static void init() {

        System.setProperty("webdriver.chrome.driver","C:/ArquivosProgramaJava/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions(); chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://accounts.google.com/SignUp?hl=pt-BR");


    }

    @AfterClass
    public static void finalizando() {
        driver.quit();
    }
    //Resposta:
    @Test
    public void AnomeSobreNome() throws Exception {

//Espera o elemento.
        Thread.sleep(1000);
        WebDriverWait elementNome = new WebDriverWait(driver, 120);
//Ele serve para quando o selenium entrar em alguma pagina ele não passar direto, ele espera ate o item ficar visivel.        elementNome.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        //Aqui ele va inserir no campo by.id um nome qualquer
        elementNome.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys("QualquerNome");

        assertEquals("QualquerNome",driver.findElement(By.id("FirstName")).getAttribute("value"));

        //ELe ira inserir um sobre nome qualquer
        WebElement elementSobreNome = driver.findElement(By.id("LastName"));
        elementSobreNome.sendKeys("QualquerSobreNome");

    }

    @Test
    public void BescolhaSeuUsuarioESenha() throws Exception {

        WebElement elementSeuUsuario = driver.findElement(By.name("GmailAddress"));
        elementSeuUsuario.sendKeys("QualquerEmaiaaaal@gmail.com.br");


        WebElement elementSuaSenha = driver.findElement(By.cssSelector("[type=\"password\"]"));
        elementSuaSenha.sendKeys("QualquerSenha123");


        WebElement elementConfirmaSenha =
                driver.findElement(By.name("PasswdAgain"));
        elementConfirmaSenha.sendKeys("QualquerSenha123");
    }

    @Test
    public void CdataDeNascimento() throws Exception {
        WebElement elementDia = driver.findElement(By.id("BirthDay"));
        elementDia.sendKeys("06");


        //Referente ao campo de mês de nasciometo, não teve outra alternativa a não ser o xpath, pois não apresentava nenhuma das opção de captura do selenium a não ser o xpath.

//Ira clicar no dropBox
        driver.findElement(By.xpath("//*[@id='BirthMonth']/div[1]")).click();

//Ira selecionar o 4 elemento da Div  que é o mês abril
        driver.findElement(By.xpath("//*[@id=':4']/div")).click();
// O que você acha de usar o xpath, para que serve ?
        WebElement elementAno = driver.findElement(By.id("BirthYear"));
        elementAno.sendKeys("1997");//Tem que ser maior de 18 anos

    }

    @Test
    public void EescolhaSexo() throws Exception {

        //Outro dropBox mas esse e referente  ao tipo de sexo do indivíduo
        //Ira clicar no dropBox sexo

        driver.findElement(By.xpath("//*[@id='Gender']/div[1]")).click();
// Porque não é uma boa pratica usar o Xpath ? E quando usar ele ?
//Ira selecionar o elemento f que é o Masculino na tabela desse dropBox
        driver.findElement(By.xpath("//*[@id=':f']/div")).click();
    }

    @Test
    public void FfinalCelularEmailAtualClique() throws Exception {


        WebElement elementCelular = driver.findElement(By.id("RecoveryPhoneNumber"));
        elementCelular.sendKeys("34988757489");


        WebElement elementEmailAtual = driver.findElement(By.id("RecoveryEmailAddress"));
        elementEmailAtual.sendKeys("neppoadm@neppoadm.com.br");


        WebElement elementCliqueProximaEtapa = driver.findElement(By.id("submitbutton"));
        elementCliqueProximaEtapa.click();

    }

}
