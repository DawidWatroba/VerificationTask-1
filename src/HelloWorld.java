import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.lang.StringBuilder;

public class HelloWorld{

    public static void main(String []args) throws Exception {
        HashMap<Character, Character> konwerter = new HashMap<>();
        konwerter.put('A', 'T');
        konwerter.put('C', 'G');
        konwerter.put('T', 'A');
        konwerter.put('G', 'C');
        StringBuilder builder = new StringBuilder();

        // Tutaj taki input
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader((new FileReader(file)));
        StringBuilder input = new StringBuilder();
        String temp;
        while((temp = br.readLine())!=null){
            input.append(temp);
        }
        System.out.println(input.toString());
        char[] chars = input.toString().toCharArray();

        for (char ch : chars) {
            if(ch=='A'||ch=='C'||ch=='G'||ch=='T')
            builder.append(konwerter.get(ch));
            else{
                byte x = (byte) ch;
                ++x;
                char y = (char)x;
                builder.append(y);
            }
        }

        System.out.println(builder.toString());
        if(input.length()==builder.length()) System.out.println("Size OK");
        else System.out.println("Size NOT OK");
        String path = "output.txt";
        try {
            Files.writeString(Paths.get(path), builder.toString());
            System.out.println("Wynik zapisany do pliku.");
        }catch(IOException e){
            System.err.println("Nie udało się zapisać wyniku do pliku!");
        }
    }
}
