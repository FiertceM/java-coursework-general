package edu.javavt16.dao.jdbc;

import edu.javavt16.dao.CarBrandDAO;
import edu.javavt16.model.CarBrand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class CarBrandDAOJdbcImpl implements CarBrandDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CarBrandDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(CarBrand item) {
        if (item.getIdGame() > 0) {
            // update
            System.out.println("CarBrand update");
            String sql = "UPDATE brand SET name=?, fond_year=?, jenre=?, developer=?, platforms=? WHERE idGame=?";
            jdbcTemplate.update(sql, item.getName(), item.getFond_year(),item.getJenre(), item.getDeveloper(), item.getPlatforms(), item.getIdGame());
        } else {
            // insert
            System.out.println("CarBrand insert");
            String sql = "INSERT INTO brand (name, fond_year, jenre, developer, platforms)"
                    + " VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, item.getName(), item.getFond_year(), item.getJenre(), item.getDeveloper(), item.getPlatforms());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM brand WHERE idGame=?";
        jdbcTemplate.update(sql, itemId);
    }

    public CarBrand get(int itemId) {
        String sql = "SELECT * FROM brand WHERE idGame=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<CarBrand>() {

            public CarBrand extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getCarBrandFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<CarBrand> list() {
        String sql = "SELECT * FROM brand";
        List<CarBrand> listCarBrand = jdbcTemplate.query(sql, new RowMapper<CarBrand>() {

            public CarBrand mapRow(ResultSet rs, int i) throws SQLException {

                return getCarBrandFromDB(rs);
            }
        });
        return listCarBrand;
    }

    private CarBrand getCarBrandFromDB(ResultSet rs) throws SQLException{
        CarBrand brand = new CarBrand();
        brand.setIdGame(rs.getInt("idGame"));
        brand.setName(rs.getString("name"));
        brand.setFond_year(rs.getShort("fond_year"));
        brand.setJenre(rs.getString("jenre"));
        brand.setDeveloper(rs.getString("developer"));
        brand.setPlatforms(rs.getString("platforms"));
        return brand;
    }
}