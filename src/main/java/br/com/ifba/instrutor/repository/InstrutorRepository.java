package br.com.ifba.instrutor.repository;

import br.com.ifba.instrutor.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

    // Verifica se já existe um instrutor com o CPF informado
    boolean existsByCpf(String cpf);
}