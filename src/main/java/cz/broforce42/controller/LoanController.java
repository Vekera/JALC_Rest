package cz.broforce42.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.broforce42.model.ILoan;
import cz.broforce42.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;

	/**
	 * @see LoanService#calculateLoan(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateLoan")
	public ILoan calculateLoan(@Validated @RequestBody ILoan loan) {
		return loanService.calculateLoan(loan);
	}

	/**
	 * @see LoanService#calculateApr(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateApr")
	public double calculateApr(@Validated @RequestBody ILoan loan) {
		return loanService.calculateApr(loan);
	}

	/**
	 * @see LoanService#calculateInterestRate(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateInterestRate")
	public double calculateInterestRate(@Validated @RequestBody ILoan loan) {
		return loanService.calculateInterestRate(loan);
	}

	/**
	 * @see LoanService#calculateMonthlyPayment(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateMonthlyPayment")
	public double calculateMonthlyPayment(@Validated @RequestBody ILoan loan) {
		return loanService.calculateMonthlyPayment(loan);
	}

	/**
	 * @see LoanService#calculateTotalPayment(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateTotalPayment")
	public double calculateTotalPayment(@Validated @RequestBody ILoan loan) {
		return loanService.calculateTotalPayment(loan);
	}

	/**
	 * @see LoanService#calculateTotalTaxes(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateTotalTaxes")
	public double calculateTotalTaxes(@Validated @RequestBody ILoan loan) {
		return loanService.calculateTotalTaxes(loan);
	}

	/**
	 * @see LoanService#calculateTotalInterests(ILoan)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/calculateTotalInterests")
	public double calculateTotalInterests(@Validated @RequestBody ILoan loan) {
		return loanService.calculateTotalInterests(loan);
	}

}