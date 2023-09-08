package com.example.clase1gtics.controlador;

import com.example.clase1gtics.entidad.Employees;
import com.example.clase1gtics.repositorio.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleados")

public class EmpleadosController {

    final EmployeesRepository employeesRepository;

    public EmpleadosController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    //LISTAMOS LOS JUGADORES, RECORDEMOS QUE LISTAR ES ÚNICAMENTE MÉTODO GET
    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        //CREAMOS UNA LISTA DE JUGADORES, LLAMADA listajugadores, y guardamos ahí a todos los jugadores que salgan
        //CON EL REPOSITORIO
        List<Employees> listaempleados = employeesRepository.findAll();
        //AHORA PONEMOS EL MODEL PARA MANDARLO A LA VISTA HTML:
        //GUARDAMOS NUESTRA LISTA QUE ACABAMOS DE CREAR "listajugadores" en nuestro variable "listajugadoreshtml"
        //ESTA ÚLTIMA ES LA QUE MANDAREMOS AL HTML
        model.addAttribute("listaempleadoshtml", listaempleados);
        return "empleados/list";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        // Optional es una clase contenedora que puede o no contener un valor no nulo.
        // Aquí, se utiliza para buscar un Jugador en el repositorio usando el id proporcionado.
        // Si el Jugador existe, el Optional contendrá el Jugador. Si no existe, el Optional estará vacío.
        Optional<Employees> optional = employeesRepository.findById(id);

        // Verificar si el Optional contiene un Jugador (es decir, si se encontró un Jugador con el id proporcionado)
        if (optional.isPresent()) {
            // Borrar el Jugador con el id proporcionado del repositorio
            employeesRepository.deleteById(id);
        }

        // Redirigir al navegador a la página de listado de jugadores
        return "redirect:/empleados/listar";
    }

}
