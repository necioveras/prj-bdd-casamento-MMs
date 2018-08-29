import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
public class TestaListaDeConvidados{
	
	private List<String> lista;
	
	@Given("uma lista de $numero convidados")
	public void givenUmaListaDeConvidados(int numero){
		 lista = new ArrayList<>(numero); 
	}
	
	@When(" a lista for conhecida. Exemplos:$nomes")
	public void whenAListaForConhecida(List<String> nomes){
		 lista.addAll(nomes);
	}
	
	@Then(" $nomes devem fazer parte da lista")
	public void thenTestaParteDaLista(List<String> nomes){
		for (String nome: nomes)
			assertEquals(true, lista.contains(nome));
	}
	
	@Then(" confirmar que $nomes estão na lista and $penetra está ausente na lista")
	public void theanTestaAusenciaNaLista(List<String> nomes, String penetra) {
		for (String nome: nomes)
			assertEquals(true, lista.contains(nome));
		assertEquals(false, lista.contains(penetra));
	}
	
	
}