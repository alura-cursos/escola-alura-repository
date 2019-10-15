package br.com.alura.escola;

import br.com.alura.escola.servico.AlunoServico;

public class Principal {

	public static void main(String...strings) {

		AlunoServico alunoServico = new AlunoServico();
		alunoServico.listar();
	}
}
