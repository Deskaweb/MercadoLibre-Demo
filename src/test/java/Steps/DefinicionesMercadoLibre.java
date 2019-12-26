package Steps;

import Pages.MercadoLibrePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class DefinicionesMercadoLibre {

    MercadoLibrePage page = new MercadoLibrePage();
    public static WebDriver webDriver;

    @Given("^Ingresar a la Web de MercadoLibre$")
    public void IngresarWeb(){
        page.AbrirWeb();
        page.ValidarIngreso();
    }

    @When("^Ingresar a la \"([^\"]*)\" y a su \"([^\"]*)\"$")
    public void SeIngresaAlaSubcategoria(String Categoria, String Sub)  {
        page.IngresarSubcategoria(Categoria, Sub);
    }

    @Then("^Se valida la \"([^\"]*)\" y la cantidad de resultados$")
    public void SeValidaSubtipoYCantidad(String Sub){
        page.ValidarSubYCantidad(Sub);
        page.CerrarDriver();
    }

    @And("^Se cambia la vista de la grilla$")
    public void SeCambiaLaVista(){
        page.CambioDeVistaGrilla();
    }

    @Then("^Se verifica la cantidad de elementos existen$")
    public void SeVericaCantidadElementos(){
        page.CantidadDeElementos();
    }

    @And("^Se marca la opcion 'LLegan hoy'$")
    public void SeMarcaOpcionLleganHoy(){
        page.OpcionLleganHoy();
    }

    @Then("^Se verifica que los primeros 5 resultado lleguen hoy$")
    public void SeVerifican5Registros(){
        page.Verificar5RegistrosLleganHoy();
    }

    @And("^Ordenar por 'Mayor Precio'$")
    public void SeOrdenaPorMayorPrecio(){
        page.OrdenarMayorPrecio();
    }

    @Then("^Se verifica el precio del primer resultado y del ultimo$")
    public void SeVerificaPrecioPrimerYUltimoResultado(){
        page.VerificarResultado();
    }

    @When("^Se filtra por la ubicacion \"([^\"]*)\"$")
    public void SeFiltraPorUbicacion(String Ubicacion) {
        page.FiltrarUbicacion(Ubicacion);
    }

    @Then("^Se ingresa a una publicacion y se verifican los datos$")
    public void SeVerificaLosDatosDeLaPublicacion(){
        page.VerificarDatosPublicacion();
        page.CerrarDriver();
    }

}
