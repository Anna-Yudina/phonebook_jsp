package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteContactServlet extends HttpServlet {
    private ContactService contactService = PhoneBook.contactService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteButton = req.getParameter("delete_button");

        if (deleteButton != null) {
            int contactId = Integer.parseInt(deleteButton);
            contactService.deleteContact(contactId);
            resp.sendRedirect("/phonebook");
        } else {
            String[] contactIds = req.getParameterValues("checkboxName");

            if (contactIds == null) {
                resp.sendRedirect("/phonebook");
            } else {
                List<Integer> contactIdsList = new ArrayList<>();

                for (String contactId : contactIds) {
                    contactIdsList.add(Integer.parseInt(contactId));
                }
                contactService.deleteChecked(contactIdsList);
                resp.sendRedirect("/phonebook");
            }
        }
    }
}


