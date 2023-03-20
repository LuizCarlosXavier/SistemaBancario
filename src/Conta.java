import java.io.Serializable;

// métodos que o banco irá implementar
public interface Conta extends Serializable {
	public void extrato();
	
	public void deposito(double valor);
	
	public void saque(double valor);
	
	// cf = capital financiado, n = meses
	public double simulaEmprestimo(double cf, int n);
}
