package src.jdbc.homework;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.jdbc.GoodsDao2;

import javax.annotation.Resource;

@Service
public class Goods2Service {
    @Resource
    private BuyerDao buyerDao;
    @Resource
    private SellerDao sellerDao;
    @Resource
    private GoodsDao2 goodsDao2;
    @Resource
    private Taobao taobao;
    @Transactional(timeout = 1)
    public void shopping(Integer id,int sellerId,int amount){
        Float price = goodsDao2.queryPriceById2(id);
        double money = price * amount;
        buyerDao.updateBalance(sellerId, money);
        sellerDao.updateBalance(sellerId, money);
    }
}
