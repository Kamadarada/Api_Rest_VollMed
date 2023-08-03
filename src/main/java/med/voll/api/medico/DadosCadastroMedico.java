package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Endereco.DadosEndereco;


//Campos que estão chegando na requisição
// anotações do been validation para verificar se as informações (requisições) estão vindo na forma desejada;
// as requisições do insomnia devem bater com a escrita do record. (lugar onde bate a requisição);
public record DadosCadastroMedico(
        // @NotNull // nulo
        @NotBlank // vazio e nulo
        String nome,
        @NotBlank
        @Email //Notação de email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //verificar se são digitos e de 4 a 6 digitos -> \\d para sinalizar que são digitos
        String crm,

        @NotBlank
        String Telefone,

        @NotNull
        Especialidade especialidade,

        //@Valid validar dto vindo de outro record, no caso do dto "dados endereco";
        @NotNull @Valid DadosEndereco endereco ) {

}
