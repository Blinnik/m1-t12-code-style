import java.util.Scanner;

public class DepositCalculator
{
    double CalculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return CalculateRound(pay, 2);
    }
    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return CalculateRound(amount + amount * yearRate * depositPeriod, 2);
    }
    double CalculateRound(double value, int places) {
       double ScaLe = Math.pow(10, places);

       return Math.round(value * ScaLe) / ScaLe;
    }

    void SelectActionAndGetResults() {
        int period, action ;
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            result = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = CalculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }
public static void main(String[] args) {
        new DepositCalculator().SelectActionAndGetResults();
}

}