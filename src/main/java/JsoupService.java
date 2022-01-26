import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupService {
    public static String getNumberOfOffers(String connectUrl) throws IOException {
        Document doc = Jsoup.connect(connectUrl).get();
        return doc.getElementsByClass("results-header__offer-count-text-number").text();
    }

    public static void showOffers(String connectUrl, String language) throws IOException {
        Document doc = Jsoup.connect(connectUrl).get();
        Elements offers = doc.getElementsByClass("offer-details__title-link");

        offers.forEach(offer -> {
            System.out.println("--------------------");
            System.out.println(offer.text());
            System.out.println(offer.attr("href"));
        });

        System.out.println();
        System.out.printf("--Powyżej znajdziesz 10 najnowszych ofert pracy dla %s developera--%n", language);
    }

    public static void showOffers(String connectUrl) throws IOException {
        Document doc = Jsoup.connect(connectUrl).get();
        Elements offers = doc.getElementsByClass("offer-details__title-link");

        offers.forEach(offer -> {
            System.out.println("--------------------");
            System.out.println(offer.text());
            System.out.println(offer.attr("href"));
        });

        System.out.println();
        System.out.println("--Powyżej znajdziesz 10 najnowszych ofert pracy dla java developera--");
    }
}
