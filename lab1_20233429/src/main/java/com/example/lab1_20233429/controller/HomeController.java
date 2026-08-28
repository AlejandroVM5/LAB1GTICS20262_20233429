package com.example.lab1_20233429.controller;
import com.example.lab1_20233429.model.Equipo;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/equipos")
public class HomeController {
    private static final List<Equipo> listaEquipos = new ArrayList<>();

    @GetMapping("/nuevo")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarEquipo(@RequestParam("nombre") String nombre,
                                @RequestParam("tipo") String tipo,
                                @RequestParam("codigoActivo") String codigoActivo,
                                @RequestParam("fechaAdquisicion") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaAdquisicion){

        Equipo nuevoEquipo = new Equipo(nombre, tipo, codigoActivo, fechaAdquisicion);
        listaEquipos.add(nuevoEquipo);
        return "redirect:/equipos/listar";
    }
    @GetMapping ("/listar")
    public String listarEquipos(Model model) {
        model.addAttribute("listaEquipos", listaEquipos);
        return "listado";
    }
    @GetMapping("/buscar/{codigo}")
    public String buscarPorCodigoPath(@PathVariable("codigo") String codigo, Model model) {
        List<Equipo> resultados = new ArrayList<>();
        for (Equipo eq : listaEquipos) {
            if (eq.getCodigoActivo().equalsIgnoreCase(codigo)) {
                resultados.add(eq);
            }
        }
        model.addAttribute("listaEquipos", resultados);
        model.addAttribute("codigoBuscado", codigo);
        return "listado";
    }




}
