package com.edreams.main.model.compare.type;

import java.util.Collections;
import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class DescendentTypeComaparator implements ITypeComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	private Comparator<Flight> comparator;
	public DescendentTypeComaparator(IParameterProcessor parameterProcessor, Comparator<Flight> comparator) {
		super();
		this.parameterProcessor = parameterProcessor;
		this.comparator = comparator;
	}

	@Override
	public Comparator<Flight> getComparator() {		
		return  Collections
				.reverseOrder(comparator);
						//new ComparatorPrice(parameterProcessor.getFirstParameter("orderBy"));
	}

	@Override
	public boolean isSelected() {
		return "desc".equals(parameterProcessor.getFirstParameter("typeSorter"));
	}
}
