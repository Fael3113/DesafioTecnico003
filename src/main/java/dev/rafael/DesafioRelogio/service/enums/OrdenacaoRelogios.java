package dev.rafael.DesafioRelogio.service.enums;

public enum OrdenacaoRelogios {
	MAIS_RECENTES, PRECO_CRESC, PRECO_DESC, DIAMETRRO_CRESC, RESISTENCIA_DESC;

	public static OrdenacaoRelogios fromApi(String valor){
		if (valor == null || valor.isBlank()) return MAIS_RECENTES;
		return switch (valor){
			case "newest" -> MAIS_RECENTES;
			case "price_asc" -> PRECO_CRESC;
			case "price_desc" -> PRECO_DESC;
			case "diametro_asc" -> DIAMETRRO_CRESC;
			case "wr_desc" -> RESISTENCIA_DESC;
			default -> throw new IllegalArgumentException("Ordenação inválida: "+valor);
		};
	}
}
