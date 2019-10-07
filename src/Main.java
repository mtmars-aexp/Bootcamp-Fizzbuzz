import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) {

        boolean swapMade = false;
        String fbOutput = "init";
        int maxNumber;
        int fizzbuzzCount, buzzCount, fizzCount, bangCount, bongCount, fezzCount, reverseCount;
        fizzbuzzCount = buzzCount = fizzCount = bangCount = bongCount = fezzCount = reverseCount = 0;

        if (args.length == 0){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter number: ");
            maxNumber = scan.nextInt();
        } else {
            maxNumber = Integer.parseInt(args[0]);
        }

        for(int i=1;i<=maxNumber;i++) {

            fbOutput = "";
            swapMade = false;

            //If i is divisible by 3, append "Fizz"
            if (i % 3 == 0) {
                fbOutput += "Fizz";
                fizzCount += 1;
                swapMade = true;
            }

            //If i is divisible by 5, append "Buzz"
            if (i % 5 == 0) {
                fbOutput += "Buzz";
                buzzCount += 1;
                swapMade = true;
            }

            if (fbOutput.equals("FizzBuzz")){
                fizzbuzzCount += 1;
            }


            //If i is divisible by 7, append "Bang"
            //
            if (i % 7 == 0) {
                fbOutput += "Bang";
                bangCount += 1;
                swapMade = true;
            }

            //If i is divisible by 11, replace the output with Bong.
            if (i % 11 == 0) {
                fbOutput = "Bong";
                bongCount += 1;
                swapMade = true;
            }


            if (i % 13 == 0) {
                int index = fbOutput.indexOf("B");
                if (index == -1) {
                    if (fbOutput == "") { //checks if fbOutput starts with a character, if false, appends instead of replacing
                        fbOutput = "Fezz";
                    } else
                        fbOutput += "Fezz";

                } else {
                    String beforeFezz = fbOutput.substring(0, index);
                    String afterFezz = fbOutput.substring(index);
                    fbOutput = beforeFezz + "Fezz" + afterFezz;
                }
                fezzCount += 1;
                swapMade = true;
            }

            if (i % 17 == 0) {
                String fbOutputBackup = fbOutput;
                if (fbOutput != "") {
                    Stack<String> fbReversalStack = new Stack();

                    int fbSections = (fbOutput.length() / 4);
                    for (int j = 0; j <= fbSections - 1; j++) {
                        fbReversalStack.push(fbOutput.substring(j * 4, (j * 4) + 4));
                    }

                    fbOutput = "";

                    for (int j = 0; j <= fbSections - 1; j++) {
                        fbOutput += fbReversalStack.pop();
                    }
                    reverseCount += 1;
                    swapMade = true;
                }
            }

            if (swapMade == true) {
                System.out.println(Integer.toString(i) + " " + fbOutput); //Output the output
            } else {
                System.out.println(Integer.toString(i));
            }

        }


        System.out.println("Total fizzes: " + fizzCount);
        System.out.println("Total buzzes: " + buzzCount);
        System.out.println("Total fizzbuzzes: " + fizzbuzzCount);
        System.out.println("Total bangs (appended): " + bangCount);
        System.out.println("Total bongs: " + bongCount);
        System.out.println("Total fezzes: " + fezzCount);
        System.out.println("Total reversals: " + reverseCount);
    }
}
