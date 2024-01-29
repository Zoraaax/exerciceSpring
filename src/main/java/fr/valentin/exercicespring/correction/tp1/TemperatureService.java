package fr.valentin.exercicespring.correction.tp1;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public Thermometre getBaseTemperature(double celsius) {
        Thermometre thermometre = new Thermometre();
        thermometre.setCelsius(celsius);
        return thermometre;
    }

    public Thermometre getBaseTemperature() {
        return this.getBaseTemperature(0);
    }

    public Thermometre getTemperatures(double value, String unit) {

        Thermometre temperature = this.getBaseTemperature(0);

        char formatUnit = unit.toLowerCase().charAt(0);

        switch (formatUnit) {
            case 'f':
                temperature.setFahrenheit(value);
            case 'k':
                temperature.setKelvin(value);
            default:
                return temperature;
        }
    }
}
