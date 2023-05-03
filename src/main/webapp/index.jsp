<%@ page import="ru.academits.model.Contact" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.academits.service.ContactService" %>
<%@ page import="ru.academits.PhoneBook" %><%--
  Created by IntelliJ IDEA.
  User: anuta
  Date: 23.04.2023
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% int i = 8;
%>
<% ContactService contactService = PhoneBook.contactService;
List<Contact> contacts = contactService.getAllContacts();
    for (Contact contact: contacts){
        System.out.println(contact);
    }%>
Hello world <%= i %>
</body>
</html>
