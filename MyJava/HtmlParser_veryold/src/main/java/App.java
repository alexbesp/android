import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lenovo on 14.07.2015.
 */
public class App {

    public static void main(String[] args) throws IOException {
        // разобраться с "в" (с|в) или [св]
        // жрет строки с "с" но без года
        //удалить дубли по одному сайту

        //-Djsse.enableSNIExtension=false
        System.setProperty("jsse.enableSNIExtension", "false");

        String firstPattern = ".{0,45}(((исполнилось|1996|зарегистрировано|зарегистрирована|основана|основан|основанное|основанная|основание|" +
                "образована|образовано|создана|создано|осуществляет|приступила|работает|работавшей|существует|специализируется|история|более).{0,80})|(с\\s))" + // 35 симв + ((основана + 80 симв) или ("с "))
            "(" +
                "(" + //start of 1st case
                    "(" +
                        "(19[6-9][0-9])|" +       //1960-1999
                        "(20[0-1][0-5])" +       //2000-2015
                    ")" +
                    ".{0,10}(лет|год|года|году|г)" +
                ")|" + // end of 1st case
                "(" + //start of 2nd case
                    "(" +
                        "([1-3][0-9])|" +        // 10-39
                        "[2-9]" +                 //2-9
                    ")" +
                    ".{0,10}(лет|год)" +
                ")" + // end of 2nd case

            ").{0,30}";
        String url = "http://www.sovnet.ru/about/history/";
        String sourseFile = "C:/MyJava/testExcelData.xlsx";
        Document doc1 = null;
        String title = null;

        ArrayList<String> siteList = ExcelEditor.extractColumn(sourseFile, 1, 3, 2);
        ArrayList<String> pageList = ExcelEditor.extractColumn(sourseFile, 1, 1, 2);
        ArrayList<ArrayList> sitesWithPagesList = Parser.makeSitesWithPagesList(siteList, pageList);

        Parser.printStringList(siteList);
        Parser.printStringList(pageList);

        Parser.parse(sitesWithPagesList, firstPattern);

        System.out.println();
        System.out.println("Обработано " + siteList.size() + " сайтов");
        System.out.println("Найдено " + Parser.NUMBER_OF_RESULTS + " результатов с " + (siteList.size() * pageList.size() + siteList.size()) + " страниц ");

        for (Exception e : Parser.exceptions) {
            System.out.println("Возникли следующие ошибки: " + e);
        }
    }
}
