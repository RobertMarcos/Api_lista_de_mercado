package com.example.lista_mecados.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Lista_record_dto( @NotBlank String nome, @NotNull int quantidade) {
    // notblack não deixa  a variavel (coluna) ser nula nem estar em branco
    //responsavel po pegar e distribuir os valores. java 16 +
}
