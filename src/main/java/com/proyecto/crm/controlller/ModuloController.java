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

import com.proyecto.crm.dtos.ModuloRequestDto;
import com.proyecto.crm.dtos.ModuloResponseDto;
import com.proyecto.crm.services.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
	private final ModuloService moduloService;

	public ModuloController(ModuloService moduloService) {
		this.moduloService = moduloService;
	}

	// READ BY ID - GET /api/modulos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<ModuloResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(moduloService.obtenerPorId(id));
	}

	// READ BY CODE - GET /api/modulos/codigo/{codigo}
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<ModuloResponseDto> obtenerPorCodigo(@PathVariable String codigo) {
		return ResponseEntity.ok(moduloService.obtenerPorCodigo(codigo));
	}

	// CREATE - POST /api/modulos
	@PostMapping
	public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(moduloService.crear(requestDto));
	}

	// UPDATE BY ID - PUT /api/modulos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ModuloResponseDto> actualizarPorId(
			@PathVariable Long id,
			@RequestBody ModuloRequestDto requestDto) {
		return ResponseEntity.ok(moduloService.actualizar(id, requestDto));
	}

	// UPDATE BY CODE - PUT /api/modulos/codigo/{codigo}
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<ModuloResponseDto> actualizarPorCodigo(
			@PathVariable String codigo,
			@RequestBody ModuloRequestDto requestDto) {
		return ResponseEntity.ok(moduloService.actualizar(codigo, requestDto));
	}

	// DELETE BY ID - DELETE /api/modulos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
		moduloService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	// DELETE BY CODE - DELETE /api/modulos/codigo/{codigo}
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarPorCodigo(@PathVariable String codigo) {
		moduloService.eliminar(codigo);
		return ResponseEntity.noContent().build();
	}
}
