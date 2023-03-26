package src.jdbc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class GoodService2 {
    @Resource
    private GoodsDao goodsDao;
    public void buyGoods(Integer id,Integer goodsId,Integer account){
        Float price = goodsDao.queryPriceById(goodsId);
        goodsDao.subBalance(id,price*account);
        goodsDao.updateAmount(goodsId,account);
    }
    @Transactional
    //声明式的事务控制
    public void buyGoodsT(Integer id,Integer goodsId,Integer account){
        Float price = goodsDao.queryPriceById(goodsId);
        goodsDao.subBalance(id,price*account);
        goodsDao.updateAmount(goodsId,account);
    }
}
