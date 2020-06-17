package db;

/*попытка выгрузить */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class QueryResult {
    String[] header;
    List<String[]> body;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String query) throws SQLException {
        ResultSet rs = DbConnect.executeQuery(query);
        int columns = rs.getMetaData().getColumnCount();
        header = new String[columns];
        for (int i=0; i<columns; i++){header[i]=rs.getMetaData().getColumnLabel(i);}
    }

    public List< String[] > getBody() {
        return body;
    }

    public void setBody(String query) throws SQLException {
        ResultSet rs = DbConnect.executeQuery(query);
        List<String[]> result = new ArrayList<>();
        int columns = rs.getMetaData().getColumnCount();
        while(rs.next()) {
            String[] row = new String[columns];
            for (int i = 0; i < columns; i++) {
                row[i] = rs.getString(i);
            }
            result.add(row);
        }
        this.body=result;
    }
}
