package fr.valentin.exercicespring.thermometre.dto;

import lombok.Data;

@Data
public class TemperatureDto {
    private double celsius = 0;
    private double fahrenheit = 32;
    private double kelvin = 273.15;
}
