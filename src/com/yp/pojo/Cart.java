package com.yp.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
/*    private Integer totalCount;
    private BigDecimal totalPrice;*/
    private Map<Integer, CartItem> items = new LinkedHashMap<>();


    public void addItem(CartItem cartItem) {

        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().
                    multiply(new BigDecimal(item.getCount())));
        }

    }

    public void deleteItem(Integer id) {

        items.remove(id);

    }

    public void clear() {

        items.clear();
    }

    public void updateItem(Integer id, Integer count) {

        CartItem item = items.get(id);

        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().
                    multiply(new BigDecimal(item.getCount())));
        }

    }



    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /*public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }*/

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }

        return  totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal TotalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem>entry : items.entrySet()) {
            TotalPrice = TotalPrice.add(entry.getValue().getTotalPrice());
        }

        return  TotalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
