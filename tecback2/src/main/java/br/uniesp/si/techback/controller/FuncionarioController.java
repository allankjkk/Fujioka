package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public Funcionario salvar(@Valid @RequestBody Funcionario func){
        return service.salvar(func);
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping
    public java.util.List<Funcionario> listar(){
        return service.listar();
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id,
                                 @Valid @RequestBody Funcionario func){
        return service.atualizar(id, func);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
