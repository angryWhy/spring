package src.dependenceInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;
}
