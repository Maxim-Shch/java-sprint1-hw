class MonthData {
    int[] days = new int[30]; //количество дней в месяце

    public void printDaysAndStepsFromMonth() {//кол-во пройденных шагов по дням
        for (int i = 0; i < days.length; i++) {
            System.out.println("День " + (i + 1) + " шаги " + days[i]);
        }
    }

    public int sumStepsFromMonth() { //подсчёт суммы шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    public int maxSteps() { //максимальное количество шагов за месяц
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) { //поиск максимальной серии
        int currentSeries = 0;
        int finalSeries = 0;

        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries += 1;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
