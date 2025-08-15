package org.helal_anwar;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.apache.commons.text.StringEscapeUtils;
import org.json.*;

public class QuizService {

    public static List<Question> fetchQuestions() throws Exception {
        List<Question> questions = new ArrayList<>();

        JSONArray results = getObjects();

        for (int i = 0; i < results.length(); i++) {
            JSONObject q = results.getJSONObject(i);
            String question = StringEscapeUtils.unescapeHtml4(q.getString("question"));
            String correct = StringEscapeUtils.unescapeHtml4(q.getString("correct_answer"));
            JSONArray incorrect = q.getJSONArray("incorrect_answers");

            List<String> options = new ArrayList<>();
            for (int j = 0; j < incorrect.length(); j++) {
                options.add(StringEscapeUtils.unescapeHtml4(incorrect.getString(j)));
            }
            options.add(correct);
            Collections.shuffle(options);

            questions.add(new Question(question, correct, options));
        }

        return questions;
    }

    private static JSONArray getObjects() throws IOException {
        URL url = new URL("https://opentdb.com/api.php?amount=10&type=multiple");
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
