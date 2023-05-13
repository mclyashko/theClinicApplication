import React from 'react';
import {Container, Nav, Navbar} from "react-bootstrap";
import {PATIENT_HOME_ROUTE} from "../../util/consts";

function PatientNavbar(props) {
    return (
        <div>
            <Navbar collapseOnSelect expand={"lg"} bg={"light"}>
                <Container>
                    <Navbar.Brand href={PATIENT_HOME_ROUTE}>ParaMedic</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/list_of_services">Услуги</Nav.Link>
                            <Nav.Link href="/contact_details">Контактные данные</Nav.Link>
                            <Nav.Link href="/quiz">Квиз</Nav.Link>
                            <Nav.Link href="/covid_stat">Статистика по коронавирусу</Nav.Link>
                            <Nav.Link href="/review">Отзывы</Nav.Link>
                            <Nav.Link href="/logout">Выйти</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
}

export default PatientNavbar;
