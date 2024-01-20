<%--
  Created by IntelliJ IDEA.
  User: DuyThai
  Date: 19/01/2024
  Time: 2:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- import thư viện spring-form -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description"
          content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords"
          content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">
    <link rel="preconnect" href="https://fonts.gstatic.com">

    <link rel="canonical" href="https://demo-basic.adminkit.io/"/>
    <title>Admin page</title>
    <link href="${base}/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="${base}/css/product.css">
    <link rel="stylesheet" href="${base}/css/changepassword.css">
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css"
            rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
            rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="${base}/admin/product/list">
                <span class="align-middle">Admin page</span>
            </a>

            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Pages
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link" href="${base}/admin/product/list">
                        <i class="align-middle" data-feather="sliders"></i> <span
                            class="align-middle">Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="${base}/admin/change-password">
                        <i class="align-middle" data-feather="lock"></i> <span
                            class="align-middle">Đổi mật khẩu</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="${base}/admin/profile">
                        <i class="align-middle" data-feather="user"></i> <span class="align-middle">Thông tin cá nhân</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="${base}/admin/product">
                        <i class="align-middle" data-feather="inbox"></i> <span class="align-middle"> Sản phẩm</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link" href="${base}/admin/category">
                        <i class="align-middle" data-feather="bar-chart-2"></i> <span
                            class="align-middle">Category</span>
                    </a>
                </li>

                <li class="sidebar-item"><a class="sidebar-link"
                                            href="${base}/admin/order"> <i class="align-middle" data-feather="map"></i>
                    <span
                            class="align-middle">Đơn hàng</span>
                </a></li>
                <li class="sidebar-item"><a class="sidebar-link" href="${base}/logout"> <i class="align-middle"
                                                                                           data-feather="log-in"></i>
                    <span class="align-middle">Đăng xuất </span>
                </a></li>
            </ul>
        </div>
    </nav>

    <%--    <div class="main">--%>
    <%--        <main class="content">--%>
    <%--            <h2>Change Password</h2>--%>
    <%--            <form action="${base}/admin/change-password" method="post">--%>
    <%--                <div class="form-group">--%>
    <%--                    <label for="currentPassword">Current Password:</label>--%>
    <%--                    <input type="password" id="currentPassword" name="currentPassword" required>--%>
    <%--                </div>--%>

    <%--                <div class="form-group">--%>
    <%--                    <label for="newPassword">New Password:</label>--%>
    <%--                    <input type="password" id="newPassword" name="newPassword" required>--%>
    <%--                </div>--%>

    <%--                <div class="form-group">--%>
    <%--                    <label for="confirmPassword">Confirm Password:</label>--%>
    <%--                    <input type="password" id="confirmPassword" name="confirmPassword" required>--%>
    <%--                </div>--%>

    <%--                <button type="submit">Change Password</button>--%>
    <%--            </form>--%>
    <%--        </main>--%>
    <%--    </div>--%>
    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle"> <i
                    class="hamburger align-self-center"></i>
            </a>

            <div class="navbar-collapse collapse">
                <ul class="navbar-nav navbar-align">
                    <li class="nav-item dropdown"><a
                            class="nav-icon dropdown-toggle" href="#" id="alertsDropdown"
                            data-bs-toggle="dropdown">
                        <div class="position-relative">
                            <i class="align-middle" data-feather="bell"></i> <span
                                class="indicator">4</span>
                        </div>
                    </a></li>
                    <li class="nav-item dropdown"><a
                            class="nav-icon dropdown-toggle" href="#" id="messagesDropdown"
                            data-bs-toggle="dropdown">
                        <div class="position-relative">
                            <i class="align-middle" data-feather="message-square"></i>
                        </div>
                    </a></li>
                    <li class="nav-item dropdown"><a
                            class="nav-icon dropdown-toggle d-inline-block d-sm-none"
                            href="#" data-bs-toggle="dropdown"> <i class="align-middle"
                                                                   data-feather="settings"></i>
                    </a>
                        <a class="nav-link dropdown-toggle d-none d-sm-inline-block"
                           href="#" data-bs-toggle="dropdown">
                            <img src="${base}/img/images.png" class="avatar img-fluid rounded me-1" alt=""/>
                            <span class="text-dark"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item" href="${base}/admin/profile"><i
                                    class="align-middle me-1" data-feather="user"></i> Profile</a> <a
                                class="dropdown-item" href="#"><i class="align-middle me-1"
                                                                  data-feather="pie-chart"></i> Analytics</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#"><i
                                    class="align-middle me-1" data-feather="settings"></i> Settings
                                & Privacy</a> <a class="dropdown-item" href="#"><i
                                class="align-middle me-1" data-feather="help-circle"></i> Help
                            Center</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${base}/logout">Log out (${userLogined.email})</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <%--            <main class="content">--%>
        <%--                <h2>Change Password</h2>--%>
        <%--                <form action="${base}/admin/change-password" method="post">--%>
        <%--                    <div class="form-group">--%>
        <%--                        <label for="currentPassword">Current Password:</label>--%>
        <%--                        <input type="password" id="currentPassword" name="currentPassword" required>--%>
        <%--                    </div>--%>
        <%--&lt;%&ndash;                    <c:if test="${not empty error}">&ndash;%&gt;--%>
        <%--&lt;%&ndash;                        <div class="error-message">${error}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;                    </c:if>&ndash;%&gt;--%>
        <%--                    <c:if test="${not empty param.changepw_error}">--%>
        <%--                        <div class="error-message" role="alert">--%>
        <%--                            Mật khẩu cũ không đúng. Vui lòng nhập lại!--%>
        <%--                        </div>--%>
        <%--                    </c:if>--%>
        <%--                    <div class="form-group">--%>
        <%--                        <label for="newPassword">New Password:</label>--%>
        <%--                        <input type="password" id="newPassword" name="newPassword" required>--%>
        <%--                    </div>--%>

        <%--                    <div class="form-group">--%>
        <%--                        <label for="confirmPassword">Confirm Password:</label>--%>
        <%--                        <input type="password" id="confirmPassword" name="confirmPassword" required>--%>
        <%--                    </div>--%>

        <%--                    <button type="submit">Change Password</button>--%>
        <%--                </form>--%>
        <%--            </main>--%>
        <main class="content">
            <h2>Đổi mật khẩu</h2>
            <c:if test="${not empty param.changepw_error}">
                <div class="error-password" role="alert">
                    <i class="bi bi-exclamation-triangle-fill"></i>
                    Mật khẩu cũ không đúng. Vui lòng nhập lại!
                </div>
            </c:if>
            <c:if test="${not empty param.confirmPassword_error}">
                <div class="error-password" role="alert">
                    <i class="bi bi-exclamation-triangle-fill"></i>
                    Mật khẩu mới không trùng khớp. Vui lòng nhập lại chính xác!
                </div>
            </c:if>
            <c:if test="${not empty param.successPasswordChange}">
                <div class="success-password" role="alert">
                    <i class="bi bi-exclamation-triangle-fill"></i>
                    Thay đổi mật khẩu thành công!
                </div>
            </c:if>

            <form action="${base}/admin/change-password" method="post">
                <div class="form-group">
                    <label for="currentPassword">Mật khẩu cũ:</label>
                    <input type="password" id="currentPassword" name="currentPassword" required>
                    <c:if test="${bindingResult.hasFieldErrors('currentPassword')}">
                        <div class="error-message" role="alert">
                                ${bindingResult.getFieldError('currentPassword').defaultMessage}
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="newPassword">Mật khẩu mới:</label>
                    <input type="password" id="newPassword" name="newPassword" required>
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                        <div class="error-message" role="alert">
                                ${bindingResult.getFieldError('confirmPassword').defaultMessage}
                        </div>
                    </c:if>
                </div>
                <button type="submit">Đổi mật khẩu</button>
            </form>
        </main>
    </div>
    <script src="${base}/js/jquery-3.6.1.min.js"></script>
    <script src="${base}/js/app.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js">
    </script>
    <script>
        $(document).ready(function () {
            $('#details').summernote({});
        });
    </script>
</body>

</html>