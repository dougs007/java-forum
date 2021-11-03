package br.com.springboot.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springboot.forum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository   cursoRepository;
	@Autowired
	private TestEntityManager em;

	@Test
	public void getCursoPeloNome() {
		String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);

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
