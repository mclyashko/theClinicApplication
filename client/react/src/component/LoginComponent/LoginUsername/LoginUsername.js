import React from "react";
import './LoginUsername.css'
import {useDispatch, useSelector} from "react-redux";
import {updateLoginAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

const LoginUsername = () => {
    const login = useSelector(state => state.userInf.login)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="username" className="sr-only">E-mail</label>
            <input value={login || ''} onChange={event => dispatch(updateLoginAction(event.target.value))}
                type="text" id="username" name="username" className="form-control" placeholder="E-mail" required="required" autoFocus=""/>
        </div>
    )
}

export default LoginUsername
