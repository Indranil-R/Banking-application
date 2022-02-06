import java.sql.SQLException;
import java.util.Scanner;

import com.dao.AccountDAO;
import com.entity.Account;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		AccountDAO accountDAO = new AccountDAO();

		System.out.println("*****Welcome To Thunder Bank E-portal*****");
		do {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			System.out.println("3. Exit Portal");
			System.out.println("Please enter your choice");
			switch (sc.nextInt()) {

			case 1:
				System.out.println("Enter account number");
				Account account = accountDAO.getAccount(sc.nextLong());

				if (account == null) {
					System.out.println("Account not found");
					System.out.println("please check the number you entered or create a new account\n");
					break;
				}
				System.out.println("Enter your password");
				sc.nextLine();
				String password = sc.nextLine();
				if (!account.getPassword().trim().equals(password)) {
					System.out.println("Password doesn't match");
					System.out.println("please check your password");
					System.out.println("Logon Denied\n");
					break;
				}
				System.out.println("Logged in successfully\n");
				do {
					System.out.println("Select from the following option");
					System.out.println("1.Withdraw Cash");
					System.out.println("2.Deposit Cash");
					System.out.println("3.View Account balance");
					System.out.println("4.View Account details");
					System.out.println("5.Logout and close the application");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter amount to withdraw");
						float withdrawAmount = sc.nextFloat();
						if (account.getAmount() < withdrawAmount) {
							System.out.println("Entered Amount is greater than current balance");
							System.out.println("Withdrawal denied\n");
							break;
						}
						if (accountDAO.deductAmount(account.getAccount_number(),
								account.getAmount() - withdrawAmount) != 1) {
							System.out.println("An unknown exception occured\n");
							break;
						}

						System.out.println("Amount withdrawn Successfully\n");
						break;

					case 2:
						System.out.println("Enter amount to add");
						int acc = accountDAO.updateAmount(account.getAccount_number(),
								account.getAmount() + sc.nextFloat());
						if (acc != 1) {
							System.out.println("An unknown exception occured\n");
							break;
						}
						System.out.println("Amount successfully added\n");
						break;
					case 3:
						System.out.println(
								"Your current account balance is " + String.format("%.2f", account.getAmount()) + "\n");
						break;
					case 4:
						System.out.println("Account number : " + account.getAccount_number());
						System.out.println("Name : " + account.getName());
						System.out.println("Email Id : " + account.getEmail_id());
						System.out.println("Mobile number : " + account.getMobile_number());
						System.out.println("Address : " + account.getAddress() + "\n");
						break;
					case 5:
						System.out.println("Logged out successfully");
						System.out.println("Thanks for choosing us");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice");
						System.out.println("Please Enter correct choice\n");
						break;
					}

				} while (true);

			case 2:
				System.out.println("We are initiating the Account creation process");
				System.out.println("Please enter the following details\n");
				System.out.println("Enter your name");
				sc.next();
				String name = sc.nextLine();
				System.out.println("choose your Password");
				String password1 = sc.nextLine();
				System.out.println("Confirm Password");
				if (!password1.equals(sc.nextLine())) {
					System.out.println("Passwords don't match make sure passwords match\n");
					break;
				}
				System.out.println("Enter Email id");
				String email = sc.nextLine();
				System.out.println("Enter Mobile number");
				Long mobile_number = sc.nextLong();
				System.out.println("Enter the opening balance");
				float amount = sc.nextFloat();
				System.out.println("Enter your address");
				sc.next();
				String Address = sc.nextLine();
				Long accountNo = (long) (Math.random() * (999999999999l - 100000000000l + 1) + 100000000000l);
				if (accountDAO.createAccount(
						new Account(accountNo, name, password1, email, mobile_number, amount, Address)) == 0) {
					System.out.println("unknown exception occured\n");
					break;
				}
				System.out.println("Account created successfully");
				System.out.println("Kindly note your login credentials ");
				System.out.println("Name : " + name);
				System.out.println("Account no : " + accountNo);
				System.out.println("Password : " + password1 + "\n");

				break;
			case 3:
				System.out.println("Thanks for choosing Thunder Bank");
				System.out.println("We are happy to serve you");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Inavalid choice");
				System.out.println("Please Enter correct choice\n");
				break;
			}

		} while (true);

	}
}
