public class SaqueATM extends Thread {
		
		private Conta conta;
		private double saque;
		
		public SaqueATM(Conta conta, double saque) {
			this.conta = conta;
			this.saque = saque;
		}
		
		public void run() {
			conta.saque(saque);
		}
	}