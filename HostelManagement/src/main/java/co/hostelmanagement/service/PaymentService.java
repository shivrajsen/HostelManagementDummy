
package co.hostelmanagement.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import co.hostelmanagement.controller.PaymentController;
import co.hostelmanagement.dto.PaymentDTO;


public class PaymentService extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
        
        String bankName = req.getParameter("bankName");
        String cardType = req.getParameter("cardType");
        String upiId = req.getParameter("upiId");
        String candidate = req.getParameter("candidate");
        String viewType = req.getParameter("viewType"); 
        String roomViewType = req.getParameter("roomviewType"); 
        String roomType = req.getParameter("roomtype"); 

        int roomNumber;
        Long cardNumber;

      
       
          
          
       

       
        try {
            cardNumber = Long.parseLong(req.getParameter("cardNumber"));
            roomNumber = Integer.parseInt(req.getParameter("roomNumber"));
            if (String.valueOf(cardNumber).length() < 16) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage1", "Invalid card number. It must be a 16-digit number.");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

       
        if (upiId != null && !upiId.trim().isEmpty() && !upiId.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+$")) {
            req.setAttribute("errorMessage2", "Invalid UPI ID format.");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

       
        if (bankName == null || bankName.trim().isEmpty()) {
            req.setAttribute("errorMessage3", "Bank name is required.");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

        if (cardType == null || cardType.trim().isEmpty()) {
            req.setAttribute("errorMessage4", "Card type is required.");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

        
        int numCandidates;
        try {
            numCandidates = Integer.parseInt(candidate);
            if (numCandidates <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage5", "Invalid number of candidates. It must be a positive integer.");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

     
        if (viewType == null || viewType.trim().isEmpty() || !(viewType.equalsIgnoreCase("City") || viewType.equalsIgnoreCase("Garden") || viewType.equalsIgnoreCase("None"))) {
            req.setAttribute("errorMessage6", "Valid view type is required (City, Garden, or None).");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

       
        if (roomViewType == null || roomViewType.trim().isEmpty() || !(roomViewType.equalsIgnoreCase("AC") || roomViewType.equalsIgnoreCase("Non-AC"))) {
            req.setAttribute("errorMessage7", "Room view type is required (AC or Non-AC).");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

        
        if (roomType == null || roomType.trim().isEmpty() || !(roomType.equalsIgnoreCase("Private") || roomType.equalsIgnoreCase("Shared"))) {
            req.setAttribute("errorMessage8", "Room type is required (Private or Shared).");
            RequestDispatcher rd = req.getRequestDispatcher("/PaymentProssecc.jsp");
            rd.forward(req, response);
            return;
        }

       
        double paymentAmount = calculatePayment(roomType, roomViewType, viewType, numCandidates);

       
        PaymentDTO pay = new PaymentDTO();
        pay.setRoom_number(roomNumber);
        pay.setBank_Name(bankName);
        pay.setCard_Type(cardType);
        pay.setCard_Number(cardNumber);
        pay.setUpi_Id(upiId);
       // pay.setPaymentAmount(paymentAmount); 

      
        boolean insertPaymentDetails = PaymentController.insertPaymentDetails(pay);
        if (insertPaymentDetails) {
            req.setAttribute("paymentAmount", paymentAmount); 
            req.setAttribute("bankName", bankName); 
            req.setAttribute("roomNumber", roomNumber); 
            req.setAttribute("cardType", cardType); 
            req.setAttribute("upiId", upiId);
            req.setAttribute("cardNumber", cardNumber);
            req.setAttribute("candidate", candidate);
			req.setAttribute("viewType", viewType);
			req.setAttribute("roomViewType", roomViewType);
			req.setAttribute("roomType", roomType);
			
            RequestDispatcher rd = req.getRequestDispatcher("/PayNow.jsp");
            rd.forward(req, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body><h3>Payment failed. Please try again.</h3></body></html>");
        }
    }

   
    private double calculatePayment(String roomType, String roomViewType, String viewType, int numCandidates) {
        double basePrice = 7000.0;
        double paymentAmount;

      
        if (roomType.equalsIgnoreCase("Private") || roomViewType.equalsIgnoreCase("AC")) {
            basePrice += 2000.0;
        }

       
        if (viewType.equalsIgnoreCase("City") || viewType.equalsIgnoreCase("Garden")) {
            basePrice += 1000.0; 
        }

       
        paymentAmount = basePrice * numCandidates; 

    
        if (roomType.equalsIgnoreCase("Shared")) {
            paymentAmount *= 0.5; 
        }

        return paymentAmount;
    }
}
