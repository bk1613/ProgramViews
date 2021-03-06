package com.nielson.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nielson.domain.ChartView;

@Repository
public class ProgramDAOImpl implements ProgramDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ChartView> findTotalView(String hov1, String hov2) {
		String sql = "select genre, sum(Viewers) from programs where ViewerHometown = ? or ViewerHometown = ? group by genre";
		Object[] args = {hov1, hov2};
		List<ChartView> views = jdbcTemplate.query(sql, args, new RoomMapper());
		
		
		return views;
	}

}

class RoomMapper implements RowMapper<ChartView>{
    @Override
    public ChartView mapRow(ResultSet rs, int rowNum) throws SQLException {
    
    	ChartView views = new ChartView();
       	views.setGenre(rs.getString("genre"));
        views.setViewers(rs.getInt("sum(Viewers)"));
        return views;
    }
    
}