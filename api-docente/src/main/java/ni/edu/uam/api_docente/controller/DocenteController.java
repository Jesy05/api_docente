package ni.edu.uam.api_docente.controller;

import ni.edu.uam.api_docente.modelo.Docente;
import ni.edu.uam.api_docente.repository.DocenteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteRepository repository;

    public DocenteController(DocenteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Docente> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Docente guardar(@RequestBody Docente docente) {
        return repository.save(docente);
    }

}
