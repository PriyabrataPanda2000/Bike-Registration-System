import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		RegistrationManagement rms = new RegistrationManagement();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String filename = sc.nextLine();
		try {
			File f = new File(filename);
			Scanner dataReader = new Scanner(f);
			int count = 0;
			while (dataReader.hasNextLine()) {
				String fileData = dataReader.nextLine();
				String[] stringsplitter = fileData.split(",");

				int billNumber = Integer.parseInt(stringsplitter[0]);
				String RegNo = stringsplitter[1];
				String consumerName = stringsplitter[2];
				long mob = Long.parseLong(stringsplitter[3]);

				try {

					rms.validateRegistrationNumber(RegNo);
					Bill b = new Bill();
					b.setBillNumber(billNumber);
					b.setConsumerName(consumerName);
					b.setMobileNumber(mob);
					b.setRegistrationNumber(RegNo);
					count++;
					rms.addBillDetails(b);

				} catch (InvalidRegistrationNumberException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Number of valid records is " + count);
			dataReader.close();

			System.out.println("Enter the Resgistration Number");
			String reg_no = sc.next();
			sc.nextLine();
			Bill b_obj = rms.viewBillByRegistrationNumber(reg_no);
			if (b_obj == null)
				System.out.println("No records found");
			else {
				System.out.println("Bill Number " + b_obj.getBillNumber());
				System.out.println("Customer Name " + b_obj.getConsumerName());
				System.out.println("Phone Number " + b_obj.getMobileNumber());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
