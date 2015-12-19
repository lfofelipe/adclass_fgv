package br.com.fgv.dao;

public class DAOException extends Exception {
	//Construção recebendo a causa
	public DAOException(String e, Exception erro) {
		super(e, erro);
	}

}
