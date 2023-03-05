package src.com.wzx;

import java.util.List;

public class BookStore {
    private List<String> list;

    public BookStore(List<String> list) {
        this.list = list;
    }
    public BookStore(){}

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
