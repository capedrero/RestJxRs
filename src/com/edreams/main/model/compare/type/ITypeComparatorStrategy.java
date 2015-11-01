package com.edreams.main.model.compare.type;

import java.util.Comparator;

import com.edreams.main.bean.Flight;

public interface ITypeComparatorStrategy {
	 Comparator<Flight> getComparator();
	boolean isSelected();
}
