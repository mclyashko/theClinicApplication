import React from 'react';
import './Login.css'
import Wrapper from "../../Wrapper/Wrapper";
import LoginUsername from "../LoginUsername/LoginUsername";
import LoginPassword from "../LoginPassword/LoginPassword";
import LoginSubmit from "../LoginSubmit/LoginSubmit";
import LoginToRegistration from "../LoginToRegistration/LoginToRegistration";
import {useSelector} from "react-redux";
import {DOCTOR_HOME_ROUTE, DOCTOR_ROLE, PATIENT_HOME_ROUTE, PATIENT_ROLE} from "../../../util/consts";
import {Navigate} from "react-router-dom";

const Login = () => {
    const role = useSelector(state => state.userInf.role)

    return (
        <div>
            <Wrapper>
                <div className="login-form mg">
                    <form action="/src/component/LoginComponent/Login/Login" method="post">
                        <h2 className="text-center pd1">Вход</h2>
                        <LoginUsername/>
                        <LoginPassword/>
                    </form>
                    <LoginSubmit/>
                    <LoginToRegistration/>
                    {role === PATIENT_ROLE && <Navigate to={DOCTOR_HOME_ROUTE}/>}
                    {role === DOCTOR_ROLE && <Navigate to={PATIENT_HOME_ROUTE}/>}
                </div>
            </Wrapper>
        </div>
    );
};

export default Login;
