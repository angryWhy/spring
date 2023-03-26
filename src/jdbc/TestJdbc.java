package src.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");

    }
    public void add() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql = "INSERT INTO monster VALUES(500,'红孩儿','枪法')";
        String sql2 = "INSERT INTO monster VALUES(?,?,?)";
        jdbcTemplate.execute(sql);
        jdbcTemplate.update(sql2,600,"牛魔王","撞击");
        System.out.println("ok");
    }
    public void update() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql = "UPDATE moster SET skill=? WHERE id=?";
        jdbcTemplate.update(sql,"美女计",300);
    }
    public void addGroup() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql = "INSERT INTO monster VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{800,"老鼠精","吃食物"});
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints[0]);
    }
    public void search() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql = "SELECT id as mosterid ,NAME,skill FROM monster WHERE id = 100";
        //返回的字段，需要和类字段名字一样
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper);
    }
    public void getQueryGroup() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ioc.getBean("jdbcTemplate");
        String sql = "SELECT id as mosterid ,NAME,skill FROM monster WHERE id > ?";
        //返回的字段，需要和类字段名字一样
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        List<Monster> query = jdbcTemplate.query(sql, rowMapper, 100);
    }
    public void getDeclare(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
        String sql = "INSERT INTO monster VALUES(:myId,:name,:skill)";
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("id","900");
        paraMap.put("name","马已经");
        paraMap.put("skill","打洞");
        int update = namedParameterJdbcTemplate.update(sql, paraMap);
    }
}
