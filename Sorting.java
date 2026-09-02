import java.util.*;

class sortValue<T>{
    T val;

    sortValue(T val){
        this.val = val;
    }
    public T getValue(){return this.val;}
}



public class Sorting{
    public static void main(String[] args){
        //Instance
        Scanner scan = new Scanner(System.in);

        System.out.println(" Choose a data type");
        System.out.println(" 1. String ");
        System.out.println(" 2. Integer ");
        System.out.print(" Enter choice: ");
        int dataChoice = scan.nextInt();
        
        System.out.print(" How many values do you want to enter: ");
        int valLength = scan.nextInt();

        if(dataChoice == 1){
            System.out.println("Enter the values");
            for(int i=0; i< valLength ; i++){
                System.out.print("Array [" + i + "]" + ": ");
                int intVal = scan.nextInt();
            } 
        }
        
        else if(dataChoice == 2) {
            System.out.print("Enter the strings");
            for (int i = 0; i < valLength ; i++) {
                System.out.print("Array [" + i + "]" + ": ");
                String strVal = scan.nextLine();
            }
        }

        System.out.println("Choose a sorting algorithm");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Enter choice: ");
        int algoChoice = scan.nextInt();

        System.out.println("Choose either Ascending or Descending");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int ascChoice = scan.nextInt();

    }

}
