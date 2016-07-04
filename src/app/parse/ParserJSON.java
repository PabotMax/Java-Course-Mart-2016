package app.parse;

import app.model.Contact;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Family on 10.06.2016.
 */
public class ParserJSON {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {

        String path = "files/in/contacts.json";

        List<Contact> contacts = readJsonStream(new FileInputStream(path));

            /*for (Message message : messages) {
                System.out.println("Type = " + message.getType());
                System.out.println("Message = " + message.getMessage());

                message.setMessage(message.getType() + " " + message.getMessage());
            }

            writeJsonStream(new FileOutputStream(path), messages);*/
    }

    public static List<Contact> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

        List<Contact> contacts = new ArrayList<Contact>();
        reader.beginArray();
        while (reader.hasNext()) {
            Contact contact = gson.fromJson(reader, Contact.class);
            contacts.add(contact);
        }
        reader.endArray();
        reader.close();

        return contacts;
    }

    public static void writeJsonStream(OutputStream out, List<Contact> contacts) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        for (Contact contact : contacts) {
            gson.toJson(contact, Contact.class, writer);
        }
        writer.endArray();
        writer.close();
    }

}



