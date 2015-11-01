package com.edreams.main.model.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.compare.strategy.IComparatorStrategy;
import com.edreams.main.service.IParameterProcessor;

public class BuilderComparator implements IBuilderComparator {


	private IParameterProcessor parameterProcessor;
	private List<IComparatorStrategy> listComparatorStrategy;


	public BuilderComparator(IParameterProcessor parameterProcessor,IComparatorStrategy[] aComparatorStrategies ) {
		super();
		this.parameterProcessor = parameterProcessor;
		listComparatorStrategy = new ArrayList<>();
		listComparatorStrategy.addAll(Arrays.asList(aComparatorStrategies));
		
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
