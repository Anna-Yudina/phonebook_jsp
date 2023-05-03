package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteCheckedServlet extends HttpServlet {
    private ContactService contactService = PhoneBook.contactService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] contactIds = req.getParameterValues("checkboxName");
        List<Integer> contactIdsList = new ArrayList<>();

        for (String contactId : contactIds) {
            contactIdsList.add(Integer.parseInt(contactId));
        }

        System.out.println(contactIdsList);
        contactService.deleteChecked(contactIdsList);

        resp.sendRedirect("/phonebook");
    }
}
