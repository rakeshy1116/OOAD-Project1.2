import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Execute {

    public String ReadMethod() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString="";
        try {
            inputString = br.readLine();
        }
        catch (IOException e) {
            System.out.println("No Input");
        }
        System.out.println(inputString);
        return inputString;
    }

    public String Clean(String inputString) {
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
        System.out.println(outputString);
        return outputString;
    }

    public String sortString(String inputString) {
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
        System.out.println(outputString);
        return outputString;
    }

    public String palindrome(String inputString) {
        StringBuilder sb = new StringBuilder();
        for(int i=inputString.length()-1;i>0;i--)
        {
            sb.append(inputString.charAt(i));
        }
        sb.append(inputString);
        String outputString=sb.toString();
        System.out.println(outputString);
        return outputString;
    }

    public void Print(String inputString) {
        System.out.println(inputString);
    }
}


public class Processor {

    public static void main(String[] args) {

        Execute obj=new Execute();
       String input= obj.ReadMethod();
       String cleanedString = obj.Clean(input);
       String sortedString = obj.sortString(cleanedString);
       String palindromeString = obj.palindrome(sortedString);
       obj.Print(palindromeString);



    }
}
