package br.edu.ifg.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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

}
