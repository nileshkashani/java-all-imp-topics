

//Exception Handling help fetch errors in runtime and work on
//them using catch block so that program doesn't crash.


//How does it works?

//Try block contain the code which may cause error.
//Catch block contain the code which will execute if error occurs in try block.
//Finally block contain the code which will execute always.


// Syntax:
// try {
//   //  Block of code to try
// }
// catch(Exception e) {
//   //  Block of code to handle errors
// }



public class TryCatch {
      public static void main(String[] args){
        
        int n=10;
        try {
            System.out.println(n/0);                                       
        }catch(Exception e){
            System.out.println("Error: "+ e);
        }
    }
}

//output

//Error: / by zero