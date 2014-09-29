<%-- 
    Document   : result
    Created on : 24-09-2014, 20:57:48
    Author     : Mathias
--%>
<%--
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>
        </body>
    </html>
</f:view>--%>
<head>
    <title>Spring 4 MVC</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>

    <!-- Include one of jTable styles. -->
    <link href="/jtable/themes/metro/blue/jtable.min.css" rel="stylesheet" type="text/css" />

    <!-- Include jTable script file. -->
    <script src="/jtable/jquery.jtable.min.js" type="text/javascript"></script>
</head>
<body>
    <h1>${msg}</h1>
    <h2>User Id: ${userId}</h2>	
    <h2>Location : ${location}</h2>		

    <div id="PersonTableContainer"></div>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#PersonTableContainer').jtable({
                title: 'Table of employees',
                actions: {
                    listAction: '/api/employeeList',
                    createAction: '/api/employee/add',
                    updateAction: '/GettingStarted/UpdatePerson',
                    deleteAction: '/GettingStarted/DeletePerson'
                },
                fields: {
                    id: {
                        key: true,
                        list: false
                    },
                    forname: {
                        title: 'Forname'
                    },
                    lastname: {
                        title: 'Lastname'
                    },
                    birthday: {
                        title: 'Birthday'
                    },
                    sex: {
                        title: 'Sex'
                    },
                    mails: {
                        title: '',
                        width: '1%',
                        sorting: false,
                        edit: false,
                        create: false,
                        listClass: 'child-opener-image-column',
                        display: function (employeeData) {
                            //Create an image that will be used to open child table
                            var $img = $('<img class="child-opener-image" src="/images/email-icon-16.png" title="Edit emails" />');
                            //Open child table when user clicks the image
                            $img.click(function () {
                                console.log(employeeData);
                                $('#PersonTableContainer').jtable('openChildTable',
                                        $img.closest('tr'),
                                        {
                                            title: employeeData.record.forname + ' - Emails',
                                            actions: {
                                                listAction: '/api/employee/' + employeeData.record.id + '/mails',
                                                deleteAction: '/Demo/DeletePhone',
                                                updateAction: '/Demo/UpdatePhone',
                                                createAction: '/Demo/CreatePhone'
                                            },
                                            fields: {
                                                entry: {
                                                    title: 'Mail'
                                                }

                                            }
                                        }, function (data) { //opened handler
                                    data.childTable.jtable('load');
                                });
                            });
                            //Return image to show on the row
                            return $img;
                        }
                    },
                    phones: {
                        title: '',
                        width: '1%',
                        sorting: false,
                        edit: false,
                        create: false,
                        listClass: 'child-opener-image-column',
                        display: function (employeeData) {
                            //Create an image that will be used to open child table
                            var $img = $('<img class="child-opener-image" src="/images/phone-icon-16.png" title="Edit phone numbers" />');
                            //Open child table when user clicks the image
                            $img.click(function () {
                                console.log(employeeData);
                                $('#PersonTableContainer').jtable('openChildTable',
                                        $img.closest('tr'),
                                        {
                                            title: employeeData.record.forname + ' - Phone numbers',
                                            actions: {
                                                listAction: '/api/employee/' + employeeData.record.id + '/phones',
                                                deleteAction: '/Demo/DeletePhone',
                                                updateAction: '/Demo/UpdatePhone',
                                                createAction: '/Demo/CreatePhone'
                                            },
                                            fields: {
                                                entry: {
                                                    title: 'Phonenumber'
                                                }

                                            }
                                        }, function (data) { //opened handler
                                    data.childTable.jtable('load');
                                });
                            });
                            //Return image to show on the row
                            return $img;
                        }
                    }
                }
            });

            $('#PersonTableContainer').jtable('load');
        });
    </script>
</body>
</html> 
