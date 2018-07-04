package com.gm.base.InitBinder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class LocalDateTimeEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals("")) {
			text = "0";
		}
		
		
		System.out.println("dddddddddddddddddddddddd");
		
		Instant instant = Instant.parse(text);
		setValue(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
	}

	@Override
	public String getAsText() {
		return getValue().toString();
	}
}