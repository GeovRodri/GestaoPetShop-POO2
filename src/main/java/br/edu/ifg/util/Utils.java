package br.edu.ifg.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
	
	public static Date stringToDate(String date) {
		if (date == null || date.isEmpty())
			return null;

		int idx = date.lastIndexOf("/");
		boolean ano = idx > 0 ? date.substring(idx).length() > 4 : false;

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);
		sdf.applyPattern(ano ? "dd/MM/yyy" : "yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String dateToString(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);
		sdf.applyPattern("dd/MM/yyyy");
		return sdf.format(date);
	}


	public static String formatarValor(Double valor) {
		NumberFormat fmt = NumberFormat.getInstance(new Locale("pt", "BR"));
		fmt.setMinimumFractionDigits(2);
		return fmt.format(valor);
	}

}
