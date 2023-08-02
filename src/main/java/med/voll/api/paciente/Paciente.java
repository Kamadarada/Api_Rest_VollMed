package med.voll.api.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomepaciente;

    private String idade;

    private String data;

    public Paciente(DadosCadastroPaciente dados){
        this.nomepaciente = dados.NomePaciente();
        this.idade = dados.Idade();
        this.data = dados.Data();
    }

}
