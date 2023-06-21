package jm.web.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
        try {
            // 웹 페이지 로드
            Document document = Jsoup.connect("https://www.yeosu.go.kr/newok/reservation/096d86a2-ab00-4037-b574-8f815360126e/efa4134b-496e-459d-9811-bbd40c1f2355").get();

            // 원하는 테이블을 식별하는 선택자를 사용하여 테이블 요소 찾기
            Element table = document.selectFirst("table");

            // 테이블 내부의 모든 행(tr 요소) 찾기
            Elements rows = table.select("tr");

            // 행 순회
            for (Element row : rows) {
                // 행 내부의 모든 셀(td 또는 th 요소) 찾기
                Elements cells = row.select("td");

                // 셀 순회
                for (Element cell : cells) {
                    // 셀 내용 출력
                    System.out.print(cell.text() + " ");
                }

                System.out.println(); // 새로운 행으로 개행
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

