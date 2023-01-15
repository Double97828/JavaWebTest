package com.test.fruit.servlet;

import com.test.fruit.dao.FruitDAO;
import com.test.fruit.dao.impl.FruitDAOImpl;
import com.test.myssm.myspringmvc.ViewBaseServlet;
import com.test.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fid)){

            fruitDAO.deleteFruitFromId(Integer.parseInt(fid));
            resp.sendRedirect("index");
        }

    }
}
