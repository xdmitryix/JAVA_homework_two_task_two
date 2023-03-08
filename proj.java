import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        String subject = "по предмету";
        String probel = " ";
        readFile(student,estimation,subject,probel);
        
    }


    public static void readFile(String stud, String estim, String sobj, String prob){
        String buffer;
        File file = new File("dataList.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                buffer = line;
                String[] parStr = parser(buffer);
                String secName = parStr[0];
                String ocenka = parStr[1];
                String sub = parStr[2];
                String[] parseSecName = parserTwo(secName);
                String[] parseOcenka = parserTwo(ocenka);
                String[] parseSub = parserTwo(sub);
                String onlySecName = parseSecName[1];
                String onlyOcenka = parseOcenka[1];
                String onlySub = parseSub[1];
                String finaleSecname = onlySecName.substring(1, onlySecName.length()-1);
                String finaleOcenka = onlyOcenka.substring(1, onlyOcenka.length()-1);
                String finaleSub = onlySub.substring(1, onlySub.length()-1);
                StringBuilder user_char = new StringBuilder();
                user_char.append(stud).append(prob).append(finaleSecname).append(prob).append(estim).append(prob).append(finaleOcenka).append(prob).append(sobj).append(prob) 
                .append(finaleSub);
                System.out.println(user_char);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] parser(String oneLine){
        String[] words = oneLine.split(",");
        return words;
    }

    public static String[] parserTwo(String oneLine){
        String[] wordsTwo = oneLine.split(":"); 
        return wordsTwo;
    }
}