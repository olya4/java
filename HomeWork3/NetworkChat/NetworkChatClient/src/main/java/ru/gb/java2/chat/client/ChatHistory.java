package ru.gb.java2.chat.client;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChatHistory implements AutoCloseable {

    private static final String FILE_NAME = "./history/history_%s.txt";

    private final String login;
    private File hisfile;
    private PrintWriter writer;

    public ChatHistory(String login) {
        this.login = login;
    }

    // создать файл
    private File createFile() throws IOException {
        // имя файла
        String filename = String.format(FILE_NAME, login);
        // создать файл с заданным именем
        File file = new File(filename);
        // существует ли файл, к которому обращаюся по заданому пути
        // если нет
        if (!file.exists()) {
            // создать директорию с файлом
            file.getParentFile().mkdirs();
            // создать новый файл
            file.createNewFile();
        }
        return file;
    }

    public void create() {
        try {
            // создать файл
            hisfile = createFile();
            // создать PrintWriter через BufferedWriter
            this.writer = new PrintWriter(new BufferedWriter(new FileWriter(hisfile, StandardCharsets.UTF_8, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendText(String text) {
        writer.println(text);
        writer.flush();
    }

    @Override
    public void close() throws Exception {
        if (writer != null) {
            writer.close();
        }
    }
}
