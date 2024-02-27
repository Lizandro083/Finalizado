package model1;

public class Banco {
private String nome_banco ; 
private String certificado_autorizacao; 

public String getNomeBanco() {
	return nome_banco;
}
public String getCertificadoAutorizacao() {
	return certificado_autorizacao;
}
public void getNomeBanco (String Nome) {
	this.nome_banco = Nome;
}
public void getCertificadoAutorizacao (String Certificado) {
	this.certificado_autorizacao = Certificado;
}
}