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

import com.proyecto.crm.dtos.TitulacionRequestDto;
import com.proyecto.crm.dtos.TitulacionResponseDto;
import com.proyecto.crm.services.TitulacionService;

@RestController
@RequestMapping("/api/titulaciones")
public class TitulacionController {
	private final TitulacionService titulacionService;

	public TitulacionController(TitulacionService titulacionService) {
		this.titulacionService = titulacionService;
	}

	// READ BY ID - GET /api/titulaciones/{id}
	@GetMapping("/{id}")
	public ResponseEntity<TitulacionResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(titulacionService.obtenerPorId(id));
	}

	// READ BY CODE - GET /api/titulaciones/codigo/{codigo}
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<TitulacionResponseDto> obtenerPorCodigo(@PathVariable String codigo) {
		return ResponseEntity.ok(titulacionService.obtenerPorCodigo(codigo));
	}

	// CREATE - POST /api/titulaciones
	@PostMapping
	public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(titulacionService.crear(requestDto));
	}

	// UPDATE BY ID - PUT /api/titulaciones/{id}
	@PutMapping("/{id}")
	public ResponseEntity<TitulacionResponseDto> actualizarPorId(
			@PathVariable Long id,
			@RequestBody TitulacionRequestDto requestDto) {
		return ResponseEntity.ok(titulacionService.actualizar(id, requestDto));
	}

	// UPDATE BY CODE - PUT /api/titulaciones/codigo/{codigo}
	@PutMapping("/codigo/{codigo}")
	public ResponseEntity<TitulacionResponseDto> actualizarPorCodigo(
			@PathVariable String codigo,
			@RequestBody TitulacionRequestDto requestDto) {
		return ResponseEntity.ok(titulacionService.actualizar(codigo, requestDto));
	}

	// DELETE BY ID - DELETE /api/titulaciones/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
		titulacionService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	// DELETE BY CODE - DELETE /api/titulaciones/codigo/{codigo}
	@DeleteMapping("/codigo/{codigo}")
	public ResponseEntity<Void> eliminarPorCodigo(@PathVariable String codigo) {
		titulacionService.eliminar(codigo);
		return ResponseEntity.noContent().build();
	}
}
