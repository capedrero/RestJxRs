package com.edreams.main.model.compare.strategy;

import java.util.Comparator;

import com.edreams.main.bean.Flight;

public interface IManagerTypeOrder {

	Comparator<Flight> getComparator();

}
