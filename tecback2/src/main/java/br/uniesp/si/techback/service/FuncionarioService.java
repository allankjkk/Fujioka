package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        try {
            return repository.save(funcionario);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao salvar funcionário");
        }
    }

    public Funcionario buscarPorId(Long id) {
        Optional<Funcionario> func = repository.findById(id);
        if (func.isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado");
        }else {
            return func.get();
        }
    }

    public List<Funcionario> listar() {
        try {
            return repository.findAll();
        }catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionários");
        }
    }

    public Funcionario atualizar(Long id, Funcionario funcionario){
        Optional<Funcionario> func = repository.findById(id);
        if (func.isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado");
        }else {
            return repository.save(funcionario);
        }
    }

    public void excluir(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Funcionário não encontrado");
        }
        repository.deleteById(id);
    }
}
