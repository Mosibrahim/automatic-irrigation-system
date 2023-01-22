package com.example.automatic_irrigation_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Plot
{
	@Id
	private long id;
	private String name;
	private String code;
	private Long amountOfWater;
	private Long minimumAmountOfWater;
}
