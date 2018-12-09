package edu.javavt16.dao.jdbc;

import edu.javavt16.dao.CarBrandDAO;
import edu.javavt16.dao.CarModelDAO;
import edu.javavt16.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarModelDAOJdbcImpl implements CarModelDAO {
    @Autowired
    @Qualifier("getCarBrandJdbcDAO")
    private CarBrandDAO carBrandDAO;

    private JdbcTemplate jdbcTemplate;

    public CarModelDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(CarModel item) {
        if (item.getIdModel() > 0) {
            // update
            String sql = "UPDATE model SET idGame=?, os=?, processor=?, ram=?, hdd=?, video_card=? WHERE idModel=?";
            jdbcTemplate.update(sql, item.getIdGame(), item.getOs(),item.getProcessor(), item.getRam(), item.getHdd(), item.getVideo_card(), item.getIdModel());
        } else {
            // insert
            String sql = "INSERT INTO model (idGame, os, processor, ram, hdd, video_card)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, item.getIdGame(), item.getOs(),item.getProcessor(),
                    item.getRam(), item.getHdd(), item.getVideo_card());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM model WHERE idModel=?";
        jdbcTemplate.update(sql, itemId);
    }

    public CarModel get(int itemId) {
        String sql = "SELECT * FROM model WHERE idModel=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<CarModel>() {

            public CarModel extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return getCarModelFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<CarModel> list() {
        String sql = "SELECT * FROM model";
        List<CarModel> listCarModel = jdbcTemplate.query(sql, new RowMapper<CarModel>() {

            public CarModel mapRow(ResultSet rs, int i) throws SQLException {

                return getCarModelFromDB(rs);
            }
        });
        return listCarModel;
    }

    private CarModel getCarModelFromDB(ResultSet rs) throws SQLException{
        CarModel model = new CarModel();
        model.setIdModel(rs.getInt("idModel"));
        model.setIdGame(rs.getInt("idGame"));
        model.setCarBrand(carBrandDAO.get(rs.getInt("idBrand")));
        model.setOs(rs.getString("os"));
        model.setProcessor(rs.getString("processor"));
        model.setRam(rs.getShort("ram"));
        model.setHdd(rs.getShort("hdd"));
        model.setVideo_card(rs.getString("video_card"));
        return model;
    }
}