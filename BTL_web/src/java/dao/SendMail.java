/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BillInfoSendMail;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author NCC
 */
public class SendMail {

    public boolean sendMail(BillInfoSendMail info) {
        // Recipient's email ID needs to be mentioned.
        String to = info.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "sonnk712@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sonnk712@gmail.com", "rhofcehhzbwccjea");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Thông tin hóa đơn từ PTIT Book", "utf-8");
            // Send the actual HTML message, as big as you like
            message.setContent("<!DOCTYPE html>"
                    + "<html lang=\"en\">"
                    + "<head>"
                    + "    <meta charset=UTF-8>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <title>Fabcart</title>"
                    + "    <style>"
                    + "        body{"
                    + "            background-color: #F6F6F6; "
                    + "            margin: 0;"
                    + "            padding: 0;"
                    + "        }"
                    + "        h1,h2,h3,h4,h5,h6{"
                    + "            margin: 0;"
                    + "            padding: 0;"
                    + "        }"
                    + "        p{"
                    + "            margin: 0;"
                    + "            padding: 0;"
                    + "        }"
                    + "        .container{"
                    + "            width: 80%;"
                    + "            margin-right: auto;"
                    + "            margin-left: auto;"
                    + "        }"
                    + "        .brand-section{"
                    + "           background-color: #0d1033;"
                    + "           padding: 10px 40px;"
                    + "        }"
                    + "        .logo{"
                    + "            width: 50%;"
                    + "        }"
                    + ""
                    + "        .row{"
                    + "            display: flex;"
                    + "            flex-wrap: wrap;"
                    + "        }"
                    + "        .col-6{"
                    + "            width: 50%;"
                    + "            flex: 0 0 auto;"
                    + "        }"
                    + "        .text-white{"
                    + "            color: #fff;"
                    + "        }"
                    + "        .company-details{"
                    + "            float: right;"
                    + "            text-align: right;"
                    + "        }"
                    + "        .body-section{"
                    + "            padding: 16px;"
                    + "            border: 1px solid gray;"
                    + "        }"
                    + "        .heading{"
                    + "            font-size: 20px;"
                    + "            margin-bottom: 08px;"
                    + "        }"
                    + "        .sub-heading{"
                    + "            color: #262626;"
                    + "            margin-bottom: 05px;"
                    + "        }"
                    + "        table{"
                    + "            background-color: #fff;"
                    + "            width: 100%;"
                    + "            border-collapse: collapse;"
                    + "        }"
                    + "        table thead tr{"
                    + "            border: 1px solid #111;"
                    + "            background-color: #f2f2f2;"
                    + "        }"
                    + "        table td {"
                    + "            vertical-align: middle !important;"
                    + "            text-align: center;"
                    + "        }"
                    + "        table th, table td {"
                    + "            padding-top: 08px;"
                    + "            padding-bottom: 08px;"
                    + "        }"
                    + "        .table-bordered{"
                    + "            box-shadow: 0px 0px 5px 0.5px gray;"
                    + "        }"
                    + "        .table-bordered td, .table-bordered th {"
                    + "            border: 1px solid #dee2e6;"
                    + "        }"
                    + "        .text-right{"
                    + "            text-align: end;"
                    + "        }"
                    + "        .w-20{"
                    + "            width: 20%;"
                    + "        }"
                    + "        .float-right{"
                    + "            float: right;"
                    + "        }"
                    + "    </style>"
                    + "</head>"
                    + "<body>"
                    + ""
                    + "    <div class=\"container\">"
                    + "        <div class=\"brand-section\">"
                    + "            <div class=\"row\">"
                    + "                <div class=\"col-6\">"
                    + "                    <h1 class=\"text-white\">Đặt hàng thành công</h1>"
                    + "                </div>"
                    + "            </div>"
                    + "        </div>"
                    + ""
                    + "        <div class=\"body-section\">"
                    + "            <div class=\"row\">"
                    + "                <div class=\"col-6\">"
                    + "                    <h2 class=\"heading\">Xin chào: " + info.getName() + ",</h2><br>"
                    + "                    <h2 class=\"heading\">Thông tin đơn hàng:</h2>"
                    + "                    <p class=\"sub-heading\">Mã đơn hàng: " + info.getBillId() + "</p>"
                    + "                    <p class=\"sub-heading\">Trạng thái đơn hàng: " + "Chờ xác nhận" + "</p>"
                    + "                    <p class=\"sub-heading\">Tổng tiền: " + info.getTotal() + "</p>"
                    + "                    <p class=\"sub-heading\">Ngày đặt hàng: " + info.getDate() + " </p>"
                    + "                    <h2 class=\"heading\">Thông tin khách hàng:</h2>"
                    + "                    <p class=\"sub-heading\">Họ và tên: " + info.getName() + "</p>"
                    + "                    <p class=\"sub-heading\">Email: " + info.getEmail() + " </p>"
                    + "                    <p class=\"sub-heading\">Địa chỉ: " + info.getAddress() + " </p>"
                    + "                    <p class=\"sub-heading\">Số điện thoại:  " + info.getPhoneNumber() + "</p>"
                    + "                </div>"
                    + "            </div>"
                    + "        </div>"
                    + "        <div class=\"body-section\">"
                    + "            <p>Cảm ơn bạn đã mua hàng ở của hàng của chúng tôi."
                    + "                <a href=\"https://www.abc.com/\" class=\"float-right\">www.abc.com</a>"
                    + "            </p>"
                    + "        </div>      "
                    + "    </div>      "
                    + ""
                    + "</body>"
                    + "</html>", "text/html; charset=UTF-8");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;

        }
    }
}
