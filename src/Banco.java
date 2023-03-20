import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;


public class Banco {
	
	private ArrayList<Correntista> listaDeClientes;
	
	public Banco() {
		listaDeClientes = new ArrayList<Correntista>();
	}
	
	
	
	public ArrayList<Correntista> getListaDeClientes() {
		return listaDeClientes;
	}



	public void setListaDeClientes(ArrayList<Correntista> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}



	public void salvaClientela() throws IOException {
		// database.dat porque vamos manipular objetos e bytes, não uma sequência de caracteres
		File file = new File("database.dat");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Correntista c : listaDeClientes) {
			oos.writeObject(c); // Persiste Cliente no arquivo clientes.dat
		}
		
		oos.close(); // fechar o fluxo!
	}
	
	public void leClientela() throws IOException, ClassNotFoundException {
		File file = new File("database.dat");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = null;
		// lê objetos um a um
		try {
			while ((obj = ois.readObject()) != null) {
				this.listaDeClientes.add((Correntista) obj); // conversão de tipos
			}
		}
		catch(EOFException e) {
			
		}
		// fechamento do fluxo, permitindo que o bloco seja executado ocorrento ou não exceção
		finally {
			ois.close();
		}
	}
	
	public static void main(String args[]) {
		Banco banco = new Banco();
		ContaFisica conta = new ContaFisica();
		conta.deposito(1000);
		
		CorrentistaFisico joao = new CorrentistaFisico("joao", conta);
		CorrentistaFisico maria = new CorrentistaFisico("Maria", conta);
		
		SaqueATM saqueJoao = new SaqueATM(joao.getConta(), 500);
		SaqueATM saqueMaria = new SaqueATM(maria.getConta(),300);
		
		saqueJoao.start();
		saqueMaria.start();
	
	
	CorrentistaFisico cliente1 = new CorrentistaFisico("Luiz Carlos", new ContaFisica());
	banco.getListaDeClientes().add(cliente1);
	
	CorrentistaFisico cliente2= new CorrentistaFisico("Maria do Socoro", new ContaFisica());
	banco.getListaDeClientes().add(cliente2);
	
	CorrentistaFisico cliente3 = new CorrentistaFisico("Raiff Brasileiro", new ContaFisica());
	banco.getListaDeClientes().add(cliente3);
	
	CorrentistaFisico cliente4 = new CorrentistaFisico("Lucas Assis", new ContaFisica());
	banco.getListaDeClientes().add(cliente4);
	
	CorrentistaFisico cliente5 = new CorrentistaFisico("André Maurício", new ContaFisica());
	banco.getListaDeClientes().add(cliente5);
	
	CorrentistaJuridico clienteJ1 = new CorrentistaJuridico("SJA", "Luiz Claúdio", new ContaJuridica());
	banco.getListaDeClientes().add(clienteJ1);

	try {
		banco.salvaClientela();
	}
	catch (IOException e) {
		
	}
	
	try {
		banco.leClientela();
		
		for(Correntista c : banco.getListaDeClientes()) {
			System.out.println(c.getNome());
		}
		
	} catch (ClassNotFoundException | IOException e) {
		
	}
	
	
	cliente1.exibeIdentificacao();
	cliente2.exibeIdentificacao();
	cliente3.exibeIdentificacao();
	cliente4.exibeIdentificacao();
	cliente5.exibeIdentificacao();
	clienteJ1.exibeIdentificacao();
	
	try {
		double valorParcela = cliente1.getConta().simulaEmprestimo(1000.0, -12);
		
		System.out.println(valorParcela);
	}
	catch(IllegalArgumentException e) {
		System.out.println("Digite valores válidos.");
	}
	
	/*Iterator<Correntista> it = ListaDeClientes.iterator();
	/while(it.hasNext()) {
		System.out.println(it.next().getNome());
	}
	
	/*
	 * exemplo de polimorfismo de inclusão graças a sobrescrita:
	 * 
	 * Correntista cc = new CorrentistaJuridico("Fulano");
	 * cc.exibeIdentificacao();
	 * 
	 */
	
	}
	
}
