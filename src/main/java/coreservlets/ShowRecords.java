package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/show-records")
public class ShowRecords extends HttpServlet {
  private static final long serialVersionUID = 838967269748524522L;

  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    Object[][] records = WorldRecords.recentRecords();
    request.setAttribute("records", records);
    String address = "/WEB-INF/results/show-records.jsp";
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
