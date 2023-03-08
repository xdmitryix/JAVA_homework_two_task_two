import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.text.html.StyleSheet;

// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.


public class proj {

    public static void main(String[] args) {
        String student = "Студент";
        String estimation = "получил";
        String subject = "предмет";
        readFile();
        
    }


    public static void readFile(){
        String buffer;
        File file = new File("dataList.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                buffer = line;
                System.out.println(buffer);
                String[] parStr = parser(buffer);
                System.out.println(Arrays.toString(parStr));
                String secName = parStr[0];
                System.out.println(secName);
                String ocenka = parStr[1];
                System.out.println(ocenka); 
                String sub = parStr[2];
                System.out.println(sub);
                String[] parseSecName = parserTwo(secName);
                System.out.println(Arrays.toString(parseSecName));
                String[] parseOcenka = parserTwo(ocenka);
                System.out.println(Arrays.toString(parseOcenka));
                String[] parseSub = parserTwo(sub);
                System.out.println(Arrays.toString(parseSub));
                String onlySecName = parseSecName[1];
                System.out.println(onlySecName);
                String onlyOcenka = parseOcenka[1];
                System.out.println(onlyOcenka); 
                String onlySub = parseSub[1];
                System.out.println(onlySub);
                String finaleSecname = onlySecName.substring(1, onlySecName.length()-1);
                System.out.println(finaleSecname);
                String finaleOcenka = onlyOcenka.substring(1, onlyOcenka.length()-1);
                System.out.println(finaleOcenka);
                String finaleSub = onlySub.substring(1, onlySub.length()-1);
                System.out.println(finaleSub);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] parser(String oneLine){
        String[] words = oneLine.split(",");
        System.out.println(Arrays.toString(words)); 
        return words;
    }

    public static String[] parserTwo(String oneLine){
        String[] wordsTwo = oneLine.split(":"); 
        return wordsTwo;
    }

    
    
}