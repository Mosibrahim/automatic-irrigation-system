package com.example.automatic_irrigation_system.repositories;

import com.example.automatic_irrigation_system.model.Plot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends CrudRepository<Plot, Long>
{
	@Override
	List<Plot> findAll();
}
