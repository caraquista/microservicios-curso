package org.caraquista.microservices.modelos;

import lombok.Getter;
import lombok.Setter;

public class Moto {

    @Getter @Setter
    private String marca;
    @Getter @Setter
    private String modelo;
    @Getter @Setter
    private int usuarioId;
}
