package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//获取请求资源路径
		String path = req.getServletPath();
		String action = path.substring(0, path.indexOf("."));
//		String uri = req.getRequestURI();
//		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:"+action);
		if ("/quoto".equals(action)) {
			//返回几只股票的信息给客户端(浏览器)
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			for(int i=1;i<=8;i++) {
				Stock s = new Stock();
				s.setCode("60087"+r.nextInt(10));
				s.setName("中华神股"+r.nextInt(1000));
				s.setPrice(Math.round(Math.random()*10000)/100.0);
				stocks.add(s);
			}
			ObjectMapper om = new ObjectMapper();
			String jString = om.writeValueAsString(stocks);
			System.out.println(jString);
			out.println(jString);
		} else if ("/getNumber".equals(action)) {
			//返回一个随机整数
			Random r = new Random();
			int number = r.nextInt(1000);
			System.out.println(number);
			out.println(number);
		}
	}

}
