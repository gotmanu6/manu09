package service;

import models.ProjetoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProjetoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {


    @Autowired
    private ProjetoRepository projetoRepository;

    public Optional<ProjetoModel> findById(Long id) {
        return projetoRepository.findById(id);
    }

    public List<ProjetoModel> findAll() {
        return projetoRepository.findAll();
    }

    public void deleteById(Long id) {
        projetoRepository.deleteById(id);
    }

    public ProjetoModel criarProjeto(ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

}