package pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.core.Serenity;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PetStorePage {

    public void realizoLaCreacionDeLaMascota(String idMascota, String idCategoria, String nombre, String status) {
        String jsonCrearMascota="{\n" +
                "    \"id\": "+idMascota+",\n" +
                "    \"category\": {\n" +
                "        \"id\": "+idCategoria+",\n" +
                "        \"name\": \""+nombre+"\"\n" +
                "    },\n" +
                "    \"status\": \""+status+"\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonCrearMascota)
                .when()
                .post("")
                .then().statusCode(200)
                .extract().response();
        ResponseBody respuesta = response.getBody();
        System.out.println(respuesta.asString());
        Serenity.recordReportData().withTitle("Response").andContents(respuesta.asString());
    }

    public void consultoLaMascotaCreada(String idMascota) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/"+idMascota;
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .get("")
                .then().statusCode(200)
                .extract().response();
        ResponseBody respuesta = response.getBody();
        System.out.println(respuesta.asString());
        Serenity.recordReportData().withTitle("Response").andContents(respuesta.asString());
    }

    public void actualizoElNombreYElEstatusDeLaMascota(String idMascota, String nombre, String status) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/"+idMascota;
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name", "Motas")
                .formParam("status", "sold")
                .when()
                .post("")
                .then().statusCode(200)
                .extract().response();
        ResponseBody respuesta = response.getBody();
        System.out.println(respuesta.asString());
        Serenity.recordReportData().withTitle("Response").andContents(respuesta.asString());
    }

    public void validoLaMascotaModificadaPorStatus(String status) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/findByStatus?status="+status;
        Response response = RestAssured.given()
                .when()
                .get("")
                .then().statusCode(200)
                .extract().response();
        ResponseBody respuesta = response.getBody();
        System.out.println(respuesta.asString());
        Serenity.recordReportData().withTitle("Response").andContents(respuesta.asString());

//        ArrayList<String> bodyResponse = new ArrayList<String>();
//        bodyResponse.add(response.path("name"));
//        System.out.println(bodyResponse);
    }

}
