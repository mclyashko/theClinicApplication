import React from "react";
import './LoginPassword.css'
import {useDispatch, useSelector} from "react-redux";
import {updateLoginAction, updatePasswordAction} from "../../../reducer/UserInfoReducer/UserInfoReducer";

const LoginPassword = () => {
    const password = useSelector(state => state.userInf.password)
    const dispatch = useDispatch()

    return (
        <div className="form-group pd2">
            <label htmlFor="password" className="sr-only">Пароль</label>
            <input value={password || ''} onChange={event => dispatch(updatePasswordAction(event.target.value))}
                type="password" id="password" name="password" className="form-control" placeholder="Пароль" required="required"/>
        </div>
    )
}

export default LoginPassword
