package com.edreams.main.model.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.service.IParameterProcessor;

public class ManagerTyperOrder implements IManagerTypeOrder{
	private List<ITypeComparatorStrategy> listTypeComparatorStrategy;

	public ManagerTyperOrder(IParameterProcessor parameterProcessor) {
		super();		
		listTypeComparatorStrategy = new ArrayList<>();
		listTypeComparatorStrategy.add(new AscendentTypeComparator(parameterProcessor));
		listTypeComparatorStrategy.add(new DescendentTypeComaparator(parameterProcessor));
	}
	@Override
	public Comparator<Flight> getComparator(){
		for (ITypeComparatorStrategy iTypeComparatorStrategy : listTypeComparatorStrategy) {
			if(iTypeComparatorStrategy.isSelected()){
				return iTypeComparatorStrategy.getComparator();
			}
		}
		return null;
	}
	
	
	
}
