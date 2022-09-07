import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Processor {

    public void process() {
       ReadMethod();
    }
    private String ReadMethod() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //used flag variable to check for input. in case of input type other than string, flag is set to false
        //and program terminates
        // in case of empty input, End of input is printed to console and program exits
        String inputString="";
        boolean flag=true;
        while(flag) {
            try {
                inputString = br.readLine();
                if(inputString.equals(""))
                {
                    System.out.println("End of Input");
                    return inputString;
                }
                String cleanedString = Clean(inputString);
                String sortedString = sortString(cleanedString);
                String palindromeString = palindrome(sortedString);
                Print(palindromeString);
            }
            catch (IOException e) {
                flag=false;
           }
        }
        System.out.println("Read: " + inputString);
        return inputString;
    }

    private String Clean(String inputString) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<inputString.length();i++)
        {
            int temp=(int)inputString.charAt(i);
            if((temp>=97 && temp<=122))
            {
                char c=(char)(temp-32);
                sb.append(c);
            }
            if((temp>=65 && temp<=90))
            {
                char c=(char)(temp);
                sb.append(c);
            }
        }
        String outputString=sb.toString();
        System.out.println("Clean: " +outputString);
        return outputString;
    }

    private String sortString(String inputString) {
        //converted each character to their ascii values
        //added them to a list and sorted the number list
        //and converted back the ascii num to character.
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<inputString.length();i++)
        {
            list.add((int)inputString.charAt(i));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<list.size();i++)
        {
            int temp=list.get(i);
            sb.append((char)temp);
        }
        String outputString=sb.toString();
        System.out.println("Sort: " + outputString);

        return outputString;
    }

    private String palindrome(String inputString) {
        StringBuilder sb = new StringBuilder();  //used StringBuilder to build palindrome
        //by reversing the existing string and adding it to the front of existing string.
        for(int i=inputString.length()-1;i>0;i--)
        {
            sb.append(inputString.charAt(i));
        }
        sb.append(inputString);
        String outputString=sb.toString();
        System.out.println("Palindrome: " + outputString);
        return outputString;
    }

    private void Print(String inputString) {
        System.out.println("Print: " +inputString);
    }
}


public class Program2 {

    public static void main(String[] args) {
        Processor obj=new Processor();
        obj.process(); //all the required methods are present in process method.

    }
}
