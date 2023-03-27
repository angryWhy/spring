package src.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class GoodsDao2 {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ioc_jdbc.xml");
        GoodsDao goodsDao = classPathXmlApplicationContext.getBean(GoodsDao.class);
        float v = goodsDao.queryPriceById(1);
        System.out.println(v);
    }
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public Float queryPriceById2(Integer id){
        String sql = "SELECT price From goods_count Where goods_id=?";
        Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
        return price;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW,timeout = 2)
    public void updateBalance(Integer user_id,Float money){
        String sql = "UPDATE user_account SET money=? Where user_id=?";
        jdbcTemplate.update(sql, user_id, money);
    }
}
