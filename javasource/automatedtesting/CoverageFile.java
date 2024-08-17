package automatedtesting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CoverageFile {

    public static File getCoverageFile(String path) throws IOException {
        File coverageFile = new File(path);
        coverageFile.createNewFile();
        return coverageFile;
    }
    public static void writeCoverageToFile(File coverageFile, Map<String, TestSuite> report) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map<String, TestSuite> testSuites = getCoverageFromFile(coverageFile);

        if (testSuites != null) {
            mergeResults(report, testSuites);
        }

        String reportJson = gson.toJson(report);
        try (FileOutputStream out = new FileOutputStream(coverageFile)) {
            out.write(reportJson.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static Map<String, TestSuite> getCoverageFromFile(File coverageFile) throws IOException {

        try (FileInputStream existingCoverageFile = new FileInputStream(coverageFile)) {
            String existingJson = new String(existingCoverageFile.readAllBytes(), StandardCharsets.UTF_8);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<Map<String, TestSuite>>() {
            }.getType();
            return gson.fromJson(existingJson, type);
        }
    }

    private static void mergeResults(Map<String, TestSuite> newReport, Map<String, TestSuite> existing) {
        for (Map.Entry<String, TestSuite> entry : existing.entrySet()) {
            String key = entry.getKey();
            TestSuite existingTestSuite = entry.getValue();

            if (!newReport.containsKey(key)) {
                // If the newReport already has this TestSuite, merge the test lists
                newReport.put(key, existingTestSuite);
            }
        }
    }

}
