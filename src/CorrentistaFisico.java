// Correntista é aquele que possui uma conta corrente no banco LC BANK

/* classe filha ou Subclasse
 * 
 * extends significa que CorrentistaFisico herda de Correntista
 */

public class CorrentistaFisico extends Correntista {
	
	
	//Métodos públicos
	
	// Criando os construtores
	
	public CorrentistaFisico(String nome, Conta conta) {
		
		//realizar a chamada do construtor/metodo da classe mãe:
		
		super(nome, conta);
		
	}
	
	// Polimorfismo de inclusão: sobrescrita de métodos
	public void exibeIdentificacao() {
		System.out.println("Eu sou o correntista físico: " + getCodigo() + " - " + getNome());
	}

	
}
