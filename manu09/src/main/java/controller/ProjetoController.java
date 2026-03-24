package controller;

import models.ProjetoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.ProjetoService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoModel> findAll() {
        return projetoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> findById(@PathVariable Long id) {
        return projetoService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        projetoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){
        ProjetoModel request = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(projetoModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(request);
    }
}
