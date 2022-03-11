package util;

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

        public Question(String question) {
            json = "{\"question\":\"" +  question + "\"}";
        }

        public Question(String question, Set<String> options, String type ) {
            StringBuilder stringBuilder = new StringBuilder("{\"question\":\"");
            stringBuilder.append(question);
            stringBuilder.append("\", \"type\":\"");
            stringBuilder.append(type);
            stringBuilder.append("\", [");
            for (String option:  options) {
                stringBuilder.append('"');
                stringBuilder.append(option);
                stringBuilder.append("\",");
            }
            stringBuilder.append("]}");
            json = stringBuilder.toString();
        }

        public Question(String question, int max, int min) {
            json = "{\"question\":\"" +  question + "\"," +
                    "\"max\":\"" +  max + "\"," +
                    "\"min\":\"" +  min + "\"}";
        }
    }
    public static String surveyJson(String name,Set<Question>  questions){
        StringBuilder stringBuilder = new StringBuilder("{\"name\" : \"");
        stringBuilder.append(name);
        stringBuilder.append("\", [");
        for (Question q: questions) {
            stringBuilder.append(q.json);
            stringBuilder.append(',');
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
