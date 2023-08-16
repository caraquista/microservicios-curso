package org.caraquista.microservices.feignclients;

import org.caraquista.microservices.modelos.Carro;
import org.caraquista.microservices.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="motos-service", url = "http://localhost:8083")
public interface MotoFeignClient {
    @PostMapping("/motos")
    public Moto save(@RequestBody Moto moto);
    @GetMapping("/motos/usuario/{id}")
    public List<Moto> getMotos(@PathVariable("id") int id);
}
