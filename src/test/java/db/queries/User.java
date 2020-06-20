package db.queries;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
public class User implements RowMapper<User> {

    Integer id;
    String name;
    String surname;

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(0));
        user.setName(rs.getString(1));
        user.setSurname(rs.getString(2));
        return user;
    }
}
