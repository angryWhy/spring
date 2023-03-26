package src.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class Dao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    public void save(Monster monster){
        String sql = "INSERT INTO monster VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, monster.getId(), monster.getName(), monster.getSkill());
    }
}
