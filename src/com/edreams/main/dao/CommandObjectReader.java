package com.edreams.main.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class CommandObjectReader implements IObjetReaderFromConsumeService {

	@Override
	public <T> ObjectReader processRoot(String rootName, Class<T> classToTransform) {
		ObjectMapper mapper = new ObjectMapper();
		
		if(rootName!=null){
			return mapper.readerFor(classToTransform).withRootName(rootName);
		}
		return mapper.readerFor(classToTransform);
		
	}

}
