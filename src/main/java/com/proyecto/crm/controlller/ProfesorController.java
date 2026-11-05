package com.proyecto.crm.controlller;

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

import com.proyecto.crm.dtos.ProfesorRequestDto;
import com.proyecto.crm.dtos.ProfesorResponseDto;
import com.proyecto.crm.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
	private final ProfesorService profesorService;

	public ProfesorController(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}

	// READ BY ID - GET /api/profesores/{id}
	@GetMapping("/{id}")
	public ResponseEntity<ProfesorResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(profesorService.obtenerPorId(id));
	}

	// READ BY DNI - GET /api/profesores/dni/{dni}
	@GetMapping("/dni/{dni}")
	public ResponseEntity<ProfesorResponseDto> obtenerPorDni(@PathVariable String dni) {
		return ResponseEntity.ok(profesorService.obtenerPorIDni(dni));
	}

	// CREATE - POST /api/profesores
	@PostMapping
	public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.crear(requestDto));
	}

	// UPDATE BY ID - PUT /api/profesores/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ProfesorResponseDto> actualizarPorId(
			@PathVariable Long id,
			@RequestBody ProfesorRequestDto requestDto) {
		return ResponseEntity.ok(profesorService.actualizar(id, requestDto));
	}

	// UPDATE BY DNI - PUT /api/profesores/dni/{dni}
	@PutMapping("/dni/{dni}")
	public ResponseEntity<ProfesorResponseDto> actualizarPorDni(
			@PathVariable String dni,
			@RequestBody ProfesorRequestDto requestDto) {
		return ResponseEntity.ok(profesorService.actualizar(dni, requestDto));
	}

	// DELETE BY ID - DELETE /api/profesores/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
		profesorService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	// DELETE BY DNI - DELETE /api/profesores/dni/{dni}
	@DeleteMapping("/dni/{dni}")
	public ResponseEntity<Void> eliminarPorDni(@PathVariable String dni) {
		profesorService.eliminar(dni);
		return ResponseEntity.noContent().build();
	}
}
