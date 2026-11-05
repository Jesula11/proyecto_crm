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

import com.proyecto.crm.dtos.EstadoRequestDto;
import com.proyecto.crm.dtos.EstadoResponseDto;
import com.proyecto.crm.services.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
	private final EstadoService estadoService;

	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	// READ BY ID - GET /api/estados/{id}
	@GetMapping("/{id}")
	public ResponseEntity<EstadoResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(estadoService.obtenerPorId(id));
	}

	// CREATE - POST /api/estados
	@PostMapping
	public ResponseEntity<EstadoResponseDto> crear(@RequestBody EstadoRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.crear(requestDto));
	}

	// UPDATE - PUT /api/estados/{id}
	@PutMapping("/{id}")
	public ResponseEntity<EstadoResponseDto> actualizar(
			@PathVariable Long id,
			@RequestBody EstadoRequestDto requestDto) {
		return ResponseEntity.ok(estadoService.actualizar(id, requestDto));
	}

	// DELETE - DELETE /api/estados/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		estadoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
