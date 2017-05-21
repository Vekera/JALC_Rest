package cz.broforce42.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.broforce42.calculator.LoanCalculator;
import cz.broforce42.calculator.apr.DefaultAprCalculator;
import cz.broforce42.model.ILoan;

@Service
public class LoanService {

	@Autowired
	private LoanCalculator calculator;

	@Autowired
	private DefaultAprCalculator calculatorApr;

	/**
	 * Method to calculate complete loan, generate schedule and calculate APR
	 * 
	 * @param loan
	 * 
	 */
	public ILoan calculateLoan(ILoan loan) {
		calculator.generateSchedule(loan);
		loan.setAnnualPercentageRate(calculatorApr.getAPR(loan));
		return loan;
	}

	/**
	 * Method to calculate loan APR
	 * 
	 * @param loan
	 * 
	 */
	public double calculateApr(ILoan loan) {
		calculator.generateSchedule(loan);
		return calculatorApr.getAPR(loan);
	}

	/**
	 * Method to calculate loan interest rate if use to construct only omount,
	 * monthly payment and number of payments
	 * 
	 * @param loan
	 * 
	 */
	public double calculateInterestRate(ILoan loan) {
		return calculatorApr.getInterest(loan);
	}

	/**
	 * Method to calculate loan monthly payment
	 * 
	 * @param loan
	 * 
	 */
	public double calculateMonthlyPayment(ILoan loan) {
		calculator.generateSchedule(loan);
		return loan.getMonthlyPayment();
	}

	/**
	 * Method to calculate loan total payment
	 * 
	 * @param loan
	 * 
	 */
	public double calculateTotalPayment(ILoan loan) {
		calculator.generateSchedule(loan);
		return loan.getTotalPayments();
	}

	/**
	 * Method to calculate loan total taxes
	 * 
	 * @param loan
	 * 
	 */
	public double calculateTotalTaxes(ILoan loan) {
		calculator.generateSchedule(loan);
		return loan.getTotalTaxes();
	}

	/**
	 * Method to calculate loan total interests
	 * 
	 * @param loan
	 * 
	 */
	public double calculateTotalInterests(ILoan loan) {
		calculator.generateSchedule(loan);
		return round(loan.getTotalInterests());
	}

	/**
	 * Rounding method
	 *
	 * @param value
	 */

	private double round(double value) {
		BigDecimal result = new BigDecimal(value);
		result = result.setScale(3, RoundingMode.HALF_UP);

		return result.doubleValue();
	}
}
