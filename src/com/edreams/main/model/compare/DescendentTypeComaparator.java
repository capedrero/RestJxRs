package com.edreams.main.model.compare;

import java.util.Collections;
import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class DescendentTypeComaparator implements ITypeComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	
	public DescendentTypeComaparator(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
	}

	@Override
	public Comparator<Flight> getComparator() {		
		return  Collections
				.reverseOrder(new ComparatorPrice(parameterProcessor.getFirstParameter("orderBy")));
	}

	@Override
	public boolean isSelected() {
		return "desc".equals(parameterProcessor.getFirstParameter("typeSorter"));
	}
}
