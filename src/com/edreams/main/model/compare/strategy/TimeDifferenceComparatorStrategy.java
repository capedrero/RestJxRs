package com.edreams.main.model.compare.strategy;

import java.util.Comparator;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.compare.beanComparator.ComparatorTripTimeDifferenceBeans;
import com.edreams.main.service.IParameterProcessor;

public class TimeDifferenceComparatorStrategy implements IComparatorStrategy {
	public static final String TIME_DIFFERENCE_ORDER = "timeDifference";
	
	private IParameterProcessor parameterProcessor;
	
	public TimeDifferenceComparatorStrategy(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;	
	}

	@Override
	public Comparator<Flight> getComparator() throws Exception {
		return new ManagerTyperOrder(parameterProcessor, new ComparatorTripTimeDifferenceBeans()).getComparator();				
	}

	@Override
	public boolean isSelected() {
		return TIME_DIFFERENCE_ORDER.equals(parameterProcessor.getFirstParameter("sorter"));
	}
	
	

}
