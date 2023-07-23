class Converter {
    int stepsInCentimeters = 75; //один шаг равен 75 см, это подсчёт дистанции
    int stepsInCalories = 50; //один шаг равен 50 калориям
    int oneKilocalory = 1000; // одна килокалория равна 1000 калорий

    double convertToKm(int steps) { //перевод шагов в км
        return steps * stepsInCentimeters * 0.00001;
    }

    int convertStepsToKilocalories(int steps) { //перевод кол-во шагов в килокалории
        return steps * stepsInCalories / oneKilocalory;
    }
}
