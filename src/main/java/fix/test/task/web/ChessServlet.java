package fix.test.task.web;

import fix.test.task.service.BuildService;
import fix.test.task.util.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/horse/servlet/count")
public class ChessServlet extends HttpServlet {

    private BuildService buildService = new BuildService();
    private Validator validator = new Validator();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String width = req.getParameter("width");
        String height = req.getParameter("height");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        if (validator.validate(width, height, start, end)) {
            out.println(buildService.initService(width, height, start, end));
        } else {
            out.println("Введенные данные некорректны");
        }
    }
}
