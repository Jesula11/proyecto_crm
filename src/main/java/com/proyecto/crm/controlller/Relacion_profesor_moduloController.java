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

import com.proyecto.crm.dtos.Relacion_profesor_moduloRequestDto;
import com.proyecto.crm.dtos.Relacion_profesor_moduloResponseDto;
import com.proyecto.crm.services.Relacion_profesor_moduloService;

@RestController
@RequestMapping("/api/relaciones-profesor-modulo")
public class Relacion_profesor_moduloController {
	private final Relacion_profesor_moduloService relacionService;

	public Relacion_profesor_moduloController(Relacion_profesor_moduloService relacionService) {
		this.relacionService = relacionService;
	}

	// READ BY ID - GET /api/relaciones-profesor-modulo/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Relacion_profesor_moduloResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(relacionService.obtenerPorId(id));
	}

	// CREATE - POST /api/relaciones-profesor-modulo
	@PostMapping
	public ResponseEntity<Relacion_profesor_moduloResponseDto> crear(
			@RequestBody Relacion_profesor_moduloRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(relacionService.crear(requestDto));
	}

	// UPDATE - PUT /api/relaciones-profesor-modulo/{id}
	@PutMapping("/{id}")
	public ResponseEntity<Relacion_profesor_moduloResponseDto> actualizar(
			@PathVariable Long id,
			@RequestBody Relacion_profesor_moduloRequestDto requestDto) {
		return ResponseEntity.ok(relacionService.actualizar(id, requestDto));
	}

	// DELETE - DELETE /api/relaciones-profesor-modulo/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		relacionService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
