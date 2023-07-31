package med.voll.api.controller;


import jakarta.transaction.Transactional;
import med.voll.api.Endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return ResponseEntity.ok("Sucesso! Médico cadastrado na base de dados VollMed");

    }
}
