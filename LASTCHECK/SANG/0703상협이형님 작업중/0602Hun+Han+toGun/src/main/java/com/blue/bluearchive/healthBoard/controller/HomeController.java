package com.blue.bluearchive.healthBoard.controller;

import com.blue.bluearchive.board.entity.BlogResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(Model model) throws Exception {
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
            return "/healthContent/index";
        } else {
            return "Error Code: " + responseCode;
        }
    }
}