package com.edreams.main.model.compare.strategy;

import java.util.Comparator;

import com.edreams.main.bean.Flight;

public interface IComparatorStrategy {

	Comparator<Flight> getComparator() throws Exception;
	boolean isSelected();

}
