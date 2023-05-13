import React from 'react';
import {Container, Nav, Navbar} from "react-bootstrap";
import {CONTACT_DETAILS_ROUTE, COVID_STAT_ROUTE, LIST_OF_SERVICES_ROUTE, LOGOUT_ROUTE, PATIENT_HOME_ROUTE, QUIZ_ROUTE, REVIEW_ROUTE} from "../../util/consts";

function PatientNavbar(props) {
    return (
        <div>
            <Navbar collapseOnSelect expand={"lg"} bg={"light"}>
                <Container>
                    <Navbar.Brand href={PATIENT_HOME_ROUTE}>ParaMedic</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href={LIST_OF_SERVICES_ROUTE}>Услуги</Nav.Link>
                            <Nav.Link href={CONTACT_DETAILS_ROUTE}>Контактные данные</Nav.Link>
                            <Nav.Link href={QUIZ_ROUTE}>Квиз</Nav.Link>
                            <Nav.Link href={COVID_STAT_ROUTE}>Статистика по коронавирусу</Nav.Link>
                            <Nav.Link href={REVIEW_ROUTE}>Отзывы</Nav.Link>
                            <Nav.Link href={LOGOUT_ROUTE}>Выйти</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
}

export default PatientNavbar;
