package com.example.patterns.factory;

class Temperature {
    private double temperature;

    private Temperature(final double pTempCelsius) {
        temperature = pTempCelsius;
    }

    @Override
    public String toString() {
        return ("It is " + temperature + " Celsius degrees");
    }

    /**
     * In this case factory enables getting the same result no matter what is the origin (Celsius/Kelvin/Fahrenheit)
     */
    public static class Factory {

        public static Temperature getTemperatureFromCelsius(final double pTemperature) {
            return new Temperature(pTemperature);
        }

        public static Temperature getTemperatureFromFahrenheit(final double pTemperature) {
            return new Temperature((pTemperature - 32d) / 1.8);
        }

        public static Temperature getTemperatureFromKelvin(final double pTemperature) {
            return new Temperature(pTemperature - 273.15);
        }
    }
}

public class Factory2 {

    public static void main(String[] args) {

        Temperature t1 = Temperature.Factory.getTemperatureFromCelsius(0);
        Temperature t2 = Temperature.Factory.getTemperatureFromFahrenheit(0);
        Temperature t3 = Temperature.Factory.getTemperatureFromKelvin(0);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
