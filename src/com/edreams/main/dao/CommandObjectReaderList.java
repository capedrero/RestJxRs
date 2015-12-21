package com.edreams.main.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;

public class CommandObjectReaderList{
	public <T, K> ObjectReader processRoot(String rootName,  Class<K> rawType, Class<T> classToTransform) {

		ObjectMapper mapper = new ObjectMapper();
		if(rootName!=null){
			return mapper.readerFor(CollectionType.construct(rawType, SimpleType.construct(classToTransform))).withRootName(rootName);
		}	
		return mapper.readerFor(CollectionType.construct(rawType, SimpleType.construct(classToTransform)));
	}

	

}
