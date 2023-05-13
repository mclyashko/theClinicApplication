import React from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";

function ContactDetailsPage(props) {
    return (
        <div>
            <PatientNavbar/>
            <Wrapper>
                <h1>Красная пл., Москва, 109012</h1>
                <a href="tel:8-888-888-88-88">8-888-888-88-88</a>
                <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3Af5c2a0fcb5bb7eddaae213e2dda11741fa3d07ee964771e61a572375d9a7ca2b&amp;source=constructor" width="100%" height="440"
                        frameBorder="0"></iframe>
            </Wrapper>
        </div>
    );
}

export default ContactDetailsPage;
