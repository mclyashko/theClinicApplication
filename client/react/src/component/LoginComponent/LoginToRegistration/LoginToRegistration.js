import React from 'react';
import {useDispatch} from "react-redux";
import {registerAction} from "../../../reducer/LoginPageReducer/LoginPageReducer";

const LoginToRegistration = () => {
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <button onClick={() => dispatch(registerAction())} className="btn btn-secondary btn-block" style={{ width: '100%' }}>У вас еще нет аккаунта?</button>
        </div>
    )
}

export default LoginToRegistration
