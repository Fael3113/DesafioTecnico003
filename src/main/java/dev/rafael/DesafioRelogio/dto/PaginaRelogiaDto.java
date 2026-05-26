package dev.rafael.DesafioRelogio.dto;

import java.util.List;

public record PaginaRelogiaDto(
		List<RelogioDto> itens,
		long total
) {
}
