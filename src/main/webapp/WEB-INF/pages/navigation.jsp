<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
    <div class="page">
        <div class="page__demo">
            <nav class="menu">
                <ul class="menu__list">
                    <li class="menu__group"><a href="#0" class="menu__link">Home</a></li>
                    <li class="menu__group"><a href="#0" class="menu__link">About me</a></li>
                    <li class="menu__group"><a href="#0" class="menu__link">Services</a></li>
                    <li class="menu__group"><a href="#0" class="menu__link">Portfolio</a></li>
                    <li class="menu__group dropdown">
                        <a class="dropbtn menu__link"><spring:message code="navigation.dropdown.name"/></a>
                        <div class="dropdown-content">
                            <a href="?lang=en"><spring:message code="navigation.dropdown.eng"/></a>
                            <a href="?lang=RU_ru"><spring:message code="navigation.dropdown.rus"/></a>
                        </div>
                    <li class="menu__group "><a href="#0" class="menu__link">Contacts</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>