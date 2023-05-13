import React from 'react';
import DoctorNavbar from "../../component/DoctorNavbar/DoctorNavbar";
import DoctorInterface from "../../component/DoctorInterface/DoctorInterface";

function DoctorHomePage(props) {
    return (
        <div>
            <DoctorNavbar/>
            <DoctorInterface/>
        </div>
    );
}

export default DoctorHomePage;
