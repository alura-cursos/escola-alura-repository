package br.com.alura.escola;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.escola.modelo.Aluno;
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
				.collect(Collectors.groupingBy(Turma::getCurso,
						Collectors.filtering(a -> a.getInicio().equals(LocalDate.of(2019, 6, 3)), Collectors.toList())));

		System.out.println("Relação de turmas por curso: " + turmasPorCurso);

		Optional<Aluno> aluno = alunoServico.listarPorCpf(4915774030L);
		aluno.ifPresentOrElse(System.out::println, 
				() -> System.out.println("Não há aluno cadastrado para este cpf"));

		Optional<Aluno> alunoRecuperado = alunoServico.listarPorCpf(43647814016L)
				.or(() -> alunoServico.listarPorCpf(49157745030L))
				.or(() -> alunoServico.listarPorCpf(82757618083L))
				.or(() -> alunoServico.listarPorCpf(41189989042L));

		alunoRecuperado.ifPresentOrElse(System.out::println, 
				() -> System.out.println("Não há aluno cadastrado para este cpf"));
	}
}
