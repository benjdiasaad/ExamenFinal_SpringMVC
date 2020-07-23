<%--
  Created by IntelliJ IDEA.
  User: TOSHIBA
  Date: 26/04/2020
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-black">
    <div class="container">
        <a class="navbar-brand" style="color: white;" href="#">Master-BLOG</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            </ul>
            <ul class=" navbar-nav my-2 my-lg-0">
                <li class="nav-item" style="text-align: center;">
                    <a style="color: white; margin-bottom: -12px;" class="nav-link aColor">${fullName}</a>
                    <a class="small" href="${pageContext.request.contextPath}/disconnecte">Disconnecte</a>
                </li>
                <li class="nav-item">
                        <a class="btn btn-dark dropdown-toggle" href="#" role="button" id="menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img alt="AbdeslamRehaimi" class="avatar" src="<c:url value="/resources/images/users/${image}"/>" height="20" width="20">
                        </a>

                </li>
            </ul>
        </div>
    </div>
</nav>

