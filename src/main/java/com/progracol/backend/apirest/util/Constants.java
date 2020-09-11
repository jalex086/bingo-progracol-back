package com.progracol.backend.apirest.util;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Constants {

	public static final String SECRET_KEY = "progracol.bingo.secret.12345678";
	public static final String ERROR_SIZE_ARRAY_404 = "La cantidad de valores debe ser 25";

	public static final DateTimeFormatter FORMATTER_GLOBAL_INSTANT = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
			.withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());

	private Constants() {
	}
}
