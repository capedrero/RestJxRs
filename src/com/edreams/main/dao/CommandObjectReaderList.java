package com.edreams.main.dao;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;

public class CommandObjectReaderList implements IObjetReaderFromConsumeService{	
	@Override
	public <T> ObjectReader processRoot(String rootName, Class<T> classToTransform) {

		ObjectMapper mapper = new ObjectMapper();
		if(rootName!=null){
			return mapper.readerFor(CollectionType.construct(ArrayList.class, SimpleType.construct(classToTransform))).withRootName(rootName);
					//new TypeReference<List<T>>() {}).withRootName(rootName);
		}	
		return mapper.readerFor(CollectionType.construct(ArrayList.class, SimpleType.construct(classToTransform)));
	}

	

}
