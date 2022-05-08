package jsoup_test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

import static java.lang.System.exit;

public class parsing_knu {
    public static void main(String[] args) {
        String url = "https://knuin.knu.ac.kr/public/stddm/lectPlnInqr.knu";
        Document doc = null; // Document에는 페이지 전체 소스 저장

        try{
            doc = Jsoup.connect(url).get();
        } catch (IOException e){
            System.out.println("error");
            e.printStackTrace();
            exit(0);
        }

        //select를 통하여 원하는 태그 선택
        Elements elements = doc.select("div.sect-movie-chart");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        //iterator를 사용하여 값 가져오기
        Iterator<Element> ie1 = elements.select("strong.rank").iterator();
        Iterator<Element> ie2 = elements.select("strong.title").iterator();

        while(ie1.hasNext()){
            System.out.println(ie1.next().text() + " __ " + ie2.next().text() );
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

    }
}
