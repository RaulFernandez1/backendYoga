package com.pruebaTFG.myapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YogaScraper {
/*
    public static void main(String[] args) throws Exception {
        String baseUrl = "https://www.tummee.com/es/yoga-poses";
        String posesUrl = baseUrl + "/iyengar-yoga-poses";

        // Cargar la página principal
        Document doc = Jsoup.connect(posesUrl).get();

        // Seleccionar todos los <li> con las posturas
        Elements poseElements = doc.select("ul.yoga-poses-list > li");

        for (Element poseElement : poseElements) {
            Element aTag = poseElement.selectFirst("a");
            if (aTag == null) continue;

            // Nombre de la postura
            Element h3Tag = aTag.selectFirst("h3");
            String poseName = h3Tag != null ? h3Tag.text() : "Sin título";

            // URL de la imagen
            Element imgTag = aTag.selectFirst("img");
            String imageUrl = imgTag != null ? imgTag.attr("src") : "";

            // URL completa de la postura
            String relativeUrl = aTag.attr("href");
            String fullUrl = relativeUrl.startsWith("http") ? relativeUrl : baseUrl + relativeUrl;

            Document detailPage = Jsoup.connect(baseUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0 Safari/537.36")
                    .referrer("https://www.google.com") // referrer común
                    .timeout(10000)
                    .get();;

            // Selector completo a la tabla (puedes simplificar según convenga)
            Element infoTable = detailPage.selectFirst(
                    "div.inner-main-col.no-print > div > header > div:nth-child(2) > div:nth-child(4) > table"
            );

            if (infoTable != null) {
                Elements rows = infoTable.select("tbody > tr");
                for (Element row : rows) {
                    Element headerTd = row.selectFirst("td.pose-summary-header");
                    Element contentTd = row.selectFirst("td.pose-summary-title");

                    if (headerTd != null && contentTd != null) {
                        String header = headerTd.text().trim();
                        String content = contentTd.text().trim();

                        System.out.println(header + ": " + content);
                    }
                }
            } else {
                System.out.println("⚠️ No se encontró la tabla de detalles en " + fullUrl);
            }

            // Mostrar resultados
            System.out.println("📌 Nombre: " + poseName);
            System.out.println("🔗 Enlace: " + fullUrl);
            System.out.println("🖼 Imagen: " + imageUrl);
            System.out.println("──────────────────────────────");
        }
    }
*/
}
