package util;

import java.util.List;
import java.util.Set;

public class ToJson {
    public static String surveyorJson(String username, String firstName, String lastName, String hashedPassword){
        return "{" +
                "\"username\":\"" + username + "\"" +
                ",\"firstName\":\"" + firstName+ "\"" +
                ",\"lastName\":\"" + lastName+ "\"" +
                ",\"hashedPassword\":\"" +hashedPassword + "\"" +
                "}";
    }
    public static class Question{
        private final String json;

        public Question(String question, String type) {
            json = "{\"question\":\"" +  question + "\", \"type\":\""+type+"\"}";
        }

        public Question(String question, List<String> options, String type ) {
            StringBuilder stringBuilder = new StringBuilder("{\"question\":\"");
            stringBuilder.append(question);
            stringBuilder.append("\", \"type\":\"");
            stringBuilder.append(type);
            stringBuilder.append("\", \"options\": [");
            for (int i = 0; i < options.size(); i++) {
                stringBuilder.append('"');
                stringBuilder.append(options.get(i));
                stringBuilder.append('"');
                if (i != options.size() -1){
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append("]}");
            json = stringBuilder.toString();
        }

        public Question(String question, int max, int min, String type) {
            json = "{\"question\":\"" +  question + "\"," +
                    "\"max\":" +  max + "," +
                    "\"min\":" +  min + "," +
                    "\"type\":\"" +  type + "\"}";
        }
    }
    public static String surveyJson(String name, List<Question> questions){
        StringBuilder stringBuilder = new StringBuilder("{\"name\" : \"");
        stringBuilder.append(name);
        stringBuilder.append("\", \"questions\":  [");
        for (int i = 0; i < questions.size(); i++) {
            stringBuilder.append(questions.get(i).json);
            if (i != questions.size() -1){
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
