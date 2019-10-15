package br.com.alura.escola;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.escola.modelo.Curso;
import br.com.alura.escola.modelo.Turma;
import br.com.alura.escola.servico.AlunoServico;
import br.com.alura.escola.servico.TurmaServico;

public class Principal {

	public static void main(String...strings) {

		AlunoServico alunoServico = new AlunoServico();
		TurmaServico turmaServico = new TurmaServico();

		List<String> alunos = alunoServico.listar().stream()
				.flatMap(a -> Stream.ofNullable(a.getNome()))
				.map(s -> s.toUpperCase())
				.collect(Collectors.toList());

		System.out.println("Lista de alunos matriculados na escola: " + alunos);

		Map<Curso, List<Turma>> turmasPorCurso = turmaServico.listar().stream()
				.filter(a -> LocalDate.of(2019, 4, 3).equals(a.getInicio()))
				.collect(Collectors.groupingBy(Turma::getCurso));

		System.out.println("Rela��o de turmas por curso: " + turmasPorCurso);
	}
}
