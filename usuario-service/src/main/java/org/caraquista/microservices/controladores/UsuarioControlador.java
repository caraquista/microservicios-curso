package org.caraquista.microservices.controladores;

import org.caraquista.microservices.entidades.Usuario;
import org.caraquista.microservices.modelos.Carro;
import org.caraquista.microservices.modelos.Moto;
import org.caraquista.microservices.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioServicio.getAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id){
        Usuario usuario = usuarioServicio.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping()
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioServicio.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }


    @GetMapping("carros/{id}")
    public ResponseEntity<List<Carro>> getCarros(@PathVariable("id") int id) {
        Usuario usuario = usuarioServicio.getUsuarioById(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Carro> carros = usuarioServicio.getCarros(id);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("motos/{id}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("id") int id) {
        Usuario usuario = usuarioServicio.getUsuarioById(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioServicio.getMotos(id);
        return ResponseEntity.ok(motos);
    }

    @PostMapping("/carro/{id}")
    public Carro guardarCarro(@PathVariable("id") int usuarioId, @RequestBody Carro carro){
        Carro nuevoCarro = new Carro();
        nuevoCarro.setUsuarioId(usuarioId);
        nuevoCarro.setMarca(carro.getMarca());
        nuevoCarro.setModelo(carro.getModelo());
        Carro newCarro = usuarioServicio.saveCarro(nuevoCarro);
        return newCarro;
    }

    @PostMapping("/moto/{id}")
    public Moto guardarCarro(@PathVariable("id") int usuarioId, @RequestBody Moto moto){
        Moto nuevoMoto = new Moto();
        nuevoMoto.setUsuarioId(usuarioId);
        nuevoMoto.setMarca(moto.getMarca());
        nuevoMoto.setModelo(moto.getModelo());
        Moto newMoto = usuarioServicio.saveMoto(nuevoMoto);
        return newMoto;
    }

    @GetMapping("/vehiculos/{id}")
    public ResponseEntity<Map<String, Object>> getUsuarioAndVehiculos(@PathVariable("id") int id) {
        return ResponseEntity.ok(usuarioServicio.getUsuarioAndVehiculos(id));
    }

}
