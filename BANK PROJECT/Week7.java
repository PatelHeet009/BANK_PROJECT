
interface LoanService {

    void applyLoan(double amount);

    void showLoan();
}


class Loan implements LoanService {

    double loanAmount;

    public void applyLoan(double amount) {

        loanAmount = amount;

        System.out.println(
                "Loan Applied: ₹" + amount
        );
    }

    public void showLoan() {

        System.out.println(
                "Loan Amount: ₹" + loanAmount
        );
    }
}


public class Week7 {

    public static void main(String[] args) {

        Loan loan = new Loan();

        loan.applyLoan(100000);

        loan.showLoan();
    }
}
