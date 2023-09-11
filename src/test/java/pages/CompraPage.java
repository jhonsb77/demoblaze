package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;


public class CompraPage extends PageObject {

    @FindBy(xpath = "//a[contains(text(),'PRODUCT STORE')]")
    WebElementFacade btnInicio;

    @FindBy(xpath = "//*[text()='Add to cart']")
    WebElementFacade btnAddToCart;

    @FindBy(id = "cartur")
    WebElementFacade btnVerCarrito;

    @FindBy(xpath = "//h2[text()='Products']")
    WebElementFacade lblProductos;

    @FindBy(xpath = "//tbody[@id='tbodyid']//td[2]")
    List<WebElementFacade> listaProductos;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElementFacade btnPlaceOrder;

    @FindBy(id = "name")
    WebElementFacade txtName;

    @FindBy(id = "country")
    WebElementFacade txtCountry;

    @FindBy(id = "city")
    WebElementFacade txtCity;

    @FindBy(id = "card")
    WebElementFacade txtCard;

    @FindBy(id = "month")
    WebElementFacade txtMonth;

    @FindBy(id = "year")
    WebElementFacade txtYear;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElementFacade btnPurchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElementFacade lblPurchaseSuccess;

    @FindBy(xpath = "//button[text()='Next']")
    WebElementFacade btnNext;


    public void agregoLosProductosAlCarritoDeCompra(String producto) throws InterruptedException {
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(btnInicio);
        WebElementFacade btnProduct = find(By.xpath("//a[text()='"+producto+"']"));
        if(!btnProduct.isPresent()){
            try{
                scrollWebElementFacade(btnProduct);
            }catch (Exception e){
                scrollWebElement(btnNext);
                btnNext.click();
            }
            Thread.sleep(2000);
            scrollWebElement(btnProduct);
        }
        btnProduct.click();
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(btnAddToCart);
        try{
            btnAddToCart.click();
        }catch (org.openqa.selenium.StaleElementReferenceException e){
            btnAddToCart.click();
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        waitFor(ExpectedConditions.alertIsPresent());
        System.out.println(getDriver().switchTo().alert().getText());
        getDriver().switchTo().alert().accept();
        btnInicio.click();
    }

    public void visualizoElCarritoConLosProductosAgregados(String producto1, String producto2) {
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(btnVerCarrito);
        btnVerCarrito.click();
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(listaProductos);
        System.out.println("------- Productos agregados al carrito --------");
        System.out.println(listaProductos.get(0).getText());
        System.out.println(listaProductos.get(1).getText());
        if(!listaProductos.get(0).getText().equals(producto1)){
            assertThat("No se encontro el producto: "+producto1,
                    listaProductos.get(1).getText().equals(producto1));
        }else{
            assertThat("producto: "+producto1+" encontrado en el carrito",true);
        }
        if(!listaProductos.get(0).getText().equals(producto2)){
            assertThat("No se encontro el producto: "+producto2,
                    listaProductos.get(1).getText().equals(producto2));
        }else{
            assertThat("producto: "+producto2+" encontrado en el carrito",true);
        }
    }

    public void completoElFormularioDeCompra(String nombre, String pais, String ciudad,
                                             String numeroTarjeta, String mes, String anio) {
        btnPlaceOrder.click();
        withTimeoutOf(Duration.ofSeconds(5)).waitFor(txtName);
        txtName.sendKeys(nombre);
        txtCountry.sendKeys(pais);
        txtCity.sendKeys(ciudad);
        txtCard.sendKeys(numeroTarjeta);
        txtMonth.sendKeys(mes);
        txtYear.sendKeys(anio);
        scrollWebElementFacade(btnPurchase);
        Serenity.takeScreenshot();
        btnPurchase.click();
    }

    public void verificoQueLaCompraSeHayaRealizadoCorrectamente() {
        if(lblPurchaseSuccess.isPresent()){
            assertThat("compra realizada con exito", true);
        }else{
            fail("la compra no se pudo completar");
        }
    }

    public void scrollWebElementFacade(WebElementFacade element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElementFacade elementFacade =
                (WebElementFacade) js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollWebElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement elementFacade =
                (WebElement) js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



}
