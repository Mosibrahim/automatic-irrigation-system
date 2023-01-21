package com.example.automatic_irrigation_system.controller;

import com.example.automatic_irrigation_system.model.Plot;
import com.example.automatic_irrigation_system.repositories.PlotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("plots")
public class PlotController
{
	PlotRepository repository;

	@PostMapping("addPlot")
	public void insertPlot(@RequestBody Plot plot)
	{
		repository.save(plot);
	}

	@GetMapping("listAll")
	public List<Plot> findAllPlots()
	{
		return repository.findAll();
	}
}
