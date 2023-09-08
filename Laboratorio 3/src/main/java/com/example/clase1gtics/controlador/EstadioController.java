package com.example.clase1gtics.controlador;

import com.example.clase1gtics.entidad.Estadio;
import com.example.clase1gtics.entidad.Jugador;
import com.example.clase1gtics.repositorio.EstadioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estadio")
public class EstadioController {

    final EstadioRepository estadioRepository;

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    //LISTAMOS LOS JUGADORES, RECORDEMOS QUE LISTAR ES ÚNICAMENTE MÉTODO GET
    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        //CREAMOS UNA LISTA DE JUGADORES, LLAMADA listajugadores, y guardamos ahí a todos los jugadores que salgan
        //CON EL REPOSITORIO
        List<Estadio> listaestadios = estadioRepository.findAll();
        //AHORA PONEMOS EL MODEL PARA MANDARLO A LA VISTA HTML:
        //GUARDAMOS NUESTRA LISTA QUE ACABAMOS DE CREAR "listajugadores" en nuestro variable "listajugadoreshtml"
        //ESTA ÚLTIMA ES LA QUE MANDAREMOS AL HTML
        model.addAttribute("listaestadioshtml", listaestadios);
        return "estadio/list";
    }

    //HACEMOS UNA RUTA PARA LA CREACION DEL FORMULARIO
    @GetMapping("/new")
    public String crear() {
        //ESTO SOLO SIRVE PARA REGRESAR EL HTML CUANDO LE DAN A jugador/new
        return "estadio/newForm";
    }

    //UNA VEZ EL USUARIO HAYA DADO CLIC EN SUBMIT, LO LLEVARÁ A ESTA PORCIÓN DE CÓDIGO
    @PostMapping("/guardar")
    //NOTEMOS QUE GRACIAS AL DATABINDING, EL CONTENIDO DEL FORMULARIO SE VA A GUARDAR EN OBJETO jugador
    public String guardar(Estadio estadio) {
        estadioRepository.save(estadio);

        //SABES QUE LOS RETURN NORMALMENTE REDIRECCIONAN A UN HTML, PERO, ¿Y SI QUIERO REDIRECCIONAR A UNA
        //RUTA DE UN CONTROLADOR? FACIL, USO LO QUE SE LLAMA redirect y luego inserto la ruta del controlador
        //que quiero
        return "redirect:/estadio/listar";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Estadio> optional = estadioRepository.findById(id);

        if (optional.isPresent()) {
            estadioRepository.deleteById(id);
        }

        //UNA VEZ SE BORRA, SE VUELVE A IR A LA PÁGINA DE LISTAR ESTADIO A TRAVÉS DEL CONTROLLER "redirect:/estadio/listar"
        return "redirect:/estadio/listar";
    }
}
