package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CompraPage;

public class CompraDefinitions {

    CompraPage compraPage;

    @Given("ingreso al portal demoblaze")
    public void ingresoAlPortalDemoblaze() {
        compraPage.open();
    }

    @When("agrego los productos al carrito de compra {string} {string}")
    public void agregoLosProductosAlCarritoDeCompra(String producto1, String producto2) throws InterruptedException {
        compraPage.agregoLosProductosAlCarritoDeCompra(producto1);
        compraPage.agregoLosProductosAlCarritoDeCompra(producto2);
    }

    @When("visualizo el carrito con los productos agregados {string} {string}")
    public void visualizoElCarritoConLosProductosAgregados(String producto1, String producto2) {
        compraPage.visualizoElCarritoConLosProductosAgregados(producto1,producto2);
    }

    @When("completo el formulario de compra {string} {string} {string} {string} {string} {string}")
    public void completoElFormularioDeCompra(String nombre, String pais, String ciudad,
                                             String numeroTarjeta, String mes, String anio) {
        compraPage.completoElFormularioDeCompra(nombre,pais,ciudad,numeroTarjeta,mes,anio);
    }

    @Then("verifico que la compra se haya realizado correctamente")
    public void verificoQueLaCompraSeHayaRealizadoCorrectamente() {
        compraPage.verificoQueLaCompraSeHayaRealizadoCorrectamente();
    }

}
