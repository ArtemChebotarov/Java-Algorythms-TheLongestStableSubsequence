import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
//    private static int length;

    private static int pos;
    private static int num;
    private static int E[];
    private static int len;
    private static int maxDiff = 1;

    private static int mlen = 0;

    private static int min_val = 0;
    private static int max_val = 0;


    //    private static List<Integer> ciag = new ArrayList<>();
//    private static List<Integer> tmp = new ArrayList<>();
//    private static int tmp[];
//    private static List out = new ArrayList<>();
//    private static int p = 0;
//    private static int k = 0;
//    private static int i = 0;


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("D:\\Documents\\pjatk\\3sem\\asd\\PodciagStabilny\\Test1.txt"), StandardCharsets.UTF_8))){
            String line;
            int line_index = 1;
            int elem_index = 0;

            while ((line = reader.readLine()) != null) {

                if(line_index == 1) {
                    len = Integer.parseInt(line);
                    E = new int[len];
                }

                if(line_index == 2) {
                    maxDiff = Integer.parseInt(line);
                }

                if(line_index > 3) {
                    E[elem_index] = Integer.parseInt(line);
                    elem_index++;
                }

                line_index++;
            }
        } catch (IOException e) {
            // log error
        }

        for (int i = 0; i < len; i++) {
            min_val = E[i];
            max_val = E[i];

            if (i < len) {
                num = 1;
                while (i + num < len) {
                    if (E[i+num] >= max_val) {
                        max_val = E[i + num];
                    }
                    if (E[i + num] < min_val) {
                        min_val = E[i + num];
                    }
                    if ((max_val - min_val) > maxDiff) {
                        break;
                    }
                    else {
                        num++;
                    }
                }

                if (num > mlen) {
                    mlen = num;
                    pos = i;
                }
            }
        }

        try(FileWriter writer = new FileWriter("D:\\Documents\\pjatk\\3sem\\asd\\PodciagStabilny\\Test1_wynik.txt", false))
        {
            writer.append(pos + " " + (pos + mlen-1) + "\r\n");
            writer.append("\r\n");
            for (int i = pos; i < pos + mlen; i++) {

                writer.append(E[i] + "\r\n");
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



        /*  ALGORYTM ver 1.0 ~O(n^5) */

//	    for(int i = 0; i < E.length; i++) {
//            ciag.add(E[i]);
//        }
//
//
//	    for(int i = 0; i < ciag.size(); i++) {
//	        for(int n = i; n < ciag.size(); n++) {
//	            tmp.add(ciag.get(n));
//            }
//
//	        for(int j = 0; j < tmp.size(); j++) {
//	            for(int w = 0; w < tmp.size(); w++) {
//	                if(!((tmp.get(j) - tmp.get(w)) <= maxDiff)) {
//                        if(j < w) {
//                            for(int x = w; x < tmp.size(); x++) {
//                                tmp.remove(x);
//                                x--;
//                            }
//                            break;
//                        }
//                        else if (j > w) {
//                            for(int x = j; x < tmp.size(); x++) {
//                                tmp.remove(x);
//                                x--;
//                            }
//                            break;
//
//                        }
//                    }
//                }
//            }
//
//            if(out.size() < tmp.size()) {
//                p = i;
//                k = p + tmp.size() - 1;
//                out.clear();
//                out.addAll(tmp);
//            }
//
//            tmp.clear();
//
//        }
//        System.out.println(p + " " + k);
//        System.out.println(out);

    }

}

