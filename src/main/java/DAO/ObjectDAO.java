package DAO;

import java.util.List;


public interface ObjectDAO<T> {
    public List<T> findAll();

    public T criar(T t);

    public void remover(int id);
}
