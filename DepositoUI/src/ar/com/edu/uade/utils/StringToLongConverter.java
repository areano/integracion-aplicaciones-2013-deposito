package ar.com.edu.uade.utils;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

public class StringToLongConverter implements Converter<String, Long> {

	@Override
	public Long convertToModel(String value, Class<? extends Long> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {

		Long result = null;

		try {
			result = Long.parseLong(value);
		} catch (NumberFormatException nfe) {
			throw new ConversionException("Unable to parse String to Long");
		}
		return result;
	}

	@Override
	public String convertToPresentation(Long value, Class<? extends String> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
		return value.toString();
	}

	@Override
	public Class<Long> getModelType() {
		return Long.class;
	}

	@Override
	public Class<String> getPresentationType() {
		return String.class;
	}

}
