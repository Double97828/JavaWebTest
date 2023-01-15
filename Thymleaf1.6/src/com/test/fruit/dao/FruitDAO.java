package com.test.fruit.dao;

import com.test.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //每页显示五条
    List<Fruit> getFruitList(Integer pageNo );

    Fruit getFruitFromId(int id);


    void updateFruitFrom(Fruit fruit);

    void deleteFruitFromId(int fid);

    void addFruit(Fruit fruit);

    //查询库存总记录条数
    Integer getFruitCount();
}
