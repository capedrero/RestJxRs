package com.edreams.main.model.compare.type;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class AscendentTypeComparator implements ITypeComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	private Comparator<Flight> comparator;
	
	public AscendentTypeComparator(IParameterProcessor parameterProcessor, Comparator<Flight> comparator) {
		super();
		this.parameterProcessor = parameterProcessor;
		this.comparator = comparator;
	}

	@Override
	public Comparator<Flight> getComparator() {		
		return comparator;				
	}

	@Override
	public boolean isSelected() {
		return "asc".equals(parameterProcessor.getFirstParameter("typeSorter"));
	}
	
	
	
}
