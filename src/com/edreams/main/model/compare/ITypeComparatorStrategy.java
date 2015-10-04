package com.edreams.main.model.compare;

import java.util.Comparator;

import com.edreams.main.bean.Flight;

public interface ITypeComparatorStrategy {
	Comparator<Flight> getComparator();
	boolean isSelected();
}
