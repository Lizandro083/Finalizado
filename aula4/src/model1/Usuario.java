package model1;

public class Usuario {
private String Nome, Celular, CPF, Email, Senha;

private boolean Estalogado = false;

 Usuario (String Nome, String Celular, String CPF, String Email, String Senha ) {
	this.Nome = Nome;
	this.CPF = CPF;
	this.Celular = Celular;
	this.Email = Email;
	this.Senha = Senha;
}
void Autenticacao(String Email, String Senha) {
	if(this.Email == Email
			&& this.Senha == Senha) {
		Estalogado = true;
	}
}
public String getUsuario() {
	return ( 
		"\nNome" + this.Nome
		+ "\nCPF" + this.CPF
		+ "\nCelular" + this.Celular
		+ "\nEmail" + this.Email
		+ "\nSenha" + this.Senha
		+ "\nEstalogado" + this.Estalogado
		);

}
}
