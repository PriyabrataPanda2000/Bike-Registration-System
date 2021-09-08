import java.util.*;

public class RegistrationManagement {
	private List<Bill> billList;

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public void addBillDetails(Bill billObj) {
		if (billList == null)
			billList = new ArrayList<Bill>();
		billList.add(billObj);
	}

	public Bill viewBillByRegistrationNumber(String regNo) {
		for (Bill b : billList) {
			if (b.getRegistrationNumber().equals(regNo))
				return b;
		}
		return null;
	}

	public boolean validateRegistrationNumber(String Reg) throws InvalidRegistrationNumberException {
		if (Reg.matches("KL52[A-Z]{2}[1-8]{1}[0-9]{3}"))
			return true;
		else
			throw new InvalidRegistrationNumberException("Invalid Registration Number");
	}
}
