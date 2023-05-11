import React from 'react';
import {useSelector} from "react-redux";
import Login from "../../component/LoginComponent/Login/Login";
import Register from "../../component/RegisterComponent/Register/Register";

function LoginRegisterPage() {
    const loginOrRegister = useSelector(state => state.login.loginPage)

    return (
        <div>
            {loginOrRegister ? <Login/> : <Register/>}
        </div>
    )
}

export default LoginRegisterPage;
