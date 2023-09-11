package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PetStorePage;

public class PetStoreDefinitions {

    protected PetStorePage petstorePage = new PetStorePage();

    @Given("realizo la creacion de la mascota {string} {string} {string} {string}")
    public void realizoLaCreacionDeLaMascota(String idMascota, String idCategoria, String nombre, String status) {
        petstorePage.realizoLaCreacionDeLaMascota(idMascota,idCategoria,nombre,status);
    }

    @When("consulto la mascota creada {string}")
    public void consultoLaMascotaCreada(String idMascota) {
        petstorePage.consultoLaMascotaCreada(idMascota);
    }

    @When("actualizo el nombre y el estatus de la mascota {string} {string} {string}")
    public void actualizoElNombreYElEstatusDeLaMascota(String idMascota, String nombre, String status) {
        petstorePage.actualizoElNombreYElEstatusDeLaMascota(idMascota,nombre,status);
    }

    @Then("Valido la mascota modificada por status {string}")
    public void validoLaMascotaModificadaPorStatus(String status) {
        petstorePage.validoLaMascotaModificadaPorStatus(status);
    }
}
