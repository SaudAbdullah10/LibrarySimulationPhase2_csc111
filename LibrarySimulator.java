package phase2;
import java.util.Scanner;  
// Project Phase 2
//Student: Saud abdullah alboiez
//ID: 446104283
//github link : https://github.com/SaudAbdullah10/LibrarySimulationPhase2_csc111
public class LibrarySimulator {  
    
	public static void main(String[] args) {  
 
		Scanner read = new Scanner(System.in);  
   
		Member user1 = new Member(1, "User One", 0);  
  
		Member user2 = new Member(2, "User Two", 0);  
   
		Member user3 = new Member(3, "User Three", 0);  
  
        boolean running = true;  
  //same way of my first project but more elevated 
        while (running) {  
            System.out.println(">>>>>>>>>>>>>>>Welcome to the Library Simulation<<<<<<<<<<<<<<<");  
            System.out.println("Select an option:");  
            System.out.println("1. Login as " + user1.getName() + " (ID: " + user1.getId() + ")");  
            System.out.println("2. Login as " + user2.getName() + " (ID: " + user2.getId() + ")");  
            System.out.println("3. Login as " + user3.getName() + " (ID: " + user3.getId() + ")");  
            System.out.println("4. Login as Administrator");  
            System.out.println("5. Exit Program");  
            System.out.print("Enter your choice: ");  
  
            int choice = read.nextInt();  
            read.nextLine(); // reading from user 
  
            if (choice >= 1 && choice <= 3) {  
                Member current;  
                if (choice == 1)   
                    current = user1;  
                else if (choice == 2)   
                    current = user2;  
                else   
                    current = user3;  
  
                 
  
                boolean sessionActive = true;  
                while (sessionActive) {  
                    System.out.println(">>>>>Welcome to the library system <<<<, " + current.getName() + "!");  
                    System.out.println("1. View Borrowed Books Count");  
                    System.out.println("2. Borrow Book");  
                    System.out.println("3. Return Book");  
                    System.out.println("4. View Session Summary");  
                    System.out.println("5. Exit to Main Menu");  
                    System.out.print("Choose an option: ");  
  
                    int userOption = read.nextInt();  
                    read.nextLine();  
  
                    switch (userOption) {  
                        case 1:  
                            current.viewactiveBorrows();  
                            break;  
                        case 2:  
                            current.borrowOne();  
                            break;  
                        case 3:  
                            current.returnOne();  
                            break;  
                        case 4:  
                            current.displayStatistics();  
                            break;  
                        case 5:  
                            System.out.println("session ended. the total books currently borrowed is: " + current.getBorrowedCount());  
                            sessionActive = false;  
                            break;  
                        default:  
                            System.out.println("Incorrect selection. Please choose a valid option.");  
                            break;  
                    }  
                }  
  
            } else if (choice == 4) {  
                System.out.print("Enter admin password: ");  
                String password = read.nextLine();  
  
                if (!password.equals("admin123")) {  
                    System.out.println("Incorrect password. Access denied.");  
                } else {  
                    boolean adminActive = true;  
                    while (adminActive) {  
                        System.out.println(">>>>>>>  Welcome Admin !<<<<<<");  
                        System.out.println("1. View Total Revenue");  
                        System.out.println("2. Most Frequent Operation");  
                        System.out.println("3. Exit to Main Menu");  
                        System.out.print("Choose an option: ");  
  
                        int adminChoice = read.nextInt();  
                        read.nextLine();  
  
                        switch (adminChoice) {  
                            case 1:  
                                System.out.printf("Total Revenue from all borrow operations: %.2f\n", Member.TotalRevenue);  
                                break;  
                            case 2:  
                                System.out.println("Most Frequent Operation:");  
                                if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {  
                                    System.out.println("- No operations performed yet.");  
                                } else if (Member.TotalBorrows > Member.TotalReturns) {  
                                    System.out.println("- Borrow");  
                                } else if (Member.TotalReturns > Member.TotalBorrows) {  
                                    System.out.println("- Return");  
                                } else {  
                                    System.out.println("- Borrow and Return (Tie)");  
                                }  
                                break;  
                            case 3:  
                                adminActive = false;  
                                break;  
                            default:  
                                System.out.println("Incorrect selection. Please choose a valid option.");  
                                break;  
                        }  
                    }  
                }  
  
            } else if (choice == 5) {  
                System.out.println("Thank you for using the Library Simulation. Goodbye!");  
                running = false;  
            } else {  
                System.out.println("Incorrect selection. Please choose a valid option.");  
            }  
        }  
  
        read.close();  
    }  
}  