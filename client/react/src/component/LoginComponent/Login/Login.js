import React from 'react';
import './Login.css'
import Wrapper from "../../Wrapper/Wrapper";
import LoginUsername from "../LoginUsername/LoginUsername";
import LoginPassword from "../LoginPassword/LoginPassword";
import LoginSubmit from "../LoginSubmit/LoginSubmit";
import LoginToRegistration from "../LoginToRegistration/LoginToRegistration";

const Login = () => {
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
                </div>
            </Wrapper>
        </div>
    );
};

export default Login;
