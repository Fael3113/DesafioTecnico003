package dev.rafael.DesafioRelogio.dto;

import java.util.List;

public record PaginaRelogioDto(
		List<RelogioDto> itens,
		long total
) {
}
