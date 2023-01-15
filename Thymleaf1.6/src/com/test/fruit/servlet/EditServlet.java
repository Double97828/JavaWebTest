package com.test.fruit.servlet;

import com.test.fruit.dao.FruitDAO;
import com.test.fruit.dao.impl.FruitDAOImpl;
import com.test.fruit.pojo.Fruit;
import com.test.myssm.myspringmvc.ViewBaseServlet;
import com.test.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fid)){
            int id = Integer.parseInt(fid);
            Fruit fruit = fruitDAO.getFruitFromId(id);
            req.setAttribute("fruit", fruit);
            super.processTemplate("edit",req,resp);


        }
    }
}
