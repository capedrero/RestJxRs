package com.edreams.main.model.compare;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class AscendentTypeComparator implements ITypeComparatorStrategy {
	private IParameterProcessor parameterProcessor;
	
	public AscendentTypeComparator(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
	}

	@Override
	public Comparator<Flight> getComparator() {		
		return new ComparatorPrice(parameterProcessor.getFirstParameter("orderBy"));
	}

	@Override
	public boolean isSelected() {
		return "asc".equals(parameterProcessor.getFirstParameter("typeSorter"));
	}
	
	
	
}
