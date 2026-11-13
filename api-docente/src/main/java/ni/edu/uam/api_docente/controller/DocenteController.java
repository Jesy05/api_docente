package ni.edu.uam.api_docente.controller;

import ni.edu.uam.api_docente.modelo.Docente;
import ni.edu.uam.api_docente.repository.DocenteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteRepository repository;

    public DocenteController(DocenteRepository repository) {
        this.repository = repository;
    }

    // GET /api/docentes -> lista todos los docentes
    @GetMapping
    public List<Docente> getAllDocentes() {
        return repository.findAll();
    }

    // GET /api/docentes/{id} -> busca un docente por id
    @GetMapping("/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/docentes -> crea un docente nuevo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Docente guardar(@RequestBody Docente docente) {
        docente.setId(null);
        return repository.save(docente);
    }

    // PUT /api/docentes/{id} -> actualiza un docente existente
    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizar(@PathVariable Long id, @RequestBody Docente datos) {
        return repository.findById(id)
                .map(docente -> {
                    docente.setNombres(datos.getNombres());
                    docente.setApellidos(datos.getApellidos());
                    docente.setEspecialidad(datos.getEspecialidad());
                    return ResponseEntity.ok(repository.save(docente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/docentes/{id} -> elimina un docente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
