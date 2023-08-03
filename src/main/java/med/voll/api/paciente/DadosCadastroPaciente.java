package med.voll.api.paciente;

import jakarta.validation.constraints.NotBlank;

import java.text.DateFormat;

public record DadosCadastroPaciente(
        @NotBlank
        String NomePaciente,
        String Idade,
        @NotBlank
        String Data,

        @NotBlank
        String MedicoResponsavel) {

}
