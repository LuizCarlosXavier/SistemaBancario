/*Classe filha ou Subclasse
 * 
 * extends significa que CorrentistaFisico herda de Correntista
 */

public class CorrentistaJuridico extends Correntista {
	    //Atributos privados
		private String nomeResponsavel;
				
		// Criando os construtores
		
		public CorrentistaJuridico(String nome, String nomeResponsavel, Conta conta) {
			//realizar a chamada do construtor/metodo da classe mãe:
			super(nome, conta);
			
			this.nomeResponsavel = nomeResponsavel;
		}
		
		// Polimorfismo de inclusão: sobrescrita de métodos
		public void exibeIdentificacao() {
			System.out.println("Eu sou o correntista jurídico: " + getCodigo() + " - " + getNome());
		}

		public String getNomeResponsavel() {
			return nomeResponsavel;
		}

		public void setNomeResponsavel(String nomeResponsavel) {
			this.nomeResponsavel = nomeResponsavel;
		}
		
		
}
