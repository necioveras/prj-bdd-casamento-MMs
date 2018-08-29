import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
public class TestaMusicas{
	
	List<String> bandas; 
	
	@Given("uma lista de $numero opcoes de bandas")
	public void givenUmaListaDenumeroOpcoesDeBandas(int numero){
		 bandas = new ArrayList<>(numero);
	}
	
	@When("for conhecida as opcoes. Exemplo: $bandas")
	public void whenForConhecidaAsOpcoesExemplobandas(List<String> bandas){
		this.bandas.addAll(bandas);
	}
	
	@Then("verificar se foi escolhida $escolha banda(s) automaticamente")
	public void thenVerificarSeFoiEscolhidaescolhaBandasAutomaticamente(String escolha){
		 assertEquals(true, bandas.contains(escolha));
	}
	
	
	
}