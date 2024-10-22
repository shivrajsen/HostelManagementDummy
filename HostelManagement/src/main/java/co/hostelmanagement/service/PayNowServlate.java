package co.hostelmanagement.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import co.hostelmanagement.controller.PaymentController;
import co.hostelmanagement.dto.PayNowDTO;


public class PayNowServlate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String bankName = req.getParameter("bankName");
        int roomNumber =Integer.parseInt( req.getParameter("roomNumber"));
        String cardType = req.getParameter("cardType");
        String upiId = req.getParameter("upiId");
        String candidate = req.getParameter("candidate");
        Long cardNumber =Long.parseLong(req.getParameter("cardNumber"));
        String viewType = req.getParameter("viewType");
        String roomViewType = req.getParameter("roomviewType");
        String roomType = req.getParameter("roomtype");
        String pass=req.getParameter("password");
        double paymentAmount = Double.parseDouble(req.getParameter("paymentAmount"));
       
      
       
        String transactionId = generateTransactionId();
        String billType = "Monthly Rent"; 
       

        PayNowDTO dto=new PayNowDTO();
        dto.setRoom_number(roomNumber);
        dto.setBank_Name(bankName);
        dto.setCard_Type(cardType);
        dto.setCard_Number(cardNumber);
        dto.setUpi_Id(upiId);
        dto.setCandidate(candidate);
        dto.setViewType(viewType);
        dto.setRoomviewType(roomViewType);
        dto.setPaymentAmount(paymentAmount);
        dto.setBillType(billType);
        dto.setTransactionId(transactionId);
        dto.setPass(pass);
        boolean pay=false;
        boolean password=false;
        boolean loginEmailPass = PaymentController.getLoginEmailPass(dto);
        boolean insertPayNowDetails = PaymentController.insertPayNowDetails(dto);
        
        
        if (insertPayNowDetails && loginEmailPass) {
           
            req.setAttribute("transactionId", transactionId);
            req.setAttribute("billType", billType);
            req.setAttribute("paymentAmount", paymentAmount);

           
            req.getRequestDispatcher("/ShowPaymentHistory.jsp").forward(req, response);
        } else {
           
            req.setAttribute("errorMessage", "Payment failed. Please try again.and password  is not currect : ");
            req.getRequestDispatcher("/PayNow.jsp").forward(req, response);
        }
    }

 

    private String generateTransactionId() {
       
        return "TXN" + System.currentTimeMillis();
    }
}
