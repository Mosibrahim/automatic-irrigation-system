package com.example.automatic_irrigation_system.utils;

import com.example.automatic_irrigation_system.model.Plot;
import com.example.automatic_irrigation_system.repositories.PlotRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.PrimitiveIterator;
import java.util.Random;

import static java.lang.System.out;

@Service
@SuppressWarnings("unused")

public class IrrigationSensor
{
	private final PrimitiveIterator.OfInt irrigationStream = new Random(System.currentTimeMillis()).ints(-100, 400).iterator();

	private final PlotRepository repository;

	public IrrigationSensor(PlotRepository repository)
	{

		Assert.notNull(repository, "PlotRepository is required");

		this.repository = repository;
	}

	@Scheduled(fixedRateString = "${example.app.temp.sensor.reading.schedule.rate:1000}")
	public void readAmountOfWater()
	{

		int irrigationReading = irrigationStream.nextInt();

		this.repository.save(log(irrigationReading));
	}

	private Plot log(long amount)
	{

		out.printf("AMOUNT OF WATER READING [%s]%n", amount);
		Plot plot = new Plot();
		plot.setAmountOfWater(amount);
		return plot;
	}
}
