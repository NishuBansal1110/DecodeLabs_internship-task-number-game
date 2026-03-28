import java.util.*;
public class DecodeLabs_Java_P2 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Student Grade Calculator");
    int subjects=0;
    while(true){
      try{
        System.out.print("Enter number of Subjects: ");
        subjects=sc.nextInt();
        if(subjects <=0){
          System.out.println("Subjects must be greater than 0! ");
          continue;
        }
        break;
      }catch(Exception e){
        System.out.println("Invalid input! Enter a number.");
        sc.nextLine();
      }
    }
    int totalMarks=0;
    for(int i=1;i<=subjects;i++){
      int marks=-1;
      while(true){
        try{
          System.out.print("Enter marks for subject" + i + "(0-100): ");
          marks=sc.nextInt();
          if(marks<0 || marks>100){
            System.out.println("Marks must be between 0 and 100!");
            continue;
          }
          break;
        }catch(Exception e){
          System.out.println("Invalid input! Enter a number.");
          sc.nextLine();
        }
      }
      totalMarks+=marks;
    }
    double percentage=(double)totalMarks/subjects;
    char grade;
    if(percentage>=90){
      grade='A';
    }else if(percentage>=80){
      grade='B';
    }else if(percentage>=70){
      grade='C';
  }else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\n📊 RESULT:");
        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Percentage = " + percentage + "%");
        System.out.println("Grade = " + grade);

        if (grade == 'F') {
            System.out.println("Status = FAIL ❌");
        } else {
            System.out.println("Status = PASS ✅");
        }

        sc.close();

  
}
}
