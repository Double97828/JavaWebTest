package com.test.fruit.servlet;

import com.test.fruit.dao.FruitDAO;
import com.test.fruit.dao.impl.FruitDAOImpl;
import com.test.fruit.pojo.Fruit;
import com.test.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer count = Integer.parseInt(req.getParameter("count"));
        String remark = req.getParameter("remark");
        Integer fid = 0;
        Fruit fruit = new Fruit(fid, name, price,count,remark);

        fruitDAO.addFruit(fruit);
        resp.sendRedirect("index");
    }
}
