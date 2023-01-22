package com.example.automatic_irrigation_system.utils;

import com.example.automatic_irrigation_system.model.Plot;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class PlotMonitor
{
	private final ApplicationEventPublisher applicationEventPublisher;

	public PlotMonitor(ApplicationEventPublisher applicationEventPublisher)
	{

		Assert.notNull(applicationEventPublisher, "ApplicationEventPublisher is required");

		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void needIrrigationPlots(IrrigationEvent event)
	{
		Optional.ofNullable(event).map((IrrigationEvent source) -> new IrrigationEvent(source, new Plot())).filter(Plot.class::isInstance)
				.map(Plot.class::cast).map(it -> new IrrigationEvent(this, it)).ifPresent(this.applicationEventPublisher::publishEvent);
	}
}
