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

import com.proyecto.crm.dtos.DepartamentoRequestDto;
import com.proyecto.crm.dtos.DepartamentoResponseDto;
import com.proyecto.crm.services.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	private final DepartamentoService departamentoService;

	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	// READ BY ID - GET /api/departamentos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<DepartamentoResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(departamentoService.obtenerPorId(id));
	}

	// READ BY CODE - GET /api/departamentos/codigo/{codigo}
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<DepartamentoResponseDto> obtenerPorCodigo(@PathVariable String codigo) {
		return ResponseEntity.ok(departamentoService.obtenerPorId(codigo));
	}

	// CREATE - POST /api/departamentos
	@PostMapping
	public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.crear(requestDto));
	}

	// UPDATE BY ID - PUT /api/departamentos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<DepartamentoResponseDto> actualizarPorId(
			@PathVariable Long id,
			@RequestBody DepartamentoRequestDto requestDto) {
		return ResponseEntity.ok(departamentoService.actualizar(id, requestDto));
	}

	// UPDATE BY CODE - PUT /api/departamentos/codigo/{codigo}
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<DepartamentoResponseDto> actualizarPorCodigo(
			@PathVariable String codigo,
			@RequestBody DepartamentoRequestDto requestDto) {
		return ResponseEntity.ok(departamentoService.actualizar(codigo, requestDto));
	}

	// DELETE BY ID - DELETE /api/departamentos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
		departamentoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	// DELETE BY CODE - DELETE /api/departamentos/codigo/{codigo}
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarPorCodigo(@PathVariable String codigo) {
		departamentoService.eliminar(codigo);
		return ResponseEntity.noContent().build();
	}
}
