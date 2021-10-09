package br.com.springboot.forum.repository;

import br.com.springboot.forum.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void getCursoPeloNome() {
		String nomeCurso = "HTML 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);

		Assertions.assertNotNull(curso);
		Assertions.assertEquals(curso.getNome(), nomeCurso);
	}

	@Test
	public void getNaoExistenteCursoPeloNome() {
		String nomeCurso = "JPA";
		Curso curso = cursoRepository.findByNome(nomeCurso);

		Assertions.assertNull(curso);
	}
}
