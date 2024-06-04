import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonTableApp extends JFrame {

    public PersonTableApp() {
        setTitle("Person Table");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Person> persons = loadPersonsFromURL("https://lide.uhk.cz/fim/ucitel/kozelto1/prog/people.txt");
        Collections.sort(persons, Comparator.comparing(Person::getBirthday));
        JTable table = new JTable(new PersonTableModel(persons));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private List<Person> loadPersonsFromURL(String urlString) {
        List<Person> persons = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            String[] firstnames = null;
            String[] lastnames = null;
            String[] birthdays = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("firstnames:")) {
                    firstnames = line.substring("firstnames:".length()).split(",");
                } else if (line.startsWith("lastnames:")) {
                    lastnames = line.substring("lastnames:".length()).split(",");
                } else if (line.startsWith("birthdays:")) {
                    birthdays = line.substring("birthdays:".length()).split(",");
                }
            }
            reader.close();

            if (firstnames != null && lastnames != null && birthdays != null) {
                for (int i = 0; i < firstnames.length; i++) {
                    persons.add(new Person(firstnames[i].trim(), lastnames[i].trim(), birthdays[i].trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersonTableApp app = new PersonTableApp();
            app.setVisible(true);
        });
    }
}