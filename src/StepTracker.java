import java.util.Scanner;

class StepTracker {
    MonthData[] monthData = new MonthData[12];
    int goalByStepsPerDay = 10_000; //цель шагов на день
    Scanner scanner;
    Converter converter = new Converter();


     public StepTracker(Scanner scan) {
         scanner = scan;

        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void addNewNumbersStepsPerDay() {// записи данных
        System.out.println("Введите номер месяца:");
        int monthNumber = scanner.nextInt();

        while (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Неверно указан номер месяца! " +
                    " Нумерация месяцев начинается от 1 до 12(пример: 1 - январь). Введите номер месяца повторно.");
            monthNumber = scanner.nextInt();
        }
        monthNumber -= 1;


        System.out.println("Введите день от 1 до 30 (включительно):");
        int dayNumber = scanner.nextInt();
        while (dayNumber < 1 || dayNumber > 30) {//проверить число 30
            System.out.println("Неверное указан число дня! " +
                    "Нумерация дней начинается от 1 до 30. Введите номер дня повторно.");
            dayNumber = scanner.nextInt();
        }
        dayNumber -=1;

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Введенные шаги не могут быть отрицательными. " +
                    " Повторите еще раз ввести шаги.");
            steps = scanner.nextInt();
        }

        //получение соответствуеющего объекта MonthData из массива
        MonthData month = monthData[monthNumber];
        month.days[dayNumber] = steps;
    }

    public void changeStepGoal() {//изменение цели кол-во шагов пользователем
        int newGoalSteps = 0;
        System.out.println("Ваша текущая цель шагов составляет: " + goalByStepsPerDay);
        System.out.println("Укажите новое значение количества шагов:");
        int newGoalNumberOfSteps = scanner.nextInt(); //пользователь вводит новые данные
        newGoalSteps = newGoalNumberOfSteps; //новая цель шагов в месяц
        goalByStepsPerDay = newGoalSteps;
        System.out.println("Поставлена новая цель за месяц: " + newGoalSteps);
    }

    public void printStatistic() { //вывод статистики
        System.out.println("Введите число месяца:");
        int dateOfTheMonth = scanner.nextInt();
        while (dateOfTheMonth < 1 || dateOfTheMonth > 12) {
            System.out.println("Неверно указан номер месяца! " +
                    " Нумерация месяцев начинается от 1 до 12(Например: 1 - январь). Введите номер месяца повторно.");
            dateOfTheMonth = scanner.nextInt();
        }
        dateOfTheMonth -= 1;
        MonthData month = monthData[dateOfTheMonth]; //получение месяца
        int sumSteps = month.sumStepsFromMonth(); // получение суммы шагов за месяц

        //вывод общей статистики по дням
        month.printDaysAndStepsFromMonth();

        //вывод суммы шагов за месяц
        System.out.println("Общее количество пройденых шагов за месяц: " + sumSteps);

        //вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимально пройденых количество шагов за месяц: " + month.maxSteps());

        //вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее количество пройденых шагов за месяц: " + sumSteps / 30);

        //вывод пройденной за месяц дистанции в км
        System.out.println("Дистанция пройденных шагов за месяц в км: " + converter.convertToKm(sumSteps));


        //вывод кол-во сожжённых килокалорий за месяц
        System.out.println("Сожжено килокалорий всего за месяц: " + converter.convertStepsToKilocalories(sumSteps));


        //вывод лучшей серии
        System.out.println("Лучшая серия дней за месяц: " + month.bestSeries(goalByStepsPerDay));

        System.out.println(); //дополнительный перенос строки
    }
}
