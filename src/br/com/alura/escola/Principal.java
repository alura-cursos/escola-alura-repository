package br.com.alura.escola;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.escola.servico.AlunoServico;

public class Principal {

	public static void main(String...strings) {

		AlunoServico alunoServico = new AlunoServico();

		List<String> alunos = alunoServico.listar().stream()
				.flatMap(a -> Stream.ofNullable(a.getNome()))
				.map(s -> s.toUpperCase())
				.collect(Collectors.toList());

		System.out.println("Lista de alunos matriculados na escola: " + alunos);
	}
}
