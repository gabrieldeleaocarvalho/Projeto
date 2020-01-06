package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CartResource {

    @Autowired
    private CartRepository repositoriocart;

        public CartResource(CartRepository repositoriocart){
            this.repositoriocart = repositoriocart;
    }
    @RequestMapping(value = "/cart/", method = RequestMethod.GET)
        public List<Cart> buscarCart(@RequestParam(required = false) String usuario) {
            return this.repositoriocart.findAll();
    }
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
        public Optional<Cart> buscarClientes(@PathVariable Long id) {
            return this.repositoriocart.findById(id);
    }
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
        public void removerCart(@PathVariable Long id) {
            this.repositoriocart.deleteById(id);
    }
    @RequestMapping(value = "/cart/", method = RequestMethod.POST)
        public Cart criarCart(@RequestBody Cart cart) {
            Usuario usuario = cart.getUsuario();
            Product product = cart.getProduct();
                return this.repositoriocart.save(new Cart(usuario, product));
}
    @RequestMapping(value ="/cart/{id}", method=RequestMethod.PUT)
        public void alterarCart(@PathVariable Long id, @RequestBody Cart cartParam) {
            Cart cart = this.repositoriocart.findById(id).get();
            cart.setUsuario(cartParam.getUsuario());
            cart.setProduct(cartParam.getProduct());
                this.repositoriocart.save(cart);
  }
}