import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException {
        // разобраться с "в" (с|в) или [св]
        // жрет строки с "с" но без года
        //удалить дубли по одному сайту

        //-Djsse.enableSNIExtension=false
        System.setProperty("jsse.enableSNIExtension", "false");

        String firstPattern = ".{0,45}(((1996|" +
                "САЙТ НА РЕКОНСТРУКЦИИ|Сайт находится в разработке|This Domain Is For Sale|Domain contact information|"+
                "Congratulations|Раньше это был Ваш сайт|If you are the owner of this website|этот домен возможно продается|Срок регистрации домена|"+
                "являемся|функционирует|учреждено|учреждена|учрежден|успешно|уже|трудится|"+
                "существующий|существующая|существует|становление|стала|специализируется|создано|созданным|созданный|созданная|"+
                "создания|создание|создана|создан|с начала|с 1990|"+
                "рынке|регистрации|развивается|работающими|работающая|работает|"+
                "работаем|работавшей|прошло|приступили|приступила|принято|представляет|"+
                "представляем|представлена|празднует|появилась|почти|поставки|партнер|отпраздновал|отмечает|отметило|"+
                "отметили|отметила|открыто|открыта|открылись|осуществляющая|осуществляет|основывают|основывает|основано|основанный"+
                "|основанное|основанная|основания|основание|основана|основан|осенью|организована|опыт|образовано|образованное|"+
                "образованного|образованная|образования|образование|образована|образован|нашей|начиная|началось|начало|начала|"+
                "начал|начав|началась|накануне|протяжении|момента|многолетний|летом|лет|которая с|компания|история|исполнилось|"+
                "имеет|известны|известно|известна|зимой|заявил о себе|зарегистрировано|зарегистрирована|занимается|деятельность|"+
                "день рождения|датой создания|выпускается с|весной|ведётся|ведется|ведёт|ведет|далеком|были|более).{0,80})|(с\\s))" + // 35 симв + ((основана + 80 симв) или ("с "))
            "(" +
                "(" + //start of 1st case
                    "(" +
                        "(19[6-9][0-9])|" +       //1960-1999
                        "(20[0-1][0-5])" +       //2000-2015
                    ")" +
                    ".{0,10}(лет|году|года|год|г)" +
                ")|" + // end of 1st case
                "(" + //start of 2nd case
                    "(" +
                        "([1-3][0-9])|" +        // 10-39
                        "[2-9]" +                 //2-9
                    ")" +
                    ".{0,10}(лет|год)" +
                ")" + // end of 2nd case
            ")(\\.||\\,||.{0,30})";
        String url = "http://www.sovnet.ru/about/history/";
        String sourseFile = "C:\\Users\\Lenovo\\Desktop\\testExcelData.xlsx";
        Document doc1 = null;
        String title = null;
        ExcelEditor excelEditor = new ExcelEditor();

        ArrayList<String> domainExpiredList = excelEditor.extractColumn(sourseFile, 1, 1, 2);
        ArrayList<String> siteList = excelEditor.extractColumn(sourseFile, 1, 4, 2);
        ArrayList<String> pageList = excelEditor.extractColumn(sourseFile, 1, 2, 2);
        ArrayList<ArrayList> sitesWithPagesList = Parser.makeSitesWithPagesList(siteList, pageList);

        Parser.printStringList(siteList);
        Parser.printStringList(pageList);

        Parser parser = new Parser();
        ArrayList<ArrayList> results = parser.parse(sitesWithPagesList, firstPattern);

        excelEditor.writeTable(sourseFile, 1, 6, 2, results);

        System.out.println();
        System.out.println("Обработано " + siteList.size() + " сайтов");
        System.out.println("Найдено " + parser.numberOfResults + " результатов с " + (siteList.size() * pageList.size() + siteList.size()) + " страниц ");
        System.out.println("Произошли следующие ошибки: ");
        for (Exception e : parser.exceptions) {
            System.out.println(e);
        }
    }
}
