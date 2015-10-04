package com.edreams.main.model.compare;

import java.util.Comparator;
import java.util.Date;

import com.edreams.main.bean.Flight;

public class ComparatorTripTimeDifferenceBeans implements Comparator<Flight> {

	@Override
	public int compare(Flight bean1, Flight bean2) {
		return new Date(Math.abs(bean1.getDateDeparture().getTime() - bean1.getDateArrival().getTime()))
				.compareTo(new Date(Math.abs(bean2.getDateDeparture().getTime() - bean2.getDateArrival().getTime())));
	}

}