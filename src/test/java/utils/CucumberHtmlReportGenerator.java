package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

public class CucumberHtmlReportGenerator {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(
                new File("target/cucumber-report/cucumber.json")
        );

        StringBuilder html = new StringBuilder();
        html.append("<h2>UI Automation Result</h2>");
        html.append("<table border='1' cellpadding='8' cellspacing='0'>");
        html.append("<tr>")
                .append("<th>Feature</th>")
                .append("<th>Scenario</th>")
                .append("<th>Status</th>")
                .append("</tr>");

        Iterator<JsonNode> features = root.elements();

        while (features.hasNext()) {
            JsonNode feature = features.next();
            String featureName = feature.get("name").asText();

            for (JsonNode scenario : feature.get("elements")) {
                String scenarioName = scenario.get("name").asText();

                boolean failed = false;
                for (JsonNode step : scenario.get("steps")) {
                    if (step.has("result")
                            && step.get("result").get("status").asText().equals("failed")) {
                        failed = true;
                        break;
                    }
                }

                String statusText = failed ? "FAILED" : "PASSED";
                String color = failed ? "red" : "green";

                html.append("<tr>")
                        .append("<td>").append(featureName).append("</td>")
                        .append("<td>").append(scenarioName).append("</td>")
                        .append("<td style='color:").append(color).append(";'>")
                        .append(statusText)
                        .append("</td>")
                        .append("</tr>");
            }
        }

        html.append("</table>");

        FileWriter writer = new FileWriter("target/cucumber-report/summary.html");
        writer.write(html.toString());
        writer.close();

        System.out.println("HTML report generated at target/cucumber-report/summary.html");
    }
}
