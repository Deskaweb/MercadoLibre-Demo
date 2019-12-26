package Pages;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sun.awt.windows.WBufferStrategy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MercadoLibrePage extends PageBase {

    private WebElement IMG_LOGO() {return webDriver.findElement(By.xpath("/html/body/header/div/a[2]"));}
    private WebElement TXT_BUSCAR() {return webDriver.findElement(By.xpath("/html/body/header/div/form/input"));}

    public void AbrirWeb() {
        System.setProperty("webdriver.chrome.driver","src/main/Resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://www.mercadolibre.com.ar");
        webDriver.manage().window().maximize();
    }

    public void ValidarIngreso() {
        IMG_LOGO().isDisplayed();
    }

    private WebElement BTN_CATEGORIAS() {return webDriver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]/a"));}
    private WebElement LBL_CAT(String c) {return webDriver.findElement(By.xpath("*//li/a[contains(text(),'"+c+"')]"));}
    private WebElement LBL_SUB(String s) {return webDriver.findElement(By.xpath("*//ul//a[contains(text(),'"+s+"')]"));}
    private WebElement LBL_TITULOSUB() {return webDriver.findElement(By.xpath("//*[@id='inner-main']/aside/div[1]/h1"));}
    private WebElement LBL_CANTRESULTADO() {return webDriver.findElement(By.xpath("//*[@id='inner-main']/aside/div[2]"));}
    private WebElement BTN_GRILLA() {return webDriver.findElement(By.xpath("//*[@id='inner-main']/aside/section[1]/dl/ul/li[2]/a/div"));}
    private WebElement RES_GRILLA(Integer i) {return webDriver.findElement(By.xpath("//*[@id='searchResults']/li["+i+"]"));}
    private WebElement BTN_LLEGANHOY() {return webDriver.findElement(By.xpath("//*[@id='search-results-disclaimers']/section/div/a/span"));}
    private WebElement LBL_LLEGA(Integer i){return webDriver.findElement(By.xpath("(//div[contains(@class,'item__shipping highlighted free-shipping ')])["+i+"]"));}
    private WebElement BTN_ORDENAR() {return webDriver.findElement(By.xpath("//*[@id='inner-main']/aside/section[1]/dl/div/div/label/div"));}
    private WebElement LBL_MAYORPRECIO() {return webDriver.findElement(By.xpath("//a[contains(text(),' Mayor precio ')]"));}
    private WebElement LBL_PRECIO(Integer i){return webDriver.findElement(By.xpath("(//span[contains(@class,'price__fraction')])["+i+"]"));}
    private WebElement LBL_UBICACION(String ub) {return webDriver.findElement(By.xpath("(//a[contains(@title,'"+ub+"')])[1]"));}
    private WebElement LBL_TITULOREULTADO(Integer i) {return webDriver.findElement(By.xpath("(*//span[contains(@class,'main-title')])["+i+"]"));}
    private WebElement LBL_VALORREULTADO(Integer i) {return webDriver.findElement(By.xpath("(*//span[contains(@class,'price__fraction')])["+i+"]"));}
    private WebElement LBL_TITULOPUBLICACION() {return webDriver.findElement(By.xpath("*//h1[contains(@class,'item-title__primary ')]"));}
    private WebElement LBL_VALORPUBLICACION() {return webDriver.findElement(By.xpath("//*[@id='productInfo']/fieldset[1]/span/span[2]"));}

    private Integer CantidadDeResultados(){
        int Contador = 1;
        try {
            while (RES_GRILLA(Contador).isEnabled()) {
                Contador = Contador + 1;
            }
        } catch (Exception e) {
            Contador = Contador - 1;
        }
        return Contador;
    }

    public void IngresarSubcategoria(String categoria, String sub) {
        Sleep(2);
        BTN_CATEGORIAS().click();
        try {
            LBL_CAT(categoria).click();
            Sleep(1);
            LBL_SUB(sub).click();
        } catch (Exception e){
            System.out.println("La categoria no existe");
            System.out.println(e);
        }
        Sleep(2);
    }

    public void ValidarSubYCantidad(String sub) {
        Assert.assertTrue(LBL_TITULOSUB().getText().equals(sub), "El nombre mostrado es incorrecto");
        LBL_CANTRESULTADO().isDisplayed();
        System.out.println("LA CANTIDAD DE RESULTADOS ES: " + LBL_CANTRESULTADO().getText());
    }

    public void CerrarDriver(){
        closeDown();
    }

    public void CambioDeVistaGrilla() {
        BTN_GRILLA().click();
        Sleep(2);
    }

    public void CantidadDeElementos() {
        System.out.println("LA CANTIDAD DE RESULTADOS EN LA GRILLA ES DE: " + CantidadDeResultados());
    }

    public void OpcionLleganHoy() {
        BTN_LLEGANHOY().click();
        Sleep(2);
    }

    public void Verificar5RegistrosLleganHoy() {
        int i = 1;
        while (i <= 5){
            Assert.assertTrue(LBL_LLEGA(i).getText().contains("Llega gratis hoy") || LBL_LLEGA(i).getText().contains("Llega hoy"), "No tiene el mensaje");
            i = i + 1;
        }

    }

    public void OrdenarMayorPrecio() {
        BTN_ORDENAR().click();
        LBL_MAYORPRECIO().click();
        Sleep(2);
    }

    public void VerificarResultado() {
        System.out.println("EL PRECIO DEL PRIMER RESULTADO ES DE: $" + LBL_PRECIO(1).getText());
        System.out.println("EL PRECIO DEL ULTIMO RESULTADO ES DE: $"+LBL_PRECIO(CantidadDeResultados()).getText());
    }


    public void FiltrarUbicacion(String ubicacion) {
        LBL_UBICACION(ubicacion).click();
        Sleep(2);
    }

    public void VerificarDatosPublicacion() {
        int valor = (int) (Math.random() * CantidadDeResultados()) + 1;
        String Titulo_Resultado = LBL_TITULOREULTADO(valor).getText();
        String Valor_Resultado = LBL_VALORREULTADO(valor).getText();
        LBL_TITULOREULTADO(valor).click();
        Sleep(2);
        Assert.assertTrue(LBL_TITULOPUBLICACION().getText().equals(Titulo_Resultado),"El titulo no es el mismo");
        Assert.assertTrue(LBL_VALORPUBLICACION().getText().equals(Valor_Resultado),"El valor no es el mismo");
        System.out.println("EL PRODUCTO ES: "+Titulo_Resultado);
        System.out.println("EL VALOR ES: "+Valor_Resultado);

    }
}
