package fr.valentin.exercicespring.correction.tp1;

import fr.valentin.exercicespring.correction.tp1.dto.ThermometreConvertDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public Thermometre getTemperatureFromValue(@RequestParam(defaultValue = "0") double celsius) {
        return temperatureService.getBaseTemperature(celsius);
    }

    @PostMapping("/convert")
    public Thermometre convertTemperature(@RequestBody ThermometreConvertDto thermometreConvertDto) {
        return temperatureService.getTemperatures(
                thermometreConvertDto.getUnit(),
                thermometreConvertDto.getValue()
        );
    }

}
