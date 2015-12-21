package com.edreams.main.dao;

import java.util.List;

public interface IConsumerRestService {

	<T> T consumeServiceToJson(Class<T> classToTransform) throws Exception;

	<T, K> List<T> consumeServiceToJson(Class<K> rawType, Class<T> classToTransform) throws Exception;

	void setUrl(String url);

	void setRootName(String rootName);

}
