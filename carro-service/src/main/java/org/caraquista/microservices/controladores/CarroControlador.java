package org.caraquista.microservices.controladores;

import org.caraquista.microservices.entidades.Carro;
import org.caraquista.microservices.servicios.CarroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroControlador {
    @Autowired
    private CarroServicio carroServicio;
    @GetMapping()
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroServicio.getAll();
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carro = carroServicio.getCarroById(id);
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Carro>> listarCarrosByUsuarioId(@PathVariable("id") int id){
        List<Carro> carros = carroServicio.getByUsuarioId(id);
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @PostMapping()
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro) {
        Carro nuevoCarro = carroServicio.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }
}
