package com.blue.bluearchive.healthBoard.controller;


import com.blue.bluearchive.board.entity.BlogResult;
import com.blue.bluearchive.board.entity.NewsResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/health")
public class HealBoardController {

    @GetMapping("/healthCalculator")
    public String calculator() {
        return "healthContent/healthCalculator";
    }

    @GetMapping("/bmiCalculator")
    public String bmiCalculator() {
        return "healthContent/healthCalculator2";
    }

    @GetMapping("/consumeCalculator")
    public String consumeCalculator() {
        return "healthContent/healthCalculator3";
    }

    @GetMapping("/1RepMaxCalculator")
    public String _1RepMaxCalculator() {
        return "healthContent/healthCalculator4";
    }

    @GetMapping("/recommendedPage")
    public String recommendedPage(Model model) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {
        String host = "localhost";
        String user = "aru";
        String password = "1234";
        String database = "bluearchive3";

        String client_id = "y0Rs7wrLP4_Qh53s8zW6";
        String client_secret = "ESfd8Gc8ux";
        String encText = URLEncoder.encode("단백질 식단", "UTF-8");
        String url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText;

        URL requestUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Naver-Client-Id", client_id);
        connection.setRequestProperty("X-Naver-Client-Secret", client_secret);

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String xmlData = response.toString();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlData)));

            doc.getDocumentElement().normalize();
            NodeList itemList = doc.getElementsByTagName("item");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + database + "?useUnicode=true&characterEncoding=utf8",
                    user,
                    password
            );

            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS blog_results (title TEXT, link TEXT, image TEXT)");

            for (int i = 0; i < itemList.getLength(); i++) {
                Node item = itemList.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) item;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String cleanedTitle = title.replaceAll("<.*?>", "");
                    String link = element.getElementsByTagName("link").item(0).getTextContent();
                    String image = null;
                    if (element.getElementsByTagName("thumbnail").getLength() > 0) {
                        image = element.getElementsByTagName("thumbnail").item(0).getAttributes().getNamedItem("src").getNodeValue();
                    }

                    String insertQuery = "INSERT INTO blog_results (title, link, image) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                    preparedStatement.setString(1, cleanedTitle);
                    preparedStatement.setString(2, link);
                    preparedStatement.setString(3, image);
                    preparedStatement.executeUpdate();
                }
            }

            // 데이터 가져오기
            List<BlogResult> results = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog_results");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String link = resultSet.getString("link");
                String image = resultSet.getString("image");
                BlogResult blogResult = new BlogResult(title, link, image);
                results.add(blogResult);
            }

            conn.close();

            model.addAttribute("results", results);
            return "/healthContent/healthPage";
        } else {
            return "Error Code: " + responseCode;
        }
    }

    @GetMapping("/index")
    public String index(Model model) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {
        String host = "localhost";
        String user = "aru";
        String password = "1234";
        String database = "bluearchive3";

        String client_id = "y0Rs7wrLP4_Qh53s8zW6";
        String client_secret = "ESfd8Gc8ux";
        String blogEncText = URLEncoder.encode("단백질 식단", "UTF-8");
        String blogUrl = "https://openapi.naver.com/v1/search/blog.xml?query=" + blogEncText;

        URL blogRequestUrl = new URL(blogUrl);
        HttpURLConnection blogConnection = (HttpURLConnection) blogRequestUrl.openConnection();
        blogConnection.setRequestMethod("GET");
        blogConnection.setRequestProperty("X-Naver-Client-Id", client_id);
        blogConnection.setRequestProperty("X-Naver-Client-Secret", client_secret);

        int blogResponseCode = blogConnection.getResponseCode();

        if (blogResponseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(blogConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String xmlData = response.toString();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlData)));

            doc.getDocumentElement().normalize();
            NodeList blogItemList = doc.getElementsByTagName("item");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + database + "?useUnicode=true&characterEncoding=utf8",
                    user,
                    password
            );

            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS blog_results (title TEXT, link TEXT, image TEXT)");

            for (int i = 0; i < blogItemList.getLength(); i++) {
                Node item = blogItemList.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) item;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String cleanedTitle = title.replaceAll("<.*?>", "");
                    String link = element.getElementsByTagName("link").item(0).getTextContent();
                    String image = null;
                    if (element.getElementsByTagName("thumbnail").getLength() > 0) {
                        image = element.getElementsByTagName("thumbnail").item(0).getAttributes().getNamedItem("src").getNodeValue();
                    }

                    String insertQuery = "INSERT INTO blog_results (title, link, image) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                    preparedStatement.setString(1, cleanedTitle);
                    preparedStatement.setString(2, link);
                    preparedStatement.setString(3, image);
                    preparedStatement.executeUpdate();
                }
            }

            // News search
            String newsEncText = URLEncoder.encode("운동의 중요성", "UTF-8");
            String newsUrl = "https://openapi.naver.com/v1/search/news.xml?query=" + newsEncText;

            URL newsRequestUrl = new URL(newsUrl);
            HttpURLConnection newsConnection = (HttpURLConnection) newsRequestUrl.openConnection();
            newsConnection.setRequestMethod("GET");
            newsConnection.setRequestProperty("X-Naver-Client-Id", client_id);
            newsConnection.setRequestProperty("X-Naver-Client-Secret", client_secret);
            int newsResponseCode = newsConnection.getResponseCode();

            if (newsResponseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader newsIn = new BufferedReader(new InputStreamReader(newsConnection.getInputStream()));
                String newsInputLine;
                StringBuilder newsResponse = new StringBuilder();

                while ((newsInputLine = newsIn.readLine()) != null) {
                    newsResponse.append(newsInputLine);
                }
                newsIn.close();

                String newsXmlData = newsResponse.toString();

                DocumentBuilderFactory newsFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder newsBuilder = newsFactory.newDocumentBuilder();
                Document newsDoc = newsBuilder.parse(new InputSource(new StringReader(newsXmlData)));

                newsDoc.getDocumentElement().normalize();
                NodeList newsItemList = newsDoc.getElementsByTagName("item");

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS news_results (title TEXT, link TEXT, image TEXT)");

                for (int i = 0; i < newsItemList.getLength(); i++) {
                    Node item = newsItemList.item(i);
                    if (item.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) item;
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String cleanedTitle = title.replaceAll("<.*?>", "");
                        String link = element.getElementsByTagName("originallink").item(0).getTextContent();
                        String image = null;
                        if (element.getElementsByTagName("thumbnail").getLength() > 0) {
                            image = element.getElementsByTagName("thumbnail").item(0).getTextContent();
                        }

                        String insertQuery = "INSERT INTO news_results (title, link, image) VALUES (?, ?, ?)";
                        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setString(1, cleanedTitle);
                        preparedStatement.setString(2, link);
                        preparedStatement.setString(3, image);
                        preparedStatement.executeUpdate();
                    }
                }

                // Get blog results
                List<BlogResult> blogResults = new ArrayList<>();
                ResultSet blogResultSet = statement.executeQuery("SELECT * FROM blog_results");
                while (blogResultSet.next()) {
                    String title = blogResultSet.getString("title");
                    String link = blogResultSet.getString("link");
                    String image = blogResultSet.getString("image");
                    BlogResult blogResult = new BlogResult(title, link, image);
                    blogResults.add(blogResult);
                }

                // Get news results
                List<NewsResult> newsResults = new ArrayList<>();
                ResultSet newsResultSet = statement.executeQuery("SELECT * FROM news_results");
                while (newsResultSet.next()) {
                    String title = newsResultSet.getString("title");
                    String link = newsResultSet.getString("link");
                    String image = newsResultSet.getString("image");
                    NewsResult newsResult = new NewsResult(title, link, image);
                    newsResults.add(newsResult);
                }

                conn.close();

                model.addAttribute("blogResults", blogResults);
                model.addAttribute("newsResults", newsResults);

                String showButtonScript = "<script>\n" +
                        "function showHiddenItems(targetClass) {\n" +
                        "  var hiddenItems = document.querySelectorAll('.' + targetClass + ' .hidden');\n" +
                        "  for (var i = 0; i < hiddenItems.length; i++) {\n" +
                        "    hiddenItems[i].classList.remove('hidden');\n" +
                        "  }\n" +
                        "  var showButton = document.getElementById('show-' + targetClass + '-button');\n" +
                        "  showButton.style.display = 'none';\n" +
                        "}\n" +
                        "</script>";
                model.addAttribute("showButtonScript", showButtonScript);

                return "/healthContent/index";
            } else {
                return "Error Code: " + newsResponseCode;
            }
        } else {
            return "Error Code: " + blogResponseCode;
        }
    }


    @GetMapping("/exerciseInformationPage")
    public String exerciseInformationPage() {
        return "healthContent/healthInformation";
    }
}
