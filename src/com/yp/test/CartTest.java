package com.yp.test;

import com.yp.pojo.Cart;
import com.yp.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    Cart cart = new Cart();

    @Test
    public void addItem() {

        cart.addItem(new CartItem(1, "杨鹏", 1, new BigDecimal(12), new BigDecimal(12)));
        cart.addItem(new CartItem(1, "杨鹏", 1, new BigDecimal(12), new BigDecimal(12)));
        cart.addItem(new CartItem(2, "李昕", 1, new BigDecimal(223), new BigDecimal(223)));

//        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        addItem();

        cart.deleteItem(2);

        System.out.println(cart);
    }

    @Test
    public void clear() {

        deleteItem();

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateItem() {

        deleteItem();

        cart.updateItem(1, 4);

        System.out.println(cart);
    }
}