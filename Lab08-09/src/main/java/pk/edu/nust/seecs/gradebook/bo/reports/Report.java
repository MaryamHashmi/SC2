package pk.edu.nust.seecs.gradebook.bo.reports;

import java.io.IOException;
import java.io.PrintWriter;


public abstract class Report {

    private String[] headings;
    private Object[][] data;

    void setHeadings(String[] headings) {
        this.headings = headings;
    }

    void setData(Object[][] data) {
        this.data = data;
    }

    public void export(String filename) throws AssertionError, RuntimeException {
        try {
            PrintWriter writer = new PrintWriter(filename + ".csv", "UTF-8");
            writer.print(getCSVText());
            writer.close();
        } catch (IOException ignored) {
            throw new RuntimeException();
        }
    }

    private String getCSVText() throws AssertionError {
        assert headings != null;
        assert data != null;
        for (Object[] row : data) {
            assert row.length == headings.length;
        }

        StringBuilder output = new StringBuilder();

        output.append(getCSVRow(headings));
        for (Object[] row : data) {
            output.append(getCSVRow(row));
        }

        return output.toString();
    }

    private String getCSVRow(Object[] row) {
        StringBuilder string = new StringBuilder();
        for (Object cell : row) {
            string.append(getCSVCell(cell));
        }
        string.append("\n");
        return string.toString();
    }

    private String getCSVCell(Object cell) {
        return String.valueOf(cell) + ", ";
    }

}
