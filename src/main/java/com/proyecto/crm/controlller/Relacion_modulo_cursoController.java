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

import com.proyecto.crm.dtos.Relacion_modulo_cursoRequestDto;
import com.proyecto.crm.dtos.Relacion_modulo_cursoResponseDto;
import com.proyecto.crm.services.Relacion_modulo_cursoService;

@RestController
@RequestMapping("/api/relaciones-modulo-curso")
public class Relacion_modulo_cursoController {
	private final Relacion_modulo_cursoService relacionService;

	public Relacion_modulo_cursoController(Relacion_modulo_cursoService relacionService) {
		this.relacionService = relacionService;
	}

	// READ BY ID - GET /api/relaciones-modulo-curso/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Relacion_modulo_cursoResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(relacionService.obtenerPorId(id));
	}

	// CREATE - POST /api/relaciones-modulo-curso
	@PostMapping
	public ResponseEntity<Relacion_modulo_cursoResponseDto> crear(
			@RequestBody Relacion_modulo_cursoRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(relacionService.crear(requestDto));
	}

	// UPDATE - PUT /api/relaciones-modulo-curso/{id}
	@PutMapping("/{id}")
	public ResponseEntity<Relacion_modulo_cursoResponseDto> actualizar(
			@PathVariable Long id,
			@RequestBody Relacion_modulo_cursoRequestDto requestDto) {
		return ResponseEntity.ok(relacionService.actualizar(id, requestDto));
	}

	// DELETE - DELETE /api/relaciones-modulo-curso/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		relacionService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
