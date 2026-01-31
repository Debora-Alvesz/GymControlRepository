package br.com.ifba.turma.repository;

import br.com.ifba.turma.entity.Turma;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    @Override
    Turma save(Turma turma);

    @Override
    List<Turma> findAll();

    Turma update(String id, Turma turma);

    void delete(Long id);
}
