package automatedtesting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CoverageFileWriter {

    public static void writeCoverageFile(Map<String, TestSuite> report) {
        // Write the coverage file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the Person object to JSON and write to a file
        try (FileWriter writer = new FileWriter("coverage.json")) {
            gson.toJson(report, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
