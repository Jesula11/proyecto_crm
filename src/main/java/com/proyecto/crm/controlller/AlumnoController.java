package com.proyecto.crm.controlller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.crm.dtos.AlumnoRequestDto;
import com.proyecto.crm.dtos.AlumnoResponseDto;
import com.proyecto.crm.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // READ ALL - GET /api/alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos()); // HTTP 200 OK
    }

    // READ BY ID - GET /api/alumnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    // READ BY DNI - GET /api/alumnos/{dni}
    @GetMapping("/dni/{dni}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(alumnoService.obtenerPorDni(dni));
    }

    // CREATE - POST /api/alumnos
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto requestDto) {
        AlumnoResponseDto creado = alumnoService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // UPDATE - PUT /api/alumnos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody AlumnoRequestDto requestDto) {
        AlumnoResponseDto actualizado = alumnoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }
    
    // UPDATE - PUT /api/alumnos/{dni}
    @PutMapping("/dni/{dni}")
    public ResponseEntity<AlumnoResponseDto> actualizar(
            @PathVariable String dni,
            @RequestBody AlumnoRequestDto requestDto) {
        AlumnoResponseDto actualizado = alumnoService.actualizar(dni, requestDto);
        return ResponseEntity.ok(actualizado);
    }

    // 5. DELETE - DELETE /api/alumnos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
    
    // 5. DELETE - DELETE /api/alumnos/{dni}
    @DeleteMapping("/dni/{dni}")
    public ResponseEntity<Void> eliminar(@PathVariable String dni) {
        alumnoService.eliminar(dni);
        return ResponseEntity.noContent().build();
    }

}
