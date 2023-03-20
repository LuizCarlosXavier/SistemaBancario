import java.io.Serializable;

/* Superclasse --> responsável por conter todos os atributos
 * e métodos em comum das demais classes correntistas ( Herança )
 */

/* iremos colocar o abstract na classe correntista para impedir a instanciação
 * pois não precisa criar um objeto do tipo Correntista, visto que é necessário
 * especificar se ele é físico ou jurídico
 */

public abstract class Correntista implements Serializable {
	//Atributos privados
		private static int proxCodigo = 1;
		
		private int codigo;
		
		private String nome;
		
		private Conta conta;
		
		public Correntista(String nome, Conta conta) {
			this.nome = nome;
			codigo = proxCodigo();
			this.setConta(conta);
		}
		
		/* Será abstrato porque não necessário exibir um correntista sem especificação,
		 * porém todas as classes filhas precisam implementar esse método abstrato 
		 */
		
		public abstract void exibeIdentificacao();
		
		// Faz a leitura do Código/Nome e seu retorno
		public int getCodigo() {
			return codigo;
		}
		
		public static int proxCodigo() {
			return proxCodigo ++;
		}
		
		public String getNome() {
			return nome;
		}

		// Recebe o Código/Nome e atribui
		public void setNome(String nome) {
			this.nome = nome;
		}

		public Conta getConta() {
			return conta;
		}

		public void setConta(Conta conta) {
			this.conta = conta;
		}
}
