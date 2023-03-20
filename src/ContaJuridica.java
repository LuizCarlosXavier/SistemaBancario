
public class ContaJuridica implements Conta {

	private double saldo = 0.0;
	
	/* Taxa de juros aplicada a contas jurídicas
	 * 
	 *  marcado como FINAL para impedir que o atributo seja modificado
	 *  ao longo do programa e static para ser compartilhado por todos os objetos
	 *  da classe e não haver cópias
	 */
	public static final double I = 0.05;
	
	public void extrato() {
		System.out.println("Saldo da conta Jurídica: " + saldo + " R$");		
	}

	
	public synchronized void deposito(double valor) {
		saldo += valor;
		System.out.println("Valor depositado: " + valor + " R$");
	}

	public synchronized void saque(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println("Valor sacado: " + valor + " R$");
		} else {
			System.out.println("Saldo insuficiente!");
		}
		
	}
	
	public double simulaEmprestimo(double cf, int n) throws IllegalArgumentException {
		
		// lançamento de uma exceção, caso o argumento de meses seja negativo ou menor que 0.
		if(n <= 0.0 || cf <= 0.0){
			throw new IllegalArgumentException();
		} else {
			return I/(1-1/Math.pow(1+I, n)) * cf;
		}
	}
	
}
