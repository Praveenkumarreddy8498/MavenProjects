package com.quiz.main;

import java.util.Scanner;

import com.quiz.model.*;
import com.quiz.service.*;

public class Client {

	public static void main(String[] args) {

		IQuizService quizService = new QuizServiceImpl();
		IResultService resultService = new ResultServiceImpl();
		IUserService userService = new UserServiceImpl();
		boolean select = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Role\n" + "0.Admin\n" + "1.User");
		int chooseRole = sc.nextInt();
		sc.nextLine();
		String role = Role.values()[chooseRole].role;
		if (role == "Admin") {

			System.out.println("Welcome Admin please Login  ");

			System.out.println("Enter UserName to Login");
			String username = sc.nextLine();
			System.out.println("enter password");
			String password = sc.nextLine();
			userService.login(username, password,role);
			System.out.println("Press 1 if You want to change the password\n" + "or Any key to Continue");
			int passchoice = sc.nextInt();
			sc.nextLine();
			if (passchoice == 1) {
				System.out.println("Enter New Password");
				String newPass = sc.nextLine();
				userService.changePassword(username, newPass,role);
				userService.login(username, newPass,role);

			}
			
			while (select) {
				System.out.println("Hello welcome Admin");
				System.out.println(
						"Enter Your Choice\n" + "1.Add Question\n" + "2.Update Question\n" + "3.Delete Question\n"
								+ "4.Get Questions By Topic");
				int optChoice = sc.nextInt();
				sc.nextLine();
				if (optChoice == 1) {
					System.out.println("Enter No of Questions To add");
					int num = sc.nextInt();
					sc.nextLine();
					for (int i = 0; i < num; i++) {
						Question question = new Question();
						Answer answer = new Answer();
						System.out.println("Enter Question id");

						Integer questionId = sc.nextInt();
						sc.nextLine();
						question.setQuestionId(questionId);

						System.out.println("Enter Topic\n" + "0.JAVA\n" + "1.HTML\n" + "2.General Knowledge\n");
						int option = sc.nextInt();
						sc.nextLine();
						String topic = Topic.values()[option].topic;
						question.setTopic(topic);
						
							System.out.println("Enter Question");
							String ques = sc.nextLine();
							question.setQuestion(ques);

							System.out.println("Enter option 1");
							String optionOne = sc.nextLine();
							question.setOptionOne(optionOne);

							System.out.println("Enter option 2");
							String optionTwo = sc.nextLine();
							question.setOptionTwo(optionTwo);

							System.out.println("Enter option 3");
							String optionThree = sc.nextLine();
							question.setOptionThree(optionThree);

							System.out.println("Enter option 4");
							String optionFour = sc.nextLine();
							question.setOptionFour(optionFour);

							answer.setAnswerId(questionId);

							System.out.println("Set the Correct Answer" + "\n1." + optionOne + "\n2." + optionTwo + "\n3."
									+ optionThree + "\n4." + optionFour);
							int choice = sc.nextInt();
							sc.nextLine();

							switch (choice) {
							case 1:
								answer.setAnswerValue(optionOne);
								break;
							case 2:
								answer.setAnswerValue(optionTwo);
								break;
							case 3:
								answer.setAnswerValue(optionThree);
								break;
							case 4:
								answer.setAnswerValue(optionFour);
								break;

							default:
								break;
							}

							question.setAnswer(answer);

							quizService.addQuestion(question);
						
					}
					

					

				} else if (optChoice == 2) {
					System.out.println("Enter question Id ");
					int questionid = sc.nextInt();
					sc.nextLine();
					System.out.println("Change the below question answer");
					Question ques = quizService.getOptionsById(questionid);
					System.out.println(questionid + " " + ques.getQuestion());
					System.out.println("1." + ques.getOptionOne());
					System.out.println("2." + ques.getOptionTwo());
					System.out.println("3." + ques.getOptionThree());
					System.out.println("4." + ques.getOptionFour());

					String answerValue = "";
					int key = sc.nextInt();
					sc.nextLine();
					if (key == 1) {
						answerValue = ques.getOptionOne();

					} else if (key == 2) {
						answerValue = ques.getOptionTwo();

					} else if (key == 3) {
						answerValue = ques.getOptionThree();

					} else if (key == 4) {
						answerValue = ques.getOptionFour();

					}
					quizService.updateQuestion(questionid, answerValue);

				} else if (optChoice == 3) {
					System.out.println("Enter Question Id to delete");
					int questionId = sc.nextInt();
					sc.nextLine();
					quizService.deleteQuestion(questionId);

				}if (optChoice == 4) {
					System.out.println("Enter Topic\n" + "0.JAVA\n" + "1.HTML\n" + "2.General Knowledge\n");
					int choose = sc.nextInt();
					sc.nextLine();
					String topic = Topic.values()[choose].topic;
					quizService.getByTopic(topic).forEach(System.out::println);

				}
				System.out.println("\nEnter your choice\n" + "1.To Continue\n" + "2.To Exit\n");
				int choose = sc.nextInt();
				sc.nextLine();
				if (choose == 2)
					select = false;

			}
		} else if (role == "User") {

			System.out.println("Welcome user please Login  ");
			System.out
					.println("Enter Your Choice\n1. To Register(First Time here)\n" + "2.To Login(If Already Registered)\n"
							+ "3.To Change Password");
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
				if (passChoice == 1) {
					System.out.println("Enter New Password");
					String newPass = sc.nextLine();
					userService.changePassword(userName, newPass,role);
					userService.login(userName, newPass,role);
					System.out.println("Logged In successfully");

				}
				else {
					userService.login(userName, autoPassword,role);
				}

				break;

			case 2:
				System.out.println("Enter UserName to Login");
				String username = sc.nextLine();
				System.out.println("enter password");
				String password = sc.nextLine();
				userService.login(username, password,role);
				System.out.println("you have Logged in SuccessFully");

				break;
			case 3:
				System.out.println("Enter UserName to Change Password");
				String nameOfUser = sc.nextLine();
				System.out.println("Enter New Password");
				String newPassword = sc.nextLine();
				userService.changePassword(nameOfUser, newPassword,role);
				System.out.println("logging in with New Password");
				userService.login(nameOfUser, newPassword,role);
				System.out.println("Logged In successFully");
				break;

			}
			while (select) {
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
			

		}

		sc.close();

	}

}
