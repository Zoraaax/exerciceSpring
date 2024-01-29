package fr.valentin.exercicespring.thermometre;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ThermometreService {

    public double convertirCelsiusEnFahrenheit(double celsius) {
        if (celsius == 0) {
            return 32;
        } else {
            return celsius * 9 / 5 + 32;
        }
    }

    public double convertirCelsiusEnKelvin(double celsius) {
        if (celsius == 0) {
            return 273.15;
        } else {
            return celsius + 273.15;
        }
    }

    public HashMap<String, Double> convertir(String unit, double value) throws IllegalArgumentException {

        char unitChar = unit.toLowerCase().charAt(0);

        switch (unitChar) {
            case 'f':
                HashMap<String, Double> fahrenheitJson = new HashMap<>();
                fahrenheitJson.put("celsius", convertirCelsiusEnFahrenheit(convertirCelsiusEnKelvin(value)));
                fahrenheitJson.put("fahrenheit", value);
                fahrenheitJson.put("kelvin", convertirCelsiusEnKelvin(convertirCelsiusEnFahrenheit(value)));
                return fahrenheitJson;
            case 'k':
                HashMap<String, Double> kelvinJson = new HashMap<>();
                kelvinJson.put("celsius", convertirCelsiusEnKelvin(value));
                kelvinJson.put("fahrenheit", convertirCelsiusEnFahrenheit(convertirCelsiusEnKelvin(value)));
                kelvinJson.put("kelvin", value);
                return kelvinJson;
            case 'c':
                HashMap<String, Double> json = new HashMap<>();
                json.put("celsius", value);
                json.put("fahrenheit", convertirCelsiusEnFahrenheit(value));
                json.put("kelvin", convertirCelsiusEnKelvin(value));
                return json;
            default:
                throw new IllegalArgumentException("Unité inconnue");
        }
    }
}
