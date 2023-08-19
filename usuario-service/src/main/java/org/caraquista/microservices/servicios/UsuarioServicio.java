package org.caraquista.microservices.servicios;

import org.caraquista.microservices.entidades.Usuario;
import org.caraquista.microservices.feignclients.CarroFeignClient;
import org.caraquista.microservices.feignclients.MotoFeignClient;
import org.caraquista.microservices.modelos.Carro;
import org.caraquista.microservices.modelos.Moto;
import org.caraquista.microservices.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioServicio {
   // @Autowired
   // private CircuitBreakerFactory circuitBreakerFactory;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CarroFeignClient carroFeignClient;
    @Autowired
    private MotoFeignClient motoFeignClient;

    public List<Carro> getCarros(int usuarioId) {
         List<Carro> carros = restTemplate.getForObject(
                 "http://localhost:8000/carros/usuario/"+usuarioId,
                 List.class);
         return carros;
    }

    public List<Moto> getMotos(int usuarioId) {
        List<Moto> motos = restTemplate.getForObject(
                "http://localhost:8000/motos/usuario/"+usuarioId,
                List.class);
        return motos;
    }

    public Carro saveCarro(Carro carro) {
        Carro nuevoCarro = carroFeignClient.save(carro);
        return nuevoCarro;
    }

    public Moto saveMoto(Moto moto) {
        Moto nuevoMoto = motoFeignClient.save(moto);
        return nuevoMoto;
    }

    public List<Moto> getMotosByUsusarioId(int usuarioId) {
        List<Moto> nuevoMotos = motoFeignClient.getMotos(usuarioId);
        return nuevoMotos;
    }
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }

    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {
        Map<String, Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            resultado.put("Mensaje", "El usuario no existe");
            return resultado;
        }
        resultado.put("Usuario", usuario);
        List<Carro> carros = carroFeignClient.getCarros(usuarioId);
        if (carros.isEmpty()) {
            resultado.put("Carros", "No tiene carros");
        } else {
            resultado.put("Carros", carros);
        }

        List<Moto> motos = motoFeignClient.getMotos(usuarioId);
        if (motos.isEmpty()) {
            resultado.put("Motos", "No tiene motos");
        } else {
            resultado.put("Motos", motos);
        }

        return resultado;
    }


}
