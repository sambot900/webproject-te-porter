import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Car;
import util.UtilDBPorter;

@WebServlet("/MyServletTE")
public class MyServletTE extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletTE() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      UtilDBPorter.createCar("Kona", "Sport", "Destiny Red");
      UtilDBPorter.createCar("i30", "Luxury", "Bare Metal Gray");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Car> listCars = UtilDBPorter.listCars();
      for (Car employee : listCars) {
         System.out.println("[DBG] " + employee.getId() + ", " //
               + employee.getModel() + ", " //
               + employee.getEdition() + ", " //
               + employee.getColor());
         out.println("<li>" + employee.getId() + ", " //
               + employee.getModel() + ", " //
               + employee.getEdition() + ", " //
               + employee.getColor() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
