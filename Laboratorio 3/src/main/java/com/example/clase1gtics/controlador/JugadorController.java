package com.example.clase1gtics.controlador;

import com.example.clase1gtics.entidad.Jugador;
import com.example.clase1gtics.entidad.Seleccion;
import com.example.clase1gtics.repositorio.JugadorRepository;
import com.example.clase1gtics.repositorio.SeleccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jugador")

public class JugadorController {

    final JugadorRepository jugadorRepository;
    final SeleccionRepository seleccionRepository;

    public JugadorController(JugadorRepository jugadorRepository, SeleccionRepository seleccionRepository) {
        this.jugadorRepository = jugadorRepository;
        this.seleccionRepository = seleccionRepository;
    }

    //LISTAMOS LOS JUGADORES, RECORDEMOS QUE LISTAR ES ÚNICAMENTE MÉTODO GET
    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        //CREAMOS UNA LISTA DE JUGADORES, LLAMADA listajugadores, y guardamos ahí a todos los jugadores que salgan
        //CON EL REPOSITORIO
        List<Jugador> listajugadores = jugadorRepository.findAll();
        //AHORA PONEMOS EL MODEL PARA MANDARLO A LA VISTA HTML:
        //GUARDAMOS NUESTRA LISTA QUE ACABAMOS DE CREAR "listajugadores" en nuestro variable "listajugadoreshtml"
        //ESTA ÚLTIMA ES LA QUE MANDAREMOS AL HTML
        model.addAttribute("listajugadoreshtml", listajugadores);
        return "jugador/list";
    }

    //HACEMOS UNA RUTA PARA LA CREACION DEL FORMULARIO
    @GetMapping("/new")
    public String crear(Model model, Seleccion seleccion) {
        List<Seleccion> listitaselecciones = seleccionRepository.findAll();
        //COMO HAY UN COMBO BOX, SERÁ NECESARIO PASARLE LA INFORMACIÓN DE LAS SELECCIONES
        model.addAttribute("listaseleccioneshtml", listitaselecciones);
        //ESTO SOLO SIRVE PARA REGRESAR EL HTML CUANDO LE DAN A jugador/new
        return "jugador/newForm";
    }

    //UNA VEZ EL USUARIO HAYA DADO CLIC EN SUBMIT, LO LLEVARÁ A ESTA PORCIÓN DE CÓDIGO
    @PostMapping("/guardar")
    //NOTEMOS QUE GRACIAS AL DATABINDING, EL CONTENIDO DEL FORMULARIO SE VA A GUARDAR EN OBJETO jugador
    public String guardar(Jugador jugador) {
        jugadorRepository.save(jugador);

        //SABES QUE LOS RETURN NORMALMENTE REDIRECCIONAN A UN HTML, PERO, ¿Y SI QUIERO REDIRECCIONAR A UNA
        //RUTA DE UN CONTROLADOR? FACIL, USO LO QUE SE LLAMA redirect y luego inserto la ruta del controlador
        //que quiero
        return "redirect:/jugador/listar";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        // Optional es una clase contenedora que puede o no contener un valor no nulo.
        // Aquí, se utiliza para buscar un Jugador en el repositorio usando el id proporcionado.
        // Si el Jugador existe, el Optional contendrá el Jugador. Si no existe, el Optional estará vacío.
        Optional<Jugador> optional = jugadorRepository.findById(id);

        // Verificar si el Optional contiene un Jugador (es decir, si se encontró un Jugador con el id proporcionado)
        if (optional.isPresent()) {
            // Borrar el Jugador con el id proporcionado del repositorio
            jugadorRepository.deleteById(id);
        }

        // Redirigir al navegador a la página de listado de jugadores
        return "redirect:/jugador/listar";
    }

}
