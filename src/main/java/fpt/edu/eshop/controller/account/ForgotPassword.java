package fpt.edu.eshop.controller.account;

import fpt.edu.eshop.dao.AccountDAO;
import fpt.edu.eshop.dao.DAO;
import fpt.edu.eshop.dao.MyDAO;
import fpt.edu.eshop.utils.EmailSender;
import fpt.edu.eshop.utils.PasswordGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgotPassword", urlPatterns = {"/ForgotPassword"})
public class ForgotPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "forgot-password.jsp";
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        String url = "forgot-password.jsp";
        try {
            AccountDAO accountDAO = new AccountDAO();
            String email = request.getParameter("email");
            if (email == null) {
                message = "Not found email";
            }
            entity.Account account = accountDAO.getByEmail(email);
            if (account == null) {
                message = "Not found account";
            } else {
                //mail sender
                String password = PasswordGenerator.generatePassword();
                account.setPassword(password);
                account = accountDAO.updateAccountPassword(account);
                if (account == null) {
                    message = "Update fail !";
                } else {
                    url = "login.jsp";
                    message = "Your new password had been send to your email";
                    String title = "YOUR PASSWORD UPDATED!";
                    String content = String.format("Your password for forgot updated to :%s", password);
                    EmailSender.sendEmail(account.getEmail(), title, content);
                }
            }
            request.setAttribute("MESSAGE", message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }
}