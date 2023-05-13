import React from 'react';
import './DoctorNavbar.css'
import {Container, Nav, Navbar} from "react-bootstrap";
import {DOCTOR_HOME_ROUTE} from "../../util/consts";

function DoctorNavbar(props) {
    return (
        <div>
            <Navbar collapseOnSelect expand={"lg"} bg={"light"}>
                <Container>
                    <Navbar.Brand href={DOCTOR_HOME_ROUTE}>ParaMedic</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/logout">Выйти</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
}

export default DoctorNavbar;
