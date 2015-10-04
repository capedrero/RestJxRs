package com.edreams.main.model.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class BuilderComparator implements IBuilderComparator {


	private IParameterProcessor parameterProcessor;
	private List<IComparatorStrategy> listComparatorStrategy;


	public BuilderComparator(IParameterProcessor parameterProcessor) {
		super();
		this.parameterProcessor = parameterProcessor;
		listComparatorStrategy = new ArrayList<>();
		listComparatorStrategy.add(new PriceOrderComparatorStrategy(parameterProcessor));
		listComparatorStrategy.add(new TimeDifferenceComparatorStrategy(parameterProcessor));
		
	}


	public Comparator<Flight> getComparator() throws Exception {
		
		if(parameterProcessor.getFirstParameter("sorter")==null){
			return null;
		}
		for (IComparatorStrategy iComparatorStrategy : listComparatorStrategy) {
			if(iComparatorStrategy.isSelected()){
				return iComparatorStrategy.getComparator();
			}
		}
		return null;
				
	}
}
