package org.caraquista.microservices.servicios;

import org.caraquista.microservices.entidades.Carro;
import org.caraquista.microservices.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServicio {
    @Autowired
    private CarroRepository carroRepository;
    public List<Carro> getAll() {
        return carroRepository.findAll();
    }

    public Carro getCarroById(int id) {
        return carroRepository.findById(id).orElse(null);
    }
    public Carro save(Carro carro){
        Carro nuevoCarro = carroRepository.save(carro);
        return nuevoCarro;
    }

    public List<Carro> getByUsuarioId(int usuarioId) {
        return carroRepository.findByUsuarioId(usuarioId);
    }

}
