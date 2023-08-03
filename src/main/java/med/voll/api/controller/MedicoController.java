package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping //verbo do protocolo http
    @Transactional //contextos de transação
    //Método cadastrar recebe dto de DadosCadastroMedico
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados));
        System.out.println("Sucesso! Médico cadastrado na base de dados VollMed");
        return ResponseEntity.ok("Sucesso! Médico cadastrado na base de dados VollMed");

    }

    @GetMapping
    public List<DadosListagemMedico> ListarMedico(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList(); //converter Lista de medico para lista DadosListagemMedico (dto);
    }
}

