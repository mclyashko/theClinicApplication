import React from 'react';
import {useDispatch} from "react-redux";
import {loginAction} from "../../../reducer/LoginPageReducer/LoginPageReducer";

function RegistrationToLogin() {
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <button onClick={() => dispatch(loginAction())} className="btn btn-secondary btn-block" style={{ width: '100%' }}>У вас уже есть аккаунт?</button>
        </div>
    );
}

export default RegistrationToLogin;
