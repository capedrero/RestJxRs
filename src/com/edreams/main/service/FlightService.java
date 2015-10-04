package com.edreams.main.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.edreams.main.bean.DragonFlightCollection;
import com.edreams.main.bean.Flight;
import com.edreams.main.controller.ControllerFlightService;
import com.edreams.main.dao.ConsumerRestService;
import com.edreams.main.model.FlightBeanTranslator;
import com.edreams.main.model.ITransformFlightBean;
import com.edreams.main.model.ITransformFlightProcess;
import com.edreams.main.model.TransformFlights;
import com.edreams.main.model.compare.BuilderComparator;

@Path("/flightService/")
public class FlightService {

	private ControllerFlightService<DragonFlightCollection> controllerFlightService;

	
	public FlightService() throws Exception {
		super();
		this.controllerFlightService = new ControllerFlightService<DragonFlightCollection>();	
		this.controllerFlightService.setTransformFlightProcess(new TransformFlights(Arrays.asList(new ITransformFlightBean[]{new FlightBeanTranslator()})));
		this.controllerFlightService.setConsumerRestService(new ConsumerRestService<DragonFlightCollection>("http://odigeo-testbackend.herokuapp.com", DragonFlightCollection.class));
		this.controllerFlightService.startDB();
	}
	
	@GET
	@Path("/getFlights")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Flight> getFlights() {	
		return controllerFlightService.getFlights();
	}
	@GET
	@Path("/getOrderFlights/")
	//sorter/{sorter}/typeSorter/{typeSorter}/type/{type}/
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Flight> getOrderFlights(@Context UriInfo context)throws Exception {
			/*@QueryParam("sorter") String sorter,
											  @QueryParam("typeSorter") String typeSorter, 
											  @QueryParam("type") String type,
											  @QueryParam("origin") String origin, 
											  @QueryParam("destin") String destin) throws Exception {*/
		IParameterProcessor parameterProcessor = new ParameterProcessor();
		parameterProcessor.setContext(context);	
		return controllerFlightService.getOrderFlights(parameterProcessor.getFirstParameter("origin"), parameterProcessor.getFirstParameter("destin"), new BuilderComparator(parameterProcessor));
	}
	
	public void setTransformFlightProcess(ITransformFlightProcess transformFlightProcess) throws Exception {
		controllerFlightService.setTransformFlightProcess(transformFlightProcess);
	}
	public void setConsumerRestService(ConsumerRestService<DragonFlightCollection> consumerRestService) throws Exception {
		controllerFlightService.setConsumerRestService(consumerRestService);
	}
}
