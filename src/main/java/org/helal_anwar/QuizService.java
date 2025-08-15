package org.helal_anwar;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import org.json.*;

public class QuizService {

    public static List<Question> fetchQuestions() throws Exception {
        List<Question> questions = new ArrayList<>();

        JSONArray results = getObjects();

        for (int i = 0; i < results.length(); i++) {
            JSONObject q = results.getJSONObject(i);
            String questionText = org.apache.commons.text.StringEscapeUtils.unescapeHtml4(q.getString("question"));
            String correct = org.apache.commons.text.StringEscapeUtils.unescapeHtml4(q.getString("correct_answer"));
            JSONArray incorrect = q.getJSONArray("incorrect_answers");

            List<String> options = new ArrayList<>();
            for (int j = 0; j < incorrect.length(); j++) {
                options.add(org.apache.commons.text.StringEscapeUtils.unescapeHtml4(incorrect.getString(j)));
            }

            List<String> correctAnswers = new ArrayList<>();
            correctAnswers.add(correct);

            options.addAll(correctAnswers);
            Collections.shuffle(options);

            questions.add(new Question(questionText, correctAnswers, options));
        }

        return questions;
    }

    private static JSONArray getObjects() throws URISyntaxException, IOException {
        URL url = new URI("https://opentdb.com/api.php?amount=10&type=multiple").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(new InputStreamReader(conn.getInputStream()));
        StringBuilder json = new StringBuilder();
        while (scanner.hasNext()) {
            json.append(scanner.nextLine());
        }
        scanner.close();

        JSONObject obj = new JSONObject(json.toString());
        return obj.getJSONArray("results");
    }
}