import React from 'react';
import './RegisterEmail.css'
import {useDispatch, useSelector} from "react-redux";
import {updateLoginAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

function RegisterEmail(props) {
    const email = useSelector(state => state.userInf.login)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="email" className="sr-only">E-mail</label>
            <input value={email || ''} onChange={event => dispatch(updateLoginAction(event.target.value))}
                type="email" id="email" name="email" className="form-control" placeholder="E-mail" required="required" autoFocus=""/>
        </div>
    );
}

export default RegisterEmail;
