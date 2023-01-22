package com.example.automatic_irrigation_system.utils;

import com.example.automatic_irrigation_system.model.Plot;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class IrrigationEvent extends ApplicationEvent
{

	@Getter
	private final Plot plot;

	public IrrigationEvent(Object source, Plot amount)
	{

		super(source);

		this.plot = amount;
	}
}
