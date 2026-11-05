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

import com.proyecto.crm.dtos.FamiliaRequestDto;
import com.proyecto.crm.dtos.FamiliaResponseDto;
import com.proyecto.crm.services.FamiliaService;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {
	private final FamiliaService familiaService;

	public FamiliaController(FamiliaService familiaService) {
		this.familiaService = familiaService;
	}

	// READ BY ID - GET /api/familias/{id}
	@GetMapping("/{id}")
	public ResponseEntity<FamiliaResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(familiaService.obtenerPorId(id));
	}

	// CREATE - POST /api/familias
	@PostMapping
	public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.crear(requestDto));
	}

	// UPDATE - PUT /api/familias/{id}
	@PutMapping("/{id}")
	public ResponseEntity<FamiliaResponseDto> actualizar(
			@PathVariable Long id,
			@RequestBody FamiliaRequestDto requestDto) {
		return ResponseEntity.ok(familiaService.actualizar(id, requestDto));
	}

	// DELETE - DELETE /api/familias/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		familiaService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
