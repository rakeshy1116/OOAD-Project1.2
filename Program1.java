import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Analyzer {
    List<Double> list;

    public Analyzer(List<Double> list) {
        this.list = list;
    }

    public double Mean() {
        double mean = 0;
        for (int i = 0; i < list.size(); i++) {
            mean += list.get(i);
        }
        mean = mean / list.size();
        System.out.println("Mean= " + mean);
        return mean;
    }

    public double Variance(Double mean) {
        double variance = 0;
        for (int i = 0; i < list.size(); i++) {
            variance += (list.get(i) - mean) * (list.get(i) - mean);
        }
        variance = variance / list.size();
        System.out.println("Variance= " + variance);
        return variance;
    }

    public double StandardDeviation(Double variance) {
        double sd = 0;
        sd = Math.sqrt(variance);
        System.out.println("StandardDeviation= " + sd);
        return sd;
    }

    public double MinValue() {
        Collections.sort(list);
        System.out.println("MinValue= " + list.get(0));
        return list.get(0);
    }

    public double MaxValue() {
        Collections.sort(list);
        System.out.println("MaxValue= " + list.get(list.size() - 1));
        return list.get(list.size() - 1);

    }

    public double Median() {
        Collections.sort(list);
        int half = list.size() / 2;
        double median = 0;
        if (list.size() % 2 == 0) {
            median += (list.get(half - 1) + list.get(half)) / 2;
        } else {
            median = list.get(half);
        }
        System.out.println("Median= " + median);
        return median;

    }

    public double Mode() { //in case of multiple modes only one of them is printed.
        // (all integers with count 1 are also considered as modes
        double mode = Count();
            System.out.print("Mode= " + mode);
        return mode;
    }

    public double Count() { //if there are multiple most frequent integers with same  count only one of them is printed
        Collections.sort(list);
        double mode = list.get(0), tempMode = list.get(0);
        int count = 1, tempCount = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == tempMode) {
                tempCount += 1;
            } else {
                if (tempCount >= count) {
                    count = tempCount;
                    mode = tempMode;
                }

                tempCount = 1;
                tempMode = list.get(i);
            }

            if (tempCount >= count) {
                count = tempCount;
                mode = tempMode;
            }
        }

        return mode;

    }

    public void analyze() {
        if (list.size() >= 1) {
            double mean = Mean();
            double variance = Variance(mean);
            StandardDeviation(variance);
            MinValue();
            MaxValue();
            Median();
            Mode();

        } else {
            System.out.println("No input");
        }

    }
}

class Reader {

    public List<Double> read() throws IOException {
        boolean flag = true;
        ArrayList<Double> list = new ArrayList<>();
        while (flag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                double temp = Double.parseDouble(br.readLine());

                list.add(temp);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if (list.size() - 1 != i)
                        System.out.print(" ");
                    else
                        System.out.println(" ");
                }
            } catch (NumberFormatException e) {
                flag = false;

//                if (list.size() >= 1) {
//                    Analyzer m = new Analyzer(list);
//                    m.analyze();
//                }
            }
        }
        return list;
    }
}

public class Program1 {
    public static void main (String[] args)  throws IOException {
        Reader r = new Reader();
        List<Double> list = r.read();
        Analyzer m = new Analyzer(list);
        m.analyze();

    }

}

