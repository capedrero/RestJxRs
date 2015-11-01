package com.edreams.main.dao;

import com.fasterxml.jackson.databind.ObjectReader;

public interface IObjetReaderFromConsumeService {
	

	<T>  ObjectReader processRoot(String rootName,  Class<T> classToTransform);
	


}
