package com.edreams.main.model.compare.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edreams.main.bean.Flight;
import com.edreams.main.model.compare.type.AscendentTypeComparator;
import com.edreams.main.model.compare.type.DescendentTypeComaparator;
import com.edreams.main.model.compare.type.ITypeComparatorStrategy;
import com.edreams.main.service.IParameterProcessor;

public class ManagerTyperOrder implements IManagerTypeOrder{
	private List<ITypeComparatorStrategy> listTypeComparatorStrategy;

	public ManagerTyperOrder(IParameterProcessor parameterProcessor, Comparator<Flight> comparator) {
		super();		
		listTypeComparatorStrategy = new ArrayList<>();
		listTypeComparatorStrategy.add(new AscendentTypeComparator(parameterProcessor, comparator));
		listTypeComparatorStrategy.add(new DescendentTypeComaparator(parameterProcessor, comparator));
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
