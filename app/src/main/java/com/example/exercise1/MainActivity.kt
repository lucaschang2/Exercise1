package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            var valid = true;
            val carPrice: String = editTextCarPrice.text.toString()

            if (editTextCarPrice.text.length == 0) {
                editTextCarPrice.setError("Invalid")
                valid = false;
            }
            val downPayment: String = editTextDownpayment.text.toString()

            if (downPayment.length == 0) {
                editTextDownpayment.setError("Invalid")
                valid = false;
            }

            val loanPeriod: String = editTextLoanPeriod.text.toString()

            if (loanPeriod.length == 0) {
                editTextLoanPeriod.setError("Invalid")
                valid=false;
            }
            val interestRate: String = editTextInterestRate.text.toString()

            if (interestRate.length == 0) {
                editTextInterestRate.setError("Invalid")
                valid = false;
            }
            if(valid) {
                val car_price = editTextCarPrice.text.toString().toInt()
                val down_payment = editTextDownpayment.text.toString().toInt()
                val loan_period = editTextLoanPeriod.text.toString().toInt()
                val interest_rate = editTextInterestRate.text.toString().toFloat()
                //todo continue the calculation here
                val loan = car_price - down_payment
                val interest = loan * interest_rate / 100 * loan_period
                val monthlyPayment = (loan + interest) / loan_period / 12
                textViewLoan.text = getString(R.string.loan) + "RM ${loan}"
                textViewInterest.text = getString(R.string.interest) + "RM ${interest}"
                textViewMonthlyPayment.text =
                    getString(R.string.monthly_payment) + "RM ${monthlyPayment}"
            }

        }
    }

    fun resetInputs(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.text.clear()
        editTextDownpayment.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
        textViewInterest.text = getString(R.string.interest)
        textViewLoan.text = getString(R.string.loan)
        textViewMonthlyPayment.text = getString(R.string.monthly_payment)

    }

    fun showResult(view: View) {

    }
}
