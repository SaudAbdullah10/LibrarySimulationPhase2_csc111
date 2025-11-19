package phase2;
public class Member {  
	// Project Phase 2
	//student: Saud abdullah alboiez
	//student id: 446104283
	//github link : https://github.com/SaudAbdullah10/LibrarySimulationPhase2_csc111
   
	private int id;  
   
    private String name;  
  
    private int activeBorrows;      //  books currently borrowed
  
    private int numViewBorrowed;    //   view borrowed count used
  
    private int numBorrows;         //  borrow operations 
   
    private int numReturns;         //  return operations 
  
    private double sessionFees;     //  fees incurred 
  
    
   
    public static double TotalRevenue = 0.0;  
    
    public static int TotalViewBorrowed = 0;  
    
    public static int TotalBorrows = 0;  
   
    public static int TotalReturns = 0;  
  
    //  constructing   
    public Member(int id, String name, int activeBorrows) {  
        this.id = id;  
        this.name = name;  
        this.activeBorrows = activeBorrows;  
      
    }  
  
   
    private boolean canBorrow() {  
        return activeBorrows < 5;   // checking if he can borrow or not 
    }  
  
    private boolean canReturn() {  
        return activeBorrows > 0; //checking for return he can or not  
    }  
  
    // showing the user the current borrowed count
    public void viewactiveBorrows() {  
        numViewBorrowed++;  
        TotalViewBorrowed++;  
        System.out.println("Books currently borrowed: " + activeBorrows);  
    }  
  
    // borrowing one book if he can is true if not is false
    public boolean borrowOne() {  
        if (!canBorrow()) {  
            System.out.println("You’ve reached the maximum borrowing limit(5 books).");  
            return false;  
        }  
        activeBorrows++;  
        numBorrows++;  
        TotalBorrows++;  
        sessionFees += 0.50;  
        TotalRevenue += 0.50;  
        System.out.printf("Borrowing completed. Fee: %.2f\n", 0.50);  
        return true;  
    }  
  
    //  return one book if he can is true if not is false
    public boolean returnOne() {  
        if (!canReturn()) {  
            System.out.println("You dont have any borrowed books to return.");  
            return false;  
        }  
        activeBorrows--;  
        numReturns++;  
        TotalReturns++;  
        System.out.println("Return completed Thank you!.");  
        return true;  
    }  
  
    // displaying session summary 
    public void displayStatistics() {  
        System.out.println(">>>>>>>>>>>>>Session Summary for " + name + " (ID: " + id + ")<<<<<<<<<<<<<");  
        System.out.println("Books Borrowed (this session): " + numBorrows);  
        System.out.println("Books Returned (this session): " + numReturns);  
        System.out.println("Times View Borrowed Count used (this session): " + numViewBorrowed);  
        System.out.printf("Fees Incurred (this session): %.2f\n", sessionFees);  
    }  
  
   
    public void reset() {  
        this.numViewBorrowed = 0;  
        this.numBorrows = 0;  
        this.numReturns = 0;  
        this.sessionFees = 0.0;  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public int getBorrowedCount() {  
        return activeBorrows;  
    }  
  
    public double getSessionFees() {  
        return sessionFees;  
    }  
}  