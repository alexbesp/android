import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexander.bespalov on 21.07.2015.
 */
public class Parser {
    static int NUMBER_OF_RESULTS = 0;
    static ArrayList<Exception> exceptions = new ArrayList<>();

    public static void printStringList(List<String> list) {
        for (String line : list) {
            System.out.println(line);
        }
    }

    public static void parse(ArrayList<ArrayList> sitesWithPagesList, String firstPattern) throws IOException {
        Document doc1;
        ArrayList<String> matches = null;

        for (ArrayList<String> site : sitesWithPagesList) {
            for (String page : site) {
//                System.out.println(page);
                try {
                    doc1 = Jsoup.connect(page).timeout(10000).get();
//                } catch (HttpStatusException | SocketTimeoutException | UnsupportedMimeTypeException | UnknownHostException e){
                } catch (Exception e){
                    exceptions.add(e);
                    continue;
                }

                System.out.println("SITE: " + page );
                String bodyText1 = doc1.select("body").text();
//                System.out.println();
//                System.out.println(bodyText1);
//                System.out.println();
                matches = findMatches(bodyText1, firstPattern);
                ExcelEditor.writeRow("C:/MyJava/testExcelData.xlsx", 1, 6, 2, matches);
            }
        }
    }

    public static ArrayList<String> findMatches(String text, String mask) {
        Pattern pattern = Pattern.compile(mask,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> matches = null;
//        System.out.println(text);
        while (matcher.find()) {
            NUMBER_OF_RESULTS++;
            String match = matcher.group();
            matches.add(match);
            String result = "result: " + matcher.group();

            System.out.println(result);
        }
        return matches;
    }

    public static ArrayList<ArrayList> makeSitesWithPagesList(ArrayList<String> siteList, ArrayList<String> pageList) {
        ArrayList<ArrayList> sitesWithPagesList = new ArrayList<ArrayList>();
        for (String site : siteList) {
            ArrayList<String> siteWithPage = new ArrayList<String>();
            siteWithPage.add(site);
            for (String page : pageList) {
                siteWithPage.add(site + page);
            }
            sitesWithPagesList.add(siteWithPage);
        }
        return sitesWithPagesList;
    }
}
