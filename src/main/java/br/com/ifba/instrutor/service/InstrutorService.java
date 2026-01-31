package br.com.ifba.instrutor.service;

import br.com.ifba.instrutor.entity.Instrutor;
import br.com.ifba.instrutor.repository.InstrutorRepository;
import br.com.ifba.usuario.enums.PerfilUsuarioEnum;
import br.com.ifba.util.ValidadorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstrutorService {

    private final InstrutorRepository instrutorRepository;


    //Salva um novo Instrutor
    public Instrutor salvar(Instrutor instrutor) {

        log.info("Iniciando cadastro de instrutor");

        // VALIDAÇÕES BÁSICAS
        ValidadorUtil.validarNaoNulo(instrutor, "Instrutor");
        ValidadorUtil.validarNaoNulo(instrutor.getCpf(), "CPF");
        ValidadorUtil.validarNaoNulo(instrutor.getEspecialidade(), "Especialidade");
        ValidadorUtil.validarNaoNulo(instrutor.getDisponibilidade(), "Disponibilidade");


        // VALIDAÇÃO CPF DUPLICADO
        if (instrutorRepository.existsByCpf(instrutor.getCpf())) {
            log.error("CPF já cadastrado: {}", instrutor.getCpf());
            throw new IllegalArgumentException("CPF já cadastrado no sistema");
        }

        // DEFINIÇÃO DO PERFIL
        instrutor.setPerfil(PerfilUsuarioEnum.INSTRUTOR);

        Instrutor instrutorSalvo = instrutorRepository.save(instrutor);

        log.info("Instrutor salvo com sucesso. ID: {}", instrutorSalvo.getId());

        return instrutorSalvo;
    }

    public List<Instrutor> listarTodos() {
        log.info("Listar todos os instrutores");
        return instrutorRepository.findAll();
    }

    public Instrutor buscarPorId(Long id) {
        return instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));
    }

    public Instrutor atualizar(Long id, Instrutor instrutor) {

        Instrutor existente = buscarPorId(id);

        existente.setCpf(instrutor.getCpf());
        existente.setEspecialidade(instrutor.getEspecialidade());
        existente.setCarga_horaria(instrutor.getCarga_horaria());
        existente.setDisponibilidade(instrutor.getDisponibilidade());
        existente.setStatus(instrutor.isStatus());

        return instrutorRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!instrutorRepository.existsById(id)) {
            log.info("Deletar instrutor por id");
            throw new RuntimeException("Instrutor não encontrado");
        }
        instrutorRepository.deleteById(id);
    }
}
