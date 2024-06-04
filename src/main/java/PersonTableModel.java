import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> persons;
    private String[] columnNames = {"Firstname", "Lastname", "Birthday"};

    public PersonTableModel(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0: return person.getFirstname();
            case 1: return person.getLastname();
            case 2: return person.getBirthday();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
