package br.com.fgv.dao;

public class DAOException extends Exception {
	//Constru��o recebendo a causa
	public DAOException(String e, Exception erro) {
		super(e, erro);
	}

}
