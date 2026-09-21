class Loan {
double amount;
double rate;
int years;

Loan(
        double amount,
        double rate,
        int years) {

    this.amount = amount;
    this.rate = rate;
    this.years = years;
}


double calculateEMI() {

    double monthlyRate =
            rate / 12 / 100;

    int months = years * 12;

    double emi =
            amount
            * monthlyRate
            * Math.pow(
                    1 + monthlyRate,
                    months
            )
            /
            (
                Math.pow(
                        1 + monthlyRate,
                        months
                ) - 1
            );

    return emi;
}


void showLoan() {

    System.out.println(
            "Loan Amount: ₹" + amount
    );

    System.out.println(
            "Interest Rate: " + rate + "%"
    );

    System.out.println(
            "Years: " + years
    );

    System.out.println(
            "Monthly EMI: ₹"
                    + String.format(
                            "%.2f",
                            calculateEMI()
                    )
    );
}

}

public class Week8 {
public static void main(String[] args) {

    Loan loan = new Loan(
            100000,
            8.5,
            5
    );

    loan.showLoan();
}
}