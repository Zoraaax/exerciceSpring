package fr.valentin.exercicespring.correction.tp1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Thermometre {
    private double kelvin;

    public double getCelsius() {
        return this.kelvin - 273.15;
    }

    public double getFahrenheit() {
        return this.kelvin * 9 / 5 - 459.67;
    }

    public void setCelsius(double celsius) {
        this.kelvin = celsius + 273.15;
    }

    public void setFahrenheit(double fahrenheit) {
        this.kelvin = (fahrenheit + 459.67) * 5 / 9;
    }
}
