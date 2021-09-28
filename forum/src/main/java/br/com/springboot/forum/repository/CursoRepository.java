package br.com.springboot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
