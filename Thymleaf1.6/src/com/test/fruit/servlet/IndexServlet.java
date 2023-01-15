package com.test.fruit.servlet;

import com.test.fruit.dao.FruitDAO;
import com.test.fruit.dao.impl.FruitDAOImpl;
import com.test.fruit.pojo.Fruit;
import com.test.myssm.myspringmvc.ViewBaseServlet;
import com.test.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//servlet 3.0以后支持注解方式注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if(StringUtil.isNotEmpty(pageNoStr)){
            pageNo = Integer.parseInt(pageNoStr);
        }

        FruitDAO fruitDAO = new FruitDAOImpl() ;
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);
        //保存到session中
        HttpSession  session = req.getSession();
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageNo", pageNo);

        Integer total = fruitDAO.getFruitCount();
        Integer totalPage = (total + 4) / 5 ;
        session.setAttribute("totalPage", totalPage);

        super.processTemplate("index",req,resp);
    }
}
