package TextSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by stephan on 03.05.2016.
 */
public class Review {
    private String author;
    private String title;
    private int wordCount;
    private int distinctWordCount;
    private int totalCharacters;
    private int sentenceCount;
    private long bytes;
    private HashMap<String, Integer> wordlist = new HashMap<>();

    public Review(String title, String author) {
        this.title = title;
        this.author = author;
        calculate();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getWordCount() {
        return wordCount;
    }

    public double getAverageCharactersPerWord() {
        return totalCharacters / wordCount;
    }

    public double getAverageCharactersPerSentence() {
        return totalCharacters / sentenceCount;
    }

    public double getQuality() {
        int result = 0;
        result += getAverageCharactersPerWord() / 2;
        result += getAverageCharactersPerSentence() / 2;
        return result;
    }


    public void scanFile(String basePath) throws FileNotFoundException {
        distinctWordCount=0;
        File reviewFile = getFile(basePath);
        Scanner scanner = new Scanner(reviewFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            for (String word : words)
                if (!word.equals("")) {
                    //word.trim();
                    word=word.replaceAll("\\P{Alnum}", "");
                    //todo: for debugging,afterwards remove:
                    //System.out.println(word);
                    if (!wordlist.containsKey(word)) {
                        wordlist.put(word, 1);
                        distinctWordCount++;
                        wordCount++;
                    } else {
                        wordlist.replace(word, wordlist.get(word) + 1);
                        wordCount++;
                    }
                    wordCount++;
                }
        }
    }

    public ArrayList<String> getWords() {
        ArrayList<String> result = new ArrayList<>();
        for (String word : wordlist.keySet()) {
            result.add(word);
        }
        return result;
    }

    private File getFile(String basePath) {
        String path = basePath + "/" + author + "/" + title;
        File reviewFile = new File(path);
        return reviewFile;
    }

    public String getContent() throws FileNotFoundException {
        String content = new Scanner(getFile(IndexBuilder.REVIEWPATH)).useDelimiter("\\Z").next();
        return content;
    }


    private void calculate() {
        bytes = getFile(IndexBuilder.REVIEWPATH).length();
    }


    public long getBytes() {
        return bytes;
    }
}
