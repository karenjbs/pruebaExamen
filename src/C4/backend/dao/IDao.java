package C4.backend.dao;

import java.util.List;

public interface IDao<T>{
    T registarCliente (T t);
    T buscarPorId(Integer id);
    T buscarPorNombre(String nombre);
    List<T> listarTodos();
}
