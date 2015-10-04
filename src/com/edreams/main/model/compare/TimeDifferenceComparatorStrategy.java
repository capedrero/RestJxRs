package com.edreams.main.model.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class TimeDifferenceComparatorStrategy implements IComparatorStrategy {
	public static final String TIME_DIFFERENCE_ORDER = "timeDifference";
	
	private IParameterProcessor parameterProcessor;
	private List<ITypeComparatorStrategy> listTypeComparatorStrategy;
	
	public TimeDifferenceComparatorStrategy(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
		listTypeComparatorStrategy = new ArrayList<>();
		listTypeComparatorStrategy.add(new AscendentTypeComparator(parameterProcessor));
		listTypeComparatorStrategy.add(new DescendentTypeComaparator(parameterProcessor));
	}

	@Override
	public Comparator<Flight> getComparator() throws Exception {
		for (ITypeComparatorStrategy iTypeComparatorStrategy : listTypeComparatorStrategy) {
			if(iTypeComparatorStrategy.isSelected()){
				return iTypeComparatorStrategy.getComparator();
			}
		}
		 return null;
	}

	@Override
	public boolean isSelected() {
		return TIME_DIFFERENCE_ORDER.equals(parameterProcessor.getFirstParameter("sorter"));
	}
	
	

}
