package org.caraquista.microservices.feignclients;

import org.caraquista.microservices.modelos.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="carros-service", url = "http://localhost:8082")
public interface CarroFeignClient {
    @PostMapping("/carros")
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/carros/usuario/{id}")
    public List<Carro> getCarros(@PathVariable("id") int usuarioId);
}
