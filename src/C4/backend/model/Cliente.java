package C4.backend.model;

public class Cliente {
    private Integer id;
    private Integer codigo;
    private String nombre;
    private String apellido;
    private Integer banco;
    private Integer saldo;

    public Cliente(Integer codigo, String nombre, String apellido, Integer banco, Integer saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.banco = banco;
        this.saldo = saldo;
    }

    public Cliente(Integer id, Integer codigo, String nombre, String apellido, Integer banco, Integer saldo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.banco = banco;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", banco=" + banco +
                ", saldo=" + saldo;
    }
}
