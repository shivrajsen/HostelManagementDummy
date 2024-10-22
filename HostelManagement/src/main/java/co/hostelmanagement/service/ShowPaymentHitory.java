package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import co.hostelmanagement.controller.PaymentController;
import co.hostelmanagement.dto.PayNowDTO;


public class ShowPaymentHitory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String password = request.getParameter("password");

        List<PayNowDTO> paymentList = PaymentController.getPaymentHistory(roomNumber, password);

     
            request.setAttribute("paymentList", paymentList);
    
          //  request.setAttribute("errorMessage", "No payment history found or invalid credentials.");
      

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowPaymentHistory.jsp");
        dispatcher.forward(request, response);
    }
    
}
