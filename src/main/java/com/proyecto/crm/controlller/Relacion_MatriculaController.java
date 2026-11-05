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

import com.proyecto.crm.dtos.Relacion_MatriculaRequestDto;
import com.proyecto.crm.dtos.Relacion_MatriculaResponseDto;
import com.proyecto.crm.services.Relacion_MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class Relacion_MatriculaController {
	private final Relacion_MatriculaService relacionService;

	public Relacion_MatriculaController(Relacion_MatriculaService relacionService) {
		this.relacionService = relacionService;
	}

	// READ BY ID - GET /api/matriculas/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Relacion_MatriculaResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(relacionService.obtenerPorId(id));
	}

	// CREATE - POST /api/matriculas
	@PostMapping
	public ResponseEntity<Relacion_MatriculaResponseDto> crear(
			@RequestBody Relacion_MatriculaRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(relacionService.crear(requestDto));
	}

	// UPDATE - PUT /api/matriculas/{id}
	@PutMapping("/{id}")
	public ResponseEntity<Relacion_MatriculaResponseDto> actualizar(
			@PathVariable Long id,
			@RequestBody Relacion_MatriculaRequestDto requestDto) {
		return ResponseEntity.ok(relacionService.actualizar(id, requestDto));
	}

	// DELETE - DELETE /api/matriculas/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		relacionService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
