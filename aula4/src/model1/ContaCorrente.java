

public class ContaCorrente extends Conta{
	
	ContaCorrente(String email){
		super (email);
		
	}
	public String Saque (double valorSaque) {
		if(valorSaque < saldo) {
			saldo =- valorSaque;
			return (
				"Valor Sacado: " + valorSaque
				+"\nValor Saldo Após o Saque: " 
			    + saldo
			    
				);
			
					
		} else {
			return "Saldo Insuficiente";
		}
	}
	
	public String  Deposito(double ValorDeposito) {
		saldo += ValorDeposito;
		return ("Valor Sacado: " + ValorDeposito
				+"\nValor Saldo Após o Saque: " 
				+ saldo);
				
		
		
	}
	
	public double getSaldo() {
		
	}

}
