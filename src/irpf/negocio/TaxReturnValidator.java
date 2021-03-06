package irpf.negocio;

// Classe de validação para entrada de dados
public class TaxReturnValidator {
	private String name;
	private String cpf;
	private double total_income;
	private double social_security_contribution;
	private int age;
	private int total_dependents;

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public double getTotalIncome() {
		return total_income;
	}

	public double getSocialSecurityContribution() {
		return social_security_contribution;
	}

	public int getAge() {
		return age;
	}

	public int getTotalDependents() {
		return total_dependents;
	}

	public boolean isValidName(String name) {
		boolean is_valid = false;
		if (name.length() > 0) {
			is_valid = true;
			this.name = name;
		}
		return is_valid;
	}

	public boolean isValidCpf(String cpf) {
		boolean is_valid;
		try {
			Double.parseDouble(cpf);
			is_valid = true;
			this.cpf = cpf;
		} catch(Exception e) {
			is_valid = false;
		}
		return is_valid;
	}

	public boolean isValidTotalIncome(String total_income) {
		boolean is_valid;
		try {
			double t = Double.parseDouble(total_income);
			if (t < 0) {
				is_valid = false;
			} else {
				is_valid = true;
				this.total_income = t;
			}
		} catch(Exception e) {
			is_valid = false;
		}
		return is_valid;
	}

	public boolean isValidTotalSocialSecurityContribution(String social_security_contribution) {
		boolean is_valid;
		try {
			double s = Double.parseDouble(social_security_contribution);
			if (s < 0) {
				is_valid = false;
			} else {
				is_valid = true;
				this.social_security_contribution = s;
			}
		} catch(Exception e) {
			is_valid = false;
		}
		return is_valid;
	}

	public boolean isValidAge(String age) {
		boolean is_valid;
		try {
			double a = Integer.parseInt(age);
			if (a < 0) {
				is_valid = false;
			} else {
				is_valid = true;
				this.social_security_contribution = a;
			}
		} catch(Exception e) {
			is_valid = false;
		}
		return is_valid;
	}

	public boolean isValidTotalDependents(String total_dependents) {
		boolean is_valid;
		try {
			int t = Integer.parseInt(total_dependents);
			if (t < 0) {
				is_valid = false;
			} else {
				is_valid = true;
				this.total_dependents = t;
			}
		} catch(Exception e) {
			is_valid = false;
		}
		return is_valid;
	}

	public boolean isValidSimplifiedTaxReturn(String name, String cpf, String total_income, String social_security_contribution) {
		if (
			this.isValidName(name) &&
			this.isValidCpf(cpf) &&
			this.isValidTotalIncome(total_income) &&
			this.isValidTotalSocialSecurityContribution(social_security_contribution)
		) {
			return true;
		}
		return false;
	}

	public boolean isValidCompleteTaxReturn(String name, String cpf, String total_income, String social_security_contribution, String age, String total_dependents) {
		if (
			this.isValidSimplifiedTaxReturn(name, cpf, total_income, social_security_contribution) &&
			this.isValidAge(age) &&
			this.isValidTotalDependents(total_dependents)
		) {
			return true;
		}
		return false;
	}
}