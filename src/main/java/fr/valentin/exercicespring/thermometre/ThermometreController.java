package fr.valentin.exercicespring.thermometre;

import fr.valentin.exercicespring.thermometre.dto.ConvertisseurDto;
import fr.valentin.exercicespring.thermometre.dto.TemperatureDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ThermometreController {

    private final ThermometreService thermometreService;

    public ThermometreController(ThermometreService thermometreService) {
        this.thermometreService = thermometreService;
    }

    @GetMapping("/temperature")
    public HashMap<String, Double> getTemperature(TemperatureDto temperatureDto) {
        double celsius = temperatureDto.getCelsius();
        double fahrenheit = temperatureDto.getFahrenheit();
        double kelvin = temperatureDto.getKelvin();

        HashMap<String, Double> json = new HashMap<>();
        json.put("celsius", celsius);
        json.put("fahrenheit", fahrenheit);
        json.put("kelvin", kelvin);
        return json;
    }

    @GetMapping("/temperature/param")
    public HashMap<String, Double> getTemperatureWithParam(@RequestParam(required = true) double celsius
    ) {

        double fahrenheit;
        double kelvin;

        fahrenheit = thermometreService.convertirCelsiusEnFahrenheit(celsius);
        kelvin = thermometreService.convertirCelsiusEnKelvin(celsius);

        HashMap<String, Double> json = new HashMap<>();
        json.put("celsius", celsius);
        json.put("fahrenheit", fahrenheit);
        json.put("kelvin", kelvin);
        return json;
    }

    @PostMapping("/temperature/convert")
    public HashMap<String, Double> convertTemperature(@RequestBody ConvertisseurDto convertisseurDto) {
        return thermometreService.convertir(convertisseurDto.getUnit(), convertisseurDto.getValue());
    }
}
