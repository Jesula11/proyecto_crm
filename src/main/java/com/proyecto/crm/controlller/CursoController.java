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

import com.proyecto.crm.dtos.CursoRequestDto;
import com.proyecto.crm.dtos.CursoResponseDto;
import com.proyecto.crm.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	private final CursoService cursoService;

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	// READ ALL - GET /api/cursos
	@GetMapping
	public ResponseEntity<List<CursoResponseDto>> obtenerTodos() {
		return ResponseEntity.ok(cursoService.obtenerTodos());
	}

	// READ BY ID - GET /api/cursos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<CursoResponseDto> obtenerPorId(@PathVariable Long id) {
		return ResponseEntity.ok(cursoService.obtenerPorId(id));
	}

	// READ BY DIMINUTIVO - GET /api/cursos/diminutivo/{diminutivo}
	@GetMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<CursoResponseDto> obtenerPorDiminutivo(@PathVariable String diminutivo) {
		return ResponseEntity.ok(cursoService.obtenerPorDiminutivo(diminutivo));
	}

	// CREATE - POST /api/cursos
	@PostMapping
	public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto requestDto) {
		CursoResponseDto creado = cursoService.crear(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	// UPDATE BY ID - PUT /api/cursos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<CursoResponseDto> actualizarPorId(
			@PathVariable Long id,
			@RequestBody CursoRequestDto requestDto) {
		return ResponseEntity.ok(cursoService.actualizar(id, requestDto));
	}

	// UPDATE BY DIMINUTIVO - PUT /api/cursos/diminutivo/{diminutivo}
	@PutMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<CursoResponseDto> actualizarPorDiminutivo(
			@PathVariable String diminutivo,
			@RequestBody CursoRequestDto requestDto) {
		return ResponseEntity.ok(cursoService.actualizar(diminutivo, requestDto));
	}

	// DELETE BY ID - DELETE /api/cursos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
		cursoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	// DELETE BY DIMINUTIVO - DELETE /api/cursos/diminutivo/{diminutivo}
	@DeleteMapping("/diminutivo/{diminutivo}")
	public ResponseEntity<Void> eliminarPorDiminutivo(@PathVariable String diminutivo) {
		cursoService.eliminar(diminutivo);
		return ResponseEntity.noContent().build();
	}
}
