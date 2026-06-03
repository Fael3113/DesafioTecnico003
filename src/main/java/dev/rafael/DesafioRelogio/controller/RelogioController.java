package dev.rafael.DesafioRelogio.controller;

import dev.rafael.DesafioRelogio.dto.AtualizarRelogioRequest;
import dev.rafael.DesafioRelogio.dto.CriarRelogioRequest;
import dev.rafael.DesafioRelogio.dto.PaginaRelogioDto;
import dev.rafael.DesafioRelogio.dto.RelogioDto;
import dev.rafael.DesafioRelogio.service.RelogioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/relogios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RelogioController {

	private final RelogioService service;

	@GetMapping
	public PaginaRelogioDto listar(
		@RequestParam(defaultValue = "1") int pagina,
		@RequestParam(defaultValue = "12") int porPagina,
		@RequestParam(required = false) String busca,
		@RequestParam(required = false) String marca,
		@RequestParam(required = false) String tipoMovimento,
		@RequestParam(required = false) String materialCaixa,
		@RequestParam(required = false) String tipoVidro,
		@RequestParam(required = false) Integer resistenciaMin,
		@RequestParam(required = false) Integer resistenciaMax,
		@RequestParam(required = false) Long precoMin,
		@RequestParam(required = false) Long precoMax,
		@RequestParam(required = false) Integer diametroMin,
		@RequestParam(required = false) Integer diametroMax,
		@RequestParam(required = false) String ordenar
	) {
		return service.listar(pagina, porPagina, busca, marca, tipoMovimento,
				materialCaixa, tipoVidro, resistenciaMin,
				resistenciaMax, precoMin, precoMax, diametroMin, diametroMax, ordenar);
	}

	@GetMapping("/{id}")
	public RelogioDto buscarPorId(@PathVariable UUID id){
		return service.buscarPorId(id);
	}

	@PostMapping
	public RelogioDto criar(@PathVariable CriarRelogioRequest req){
		return service.criar(req);
	}

	@PutMapping("/{id}")
	public RelogioDto atualizar(@PathVariable UUID id, @Valid @RequestBody AtualizarRelogioRequest req){
		return service.atualizar(id, req);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable UUID id){
		service.remover(id);
	}
}
