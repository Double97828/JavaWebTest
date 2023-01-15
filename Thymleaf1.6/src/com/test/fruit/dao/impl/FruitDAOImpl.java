package com.test.fruit.dao.impl;

import com.test.fruit.dao.FruitDAO;
import com.test.fruit.pojo.Fruit;
import com.test.myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList(Integer pageNo) {
        return super.executeQuery("select * from t_fruit limit ?,5",(pageNo - 1) * 5);
    }

    @Override
    public Fruit getFruitFromId(int id) {
        return super.load("select * from t_fruit where fid =?", id);
    }

    @Override
    public void updateFruitFrom(Fruit fruit){
        String sql = "update t_fruit set price=?,fcount=? where fid=?";
        super.executeUpdate(sql, fruit.getPrice(), fruit.getFcount(),fruit.getFid());
    }

    @Override
    public void deleteFruitFromId(int fid){
        String sql ="delete from t_fruit where fid =?";
        super.executeUpdate(sql, fid);
    }

    @Override
    public void addFruit(Fruit fruit){
        String sql = "insert into t_fruit (fid, fname, price, fcount, remark) values(?,?,?,?,?)";
        super.executeUpdate(sql, fruit.getFid(), fruit.getFname(), fruit.getPrice(), fruit.getFcount(),fruit.getRemark());

    }

    @Override
    public Integer getFruitCount() {
        return ((Long) super.executeComplexQuery("select count(*) from t_fruit")[0]).intValue();
    }
}
