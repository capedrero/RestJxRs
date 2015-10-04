package com.edreams.main.model.compare;

import java.util.Comparator;

import com.edreams.main.bean.Flight;

public interface IBuilderComparator {
	Comparator<Flight> getComparator() throws Exception;
}
