package src.service;

import src.dao.DAO;

public class Service {
    private DAO dao = new DAO();

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;

    }
    public void add(){
        dao.add();
    }
}
