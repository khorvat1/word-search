package hr.kh.demo.core.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum SearchPlatform {
	GITHUB(1);
	
	Integer value;
	
	SearchPlatform(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public static SearchPlatform fromValue(Integer value) {
		for (SearchPlatform sp : SearchPlatform.values()) {
			if(sp.getValue().equals(value)) {
				return sp;
			}
		}
		
		return null;
	}
	
	@Converter(autoApply=true)
	public static class SearchPlatformConverter implements AttributeConverter<SearchPlatform, Integer> {

		@Override
		public Integer convertToDatabaseColumn(SearchPlatform value) {
			return value.getValue();
		}

		@Override
		public SearchPlatform convertToEntityAttribute(Integer value) {
			return SearchPlatform.fromValue(value);
		}
		
	}

}
