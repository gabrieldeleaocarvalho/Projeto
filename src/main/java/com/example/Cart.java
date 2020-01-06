package com.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Usuario usuario;

    protected Cart(){}

    public Cart(Usuario usuario, Product product){
        this.product = product;
        this.usuario = usuario;
    }
    @Override
    public String toString(){
        return String.format(
            "[id=%, usuario='%s', product='%s']",
            id, usuario, product);
    }
    public Long getId() {
        return id;
}
    public void setId(Long id) {
        this.id = id;
}
    public Product getProduct() {
        return product;
}
    public void setProduct(Product product) {
        this.product = product;
}

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
}
    public Usuario getUsuario() {
        return usuario;
}
}

