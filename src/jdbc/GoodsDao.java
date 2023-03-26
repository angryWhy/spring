package src.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GoodsDao {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ioc_jdbc.xml");
        GoodsDao goodsDao = classPathXmlApplicationContext.getBean(GoodsDao.class);
        float v = goodsDao.queryPriceById(1);
        System.out.println(v);
    }
    @Resource
    private JdbcTemplate jdbcTemplate;

    public float queryPriceById(Integer id) {
        String sql = "SELECT price From goods_count Where goods_id=?";
        Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
        return price;
    }

    public void subBalance(Integer id, Float moeny) {
        String sql = "UPDATE user_account SET money=money-? Where user_id=?";
        jdbcTemplate.update(sql, id, moeny);
    }

    public void updateAmount(Integer id, int ammount) {
        String sql = "UPDATE goods_count SET goods_num=goods_num-? Where goods_id=?";
        jdbcTemplate.update(sql, id, ammount);
    }
    public Float queryPriceById2(Integer id){
        String sql = "SELECT price From goods_count Where goods_id=?";
        Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
        return price;
    }
    public void updateBalance(Integer user_id,Float money){
        String sql = "UPDATE user_account SET money=? Where user_id=?";
        jdbcTemplate.update(sql, user_id, money);
    }
}
