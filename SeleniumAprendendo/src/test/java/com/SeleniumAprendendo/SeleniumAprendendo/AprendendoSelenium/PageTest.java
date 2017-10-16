package com.SeleniumAprendendo.SeleniumAprendendo.AprendendoSelenium;

import com.SeleniumAprendendo.SeleniumAprendendo.AprendendoSelenium.PageObject.PageBase;
import com.SeleniumAprendendo.SeleniumAprendendo.AprendendoSelenium.PageObject.PageRegister;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PageTest {

    private static PageBase pageBase = new PageBase();

    @BeforeClass
    public static void init(){
        accessURL();
    }

    @AfterClass
    public static void finishingProject() {
        closeNavegator();
    }

    private static void closeNavegator() {
        pageBase.closeNavegator();
    }

    @Test
    public void registerUser()throws Exception{
        register();
    }

    private static void accessURL(){
        pageBase.navegateTo("https://accounts.google.com/SignUp?hl=pt-BR");
    }

    private void register() throws Exception{
        PageRegister register = new PageRegister(PageBase.getDriver());
        register.register();
    }
}
