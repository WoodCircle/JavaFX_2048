package sample;

import java.io.*;

public class BestScore {

    public String getBestScore() throws IOException {
        String score = null;
        File file = new File("src/sample/score.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        score = reader.readLine();
        reader.close();
        return score;
    }

    public void setBestScore(String score) throws IOException {
        File file = new File("src/sample/score.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(score);
        fileWriter.flush();
        fileWriter.close();
    }
}
