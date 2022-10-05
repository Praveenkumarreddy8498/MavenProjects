package com.quiz.main;

import java.util.Scanner;

import com.quiz.model.Result;
import com.quiz.model.Role;
import com.quiz.model.Topic;
import com.quiz.model.User;
import com.quiz.service.IResultService;
import com.quiz.service.IUserService;
import com.quiz.service.ResultServiceImpl;
import com.quiz.service.UserServiceImpl;

/**
 * @author PraveenKumarReddy
 *
 */
public class UserMain {

	/**
	 * This is main method for the User
	 * 
	 * @param args for passing arguments
	 */
	public static void main(String[] args) {
		IResultService resultService = new ResultServiceImpl();
		IUserService userService = new UserServiceImpl();
		boolean select = true;
		String role = "User";
		Scanner sc = new Scanner(System.in);
		System.out.println("**welcome to QuizExpo**" + "Welcome user please Login  ");
		System.out.println("Enter Your Choice\n1. To Register(First Time here)\n"
				+ "2.To Login(If Already Registered)\n" + "3.To Change Password");
		int chooseTask = sc.nextInt();
		sc.nextLine();
		switch (chooseTask) {
		case 1:
			User user = new User();
			System.out.println("Enter your Role\n" + "0.Admin\n" + "1.User");
			int roleChoice = sc.nextInt();
			sc.nextLine();
			String userRole = Role.values()[roleChoice].role;
			user.setRole(userRole);

			System.out.println("Enter UserName(should be Unique)");
			String userName = sc.nextLine();
			user.setUserName(userName);

			System.out.println("Enter your Name");
			String name = sc.nextLine();
			user.setName(name);

			System.out.println("Enter Your Mobile Number");
			Long mobileNo = sc.nextLong();
			sc.nextLine();
			user.setMobileNo(mobileNo);

			System.out.println("Enter Your Email Id");
			String emailId = sc.nextLine();
			user.setEmail(emailId);

			System.out.println("Enter your City Name");
			String city = sc.nextLine();
			user.setCity(city);
			String autoPassword = userService.register(user);
			System.out.println("you have Registered in SuccessFully");
			System.out.println("Your Auto generated password is " + autoPassword);
			System.out.println("Press 1 if You want to change the password" + "(Or) press Any key to Continue");
			int passChoice = sc.nextInt();
			sc.nextLine();
			if (passChoice == 1) {
				System.out.println("Enter New Password");
				String newPass = sc.nextLine();
				userService.changePassword(userName, newPass, role);
				userService.login(userName, newPass, role);
			}
			userService.login(userName, autoPassword, role);

			break;

		case 2:
			System.out.println("Enter UserName to Login");
			String username = sc.nextLine();
			System.out.println("enter password");
			String password = sc.nextLine();
			userService.login(username, password, role);
			System.out.println("you have Logged in SuccessFully");
			break;
		case 3:
			System.out.println();
			System.out.println("Enter UserName to Change Password");
			String nameOfUser = sc.nextLine();
			System.out.println("Enter New Password");
			String newPassword = sc.nextLine();
			userService.changePassword(nameOfUser, newPassword, role);
			System.out.println("logging in with New Password");
			userService.login(nameOfUser, newPassword, role);
			break;

		}
		while (select) {
			System.out.println();
			System.out.println("To Begin The Quiz press 1");
			int optChoice = sc.nextInt();
			sc.nextLine();
			if (optChoice == 1) {
				Result result = new Result();
				System.out.println("To begin Quiz");
				System.out.println("Enter Topic\n" + "0.JAVA\n" + "1.HTML\n" + "2.General Knowledge\n");
				int choose = sc.nextInt();
				sc.nextLine();
				String topic = Topic.values()[choose].topic;
				result = resultService.beginQuiz(topic);

				System.out.println("Your results!");
				System.out.println("Total Questions " + result.getTotalQuestions());
				System.out.println("Number of correct answers " + result.getCorrectAnswers());
				System.out.println("Number of wrong answers " + result.getWrongAnswers());
				System.out.println("Percentage "
						+ resultService.getPercentage(result.getCorrectAnswers(), result.getTotalQuestions()));
				System.out.println("Your performance " + resultService.getPerformance(
						resultService.getPercentage(result.getCorrectAnswers(), result.getTotalQuestions())));

			}
			System.out.println("\nEnter your choice\n" + "1.To Continue\n" + "2.To Exit\n");
			int choose = sc.nextInt();
			sc.nextLine();
			if (choose == 2)
				select = false;

		}
		sc.close();

	}

}
