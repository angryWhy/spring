package src.jdbc.homework;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class BuyerDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Transactional(propagation = Propagation.REQUIRES_NEW,timeout = 2)
    public void updateBalance(Integer user_id,Double money){
        String sql = "UPDATE user_account SET money=? Where user_id=?";
        jdbcTemplate.update(sql, user_id, money);
    }
}
